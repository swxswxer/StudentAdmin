<template>
  <div class="expandInfo">

  </div>
</template>

<script>
export default {
  name: "StudentInfoExpand",
  props: {
    stuName: String,
    stuId: Number
  },
  created() {
    console.log("expand name: " + this.stuName + " id: " + this.stuId)
  }
}
</script>

<style scoped>
.expandInfo {
  width: 100%;
  height: 100px;
  background-color: black;
}
</style>