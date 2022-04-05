<template>
  <div id="app">
    <router-view />
      <b-button v-b-toggle.sidebar-right class="MenuPosition"><span>Menu</span>&nbsp;&nbsp;&nbsp;<img src="./assets/logo.png" /></b-button>
    <sidebar />
  </div>
</template>

<script>
import Sidebar from '@/components/Sidebar'
export default {
  components: { Sidebar },
  name: 'App',
  data() {
    return {
      showSidebar: false
    }
  },
  methods: {
    changeShowSidebar: function() {
      this.showSidebar = !this.showSidebar
    }
  },
  component: {
    'sidebar': Sidebar
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700;900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap');

.title {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 900;
  font-size: 50pt;
  color: #00994C;
  text-align: center;
}
.subtitle {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 500;
  font-size: 20pt;
  text-align: center;
  margin: 10pt;
  color: white;
}
.MenuPosition {
position: fixed; /* 고정 기능 */
top: 10px;
right: 10px;
cursor: pointer;
background-color:transparent; /* 배경 투명 */
border: 0;
z-index: 1; /* 겹치지 않게 해주는 기능 */
}
.MenuPosition:hover{
  background-color:transparent; /* 배경 투명 */
  border: 0;
}
.MenuPosition > img {
  width: 50px;
  height: 30px;
}
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  margin-top: 30px;
}
body {
  background-color: #212926;
}
</style>