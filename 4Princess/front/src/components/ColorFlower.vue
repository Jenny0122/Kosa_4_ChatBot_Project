<template>
  <div>
    <h3>{{ msg }}</h3>
    <div v-for="color in colors" :key="color" @click="addTodo(color)">
      {{color}}
    </div>
    <modal v-if="showModal" @close="showModal = false">
      <h3 slot="header">{{selectedColor}}의 꽃이 주는 효과</h3>
      <div slot="body" @click="showModal=false">
        효과입니다.
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
      colors: ['빨간색 계열', '파란색 계열', '분홍색 계열', '노란색 계열', '주황색 계열', '흰색 계열', '녹색 계열'],
      newTodoItem: '',
      showModal: false,
      selectedColor: ''
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
  // 5) 모달 컴포넌트 등록
  components: {
    Modal: Modal
  }
}
</script>