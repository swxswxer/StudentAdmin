"use strict";(self["webpackChunkstu_admin"]=self["webpackChunkstu_admin"]||[]).push([[790],{7790:function(t,e,s){s.r(e),s.d(e,{default:function(){return k}});var a=function(){var t=this,e=t._self._c;return e("div",{staticStyle:{width:"100%",height:"100%"}},[e("div",{staticClass:"main",attrs:{id:"main"}},[e("h1",[t._v("学生信息管理系统")]),e("div",{staticClass:"inputModule"},[e("el-input",{staticClass:"username",attrs:{placeholder:"Please input user Name"},model:{value:t.usrInput,callback:function(e){t.usrInput=e},expression:"usrInput"}}),e("el-input",{staticClass:"password",attrs:{placeholder:"Please input password","show-password":""},model:{value:t.pwdInput,callback:function(e){t.pwdInput=e},expression:"pwdInput"}})],1),e("div",{staticClass:"bottom"},[e("el-button",{attrs:{type:"success",size:"small"},on:{click:t.loginFunc}},[t._v("登录")]),e("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.registerFunc}},[t._v("注册")])],1),e("br")]),e("el-dialog",{attrs:{title:"注册",visible:t.dialogVisible,width:"30%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[e("register-page")],1)],1)},r=[],o=s(2996),i=s.n(o),n=(s(7658),s(58));function l(t,e){return(0,n.W)({url:"/stu-admin/login",method:"post",data:{username:t,password:e},headers:{"Content-Type":"application/x-www-form-urlencoded"}}).then((t=>(!0===t.success?i().success(t.message):i().error(t.message),t)))}var u=function(){var t=this,e=t._self._c;return e("div",{staticClass:"registerPage"},[e("el-form",{ref:"formData",staticClass:"demo-formData",attrs:{model:t.formData,"status-icon":"",rules:t.rules,"label-width":"100px"}},[e("el-form-item",{attrs:{label:"用户名",prop:"name"}},[e("el-input",{model:{value:t.formData.name,callback:function(e){t.$set(t.formData,"name",e)},expression:"formData.name"}})],1),e("el-form-item",{attrs:{label:"密码",prop:"pass"}},[e("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:t.formData.pass,callback:function(e){t.$set(t.formData,"pass",e)},expression:"formData.pass"}})],1),e("el-form-item",{attrs:{label:"确认密码",prop:"checkPass"}},[e("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:t.formData.checkPass,callback:function(e){t.$set(t.formData,"checkPass",e)},expression:"formData.checkPass"}})],1),e("el-form-item",[e("el-button",{attrs:{type:"primary",loading:t.submitLoading},on:{click:function(e){return t.submitForm("formData")}}},[t._v("提交")]),e("el-button",{on:{click:function(e){return t.resetForm("formData")}}},[t._v("重置")])],1)],1)],1)},c=[];function m(t,e){return(0,n.W)({url:"/stu-admin/register",method:"post",data:{username:t,password:e},headers:{"Content-Type":"application/x-www-form-urlencoded"}})}var p={name:"RegisterPage",data(){let t=(t,e,s)=>{""===e?s(new Error("请输入密码")):(""!==this.formData.checkPass&&this.$refs.formData.validateField("checkPass"),s())},e=(t,e,s)=>{""===e?s(new Error("请再次输入密码")):e!==this.formData.pass?s(new Error("两次输入密码不一致!")):s()};return{submitLoading:!1,formData:{name:"",pass:"",checkPass:""},rules:{pass:[{validator:t,trigger:"blur"}],checkPass:[{validator:e,trigger:"blur"}]}}},methods:{submitForm(t){this.$refs[t].validate((t=>{if(!t)return console.log("error submit!!"),!1})),this.submitLoading=!0,m(this.formData.name,this.formData.pass).then((t=>{!0===t.success?(i().success("注册成功"),sessionStorage.setItem("username",this.formData.name),this.$router.push("/home/student_info").catch((()=>{})),this.$router.replace("/home/student_info")):i().warning("注册失败, "+t.message),this.submitLoading=!1}))},resetForm(t){this.$refs[t].resetFields()}}},d=p,h=s(1001),f=(0,h.Z)(d,u,c,!1,null,"d17500cc",null),g=f.exports,b={name:"LoginPage",components:{RegisterPage:g},data(){return{dialogVisible:!1,usrInput:"",pwdInput:""}},methods:{loginFunc(){if(console.log("login"),""===this.usrInput||""===this.pwdInput)i().warning("请输入用户名或密码");else{const t=this.$loading({lock:!0,text:"Loading",spinner:"el-icon-loading",background:"rgba(0, 0, 0, 0.7)"});l(this.usrInput,this.pwdInput).then((e=>{console.log(e),t.close(),!0===e.success&&(sessionStorage.setItem("username",this.usrInput),this.$router.push("/home").catch((()=>{})),this.$router.replace("/home"))}))}},registerFunc(){console.log("register"),this.dialogVisible=!0}}},w=b,v=(0,h.Z)(w,a,r,!1,null,null,null),k=v.exports}}]);
//# sourceMappingURL=790.e403e322.js.map