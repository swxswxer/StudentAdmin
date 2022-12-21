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
            <el-table-column prop="courseId" label="课程id"/>
            <el-table-column prop="courseName" label="课程名字"/>
            <el-table-column prop="courseScore" label="学分"/>
            <el-table-column prop="courseTime" label="时长"/>
          </el-table>
        </el-col>
        <el-col :span="12">
          <div class="description">
            <el-descriptions title="课程统计">
              <el-descriptions-item label="修读课程数">{{courseTotal}}</el-descriptions-item>
              <el-descriptions-item label="修读总学分">{{ courseScores }}</el-descriptions-item>
            </el-descriptions>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "StudentInfoExpand",
  data() {
    return {
      tableLoading: false,
      courseTotal: 0,
      courseScores: 0,
      tableData: [
        {
          courseId: 123456,
          courseName: "java 程序设计",
          courseScore: 4,
          courseTime: "8周"
        },
        {
          courseId: 123456,
          courseName: "java 程序设计",
          courseScore: 4,
          courseTime: "8周"
        },
        {
          courseId: 123456,
          courseName: "java 程序设计",
          courseScore: 4,
          courseTime: "8周"
        },
        {
          courseId: 123456,
          courseName: "java 程序设计",
          courseScore: 4,
          courseTime: "8周"
        },
        {
          courseId: 123456,
          courseName: "java 程序设计",
          courseScore: 4,
          courseTime: "8周"
        },
        {
          courseId: 123456,
          courseName: "java 程序设计",
          courseScore: 4,
          courseTime: "8周"
        },
        {
          courseId: 123456,
          courseName: "java 程序设计",
          courseScore: 4,
          courseTime: "8周"
        },
        {
          courseId: 123456,
          courseName: "java 程序设计",
          courseScore: 4,
          courseTime: "8周"
        },
      ]
    }
  },
  props: {
    stuName: String,
    stuId: Number
  },
  created() {
    console.log("expand name: " + this.stuName + " id: " + this.stuId)
    // this.tableLoading = true

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
  /*background-color: white;*/
}

.table {
  /*padding: 0 5px;*/
  border-right: 3px solid #EBEEF5;
}

.description {
  background-color: white;
  border-radius: 10px;
  padding: 10px;
  margin: 0 auto
  /*border: 1px solid black;*/
}

</style>