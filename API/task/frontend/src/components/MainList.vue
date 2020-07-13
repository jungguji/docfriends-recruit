<template>
  <div class="list">
    <h2>{{pageTitle}}</h2>
    <div class="question" v-for="(question, id) in questionList" :key="id">
        <span> {{question.title}} </span> <br />
        <span> {{question.tag}} </span> <br />
        <span> {{question.content}} </span> <br />
        <span> 답변 {{question.answerCount}} </span> <span> {{question.createDate}} </span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MainList',
  data: function() {
    return {
      pageTitle: 'Doctalk',
      questionList: []
    }
  },
  mounted () {
    let _this = this
    _this.$axios.get('http://127.0.0.1:9000/main')
    .then((response) => {
      response.data.map((item) => {
        _this.questionList.push(item)
      })
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
