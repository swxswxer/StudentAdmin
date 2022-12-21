<template>
  <div id="courseInfo" class="courseInfo">
    <div class="table">
      <el-table
          stripe
          highlight-current-row
          style="width: 100%"
          :show-header="showHeader"
          :data="tableData"
          :height="tableHeight"
          v-loading="tableLoading">
        <el-table-column
            prop="id"
            label="课程id"
        >
        </el-table-column>
        <el-table-column
            prop="name"
            label="课程名"
        >
          <template slot-scope="scope">
            <el-tag size="medium">{{ scope.row.name }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column
            prop="credit"
            label="课程学分"
        >
        </el-table-column>
        <el-table-column
            prop="time"
            label="课程周数"
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
    <el-dialog ref="dialog" title="编辑课程信息" :visible.sync="dialogVisible" width="30%"
               :before-close="beforeDialClose" destroy-on-close>
      <course-info-edit ref="courseEdit" @stuInfoEditCallBack="editCallBack"/>
    </el-dialog>
  </div>

</template>

<script>
import {
  deleteCourse,
  getAllCourse,
} from "@/network/course";
import {Dialog, Message} from "element-ui";
import CourseInfoEdit from "@/components/course/CourseInfoEdit";

export default {
  name: "CourseInfo",
  components: {
    CourseInfoEdit
  },
  extends: Dialog,
  data() {
    return {
      dialogVisible: false,
      tableLoading: false,
      showHeader: true,
      originSelectData: {},
      tableData: [],
      tableHeight: 0,
    }
  },
  mounted() {
    this.$refs.dialog.rendered = true
  },
  created() {
    console.log("table length: " + this.tableData.length)
    this.$nextTick(() => {
      this.tableHeight = document.getElementById("courseInfo").offsetHeight
    })
    this.tableLoading = true
    getAllCourse().then(res => {
      if (res.status === true) {
        this.tableData = res.data
        this.addLoadingToResp()
      }
      this.tableLoading = false
    })
  },
  methods: {
    beforeDialClose(done) {
      const hasSubmit = this.$refs.courseEdit.hasSubmit
      if (!hasSubmit) {
        this.$refs.courseEdit.formData.id = this.originSelectData.id
        this.$refs.courseEdit.formData.name = this.originSelectData.name
        this.$refs.courseEdit.formData.credit = this.originSelectData.credit
        this.$refs.courseEdit.formData.time = this.originSelectData.time
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
      this.$refs.courseEdit.formData = row;
      this.dialogVisible = true;
    },
    handleDelete(index, row) {
      row.loading = true
      console.log(row.id)
      deleteCourse(row.id).then(res => {
        if (res.success !== true) {
          Message.warning(res.message)
        } else {
          Message.success("删除成功")
        }
        row.loading = false
        this.tableData.splice(index, 1)
      })
    },
  }
}
</script>

<style scoped>
.courseInfo {
  height: 100%;
  width: calc(100% - 5px);
}
</style>