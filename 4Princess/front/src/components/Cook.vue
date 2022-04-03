<template>
<div id="cook">
  <div class="title">RECIPE</div>
  <div class="subtitle">키우는 작물을 선택해 주세요! 작물별 추천음식 레시피를 알려드려요:)</div>
  <div class="button-area">
    <div class="crop-button-area" v-for="(crop, index) in crop_names" :key="index">
      <b-button class="crop-button" @click=showMENUContents(crop) variant="outline-success" size="lg">{{crop}}</b-button>
    </div>

    <div v-for="(menu, no) in selected_menus" :key="no">
      <div><b-button class="menu-button" @click=showRecipe(menu) >{{menu.menu}}</b-button></div>
      <!-- <div>{{cooks[0].ingredient}}</div>
      <div>{{cooks[0].cooking_order}}</div> -->
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'Cook',
  data() {
    return {
      cooks: [],
      crop_names: [],
      selected_menus: []
    }
  },
  methods: {
    showMENUContents: function() {
    }
  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/cook')
    .then((res) => {
      let list = res.data
      var set = new Set()

      for (var i in list) {
        this.cooks.push(list[i])
        set.add(list[i].crop)
      }

      this.crop_names = Array.from(set)
      var selectedCrop = this.crop_names[0]

      for (var j in this.cooks) {
        if (this.cooks[j].crop === selectedCrop) {
          this.selected_menus.push(this.cooks[j])
        }
      }
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.button-area {
  margin: 20pt 150pt;
  text-align: center;
}
.crop-button-area {
  display: inline-block;
  width: 15%;
  height: 75pt;
  vertical-align: middle;
  text-align: center;
  margin: 20pt 2.5%;
  border: 1 solid black
}
.crop-button {
  width: 100%;
  height: 100%;
  font-size: 150%;
}
</style>