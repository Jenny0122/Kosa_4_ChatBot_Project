<template>
<div id="FAQ">
  <div class="title">{{title}}</div>
  <div class="subtitle">{{subtitle}}</div>
  <div class="faq-text" v-for="(faq, index) in faqs" :key="index">
    <div class="accordion" role="tablist">
      <b-card no-body class="mb-1" text-variant="white">
        <b-card-header header-tag="header"  class="p-1" role="tab">
          <b-button block v-b-toggle="'accordion-' + faq.no" text-variant="white">{{faq.no}}&nbsp;&nbsp;&nbsp;&nbsp;{{faq.question}}</b-button>
        </b-card-header>
        <b-collapse :id="'accordion-' + faq.no" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>{{faq.answer}}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>
    </div>
  </div>
</div>
</template>

<script>
export default {
  data() {
    return {
      title: 'FAQ',
      subtitle: '자주 하는 질문들을 모아봤어요. :)',
      faqs: []
    }
  },
  methods: {
    showAnswer: function(item, index) {
      this.answer = this.faq[index]
    }
  },
  beforeCreate: function() {
    console.log('FAQ.vue is created')

    this.$axios.get('/faq')
    .then((res) => {
      let list = res.data

      for (var i in list) {
        this.faqs.push(list[i])
      }
    })
  }
}
</script>
<style scoped>
.faq-text {
  padding: 0.5% 20%;
  font-size: 15pt;
}
.btn-info {
  border: 0;
}
.card-header {
  border-bottom: 0;
}
.btn-secondary {
  background-color: #21b2a6;
  border: 0;
  font-size: 15pt;
  font-weight: 500;
}
.card {
  border: 0;
  background: unset;
}


</style>