<template>
  <div class="registerPage">
    <el-form :model="formData" status-icon :rules="rules" ref="formData" label-width="100px" class="demo-formData">
      <el-form-item label="用户名" prop="name">
        <el-input v-model="formData.name"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pass">
        <el-input type="password" v-model="formData.pass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="formData.checkPass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('formData')" :loading="submitLoading">提交</el-button>
        <el-button @click="resetForm('formData')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {register} from "@/network/register";
import {Message} from "element-ui";

export default {
  name: "RegisterPage",
  data() {
    let validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.formData.checkPass !== '') {
          this.$refs.formData.validateField('checkPass');
        }
        callback();
      }
    };
    let validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.formData.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      submitLoading: false,
      formData: {
        name: '',
        pass: '',
        checkPass: '',
      },
      rules: {
        pass: [
          {validator: validatePass, trigger: 'blur'}
        ],
        checkPass: [
          {validator: validatePass2, trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (!valid) {
          console.log('error submit!!');
          return false;
        }
      });
      this.submitLoading = true
      register(this.formData.name, this.formData.pass).then(res => {
        if (res.success === true) {
          Message.success("注册成功")
          sessionStorage.setItem("username", this.formData.name);
          this.$router.push("/home/student_info").catch(() => {})
          this.$router.replace("/home/student_info")
        } else {
          Message.warning("注册失败, " + res.message)
        }
        this.submitLoading = false
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
.registerPage {
  width: 80%;
}
</style>