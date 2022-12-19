<template>
  <div style="width: 100%; height: 100%">
    <div id="main" class="main">
      <h1>学生信息管理系统</h1>
      <div class="inputModule">
        <el-input class="username" placeholder="Please input user Name" v-model="usrInput"></el-input>
        <el-input class="password" placeholder="Please input password" v-model="pwdInput" show-password></el-input>
      </div>
      <div class="bottom">
        <el-button type="success" size="small" @click="loginFunc">登录</el-button>
        <el-button type="primary" size="small" @click="registerFunc">注册</el-button>
      </div>
      <br/>
    </div>
  </div>
</template>

<script>
// import {login} from "@/network/login";
import {Message} from "element-ui";

export default {
  name: "LoginPage",
  data() {
    return {
      usrInput: '',
      pwdInput: ''
    }
  },
  methods: {
    loginFunc() {
      console.log("login")
      if (this.usrInput === '' || this.pwdInput === '') {
        Message.warning("请输入用户名或密码")
      } else {
        const loading = this.$loading({
          lock: true,
          text: 'Loading',
          spinner: 'el-icon-loading',
          background: 'rgba(0, 0, 0, 0.7)'
        });

        loading.close()
        this.$router.push('/home').catch(()=>{})
        this.$router.replace('/home')
        // login(this.usrInput, this.pwdInput).then(res => {
        //   console.log(res);
        //   loading.close()
        //   if (res.success === true) {
        //     this.$router.push('/rent').catch(()=>{})
        //     this.$router.replace('/rent')
        //   }
        // })
      }
    },
    registerFunc() {
      console.log("register")
    }
  }
};
</script>

<style>
.main {
  background: rgba(255, 255, 255, 0.4);
  margin: auto;
  width: 30%;
  height: 200px;
  border-radius: 3rem;
  box-shadow: 0 0 8px -5px #000000;
  padding: 3% 5px 5%;

  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

.inputModule {
  width: 50%;
  margin: 0 auto;
}

.username {
  margin: 5px 0;
}

.password {
  margin: 5px 0;
}

h1 {
  cursor: default;
  user-select: none;
}

.bottom {
  margin-top: 10px;
}
</style>
