<template>
  <div>
    <div class="title">꽃 색상에 따른 효과</div>
    <div class="subtitle">색상을 선택해주세요! :)</div>
    <div class="color-area" v-for="(color, index) in color_flower" :key="color.no" @click="showColorInfo(color, index)" :style="button_layout[index]"></div>
    <modal v-if="showModal" @close="showModal = false">
      <div class="header" slot="header">{{selectedColor.color_info}}의 꽃이 주는 효과</div>
      <div class="body" slot="body" @click="showModal=false">
        <img v-bind:src="selectedColor.img_url">
        <div class="effect">
          {{selectedColor.effect_info}}
        </div>
        <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
      </div>
    </modal>
  </div>
</template>

<script>
import Modal from '@/components/ColorFlowerModal.vue'
export default {
  name: 'ColorFlower',
  data() {
    return {
      msg: '색상을 선택해주세요!',
      color_flower: [],
      newTodoItem: '',
      showModal: false,
      selectedColor: '',
      color_position: [],
      button_layout: []
    }
  },
/* eslint-disable */
  methods: {
    changeModalState() {
      this.showModal = !this.showModal
    },
    showColorInfo(value) {
      this.selectedColor = value
      if (this.newTodoItem !== '') {
        var value = this.newTodoItem && this.newTodoItem.trim()
        this.$emit('addTodo', value)
        this.clearInput()
      } else {
        // 4) 텍스트 미입력시 모달 동작
        this.showModal = !this.showModal
      }
    },
    clearInput() {
      this.newTodoItem = ''
    }
  },

  beforeCreate() {
    const T = Math.PI / 4
    this.$axios.get('/color_flower')
    .then((res) => {
      for(var i in res.data) {
        this.color_flower.push(res.data[i])

        var x = 400 - 200 * Math.sin(T * (i - 6)) + 'pt'
        var y = 400 - 200 * Math.cos(T * (i - 6)) + 'pt'
        this.button_layout[i] = {
          'background-color': res.data[i].color_eng_name,
          'top': x,
          'left': y
        }
      }
    })

    //위치 계산
    var x = 200
    var y = 200
    var radius = 50
  },
  // 5) 모달 컴포넌트 등록
  components: {
    Modal: Modal
  }
}
</script>

<style scoped>
.header {
  text-align: center;
}
.color-area {
  border: 1pt solid black;
  width: 100pt;
  height: 100pt;
  border-radius: 100%;
  text-align: center;
  vertical-align: middle;
  display: table-cell;
  border: none;
  position: fixed;
}
img {
  width: 50%;
  height: auto;
}
.effect {
  margin: 20pt 0;
  margin-bottom: 0 auto;
}
</style>