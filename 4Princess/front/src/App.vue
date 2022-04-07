<template>
  <div id="app">
    <div id="page-wrapper">
      <b-button v-b-toggle.sidebar-right class="MenuPosition"><span>Menu</span>&nbsp;&nbsp;&nbsp;<img src="./assets/homelogo.png" /></b-button>
      <sidebar />
      <router-view/>
      <bottom />
    </div>
  </div>
</template>

<script>
import Bottom from '@/components/Bottom'
import Sidebar from '@/components/Sidebar'
export default {
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
  components: {
    'bottom': Bottom,
    'sidebar': Sidebar
  }
}
</script>

<style scope>
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
  font-family: 'Noto Sans KR', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
body.landing #page-wrapper {
    background-image: -moz-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("./assets/bgimg.jpg");
    background-image: -webkit-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("./assets/bgimg.jpg");
    background-image: -ms-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("./assets/bgimg.jpg");
    background-image: linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("./assets/bgimg.jpg");
    background-attachment: fixed;
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
    padding-top: 0;
}

</style>