<template>
  <el-container>
    <el-aside class="aside"></el-aside>
    <el-main class="main"></el-main>
  </el-container>
</template>


<script>
export default {
  name: "HomePage"
}
</script>

<style scoped>
.aside {
  width: 200px;
  height: 500px;
  background-color: black;
}

.main {
  width: 100%;
  height: 100%;
  background-color: red;
}
</style>