<template>
  <el-container style="height: 100%">
    <el-aside style="width: 250px">
      <el-menu
          :default-active="activeIndex"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          class="container-menu">
        <div class="title">
          StudentAdmin
        </div>
        <el-menu-item index="/student_info">
          <i class="el-icon-user"></i>
          <span slot="title">学生信息</span>
        </el-menu-item>
        <el-menu-item index="/class_info">
          <i class="el-icon-reading"></i>
          <span slot="title">课程信息</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main class="homeMain">
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
    </el-main>
  </el-container>
</template>


<script>
import {getStudentInfo} from "@/network/student";

export default {
  name: "HomePage",
  data() {
    return {
      loading: false,
      activeIndex: '/student_info',
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
.homeMain {
  width: 100%;
  height: 100%;
}

.title {
  color: lightblue;
  font-size: 30px;
  margin: 20px 0;
}

.container-menu {
  height: 100%;
}
</style>