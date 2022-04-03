<template>
<div id="mbti">
  <div class="title">{{msg}}</div>
  <div class="subtitle">{{subject}}</div>
  <div class="button-area">
    <div class="mbti-button-area" v-for="(mt, index) in mbti" :key="index">
      <b-button class="mbti-button" @click="showMBTIContents(mt)" variant="outline-success" size="lg">
        {{mt.mbti}}
      </b-button>
    </div>
  </div>
  <div class="mbti-area">
    <div class="mbti-img">
      <img v-bind:src="selected_mbti.image_url">
    </div>
    <div class="mbti-text">
      <div class="mbti-name">{{selected_mbti.flower_name}}</div>
      <div class="mbti-desc">{{selected_mbti.description}}</div>
    </div>
  </div>
</div>
</template>


<script>
export default {
  name: 'MBTI',
  data() {
    return {
      msg: 'MBTI',
      subject: 'MBTI별 꽃 추천을 해드려요:) 본인의 MBTI를 선택해주세요.',
      mbti: [],
      selected_mbti: []
    }
  },
  methods: {
    showMBTIContents: function(mt) {
      this.selected = mt
    }
  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/mbti')
    .then((res) => {
      let list = res.data

      for (var i in list) {
        this.mbti.push(list[i])
      }

      this.selected_mbti = list[0]
    })
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.button-area {
  text-align: center;
}
.mbti-button-area {
  width: 20%;
  height: 80pt;
  margin: 10pt 10pt;
  display: inline-block;
  vertical-align: center;
}
.mbti-button {
  height: 60pt;
  width: 80%;
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
}
.mbti-name {
  font-size: 40pt;
  font-weight: bold;
  line-height: 100pt;
  text-align: left;
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 500;
}
.mbti-desc {
  font-size: 20pt;
  text-align: left;
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 100;
  padding-bottom: 5%;
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