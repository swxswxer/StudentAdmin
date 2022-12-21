<template>
  <div class="stuCourseModify">
    <div class="courseTransfer">
      <el-transfer
          filterable
          v-model="selectValue"
          :data="transferData"
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
    selectCourse: Array
  },
  data() {
    return {
      allCourse: [
        {
          courseId: 123456,
          name: 'java程序设计'
        },
        {
          courseId: 123457,
          name: 'web程序设计'
        },
      ],
      modifyLoading: false,
      transferData: [],
      selectValue: []
    }
  },
  methods: {
    modifyClick() {
      alert("click modify: " + this.selectValue)
    }
  },
  created() {
    // TODO get all course

  },
  beforeMount() {
    let hasSelectCourse = {};
    for (let course of this.selectCourse) {
      hasSelectCourse[course.courseId] = course;
    }
    console.log(hasSelectCourse)
    let transData = []
    for (let course of this.allCourse) {
      const courseId = course.courseId

      if (hasSelectCourse[courseId] !== undefined) {
        this.selectValue.push(courseId)
      }
      transData.push(
          {
            key: courseId,
            label: course.name,
            disabled: false,
          }
      )
    }
    this.transferData = transData
    console.log(transData)
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

.courseTransfer >>> .el-transfer-panel {
  width: 300px;
}

.courseTransfer >>> .el-transfer-panel__filter {
  margin: 15px 0 5px 0;
  padding: 0 10px;
}

.modifyButton {
  width: 150px;
  margin: 20px auto;
}
</style>