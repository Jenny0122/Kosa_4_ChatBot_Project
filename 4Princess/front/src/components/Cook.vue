<template>
<div id="app">
  <div>
    <h1>RECIPE</h1>
    <h3>키우는 작물을 선택해 주세요! 작물별 추천음식 레시피를 알려드려요 :)</h3>
  </div>
  <div v-for="cook in cooks" :key="cook">
      <div>
      {{cook.crop}}
      </div>
      <div>
      {{cook.menu}}
      </div>
      <div>
      {{cook.ingredient}}
      </div>
      <div>
      {{cook.cooking_order}}
      </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'Cook',
  data() {
    return {
      cooks: []
    }
  },
  methods: {
    test: function() {
    }
  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/cook')
    .then((res) => {
      let list = res.data

      for (var i in list) {
        this.cooks.push(list[i])
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