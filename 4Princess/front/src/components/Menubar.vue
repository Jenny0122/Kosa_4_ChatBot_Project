<template>
  <div id="menubar">
    <b-navbar toggleable="sm"  variant="light" text-variatnt="black">
      <!-- Home글씨 대신 로고 교체 예정 -->
      <div class="home"><router-link class="router-link" to="/" ><img src="@/assets/homelogo.png"></router-link></div>
      <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item-dropdown class="menu" text="가드닝 가이드">
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/page1">소개영상</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/info/growmethod/">키우는 방법</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/info/plantdisease/">식물질병</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/info/tip">팁</router-link></b-dropdown-item></div>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown class="menu" text="식물 정보">
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/plant/insideplant">실내 정원 식물</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/plant/dryplant">건조에 강한 식물</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/page1">공기 정화 식물</router-link></b-dropdown-item></div>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown class="menu" text="라이프 스타일">
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/life-style/cook">레시피</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/life-style/book">책</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/life-style/tool">도구</router-link></b-dropdown-item></div>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown class="menu" text="커뮤니티">
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/community/colorflower">꽃 색상 효과</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/community/mbti">MBTI</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/community/invention">발명품</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/community/neologism">신조어</router-link></b-dropdown-item></div>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown class="menu" text="회원 라운지">
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/member/board">게시판</router-link></b-dropdown-item></div>
          <div class="side-link"><b-dropdown-item><router-link class="router-link" to="/member/faq">FAQ</router-link></b-dropdown-item></div>
        </b-nav-item-dropdown>
      </b-navbar-nav>

      <b-navbar-nav class="ms-auto">
        <b-navbar-brand><router-link class="router-link" to="/page1">회원가입</router-link></b-navbar-brand>
        <b-navbar-brand><router-link router-link class="router-link" to="/page1">로그인</router-link></b-navbar-brand>
      </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: 'Menubar',
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
  font-size: 18pt;
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
  font-size: 18pt;
  font-family: 'Noto Sans KR', sans-serif;
  margin: 10pt 0;
  line-height: 45pt;
  bottom: 0;
}
.router-link {
  text-decoration: none;
  color: rgb(0, 0, 0, 0.55);
}
.menu:hover,
.router-link:hover {
  color:#00994C;
  cursor: pointer;
}
.navbar-light .navbar-nav .nav-link {
  color: rgb(0, 0, 0, 0) !important;
}
img {
  width: 30%;
  margin: 0 20pt;
}
.home {
  width : 300pt;
  padding: 10pt;
}
b-navbar-brand {
  margin: 0 0 0 20pt;
}
</style>