<template>
  <div class="main">
    <img alt="Vue logo" src="../assets/logo.png" />
    <MainList/>
  </div>
</template>

<script>
// @ is an alias to /src
import MainList from "@/components/MainList.vue";

export default {
  name: "Main",
  components: {
    MainList
  }
};
</script>
