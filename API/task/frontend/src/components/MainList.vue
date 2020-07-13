<template>
  <div class="list">
    <h2>{{pageTitle}}</h2>
    <table class="question">
      <tr v-for="(question, questionIdx) in questionList" :key="questionIdx">
        <td class="title">
            <span> 
                {{question.title}}
            </span>
            <br>
        </td>
        <td>
          {{question.content}}
        </td>
      </tr>
    </table>
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