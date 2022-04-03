<template>
  <div class="tool">
    <b-sidebar id="sidebar-right" bg-variant="success" title="" right shadow>
      <div class="px-3 py-2">
        <!-- <b-img src="ass" fluid thumbnail></b-img> -->
        <div class="menu">
          <router-link class="router-link" to="/">Home</router-link>
        </div>
        <div class="menu" @click="changeShowInfo">Info</div>
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
            <router-link class="router-link" to="/page1">TIP</router-link>
          </div>
        </div>
        <div class="menu" @click="changeShowPlant">Plant</div>
        <div v-if="showPlant==true">
          <div class="side-link">
            <router-link class="router-link" to="/page1">실내정원식물</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/page1">건조에 강한 식물</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/page1">공기 정화 식물</router-link>
          </div>
        </div>
        <div class="menu" @click="changeShowLifeStyle">Life-Style</div>
        <div v-if="showLifeStyle==true">
          <div class="side-link">
            <router-link class="router-link" to="/life-style/cook">Recipe</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/life-style/book">Book</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/life-style/tool">Tool</router-link>
          </div>
        </div>
        <div  class="menu" @click="changeShowCommunity">Community</div>
        <div v-if="showCommunity==true">
          <div class="side-link">
            <router-link class="router-link" to="/community/colorflower">꽃 색상 효과</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/community/mbti">MBTI</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/community/tool">Invention</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/community/tool">신조어</router-link>
          </div>
        </div>
        <div  class="menu" @click="changeShowBoard">Member Lounge</div>
        <div v-if="showBoard==true">
          <div class="side-link">
            <router-link class="router-link" to="/page1">게시판</router-link>
          </div>
          <div class="side-link">
            <router-link class="router-link" to="/page1">FAQ</router-link>
          </div>
        </div >
        <div class="sign">
          <div>
            <router-link class="router-link" to="/page1">Sign Up</router-link>
          </div>
          <div>
            <router-link class="router-link" to="/page1">Log in</router-link>
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
@import url('https://fonts.googleapis.com/css2?family=Sunflower:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap');

#sidebar-right {
  background: rgb(2, 99, 42);
}
.menu {
  font-size: 20pt;
  font-family: 'Sunflower', sans-serif;
  color:black;
  text-align: center;
}
.side-link {
  font-size: 15pt;
  font-family: 'Sunflower', sans-serif;
  text-align: center;

}
.sign {
  font-size: 20pt;
  font-family: 'Sunflower', sans-serif;
  text-align: center;
}
.router-link {
  text-decoration: none;
  color: black;
  text-align: center;
}
.router-link:hover {
  color:beige;
}
</style>