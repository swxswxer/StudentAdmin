<template>
  <div class="main">
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
</template>

<script>
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
