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
import {Message} from "element-ui";
import {getAllCourse} from "@/network/course";
import {studentAddCourse, studentDeleteCourse} from "@/network/student";

export default {
  name: "studentCourseModify",
  props: {
    stuName: String,
    stuId: Number,
    selectCourse: Array
  },
  data() {
    return {
      allCourse: [],
      modifyLoading: false,
      transferData: [],
      selectValue: []
    }
  },
  methods: {
    complement(a, b) {
      return [
        ...a.filter(item => !b.includes(item)),
        ...b.filter(item => !a.includes(item))
      ]
    },
    modifyClick() {
      let originCourseId = []
      for (let course of this.selectCourse) {
        originCourseId.push(course.id)
      }

      let complementId = this.complement(originCourseId, this.selectValue)

      let addIds = []
      let deleteIds = []

      for (let courseId of complementId) {
        if (this.selectValue.includes(courseId)) {
          addIds.push(courseId)
        } else {
          deleteIds.push(courseId)
        }
      }

      if (addIds.length !== 0) {
        studentAddCourse(this.stuId, addIds).then(res => {
          if (res.success === true) {
            Message.success(`增加: ${addIds} 成功`)
          } else {
            Message.warning(`增加: ${addIds} 失败，错误信息: ${res.message}`)
          }
        })
      }

      if (deleteIds.length !== 0) {
        studentDeleteCourse(this.stuId, deleteIds).then(res => {
          if (res.success === true) {
            Message.success(`删除: ${deleteIds} 成功`)
          } else {
            Message.success(`删除: ${deleteIds} 失败，错误信息: ${res.message}`)
          }
        })
      }
    }
  },
  beforeMount() {
    getAllCourse().then(res => {
      if (res.status === true) {
        this.allCourse = res.data
        console.log(this.allCourse)
        let hasSelectCourse = {};
        for (let course of this.selectCourse) {
          hasSelectCourse[course.id] = course;
        }
        console.log(hasSelectCourse)
        let transData = []
        for (let course of this.allCourse) {
          const courseId = course.id

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
      } else {
        Message.warning(`查询信息错误: ${res.message}`)
      }
    })
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