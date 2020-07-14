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
    getTest() {
        return AXIOS.get(`/test/`);
    }
}