import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import axios from 'axios'

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");

axios.get('/main',{
  headers: {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json; charset = utf-8'
  }
})
.then(response => {
  console.log(response.data);
})
.catch(e => {
  console.log('error : ', e)
})

Vue.use(axios)
Vue.prototype.$axios = axios