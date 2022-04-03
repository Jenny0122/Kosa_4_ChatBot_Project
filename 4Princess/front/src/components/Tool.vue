<template>
<div id="tool">
  <div class="title">홈 가드닝 시 자주 쓰는 도구들</div>
  <div class="subtitle">자주 사용하는 도구에 대해 알아볼까요?</div>
  <div class="tool-area" v-for="(tool, index) in tools" :key="index">
      <div class="tool-img">
        <img v-bind:src="tool.img_url">
      </div>
      <div class="tool-text">
        <div class="tool-name subtitle">
          {{tool.name}}
        </div>
        <div class="tool-desc subtitle">
          {{tool.description}}
        </div>
      </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'Tool',
  data() {
    return {
      tools: []
    }
  },
  methods: {
    test: function() {
    }
  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/tool')
    .then((res) => {
      let list = res.data

      for (var i in list) {
        this.tools.push(list[i])
      }
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
img {
    width: 10%;
    /* height: 100pt; */
    object-fit: cover;
}
.tool-area {
  border-radius: 10pt;
  /* border: 1pt solid black; */
  margin: 20pt auto;
  width: 70%;
  text-align: center;
}
.tool-img {
  display: inline;
}
.tool-text {
  display: inline-block;
  width: 50%;
  vertical-align: middle;
}
.tool-name {
  font-size: 20pt;
  font-weight: 700;
  text-align: left;
}
.tool-desc {
  font-size: 15pt;
  text-align: left;
}
</style>