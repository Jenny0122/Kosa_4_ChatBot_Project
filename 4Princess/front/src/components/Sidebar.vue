<template>
  <div>
    <b-sidebar id="sidebar-right" width="300pt" bg-variant="white" title="" right shadow>
      <div class="px-3 py-2">
        <!-- <b-img src="ass" fluid thumbnail></b-img> -->
        <div class="menu">
          <router-link class="router-link" to="/">Home</router-link>
        </div>
        <div class="menu" @click="changeShowInfo">가드닝 가이드</div>
        <div v-if="showInfo==true">
          <div class="side-link">
            <router-link class="router-link" to="/page1">소개영상</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/page1">키우는 방법</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/page1">식물질병</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/page1">팁</router-link>
          </div>
        </div>
        <div class="menu" @click="changeShowPlant">식물 정보</div>
        <div v-if="showPlant==true">
          <div class="side-link">
            <router-link class="router-link" to="/page1">실내 정원 식물</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/page1">건조에 강한 식물</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/page1">공기 정화 식물</router-link>
          </div>
        </div>
        <div class="menu" @click="changeShowLifeStyle">라이프 스타일</div>
        <div v-if="showLifeStyle==true">
          <div class="side-link">
            <router-link class="router-link" to="/life-style/cook">레시피</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/life-style/book">책</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/life-style/tool">도구</router-link>
          </div>
        </div>
        <div  class="menu" @click="changeShowCommunity">커뮤니티</div>
        <div v-if="showCommunity==true">
          <div class="side-link">
            <router-link class="router-link" to="/community/colorflower">꽃 색상 효과</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/community/mbti">MBTI</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/community/tool">발명품</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/community/tool">신조어</router-link>
          </div>
        </div>
        <div  class="menu" @click="changeShowBoard">회원 라운지</div>
        <div v-if="showBoard==true">
          <div class="side-link">
            <router-link class="router-link" to="/page1">게시판</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/memberlounge/faq">FAQ</router-link>
          </div>
        </div >
        <div class="sign">
          <div>
            <router-link class="router-link" to="/page1">회원가입</router-link>
          </div>
          <div>
            <router-link class="router-link" to="/page1">로그인</router-link>
          </div>
        </div>
      </div>
    </b-sidebar>
  </div>
</template>

<script>
export default {
  name: 'Sidebar',
  data() {
    return {
      tool: [],
      showInfo: false,
      showPlant: false,
      showLifeStyle: false,
      showCommunity: false,
      showBoard: false
    }
  },
  methods: {
    changeShowInfo: function() {
      this.showInfo = !this.showInfo
    },
    changeShowPlant: function() {
      this.showPlant = !this.showPlant
    },
    changeShowLifeStyle: function() {
      this.showLifeStyle = !this.showLifeStyle
    },
    changeShowCommunity: function() {
      this.showCommunity = !this.showCommunity
    },
    changeShowBoard: function() {
      this.showBoard = !this.showBoard
    }
  },
  beforeCreate: function() {
    console.log('Sidebar.vue is created')
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.py-2 {
  margin: 20pt;
}
.menu {
  font-size: 20pt;
  font-family: 'Noto Sans KR', sans-serif;
  color:black;
  margin: 10pt 0;
}
.side-link {
  font-size: 15pt;
  font-family: 'Noto Sans KR', sans-serif;
  margin: 10pt;
}
.sign {
  font-size: 20pt;
  font-family: 'Noto Sans KR', sans-serif;
  margin: 10pt 0;
  line-height: 45pt;
  bottom: 0;
}
.router-link {
  text-decoration: none;
  color: black;
  margin: 10pt 0;
}
.menu:hover,
.router-link:hover {
  color:#00994C;
  cursor: pointer;
}
</style>