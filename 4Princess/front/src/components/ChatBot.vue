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
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'

export default {
	name: 'Chatbot',
	data() {
		return {
      userName: 'kskcjswo',
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
        botAvatarSize: 64,
        botAvatarImg: 'https://img.freepik.com/vector-gratis/icono-robot-signo-chat-bot-concepto-servicio-soporte-estilo-plano-personaje-chatbot_41737-796.jpg'
      }
		}
	},
	methods: {
    initHandler: function() { // 챗봇 활성화했을때 실행되는 함수

      // 만약 처음 켜는 경우는 인사말 push
      // 두번째 켜는 경우는 생략
      //thid.data.length로 확인
      if(this.data.length == 0){

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
            text: 'Submit Support\n Ticket',
            value: 'submit_ticket',
            action: 'postback'
          }
        ]
        })
      }

      // 웹소켓 연결
      const serverURL = "http://localhost:8888"
      this.socket = new SockJS(serverURL)
      this.stompClient = Stomp.over(this.socket)

      this.stompClient.connect(
        {},
        frame => {
          // 소켓 연결 성공
          this.connected = true
          console.log('소켓 연결 성공', frame)
          // 서버의 메시지 전송 endpoint를 구독합니다.
          // 이런형태를 pub sub 구조라고 합니다.
          this.stompClient.subscribe("/send", res => {

            // 받은 데이터를 json으로 파싱하고 리스트에 넣어줍니다.
            this.data.push({
              agent: 'bot',
              type: 'text',
              text: res.body
            })
          })
        },
        error => {
          // 소켓 연결 실패
          console.log('소켓 연결 실패', error)
          this.connected = false
        }
      ) 
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
      if(this.userName !== '' && value.text !== ''){
        console.log("Send message:" + value.text)
        if (this.stompClient && this.stompClient.connected) {
          const msg = { 
            userName: this.userName,
            content: value.text 
          }
          this.stompClient.send("/receive", JSON.stringify(msg), {})
        }
        value.text = ''
      }
    },
    destroyHandler: function() { // 챗봇 비활성화 했을때 실행되는 함수
      // 웹소켓 종료
      this.socket.close()
      this.connected = false
    }
	},
  components: { 'VueBotUI': VueBotUI }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>