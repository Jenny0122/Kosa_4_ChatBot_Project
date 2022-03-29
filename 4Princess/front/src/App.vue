<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view />
    <b-button v-b-toggle.sidebar-right class="MenuPosition">Menu</b-button>
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
.MenuPosition {
position: absolute;
top: 20px;
right: 20px;
cursor: pointer;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
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
</style>