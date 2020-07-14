<template>
  <div class="unprotected" v-if="loginError">
    <h1><b-badge variant="danger">ID 혹은 비밀번호가 틀립니다. </b-badge></h1>
    <h5>ID 혹은 비밀번호를 확인 후 재시도 해주세요. </h5>
  </div>
  <div class="unprotected" v-else>
    <form @submit.prevent="callLogin()">
      <input type="text" placeholder="username" v-model="user">
      <input type="password" placeholder="password" v-model="password">
      <b-btn variant="success" type="submit">Login</b-btn>
      <p v-if="error" class="error">Bad login information</p>
    </form>
  </div>
</template>

<script>
import api from "./backend-api";

export default {
  name: 'MainList',
  data: function() {
    return {
      loginSuccess: false,
      error: false
    }
  },
  methods: {
  },
  mounted () {
    api.getTest()
  }
}
</script>