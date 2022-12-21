<template>
  <div class="stuCourseModify">
    <div class="courseTransfer">
      <el-transfer v-model="value"
                   :data="data"
                   :titles="['所有课程', '已选课程']">
      </el-transfer>
    </div>
    <el-button class="modifyButton" type="primary" :loading="modifyLoading" @click="modifyClick">修改</el-button>
  </div>
</template>

<script>
export default {
  name: "studentCourseModify",
  props: {
    stuName: String,
    stuId: Number,
    selectCourse: Object
  },
  data() {
    return {
      modifyLoading: false,
      data: [
        {
          key: 0,
          label: 'java课程设计',
          disable: false,
        },
        {
          key: 1,
          label: 'web开发',
          disable: false,
        },
        {
          key: 2,
          label: '数据库原理',
          disable: false,
        },
        {
          key: 3,
          label: '计算机网络',
          disable: false,
        },
      ],
      value: []
    }
  },
  methods: {
    modifyClick() {
      alert("click modify")
    }
  }
}
</script>

<style scoped>
.stuCourseModify {
  display: flex;
  flex-direction: column;
}

.courseTransfer {
  margin: 0 auto;
}

.modifyButton {
  width: 150px;
  margin: 20px auto;
}
</style>