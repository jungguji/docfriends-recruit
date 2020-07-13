<template>
  <div>
    <div class="question">
      {{consult.title}}
      {{consult.content}}
      {{consult.tag}}
      {{consult.createDate}}
    </div>
    <div class="answer" v-for="(answer, id) in consult.answers" :key="id">
      {{answer.answerContent}}
      {{answer.doctorName}}
      {{answer.hospitalName}}
      {{answer.hospitalAddress}}
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