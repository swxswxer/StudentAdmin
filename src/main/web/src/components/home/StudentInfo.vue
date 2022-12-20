<template>
  <div id="studentInfo" class="studentInfo">
    <div id="tableHeader" class="tableHeader">
      <el-row type="flex" justify="start" align="middle" :gutter="5" style="height: 100%; margin-left: 10px">
        <el-col :span="3">
          <el-input v-model="nameInput" placeholder="请输入学生姓名"></el-input>
        </el-col>
        <el-col :span="3">
          <el-input v-model="majorInput" placeholder="请输入专业"></el-input>
        </el-col>
        <el-col :span="3" :pull="1" style="margin-left: 10px">
          <el-button type="primary" size="medium" @click="searchClick" :loading="searchLoading">查询</el-button>
        </el-col>
      </el-row>
    </div>
    <div class="table">
      <el-table
          stripe
          highlight-current-row
          style="width: 100%"
          :show-header="showHeader"
          :loading="tableLoading"
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
  </div>
</template>

<script>
import {getStudentInfo} from "@/network/student";

export default {
  name: "StudentInfo",
  data() {
    return {
      tableLoading: false,
      showHeader: false,
      searchLoading: false,
      nameInput: '',
      majorInput: '',
      tableHeight: 0,
      tableData: [],
    }
  },
  created() {
    this.$nextTick(() => {
      this.tableHeight = document.getElementById("studentInfo").offsetHeight - document.getElementById("tableHeader").offsetHeight
    })
    this.tableLoading = true
    getStudentInfo().then(res => {
      if (res.status === true) {
        this.tableData = res.data
      }
      if (this.tableData.length === 0) {
        this.showHeader = false
      }
      this.tableLoading = false
    })
  },
  methods: {
    handleEdit(index, row) {
      console.log("edit index: " + index + " row: " + row)
    },
    handleDelete(index, row) {
      console.log("edit index: " + index + " row: " + row)
    },
    searchClick() {
      console.log("name: " + this.nameInput + " major: " + this.majorInput)
      this.searchLoading = true
      this.searchLoading = false
    }
  }
}
</script>

<style scoped>
.studentInfo {
  height: 100%;
  width: calc(100% - 5px);
}

.tableHeader {
  width: 100%;
  height: 60px;
  border-bottom: 1px solid #EBEEF5;
}

</style>