<template>
  <div>
    <div class="title">꽃 색상에 따른 효과</div>
    <div class="subtitle">색상을 선택해주세요! :)</div>
    <div class = "color-area" v-bind:class="{}" v-for="(color, index) in color_flower" :key="color" @click="addTodo(color, index)">
      {{color.color_info}}
    </div>
    <modal v-if="showModal" @close="showModal = false">
      <div class="header" slot="header">{{selectedColor.color_info}}의 꽃이 주는 효과</div>
      <div slot="body" @click="showModal=false">
        {{selectedColor.effect_info}}
        <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
      </div>
    </modal>
  </div>
</template>

<script>
import Modal from '@/components/Modal.vue'
export default {
  name: 'ColorFlower',
  data() {
    return {
      msg: '색상을 선택해주세요!',
      color_flower: [],
      newTodoItem: '',
      showModal: false,
      selectedColor: '',
      color_position: []
    }
  },

/* eslint-disable */
  methods: {
    changeModalState() {
      this.showModal = !this.showModal
    },
    addTodo(value) {
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
    this.$axios.get('/color_flower')
    .then((res) => {
      for(var i in res.data) {
        this.color_flower.push(res.data[i])
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
}
</style>