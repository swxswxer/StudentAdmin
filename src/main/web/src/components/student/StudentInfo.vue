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
        <el-col :span="3" :pull="1" style="margin-left: 15px">
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
          :data="tableData"
          :height="tableHeight"
          v-loading="tableLoading">
        <el-table-column type="expand">
          <template slot-scope="scope">
            <student-info-expand :stu-name="scope.row.name" :stu-id="scope.row.studentid"/>
          </template>
        </el-table-column>
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
                :loading="scope.row.loading"
                @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog ref="dialog" title="编辑学生信息" :visible.sync="dialogVisible" width="30%" :before-close="beforeDialClose" destroy-on-close>
      <student-info-edit ref="stuEdit" @stuInfoEditCallBack="editCallBack"/>
    </el-dialog>
  </div>
</template>

<script>
import {delectStudentById, getStudentInfo, getStudentInfoByMajor, getStudentInfoByName} from "@/network/student";
import StudentInfoExpand from "@/components/student/StudentInfoExpand";
import StudentInfoEdit from "@/components/student/StudentInfoEdit";
import {Dialog, Message} from "element-ui";


export default {
  name: "StudentInfo",
  components: {
    StudentInfoExpand,
    StudentInfoEdit
  },
  extends: Dialog,
  data() {
    return {
      dialogVisible: false,
      tableLoading: false,
      showHeader: false,
      searchLoading: false,

      originSelectData: {},
      selectIndex: -1,
      nameInput: '',
      majorInput: '',
      tableHeight: 0,
      tableData: [],
    }
  },
  mounted() {
    this.$refs.dialog.rendered = true
  },
  created() {
    console.log("table length: " + this.tableData.length)
    this.showHeader = this.tableData.length !== 0;
    this.$nextTick(() => {
      this.tableHeight = document.getElementById("studentInfo").offsetHeight - document.getElementById("tableHeader").offsetHeight
    })
    this.tableLoading = true
    getStudentInfo().then(res => {
      if (res.status === true) {
        this.tableData = res.data
        this.addLoadingToResp()
      }
      this.showHeader = this.tableData.length !== 0;
      this.tableLoading = false
    })
  },
  methods: {
    beforeDialClose(done) {
      const hasSubmit = this.$refs.stuEdit.hasSubmit
      if (!hasSubmit) {
        this.$refs.stuEdit.formData.studentid = this.originSelectData.studentid
        this.$refs.stuEdit.formData.name = this.originSelectData.name
        this.$refs.stuEdit.formData.age = this.originSelectData.age
        this.$refs.stuEdit.formData.major = this.originSelectData.major
        this.$refs.stuEdit.formData.sex = this.originSelectData.sex
      }
      done()
    },
    editCallBack(item) {
      this.tableData[this.selectIndex] = item;
      console.log(this.tableData)
    },
    addLoadingToResp() {
      for (let idx = 0; idx < this.tableData.length; idx++) {
        this.$set(this.tableData[idx], 'loading', false)
      }
    },
    handleEdit(index, row) {
      this.selectIndex = index;
      Object.assign(this.originSelectData, row)
      this.$refs.stuEdit.formData = row;
      this.dialogVisible = true;
    },
    handleDelete(index, row) {
      row.loading = true
      delectStudentById(row.studentid).then(res => {
        if (res.success !== true) {
          Message.warning(res.message)
        } else {
          Message.success("删除成功")
        }
        row.loading = false
        this.tableData.splice(index, 1)
      })
    },
    searchClick() {
      this.searchLoading = true

      if (this.nameInput !== '') {
        getStudentInfoByName(this.nameInput).then(res => {
          if (res.status === true) {
            this.tableData = res.data
            this.addLoadingToResp()
          }
          this.showHeader = this.tableData.length !== 0;
          this.searchLoading = false
        })
      } else if (this.majorInput !== '') {
        getStudentInfoByMajor(this.majorInput).then(res => {
          if (res.status === true) {
            this.tableData = res.data
            this.addLoadingToResp()
          }
          this.showHeader = this.tableData.length !== 0;
          this.searchLoading = false
        })
      } else {
        getStudentInfo().then(res => {
          if (res.status === true) {
            this.tableData = res.data
            this.addLoadingToResp()
          }
          this.showHeader = this.tableData.length !== 0;
          this.tableLoading = false
          this.searchLoading = false
        })
      }
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