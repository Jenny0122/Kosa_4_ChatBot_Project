<template>
  <div id="app">
    <div id="page-wrapper">
      <menubar />
      <!-- <b-button v-b-toggle.sidebar-right class="MenuPosition"><span>Menu</span>&nbsp;&nbsp;&nbsp;<img src="./assets/homelogo.png" /></b-button> -->
      <!-- <sidebar /> -->
      <router-view/>
      <topbutton />
      <!-- <chat-form /> -->
      <bottom />
      <VueBotUI  
        :messages="data"
        :options="botOptions"
        @msg-send="messageSendHandler"
      />
    </div>
  </div>
</template>

<script>
import Bottom from '@/components/Bottom'
import TopButton from '@/components/TopButton.vue'
import Menubar from '@/components/Menubar.vue'
import ChatForm from '@/components/ChatBot/ChatForm'
import { VueBotUI } from 'vue-bot-ui'
export default {
  name: 'App',
  data() {
    return {
      data: [],
      botOptions: {
        'botTitle': 'Ma2Garden ChatBot',
        'colorScheme': '#557571',
        'inputPlaceholder': '챗봇에게 물어보세요',
        textColor:	'#fff',//	Color of bubble button icon & board header title
        bubbleBtnSize:	56,//	Size of bubble button (px)
        animation:	true,//	Set to false to disable animation of bubble button icon & board showing
        boardContentBg:	'#fff',//	Background color of board messages box
        msgBubbleBgBot: '', // Background color of Bot message
        msgBubbleColorBot:'#000',	// Text color of Bot message
        msgBubbleBgUser: '#4356e0',	// Background color of user message
        msgBubbleColorUser: '#fff',	// Text color of user message
        botAvatarImg: ''
      },
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
    'topbutton': TopButton,
    'menubar': Menubar,
    'chat-form': ChatForm,
    'VueBotUI' : VueBotUI,
  }
}
</script>

<style scope>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap');
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

.title {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 900;
  font-size: 2.5em !important;
  color: white !important;
  text-align: center;
}
.subtitle {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 500;
  font-size: 20pt;
  text-align: center;
  margin: 10pt;
  color: white important;
}
.MenuPosition {
position: fixed; /* 고정 기능 */
top: 10px;
right: 10px;
cursor: pointer;
background-color:transparent; /* 배경 투명 */
border: 0;
z-index: 1; /* 겹치지 않게 해주는 기능 */
font-size: 1.3em;
}
.MenuPosition:hover{
  background-color:transparent; /* 배경 투명 */
  border: 0;
}
.MenuPosition > img {
  width: 60px;
  height: 40px;
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