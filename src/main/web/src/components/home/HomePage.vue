<template>
  <el-container style="height: 100%">
    <el-aside style="width: 250px">
      <el-menu
          :router="isRouter"
          :default-active="activeIndex"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          class="container-menu">
        <div class="title">
          StudentAdmin
        </div>
        <el-menu-item index="/home/student_info">
          <i class="el-icon-user"></i>
          <span slot="title">学生信息</span>
        </el-menu-item>
        <el-menu-item index="/home/class_info">
          <i class="el-icon-reading"></i>
          <span slot="title">课程信息</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header class="header">
        <div class="userModule">
          <div class="userAvatar center">
            <el-avatar size="medium"
                       src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></el-avatar>
          </div>
          <span class="userName center">{{ username }}</span>
        </div>
      </el-header>
      <el-main class="homeMain">
        <keep-alive>
          <router-view></router-view>
        </keep-alive>
      </el-main>
    </el-container>
  </el-container>
</template>


<script>

export default {
  name: "HomePage",
  data() {
    return {
      username: '',
      isRouter: true,
      activeIndex: '/home/student_info',
    }
  },
  created() {
    this.username = sessionStorage.getItem("username");
    if (this.$route.fullPath === '/home') {
      this.$router.push(this.activeIndex).catch(() => {
      })
      this.$router.replace(this.activeIndex)
    }
  },
}
</script>

<style scoped>
.homeMain {
  width: calc(100% - 20px);
  height: 100%;
  padding: 0;
  margin: 10px 10px 10px 10px;
  border-radius: 10px;
  background-color: white;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}

.title {
  color: lightblue;
  font-size: 30px;
  margin: 20px 0;
}

.header {
  height: 100%;
  border-radius: 10px;
  margin: 7px 10px 0 10px;
  background-color: white;
  display: flex;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}

.userModule {
  width: 100%;
  height: 100%;
  margin-right: 20px;
  display: flex;
  align-content: center;
  justify-content: end;
}

.center {
  display: flex;
  align-content: center;
  justify-content: center;
  flex-direction: column;
}

.userAvatar {
  margin: 0 10px
}

.userName:hover {
  cursor: pointer;
}

.container-menu {
  height: 100%;
}
</style>