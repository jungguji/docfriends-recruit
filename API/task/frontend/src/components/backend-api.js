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
    createUser(firstName, lastName) {
        return AXIOS.post(`/user/` + firstName + '/' + lastName);
    },
    getSecured(user, password) {
        return AXIOS.get(`/secured/`,{
            auth: {
                username: user,
                password: password
            }});
    }
}