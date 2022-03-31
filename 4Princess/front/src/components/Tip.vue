<template>
  <div id="page-wrapper">
    <article id="main">
      <header>
        <h2>{{msg}} Page</h2>
        <p>{{subject}}</p>
      </header>
      <section class="wrapper style5">
        <div class="inner">
          <div v-for="t in tip" :key="t">
            <div>
              <h3>{{t.no}}. {{t.title}}</h3>
              <p>{{t.content}}</p>
              <hr/>
            </div>
            <br/>
          </div>
        </div>
      </section>
    </article>
  </div>
</template>

<script>
export default{
  name: 'Tip',
  data() {
    return {
      msg: 'Tip',
      subject: '홈 가드닝의 여러가지 Tip을 소개합니다',
      tip: []
    }
  },
  methods: {
  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/tip')
    .then((res) => {
      let list = res.data
      for (var i in list) {
        this.tip.push(list[i])
      }
    })
  }
}
</script>

<style scoped>
</style>