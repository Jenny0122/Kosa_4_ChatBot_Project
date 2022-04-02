<template>
  <div id="app">
    <div id="page-wrapper">
      <b-button v-b-toggle.sidebar-right class="MenuPosition"><span>Menu</span>&nbsp;&nbsp;&nbsp;<img src="./assets/logo.png" /></b-button>
      <sidebar />
      <router-view/>
      <bottom />
    </div>
  </div>
</template>

<script>
import Sidebar from '@/components/Sidebar'
import Bottom from '@/components/Bottom'
export default {
  components: { Sidebar, Bottom },
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
    'sidebar': Sidebar,
    'bottom': Bottom
  }
}
</script>

<style scope>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
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

#app {
  font-family: 'Noto Sans KR', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
#btn {
position: absolute;
width: 80px;
height: 80px;
top: 80px;
right: 0;
transform: translate(-50%, -50%);
cursor: pointer;
background: white;
border-radius: 50%;
border: none;
outline: none;
}
#btn span {
position: absolute;
width: 50px;
height: 4px;
top: 50%;
left: 50%;
background: #262626;
border-radius: 2px;
overflow: hidden;
transition: all 0.3s linear;
}
#btn span::before {
content: "";
position: absolute;
width: 0;
height: 100%;
top: 0;
right: 0;
background: gray;
transition: all 0.3s linear;
}
#btn span:nth-child(1) {
animation: span-first-off 0.5s ease-in-out;
animation-fill-mode: forwards;
}
#btn span:nth-child(2) {
animation: span-second-off 0.5s ease-in-out;
animation-fill-mode: forwards;
}
#btn span:nth-child(3) {
animation: span-third-off 0.5s ease-in-out;
animation-fill-mode: forwards;
}
#btn.on:hover span::before {
width: 100%;
transition: all 0.3s linear;
}
#btn.on span:nth-child(1) {
animation: span-first-on 0.5s ease-in-out;
animation-fill-mode: forwards;
}
#btn.on span:nth-child(2) {
animation: span-second-on 0.5s ease-in-out;
animation-fill-mode: forwards;
}
#btn.on span:nth-child(3) {
animation: span-third-on 0.5s ease-in-out;
animation-fill-mode: forwards;
}
@keyframes span-first-on {
0% {
transform: translate(-50%, -300%);
}
30% {
transform: translate(-50%, -50%);
}
100% {
transform: translate(-50%, -50%) rotate(-45deg);
}
}
@keyframes span-first-off {
0% {
transform: translate(-50%, -50%) rotate(-45deg);
}
30% {
transform: translate(-50%, -50%) rotate(0deg);
}
100% {
transform: translate(-50%, -300%);
}
}
@keyframes span-second-on {
0% {
transform: translate(-50%, -50%);
}
25% {
background: gray;
}
50% {
transform: translate(-50%, -50%) scale(1);
}
100% {
transform: translate(-150%, -50%) scale(0);
}
}
@keyframes span-second-off {
0% {
transform: translate(-150%, -50%) scale(0);
}
25% {
background: gray;
}
50% {
transform: translate(-50%, -50%) scale(1);
}
100% {
transform: translate(-50%, -50%);
}
}
@keyframes span-third-on {
0% {
transform: translate(-50%, 200%);
}
30% {
transform: translate(-50%, -50%);
}
100% {
transform: translate(-50%, -50%) rotate(45deg);
}
}
@keyframes span-third-off {
0% {
transform: translate(-50%, -50%) rotate(45deg);
}
30% {
transform: translate(-50%, -50%) rotate(0deg);
}
100% {
transform: translate(-50%, 200%);
}
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