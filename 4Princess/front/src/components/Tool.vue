<template>
<div id="app">
  <div>
    <h1>홈 가드닝 시 자주쓰는 도구들</h1>
    <h3>자주 사용하는 도구에 대해 알아볼까요?</h3>
  </div>
  <div v-for="t in tool" :key="t">
      <div>
      {{t.name}}
      </div>
      <div>
      {{t.description}}
      </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'Tool',
  data() {
    return {
      tool: []
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
        this.tool.push(list[i])
      }
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>