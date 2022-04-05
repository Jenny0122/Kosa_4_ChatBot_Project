<template>
<div id="mbti">
  <div class="title">{{msg}}</div>
  <div class="subtitle">{{subject}}</div>
  <div class="button-area">
    <div class="mbti-button-area" v-for="(mt, index) in mbti" :key="index">
      <b-button class="mbti-button" @click="showMBTIContents(index)" variant="outline-success" size="lg">
        {{mt.mbti}}
      </b-button>
    </div>
  </div>
  <div class="mbti-area" :ref="'img' + index" v-for="(mt, index) in mbti" :key="index">
    <div class="mbti-img">
      <img v-bind:src="mt.image_url">
    </div>
    <div class="mbti-text">
      <div class="mbti-name">{{mt.flower_name}}</div>
      <div class="mbti-desc">{{mt.description}}</div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  el: '#mbti',
  name: 'MBTI',
  data() {
    return {
      msg: 'MBTI',
      subject: 'MBTI별 꽃 추천을 해드려요 :) 본인의 MBTI를 선택해주세요.',
      mbti: []
    }
  },
  methods: {
    showMBTIContents: function(index) {
      var targetY = this.$refs['img' + index][0].getBoundingClientRect().top
      window.scroll(0, targetY - 150)
    }
  },
  beforeCreate: function() {
    console.log('MBTI.vue is created')

    this.$axios.get('/mbti')
    .then((res) => {
      let list = res.data

      for (var i in list) {
        this.mbti.push(list[i])
      }
    })
  }
}
</script>

<style scoped>
.button-area {
  text-align: center;
  margin: 20pt 150pt;
}
.mbti-button-area {
  width: 17%;
  height: 60pt;
  margin: 20pt 4%;
  display: inline-block;
  vertical-align: middle;
  color: white;
}
.mbti-button {
  margin: 0;
  width: 100%;
  height: 100%;
  color: white;
  border: 1px solid white;
}
.mbti-area {
  border-radius: 10pt;
  margin: 20pt auto;
  width: 70%;
  text-align : center;
}
.mbti-img {
  display: inline-block;
  margin: 0 auto;
  width: 50%;
}
.mbti-text {
  display: inline-block;
  width: 70%;
  vertical-align: middle;
  color: white;
}
.mbti-name {
  font-size: 30pt;
  font-weight: bold;
  line-height: 100pt;
  text-align: left;
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 500;
  color: white;
}
.mbti-desc {
  font-size: 15pt;
  text-align: left;
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 100;
  padding-bottom: 5%;
  color: white;
  line-height: 30pt;
}
img {
  width: 50%;
  height: 200pt;
  object-fit: cover;
  display: flex;
  justify-content:center;
  padding-top: 5%;
}
</style>