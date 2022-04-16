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
      beforeMessage: '',
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
        msgBubbleColorBot:'#fff',	// Text color of Bot message
        msgBubbleBgUser: '#3399ff',	// Background color of user message
        msgBubbleColorUser: '#fff',	// Text color of user message
        botAvatarSize: 64,
        botAvatarImg: 'https://img.freepik.com/vector-gratis/icono-robot-signo-chat-bot-concepto-servicio-soporte-estilo-plano-personaje-chatbot_41737-796.jpg',
      },
      guideList: ['1. \'꽃이름\'에 대해 궁금해/알려줘 (ex. 소나무)', 
                  '2. \'몇월 몇일\' 꽃말 (ex. 4월 19일)',
                  '3. \'작물이름\' 레시피 종류 (ex. 깻잎)',
                  '4. \'작물이름\' 병해충 (ex. 감귤)',
                  '5. \'작물이름\' 재배과정 (ex. 토마토)',
                  '6. 공기정화식물 추천',
                  '7. 건조에 강한 식물 추천',
                  '8. 초급자가 키우기 쉬운 식물',
                  '9. 중급자가 키우기 쉬운 식물',
                  '10. 상급자가 키우기 쉬운 식물',
                  '11. \'MBTI명\' (ex. ESFJ)']
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
          text: 'Ma2Garden 챗봇입니다. 무엇이든 물어보세요.',
          options: [
            {
              text: '질문 가이드',
              value: 'submit_ticket',
              action: 'postback'
            }
          ]
        })
      }

      // 웹소켓 연결
      const serverURL = "http://ma2garden.xyz:8888/chat"
      this.socket = new SockJS(serverURL)
      this.stompClient = Stomp.over(this.socket)

      this.stompClient.connect(
        {},
        frame => {
          // 소켓 연결 성공
          this.connected = true
          console.log('소켓 연결 성공', frame)
          // this.stompClient.debug = null
          // 서버의 메시지 전송 endpoint를 구독합니다.
          // 이런형태를 pub sub 구조라고 합니다.
          this.stompClient.subscribe("/send", res => {

            // 받은 데이터를 json으로 파싱하고 리스트에 넣어줍니다.
            var answer = res.body.replace(/~!~/gi, '\n')

            if(answer.includes('|')){
              this.showAnswerButtons(answer)
            } else {
              this.data.push({
                agent: 'bot',
                type: 'text',
                text: answer
              })
            }
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

      if(value.text == '질문 가이드') {
        this.showGuide()
        return
      }

      // 소켓서버로 text전달
      // response받은 text를 data로 push
      if(this.userName !== '' && value.text !== ''){
        console.log("Send message:" + value.text)

        if (this.stompClient && this.stompClient.connected) {
          const msg = {
            userName: this.userName,
            content: this.beforeMessage + value.text,
          }
          console.log(msg)
          this.stompClient.send("/receive", JSON.stringify(msg), {})

          if(this.beforeMessage != '')
            this.beforeMessage = ''

          if(value.text.includes('레시피') || value.text.includes('병해충')){
            var spacebar = value.text.indexOf(' ')
            
            this.beforeMessage = value.text.substring(0, spacebar) + '(btn)'
          }
        }
        value.text = ''
      }
    },
    destroyHandler: function() { // 챗봇 비활성화 했을때 실행되는 함수
      // 웹소켓 종료
      this.socket.close()
      this.connected = false
    },
    showGuide: function() {
      var guide = ''

      for(var i in this.guideList) {
        guide += this.guideList[i] + '\n'
      }
      this.data.push({
        agent: 'bot',
        type: 'text',
        text: guide
      })
      
    },
    showAnswerButtons: function(answer) {
      var list = answer.split('|')
      var options = []
      for(var i in list){
        options.push({
          text: list[i],
          value: 'submit_ticket',
          action: 'postback'
        })
      }

      this.data.push({
        agent: 'bot',
        type: 'button',
        text: '다음 중 하나를 선택하세요',
        options: options
      })
      
    }
	},
  components: { 'VueBotUI': VueBotUI }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scopped>
.qkb-board {
  width: 650px !important;
}
.qkb-board-content__bubbles {
  padding-top: 1.1rem;
}
.qkb-msg-bubble-component__text {
  white-space: pre-line;
}
</style>