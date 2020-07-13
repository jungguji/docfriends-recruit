<template>
  <div class="layout">
    <h2>{{pageTitle}}</h2>
    <div class="content" v-for="(question, id) in questionList" :key="id"
    @click="toDetail(question.id)">
    <div class="title">
        <h2> {{question.title}} </h2>
        <span class="gray-font"> {{question.tag}} </span> <br />
    </div>
     <div class="consult-content">
        <span> {{question.content}} </span> <br />
      </div>
      <div class="content-floor">
        <span style="color: green"> 답변 {{question.answerCount}} </span> <span class="gray-font" style="float: right; padding-right: 1rem;"> {{question.createDate}} </span>
      </div>
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
</style>
