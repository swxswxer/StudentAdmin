<template>
  <div class="courseEditForm">
    <el-form :model="formData" label-position="right" label-width="80px">
      <el-form-item label="课程id">
        <el-input class="formInput" v-model="formData.id"></el-input>
      </el-form-item>
      <el-form-item label="课程名字">
        <el-input v-model="formData.name"></el-input>
      </el-form-item>
      <el-form-item label="课程学分">
        <el-input v-model="formData.credit"></el-input>
      </el-form-item>
      <el-form-item label="课程周数">
        <el-input v-model="formData.time"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {Message} from "element-ui";
import {updateCourse} from "@/network/course";

export default {
  name: "CourseInfoEdit",
  data() {
    return {
      hasSubmit: false,
      majorData: [],
      formData: {
        id: 0,
        name: '',
        credit: 0,
        time: '',
      }
    }
  },
  methods: {
    onSubmit() {
      updateCourse(this.formData).then(res => {
        if (res.success === true) {
          Message.success("提交成功")
          this.hasSubmit = true
          this.$emit("courseInfoEditCallBack", this.formData)
        } else {
          Message.warning(res.message)
        }
      })
    },
  }
}
</script>

<style scoped>
.courseEditForm {
  width: 80%;
}

.formInput {
  width: 100%;
}
</style>