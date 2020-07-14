<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <LoginComponect />
  </div>
</template>

<script>
import LoginComponect from "@/components/LoginComponect.vue";

export default {
  name: "Login",
  components: {
    LoginComponect
  }
};
</script>