"use strict";(self["webpackChunkstu_admin"]=self["webpackChunkstu_admin"]||[]).push([[683],{5683:function(t,e,a){a.r(e),a.d(e,{default:function(){return c}});var l=function(){var t=this,e=t._self._c;return e("el-container",{staticStyle:{height:"100%"}},[e("el-aside",{staticStyle:{width:"250px"}},[e("el-menu",{staticClass:"container-menu",attrs:{"default-active":t.activeIndex,"background-color":"#545c64","text-color":"#fff","active-text-color":"#ffd04b"}},[e("div",{staticClass:"title"},[t._v(" StudentAdmin ")]),e("el-menu-item",{attrs:{index:"/student_info"}},[e("i",{staticClass:"el-icon-user"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("学生信息")])]),e("el-menu-item",{attrs:{index:"/class_info"}},[e("i",{staticClass:"el-icon-reading"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("课程信息")])])],1)],1),e("el-main",{staticClass:"homeMain"},[e("el-table",{staticStyle:{width:"100%"},attrs:{stripe:"","highlight-current-row":"",data:t.tableData,height:t.tableHeight}},[e("el-table-column",{attrs:{prop:"studentid",label:"学号"}}),e("el-table-column",{attrs:{prop:"name",label:"姓名"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-tag",{attrs:{size:"medium"}},[t._v(t._s(a.row.name))])]}}])}),e("el-table-column",{attrs:{prop:"age",label:"年龄"}}),e("el-table-column",{attrs:{prop:"sex",label:"性别"}}),e("el-table-column",{attrs:{prop:"major",label:"专业"}}),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.handleEdit(a.$index,a.row)}}},[t._v("编辑 ")]),e("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.handleDelete(a.$index,a.row)}}},[t._v("删除 ")])]}}])})],1)],1)],1)},n=[],i=a(4190);function s(){return(0,i.W)({url:"/student/selectAll",method:"get"})}var o={name:"HomePage",data(){return{activeIndex:"/student_info",tableHeight:0,tableData:[{studentid:"123456",name:"why",age:22,sex:"male",major:"软件工程"},{studentid:"123456",name:"why",age:22,sex:"male",major:"软件工程"},{studentid:"123456",name:"why",age:22,sex:"male",major:"软件工程"},{studentid:"123456",name:"why",age:22,sex:"male",major:"软件工程"},{studentid:"123456",name:"why",age:22,sex:"male",major:"软件工程"}]}},created(){this.tableHeight=window.innerHeight,s().then((t=>{this.tableData=t}))},methods:{handleEdit(t,e){console.log("edit index: "+t+"row: "+e)},handleDelete(t,e){console.log("edit index: "+t+"row: "+e)}}},r=o,d=a(1001),u=(0,d.Z)(r,l,n,!1,null,"1a33ca44",null),c=u.exports}}]);
//# sourceMappingURL=683.6a9e7eb0.js.map