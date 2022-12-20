<template>
  <div>
    <el-table
        stripe
        highlight-current-row
        style="width: 100%"
        :loading="loading"
        :data="tableData"
        :height="tableHeight">
      <el-table-column
          prop="studentid"
          label="学号"
      >
      </el-table-column>
      <el-table-column
          prop="name"
          label="姓名"
      >
        <template slot-scope="scope">
          <el-tag size="medium">{{ scope.row.name }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column
          prop="age"
          label="年龄"
      >
      </el-table-column>
      <el-table-column
          prop="sex"
          label="性别"
      >
      </el-table-column>
      <el-table-column
          prop="major"
          label="专业"
      >
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑
          </el-button>
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import {getStudentInfo} from "@/network/student";

export default {
  name: "StudentInfo",
  data() {
    return {
      loading: false,
      tableHeight: 0,
      tableData: [],
    }
  },
  created() {
    this.tableHeight = window.innerHeight;

    this.loading = true
    getStudentInfo().then(res => {
      if (res.status === true) {
        this.tableData = res.data
      }
      this.loading = false
    })
  },
  methods: {
    handleEdit(index, row) {
      console.log("edit index: " + index + "row: " + row)
    },
    handleDelete(index, row) {
      console.log("edit index: " + index + "row: " + row)
    }
  }
}
</script>

<style scoped>

</style>