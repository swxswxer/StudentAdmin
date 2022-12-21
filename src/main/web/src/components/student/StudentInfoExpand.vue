<template>
  <div class="expandInfo">
    <div class="mainModule">
      <el-row type="flex" style="width: 100%">
        <el-col class="table" :span="12">
          <el-table
              class="table"
              highlight-current-row
              :max-height="300"
              :show-header="false"
              v-loading="tableLoading"
              :data="tableData">
            <el-table-column prop="id" label="课程id"/>
            <el-table-column prop="name" label="课程名字"/>
            <el-table-column prop="credit" label="学分"/>
            <el-table-column prop="time" label="时长"/>
          </el-table>
        </el-col>
        <el-col :span="12">
          <div class="description">
            <el-descriptions title="课程统计">
              <el-descriptions-item label="修读课程数">{{courseTotal}}</el-descriptions-item>
              <el-descriptions-item label="修读总学分">{{ courseScores }}</el-descriptions-item>
            </el-descriptions>
            <div class="courseModify">
              <el-button type="primary" @click="modifyCourseClick">修改课程信息</el-button>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <el-dialog title="编辑学生课程信息" :visible.sync="dialogVisible" width="70%">
      <student-course-modify :stu-name="stuName" :stu-id="stuId" :selectCourse="tableData"/>
    </el-dialog>
  </div>
</template>

<script>
import studentCourseModify from "@/components/student/studentCourseModify";
import {queryStudentCourse} from "@/network/student";
import {Message} from "element-ui";

export default {
  name: "StudentInfoExpand",
  components: {
    studentCourseModify
  },
  data() {
    return {
      dialogVisible: false,
      tableLoading: false,
      courseTotal: 0,
      courseScores: 0,
      tableData: []
    }
  },
  props: {
    stuName: String,
    stuId: Number
  },
  created() {
    console.log("expand name: " + this.stuName + " id: " + this.stuId)
    this.tableLoading = true
    queryStudentCourse(this.stuId).then(res => {
      if (res.status === true) {
        this.tableData = res.data
        this.courseTotal = this.tableData.length

        let totalCredit = 0;
        for (let course of this.tableData) {
          totalCredit += course.credit
        }
        this.courseScores = totalCredit
      } else {
        Message.warning(res.message)
        this.courseTotal = 0;
        this.courseScores = 0;
      }
    }).then(() => {
      this.tableLoading = false
    })
  },
  methods: {
    modifyCourseClick() {
      // TODO modify student course
      this.dialogVisible = true
    }
  }

}
</script>

<style scoped>
.expandInfo {
  width: calc(100% - 20px);
  margin: 0 10px;
  border-radius: 10px;
  background-color: #EBEEF5;
  overflow:hidden;
}

.mainModule {
  width: 100%;
  padding: 7px;
  border-radius: 8px;
}

.table {
  border-radius: 10px;
  border-right: 3px solid #EBEEF5;
}

.description {
  background-color: white;
  border-radius: 10px;
  padding: 20px;
  margin: 0 auto
}

.courseModify {
  margin-top: 5px;
}

</style>