<template>
  <div class="list">
    <h2>{{pageTitle}}</h2>
    <div class="question" v-for="(question, id) in questionList" :key="id"
    @click="toDetail(question.id)">
        <span> {{question.title}} </span> <br />
        <span> {{question.tag}} </span> <br />
        <span> {{question.content}} </span> <br />
        <span> 답변 {{question.answerCount}} </span> <span> {{question.createDate}} </span>
    </div>
  </div>
</template>

<script>
import api from "./backend-api";

export default {
  name: 'MainList',
  data: function() {
    return {
      pageTitle: 'Doctalk',
      questionList: [],
      errors: []
    }
  },
  methods: {
    toDetail(id) {
      this.$router.push(`detail/${id}`)
    }
  },
  mounted () {
    api.getQuestionList()
    .then((response) => {
      this.questionList = response.data;
      console.log(response.data)
    })
    .catch(e => {
      this.errors.push(e)
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.list {
  background-color:wheat;
}
.question {
  background-color: white;
  width: 35%;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 1rem;
}
</style>
