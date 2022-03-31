<template>
  <div id="page-wrapper">
    <article id="main">
      <header>
        <h2>{{msg}} Page</h2>
        <p>{{subject}}</p>
      </header>
      <section class="wrapper style5">
        <div class="inner">
          <div v-for="gm in growMethod" :key="gm">
            <div>
              <h3>{{gm.no}}. {{gm.name}}</h3>
              <p>{{gm.kind}}<br/>
                {{gm.nutrient}}<br/>
                {{gm.growing_season}}<br/>
                {{gm.eat}}<br/>
                {{gm.level}}<br/>
                {{gm.sunlight}}<br/>
                {{gm.grow_temperature}}<br/>
                {{gm.flowerpot_size}}<br/>
                {{gm.pest}}<br/>
                {{gm.term}}<br/>
                {{gm.infomation}}<br/>
                {{gm.feature}}<br/>
                {{gm.materials}}<br/>
                {{gm.cultivation_process}}</p>
              <img :src="`${gm.img_url}`"/>
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
  name: 'GrowMethod',
  data() {
    return {
      msg: '작물 키우는 방법',
      subject: '여러가지 작물의 키우는 방법을 소개합니다',
      growMethod: []
    }
  },
  methods: {
  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/growmethod')
    .then((res) => {
      let list = res.data
      for (var i in list) {
        this.growMethod.push(list[i])
      }
    })
  }
}
</script>

<style scoped>
</style>