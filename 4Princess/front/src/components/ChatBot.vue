<template>
  <VueBotUI  
    :messages="data"
    :options="botOptions"
    @init="initHandler"
    @destroy="destroyHandler"
    @msg-send="messageSendHandler"
  />
</template>

<script>
import { VueBotUI } from 'vue-bot-ui'

export default {
	name: 'Chatbot',
	data() {
		return {
			data: [],
      botOptions: {
        'botTitle': 'Ma2Garden ChatBot',
        'colorScheme': '#557571',
        'inputPlaceholder': 'Ask your ChatBot',
        textColor:	'#fff',//	Color of bubble button icon & board header title
        bubbleBtnSize:	56,//	Size of bubble button (px)
        animation:	true,//	Set to false to disable animation of bubble button icon & board showing
        boardContentBg:	'#fff',//	Background color of board messages box
        msgBubbleBgBot: '#557571', // Background color of Bot message
        msgBubbleColorBot:'#000',	// Text color of Bot message
        msgBubbleBgUser: '#4356e0',	// Background color of user message
        msgBubbleColorUser: '#fff',	// Text color of user message
        botAvatarImg: ''
      }
		}
	},
	methods: {
    initHandler: function() { // 챗봇 활성화했을때 실행되는 함수
      // 환영인사
      // 웹소켓 연결
      this.data.push({
        agent: 'bot',
        type: 'button',
        text: 'Ma2Garden 챗봇입니다. 무엇이든 물어보세요 :)',
        options: [
          {
            text: '특정 URL로 이동',
            value: 'https://google.com',
            action: 'url'
          },
          {
            text: 'Submit Support Ticket',
            value: 'submit_ticket',
            action: 'postback' // Request to API
          }
        ]
        })
    },
    messageSendHandler: function(value) { // send버튼 눌렀을때 실행되는 함수
      // 메세지 전송      
      this.data.push({
        agent: 'user',
        type: 'text',
        text: value.text
      })

      // 소켓서버로 text전달
      // response받은 text를 data로 push
    },
    destroyHandler: function() { // 챗봇 비활성화 했을때 실행되는 함수
      // 웹소켓 종료
    }
	},
  components: { 'VueBotUI': VueBotUI }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>