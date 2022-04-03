<template>
  <div id="app">
    <router-view />
      <b-button size="lg" v-b-toggle.sidebar-right class="MenuPosition">Menu</b-button>
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
position: absolute;
top: 50pt;
right: 50pt;
cursor: pointer;
background-color: #075a3a;
}
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  margin-top: 30px;
}
body {
  background-color: #2e3842;
}
</style>