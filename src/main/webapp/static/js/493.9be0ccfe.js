"use strict";(self["webpackChunkstu_admin"]=self["webpackChunkstu_admin"]||[]).push([[493],{4493:function(e,t,a){a.r(t),a.d(t,{default:function(){return j}});var s=function(){var e=this,t=e._self._c;return t("div",{staticClass:"studentInfo",attrs:{id:"studentInfo"}},[t("div",{staticClass:"tableHeader",attrs:{id:"tableHeader"}},[t("el-row",{staticStyle:{height:"100%","margin-left":"10px"},attrs:{type:"flex",justify:"start",align:"middle",gutter:5}},[t("el-col",{attrs:{span:3}},[t("el-input",{attrs:{placeholder:"请输入学生姓名"},model:{value:e.nameInput,callback:function(t){e.nameInput=t},expression:"nameInput"}})],1),t("el-col",{attrs:{span:3}},[t("el-input",{attrs:{placeholder:"请输入专业"},model:{value:e.majorInput,callback:function(t){e.majorInput=t},expression:"majorInput"}})],1),t("el-col",{staticStyle:{"margin-left":"10px"},attrs:{span:3,pull:1}},[t("el-button",{attrs:{type:"primary",size:"medium",loading:e.searchLoading},on:{click:e.searchClick}},[e._v("查询")])],1)],1)],1),t("div",{staticClass:"table"},[t("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{stripe:"","highlight-current-row":"","show-header":e.showHeader,data:e.tableData,height:e.tableHeight}},[t("el-table-column",{attrs:{type:"expand"},scopedSlots:e._u([{key:"default",fn:function(e){return[t("student-info-expand",{attrs:{"stu-name":e.row.name,"stu-id":e.row.studentid}})]}}])}),t("el-table-column",{attrs:{prop:"studentid",label:"学号"}}),t("el-table-column",{attrs:{prop:"name",label:"姓名"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("el-tag",{attrs:{size:"medium"}},[e._v(e._s(a.row.name))])]}}])}),t("el-table-column",{attrs:{prop:"age",label:"年龄"}}),t("el-table-column",{attrs:{prop:"sex",label:"性别"}}),t("el-table-column",{attrs:{prop:"major",label:"专业"}}),t("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("el-button",{attrs:{size:"mini"},on:{click:function(t){return e.handleEdit(a.$index,a.row)}}},[e._v("编辑 ")]),t("el-button",{attrs:{size:"mini",type:"danger",loading:a.row.loading},on:{click:function(t){return e.handleDelete(a.$index,a.row)}}},[e._v("删除 ")])]}}])})],1)],1)])},n=[],l=a(2996),o=a.n(l),r=a(58);function i(){return(0,r.W)({url:"/stu-admin/student/selectAll",method:"get"})}function u(e){return(0,r.W)({url:"/stu-admin/student/selectByName",method:"get",params:{name:e}})}function d(e){return(0,r.W)({url:"/stu-admin/student/selectByName",method:"get",params:{major:e}})}function c(e){return(0,r.W)({url:"/stu-admin/student/deleteById",method:"get",params:{studentid:e}})}var m=function(){var e=this,t=e._self._c;return t("div",{staticClass:"expandInfo"},[t("div",{staticClass:"mainModule"},[t("el-row",{staticStyle:{width:"100%"},attrs:{type:"flex"}},[t("el-col",{staticClass:"table",attrs:{span:12}},[t("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticClass:"table",attrs:{"highlight-current-row":"","max-height":300,"show-header":!1,data:e.tableData}},[t("el-table-column",{attrs:{prop:"courseId",label:"课程id"}}),t("el-table-column",{attrs:{prop:"courseName",label:"课程名字"}}),t("el-table-column",{attrs:{prop:"courseScore",label:"学分"}}),t("el-table-column",{attrs:{prop:"courseTime",label:"时长"}})],1)],1),t("el-col",{attrs:{span:12}},[t("div",{staticClass:"description"},[t("el-descriptions",{attrs:{title:"课程统计"}},[t("el-descriptions-item",{attrs:{label:"修读课程数"}},[e._v(e._s(e.courseTotal))]),t("el-descriptions-item",{attrs:{label:"修读总学分"}},[e._v(e._s(e.courseScores))])],1)],1)])],1)],1)])},h=[],p={name:"StudentInfoExpand",data(){return{tableLoading:!1,courseTotal:0,courseScores:0,tableData:[{courseId:123456,courseName:"java 程序设计",courseScore:4,courseTime:"8周"},{courseId:123456,courseName:"java 程序设计",courseScore:4,courseTime:"8周"},{courseId:123456,courseName:"java 程序设计",courseScore:4,courseTime:"8周"},{courseId:123456,courseName:"java 程序设计",courseScore:4,courseTime:"8周"},{courseId:123456,courseName:"java 程序设计",courseScore:4,courseTime:"8周"},{courseId:123456,courseName:"java 程序设计",courseScore:4,courseTime:"8周"},{courseId:123456,courseName:"java 程序设计",courseScore:4,courseTime:"8周"},{courseId:123456,courseName:"java 程序设计",courseScore:4,courseTime:"8周"}]}},props:{stuName:String,stuId:Number},created(){console.log("expand name: "+this.stuName+" id: "+this.stuId)}},g=p,b=a(1001),f=(0,b.Z)(g,m,h,!1,null,"2eee18cc",null),I=f.exports,v={name:"StudentInfo",components:{StudentInfoExpand:I},data(){return{tableLoading:!1,showHeader:!1,searchLoading:!1,nameInput:"",majorInput:"",tableHeight:0,tableData:[{studentid:123456,name:"yong",age:18,sex:"male",major:"软件工程"},{studentid:123456,name:"yong",age:18,sex:"male",major:"软件工程"},{studentid:123456,name:"yong",age:18,sex:"male",major:"软件工程"}]}},created(){console.log("table length: "+this.tableData.length),this.showHeader=0!==this.tableData.length,this.$nextTick((()=>{this.tableHeight=document.getElementById("studentInfo").offsetHeight-document.getElementById("tableHeader").offsetHeight})),this.tableLoading=!0,i().then((e=>{!0===e.status&&(this.tableData=e.data,this.addLoadingToResp()),this.showHeader=0!==this.tableData.length,this.tableLoading=!1}))},methods:{addLoadingToResp(){for(let e=0;e<this.tableData.length;e++)this.$set(this.tableData[e],"loading",!1)},handleEdit(e,t){console.log("edit index: "+e+" row: "+t)},handleDelete(e,t){console.log("delete index: "+e),t.loading=!0,c(t.studentid).then((e=>{!0!==e.success?o().warning(e.message):o().success("删除成功")}))},searchClick(){console.log("name: "+this.nameInput+" major: "+this.majorInput),this.searchLoading=!0,""!==this.nameInput?u(this.nameInput).then((e=>{!0===e.status&&(this.tableData=e.data,this.addLoadingToResp()),this.showHeader=0!==this.tableData.length,this.searchLoading=!1})):""!==this.majorInput&&d(this.majorInput).then((e=>{!0===e.status&&(this.tableData=e.data,this.addLoadingToResp()),this.showHeader=0!==this.tableData.length,this.searchLoading=!1}))}}},w=v,x=(0,b.Z)(w,s,n,!1,null,"63a55aaf",null),j=x.exports}}]);
//# sourceMappingURL=493.9be0ccfe.js.map