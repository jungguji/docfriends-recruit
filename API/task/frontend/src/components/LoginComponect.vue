<template>
  <div class="unprotected" v-if="loginError">
    <h1><b-badge variant="danger">ID 혹은 비밀번호가 틀립니다. </b-badge></h1>
    <h5>ID 혹은 비밀번호를 확인 후 재시도 해주세요. </h5>
  </div>
  <div class="unprotected" v-else>
    <form @submit.prevent="callLogin()">
        <input type="text" placeholder="이메일 주소를 입력 해주세요." v-model="user" class="input-content"> <br />
        <input type="password" placeholder="비밀번호를 입력해 주세요." v-model="password" class="input-content"> <br />
      <b-btn variant="success" type="submit">Login</b-btn>
      <p v-if="error" class="error">Bad login information</p>
    </form>
  </div>
</template>

<script>
import api from "./backend-api";

export default {
  name: 'LoginComp',
  data: function() {
    return {
      loginSuccess: false,
      loginError: false,
      user: '',
      password: '',
      error: false
    }
  },
  methods: {
    callLogin() {
      api.getTest(this.user, this.password).then(response => {
        console.log("Response: '" + response.data + "' with Statuscode " + response.status)
        if(response.status == 200) {
          this.loginSuccess = true
        }
      }).catch(error => {
        console.log("Error: " + error)
        this.loginError = true
      })
    }
  }
}
</script>

<style scoped>
.input-content {
  width: 35%;
  margin-bottom: 1rem;
}
</style>