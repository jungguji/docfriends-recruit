<template>
  <div class="layout">
    <div class="content">
      <div class="title">
        <h2> {{consult.title}} </h2>
        <span class="gray-font"> {{consult.tag}} </span> <br />
        <span class="gray-font"> 상담일자: {{consult.createDate}} </span>
      </div>
      <div v-html="consult.content" class="consult-content">
      </div>
    </div>
    <div class="content" v-for="(answer, id) in consult.answers" :key="id">
      <div class="title">
        <h2> {{answer.doctorName}}원장님의 답변 </h2>
        <span class="gray-font"> 답변일자: {{answer.answerCreateDate}} </span>
      </div>
      <div v-html="answer.answerContent" class="consult-content">
      </div>
     
      <div class="content-floor">
        <b> {{answer.hospitalName}} </b> <br />
        <span class="gray-font"> {{answer.hospitalAddress}} </span>
      </div>
      
      
    </div>
  </div>
</template>

<script>
import api from "./backend-api";

export default {
  name: "ConsultDetail",
  data: function() {
    return {
      consult: '',
      errors: []
    }
  },
  mounted () {
    let _this = this
    _this.id = _this.$route.params.id
    api.getConsult(_this.id)
    .then(response => {
      this.consult = response.data;
    })
    .catch(error => {
      this.errors.push(error);
    })
  }
}
</script>