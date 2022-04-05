<template>
<div id="FAQ">
  <div class="title">FAQ</div>
  <div class="subtitle">자주 하는 질문을 모아봤어요. :)</div>
  <div class="faq-table">
    <b-table :items="items" :fields="fields" thead-class="text-white" tbody-class="text-white" @row-clicked="showAnswer">
      <template slot="row-details">{{answer}}</template>
    </b-table>
  </div>
</div>
</template>

<script>
export default {
  data() {
    return {
      fields: ['No', '질문'],
      items: [],
      faq: [],
      selectAll: false,
      allOpenRows: [],
      answer: ''
    }
  },
  methods: {
    showAnswer: function(item, index) {
      this.answer = this.faq[index]
      // this.allOpenRows.map((ele) => {
      //   if (ele.id !== item.id && ele._showDetails) {
      //     this.$set(ele, '_showDetails', !ele._showDetails)
      //   }
      // })
      this.allOpenRows = []
      this.$set(item, '_showDetails', !item._showDetails)
      this.allOpenRows.push(item)
    }
  },
  beforeCreate: function() {
    console.log('FAQ.vue is created')

    this.$axios.get('/faq')
    .then((res) => {
      let list = res.data

      for (var i in list) {
        this.items.push({
          'No': list[i].no,
          '질문': list[i].question
        })
        this.faq.push(list[i].answer)
      }
    })
  }
}
</script>

<style scoped>
.faq-table {
  display:inline-block;
  width: 100%;
  padding: 20pt 20%;
  margin-left: auto;
  margin-right: auto;
  font-size: 15pt;
}
.mb-1 {
  width: 100%;
}

table {
  color: white;
}
</style>