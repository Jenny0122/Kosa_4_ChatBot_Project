<template>
<div class="top-button" @click="scrollToTop()">
    <font-awesome-icon icon="fa-solid fa-angles-up" class="fa-xl" />
</div>
</template>

<script>
export default {
  name: 'TopButton',
  data() {
    return {
    }
  },
  methods: {
      scrollToTop() {
        window.scrollTo({ top: 0, behavior: 'smooth' })
    }
  },
  mounted: function() {
  }
}
</script>

<style scoped>
.top-button {
  bottom: 3%;
  right: 5%;
  padding: 5pt 8pt;
  position: fixed;
  background-color: #557571;
  border-radius: 100%;
}
.fa-angles-up {
  color: white;
  cursor: pointer;
}
</style>