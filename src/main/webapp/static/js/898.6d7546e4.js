"use strict";(self["webpackChunkstu_admin"]=self["webpackChunkstu_admin"]||[]).push([[898],{898:function(t,e,a){a.r(e),a.d(e,{default:function(){return k}});var i=function(){var t=this,e=t._self._c;return e("div",{staticClass:"courseInfo",attrs:{id:"courseInfo"}},[e("div",{staticClass:"tableHeader",attrs:{id:"tableHeader"}},[e("el-row",{staticStyle:{height:"100%","margin-left":"10px"},attrs:{type:"flex",justify:"start",align:"middle",gutter:5}},[e("el-col",{staticStyle:{"margin-left":"15px"},attrs:{span:3,push:11}},[e("el-button",{attrs:{type:"primary",size:"medium"},on:{click:t.addCourseClick}},[t._v("添加课程")])],1)],1)],1),e("div",{staticClass:"table"},[e("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{stripe:"","highlight-current-row":"","show-header":t.showHeader,data:t.tableData,height:t.tableHeight}},[e("el-table-column",{attrs:{prop:"id",label:"课程id"}}),e("el-table-column",{attrs:{prop:"name",label:"课程名"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-tag",{attrs:{size:"medium"}},[t._v(t._s(a.row.name))])]}}])}),e("el-table-column",{attrs:{prop:"credit",label:"课程学分"}}),e("el-table-column",{attrs:{prop:"time",label:"课程周数"}}),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.handleEdit(a.$index,a.row)}}},[t._v("编辑 ")]),e("el-button",{attrs:{size:"mini",type:"danger",loading:a.row.loading},on:{click:function(e){return t.handleDelete(a.$index,a.row)}}},[t._v("删除 ")])]}}])})],1)],1),e("el-dialog",{ref:"dialog",attrs:{title:"编辑课程信息",visible:t.dialogVisible,width:"30%","before-close":t.beforeDialClose,"destroy-on-close":""},on:{"update:visible":function(e){t.dialogVisible=e}}},[e("course-info-edit",{ref:"courseEdit",attrs:{type:"add"}})],1),e("el-dialog",{ref:"addDialog",attrs:{title:"添加课程信息",visible:t.addDialogVisible,width:"30%","destroy-on-close":""},on:{"update:visible":function(e){t.addDialogVisible=e}}},[e("course-info-edit",{ref:"courseAdd",attrs:{type:"add"},on:{stuInfoEditCallBack:t.addCallBack}})],1)],1)},s=[],l=a(2996),o=a.n(l),r=a(5574),n=a.n(r),d=(a(7658),a(8865)),u=function(){var t=this,e=t._self._c;return e("div",{staticClass:"courseModify"},[e("div",{staticClass:"courseEditForm"},[e("el-form",{attrs:{model:t.formData,"label-position":"right","label-width":"80px"}},[e("el-form-item",{attrs:{label:"课程id"}},[e("el-input",{staticClass:"formInput",model:{value:t.formData.id,callback:function(e){t.$set(t.formData,"id",e)},expression:"formData.id"}})],1),e("el-form-item",{attrs:{label:"课程名字"}},[e("el-input",{model:{value:t.formData.name,callback:function(e){t.$set(t.formData,"name",e)},expression:"formData.name"}})],1),e("el-form-item",{attrs:{label:"课程学分"}},[e("el-input",{model:{value:t.formData.credit,callback:function(e){t.$set(t.formData,"credit",e)},expression:"formData.credit"}})],1),e("el-form-item",{attrs:{label:"课程周数"}},[e("el-input",{model:{value:t.formData.time,callback:function(e){t.$set(t.formData,"time",e)},expression:"formData.time"}})],1)],1),e("el-button",{staticStyle:{width:"150px"},attrs:{type:"primary"},on:{click:t.onSubmit}},[t._v("提交")])],1)])},c=[],m={name:"CourseInfoEdit",props:{type:String},data(){return{hasSubmit:!1,majorData:[],formData:{id:0,name:"",credit:0,time:""}}},methods:{onSubmit(){"add"===this.type?(0,d.bq)(this.formData).then((t=>{!0===t.success?(o().success("提交成功"),this.hasSubmit=!0,this.$emit("courseInfoAddCallBack",this.formData)):o().warning(t.message)})):(0,d.Hf)(this.formData).then((t=>{!0===t.success?(o().success("提交成功"),this.hasSubmit=!0,this.$emit("courseInfoEditCallBack",this.formData)):o().warning(t.message)}))}}},f=m,h=a(1001),b=(0,h.Z)(f,u,c,!1,null,"210727d3",null),p=b.exports,g={name:"CourseInfo",components:{CourseInfoEdit:p},extends:n(),data(){return{addDialogVisible:!1,dialogVisible:!1,tableLoading:!1,showHeader:!0,originSelectData:{},tableData:[],tableHeight:0}},mounted(){this.$refs.dialog.rendered=!0},created(){console.log("table length: "+this.tableData.length),this.$nextTick((()=>{this.tableHeight=document.getElementById("courseInfo").offsetHeight})),this.tableLoading=!0,(0,d.kk)().then((t=>{!0===t.status&&(this.tableData=t.data,this.addLoadingToResp()),this.tableLoading=!1}))},methods:{addCourseClick(){this.addDialogVisible=!0},beforeDialClose(t){const e=this.$refs.courseEdit.hasSubmit;e||(this.$refs.courseEdit.formData.id=this.originSelectData.id,this.$refs.courseEdit.formData.name=this.originSelectData.name,this.$refs.courseEdit.formData.credit=this.originSelectData.credit,this.$refs.courseEdit.formData.time=this.originSelectData.time),t()},addCallBack(t){this.tableData.push(t)},addLoadingToResp(){for(let t=0;t<this.tableData.length;t++)this.$set(this.tableData[t],"loading",!1)},handleEdit(t,e){this.selectIndex=t,Object.assign(this.originSelectData,e),this.$refs.courseEdit.formData=e,this.dialogVisible=!0},handleDelete(t,e){e.loading=!0,console.log(e.id),(0,d.A)(e.id).then((a=>{!0!==a.success?o().warning(a.message):o().success("删除成功"),e.loading=!1,this.tableData.splice(t,1)}))}}},D=g,w=(0,h.Z)(D,i,s,!1,null,"6308cd8c",null),k=w.exports},8865:function(t,e,a){a.d(e,{A:function(){return r},Hf:function(){return o},bq:function(){return l},kk:function(){return s}});var i=a(58);function s(){return(0,i.W)({url:"/stu-admin/curriculum/selectAll",method:"get",headers:{"Content-Type":"application/x-www-form-urlencoded;charset=utf-8"}})}function l(t){return(0,i.W)({url:"/stu-admin/curriculum/add",method:"post",data:t,headers:{"Content-Type":"application/x-www-form-urlencoded;charset=utf-8"}})}function o(t){return(0,i.W)({url:"/stu-admin/curriculum/update",method:"post",data:t,headers:{"Content-Type":"application/x-www-form-urlencoded;charset=utf-8"}})}function r(t){return(0,i.W)({url:"/stu-admin/curriculum/deleteById",method:"get",params:{id:t},headers:{"Content-Type":"application/x-www-form-urlencoded;charset=utf-8"}})}}}]);
//# sourceMappingURL=898.6d7546e4.js.map