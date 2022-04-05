<template>
<div id="cook">
  <div class="title">RECIPE</div>
  <div class="subtitle">키우는 작물을 선택해 주세요! 작물별 추천음식 레시피를 알려드려요 :)</div>
  <div class="button-area">
    <div class="crop-button-area" v-for="(crop, index) in crop_names" :key="index">
      <b-button class="crop-button" @click="showMenu(crop)" variant="outline-success" size="lg">{{crop}}</b-button>
    </div>
  </div>
  <div class="menu-area">
    <div class="menu-select-area" @click="showRecipe(menu)" v-for="(menu, no) in selected_crop" :key="no">
      <div class="photo-wrapper"><img v-bind:src="menu.photo"></div>
      <div class="menu-text">{{menu.menu}}</div>
    </div>
  </div>
  <modal v-if="showModal" @close="showModal = false">
    <div class="header" slot="header">{{selected_menu.menu}}</div>
    <div slot="body" @click="showModal=false">
      [재료] <br> {{selected_menu.ingredient}} <br><br>
      [레시피] <br> <div v-html="selected_menu.cooking_order.split('\n').join('<br>')"></div>
      <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
    </div>
  </modal>
</div>
</template>

<script>
import Modal from '@/components/RecipeModal'

export default {
  name: 'Cook',
  data() {
    return {
      cooks: [], // DB에서 가져온 Recipe 전체 정보
      crop_names: [], // 작물 이름
      showModal: false, // Modal 표시 여부 체크
      selected_crop: [], // 선택된 crop
      selected_menu: ''
    }
  },
  methods: {
    showMenu: function(crop) {
      this.selected_crop = []

      for (var j in this.cooks) {
        if (this.cooks[j].crop === crop) {
          this.selected_crop.push(this.cooks[j])
        }
      }
    },
    changeModalState: function() {
      this.showModal = !this.showModal
    },
    showRecipe: function(menu) {
        this.selected_menu = menu
        this.$emit('showRecipe', menu)
        this.clearInput()
      // } else {
        // 4) 텍스트 미입력시 모달 동작
        this.showModal = !this.showModal
      // }
    },
    clearInput() {
      this.newTodoItem = ''
    }
  },
  beforeCreate: function() {
    console.log('Cook.vue is created')

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

      this.showMenu(selectedCrop)
    })
  },
  components: {
    Modal: Modal
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.button-area {
  margin: 20pt 150pt;
  /* text-align: center; */
}
.crop-button-area {
  display: inline-block;
  width: 15%;
  height: 75pt;
  vertical-align: middle;
  text-align: center;
  margin: 20pt 2.5%;
  border: 1px solid white;
}
.crop-button {
  width: 100%;
  height: 100%;
  font-size: 150%;
  color: white;
}
img {
  width: 100%;
  height: 100%;
}
.photo-wrapper {
  width: 100%;
  height: 100%;
  text-align: center;
}
.menu-area {
  text-align: center;
}
.menu-select-area {
  display: inline-block;
  margin: 30pt 3%;
  width: 19%;
}
.menu-text {
  font-size: 15t;
  margin: 20pt 0;
  color: white;
}
</style>