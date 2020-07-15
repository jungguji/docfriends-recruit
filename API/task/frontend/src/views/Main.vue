<template>
  <div class="main">
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
