<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    Login 페이지
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