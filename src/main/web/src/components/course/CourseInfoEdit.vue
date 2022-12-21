<template>
  <div class="courseModify">
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
      </el-form>
      <el-button type="primary" @click="onSubmit" style="width: 150px">提交</el-button>
    </div>
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
.courseModify {
  display: flex;
  flex-direction: column;
}

.courseEditForm {
  margin: 0 auto;
}

.formInput {
  width: 100%;
}
</style>