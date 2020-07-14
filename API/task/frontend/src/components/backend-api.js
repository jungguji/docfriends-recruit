import axios from 'axios'

const AXIOS = axios.create({
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json; charset = utf-8'
    },
    timeout: 1000
});


export default {
    getQuestionList() {
        return AXIOS.get('/main');
    },
    getConsult(questionId) {
        return AXIOS.get(`/detail/` + questionId);
    },
    getTest(id, password) {
        return AXIOS.post(`/login/vue`, { 
            auth: {
                username: id,
                password: password
          }});
    }
}