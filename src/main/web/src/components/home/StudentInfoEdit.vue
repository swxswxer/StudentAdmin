<template>
  <div class="stuEditForm">
    <el-form :model="stuInfo" label-position="right" label-width="80px">
      <el-form-item label="学生姓名">
        <el-input class="formInput" v-model="formData.name"></el-input>
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="formData.age"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="formData.sex" placeholder="请选择性别" class="formInput">
          <el-option value="男"></el-option>
          <el-option value="女"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="专业班级">
        <el-select v-model="formData.major" placeholder="请选择活动专业" class="formInput">
          <el-option v-for="(major) in this.majorData" :key="major.value"
                     :value="major.value"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">创建</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {updateStudentInfo} from "@/network/student";
import {Message} from "element-ui";
import {getAllClass} from "@/network/classes";

export default {
  name: "StudentInfoEdit",
  data() {
    return {
      majorData: [],
      formData: {
        studentid: '',
        name: '',
        age: '',
        sex: '',
        major: ''
      }
    }
  },
  created() {
    getAllClass().then(res => {
      if (res.status === true) {
        const dataList = res.data
        let majorList = []
        for (let idx = 0; idx < dataList.length; idx++){
          majorList.push({
            label: dataList[idx].classname,
            value: dataList[idx].classname
          })
        }
        this.majorData = majorList
      } else {
        Message.warning("获取班级列表失败: " + res.message)
      }
    })
  },
  beforeMount() {
    this.formData.name = this.stuInfo.name
    this.formData.studentid = this.stuInfo.studentid
    this.formData.age = this.stuInfo.age
    this.formData.sex = this.stuInfo.sex
    this.formData.major = this.stuInfo.major
  },
  props: {
    stuInfo: Object
  },
  methods: {
    onSubmit() {
      console.log(this.formData)
      updateStudentInfo(this.formData).then(res => {
        if (res.success === true) {
          Message.success("提交成功")
        } else {
          Message.warning(res.message)
        }
      })
    },
  }
}
</script>

<style scoped>
.stuEditForm {
  width: 80%;
}

.formInput {
  width: 100%;
}
</style>