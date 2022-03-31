<template>
  <div id="page-wrapper">
    <article id="main">
      <header>
        <h2>{{msg}} Page</h2>
        <p>{{subject}}</p>
      </header>
      <section class="wrapper style5">
        <div class="inner">
          <div v-for="pd in plantDisease" :key="pd">
            <div>
              <h3>[{{pd.crop_name}} : {{pd.sick_name_kor}}]</h3>
              <p>증상<br/>&nbsp;&nbsp;&nbsp;&nbsp;{{pd.symptoms}}</p>
              <p>치료방법<br/>&nbsp;&nbsp;&nbsp;&nbsp;{{pd.prevention_method}}</p>
              <img :src="`${pd.ori_img}`"/>
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
export default {
  name: 'PlantDisease',
  data() {
    return {
      msg: '식물 질병',
      subject: '식물의 질병에 관한 정보를 제공합니다',
      plantDisease: []
    }
  },
  methods: {

  },
  beforeCreate: function() {
    this.$axios.get('/plantdisease')
    .then((res) => {
      let list = res.data
      for (var i in list) {
        this.plantDisease.push(list[i])
      }
    })
  }
}
</script>
<style scoped>
    .wrapper.style5 img {
      max-width: 30vw;
      max-height: 30vh;
    }
</style>