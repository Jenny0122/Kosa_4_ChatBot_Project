<template>
  <div>
    <b-sidebar id="sidebar-right" title="Menu" right shadow>
      <div class="px-3 py-2">
        <!-- <b-img src="ass" fluid thumbnail></b-img> -->
        <router-link to="/">Home</router-link>
        <div @click="changeShowInfo">Info</div>
        <div v-if="showInfo==true">
          <div>
            <router-link to="/page1">소개영상</router-link>
          </div>
          <div>
            <router-link to="/growmethod">키우는 방법</router-link>
          </div>
          <div>
            <router-link to="/plantdisease">식물질병</router-link>
          </div>
          <div>
            <router-link to="/tip">TIP</router-link>
          </div>
        </div>
        <div @click="changeShowPlant">Plant</div>
        <div v-if="showPlant==true">
          <div>
            <router-link to="/insideplant">실내정원식물</router-link>
          </div>
          <div>
            <router-link to="/dryplant">건조에 강한 식물</router-link>
          </div>
          <div>
            <router-link to="/airplant">공기 정화 식물</router-link>
          </div>
        </div>
        <div @click="changeShowLifeStyle">Life-Style</div>
        <div v-if="showLifeStyle==true">
          <div>
            <router-link to="/life-style/cook">Recipe</router-link>
          </div>
          <div>
            <router-link to="/life-style/book">Book</router-link>
          </div>
          <div>
            <router-link to="/life-style/tool">Tool</router-link>
          </div>
        </div>
        <div @click="changeShowCommunity">Community</div>
        <div v-if="showCommunity==true">
          <div>
            <router-link to="/community/colorflower">꽃 색상 효과</router-link>
          </div>
          <div>
            <router-link to="/community/mbti">MBTI</router-link>
          </div>
          <div>
            <router-link to="/community/tool">Invention</router-link>
          </div>
          <div>
            <router-link to="/community/tool">신조어</router-link>
          </div>
        </div>
        <div @click="changeShowBoard">Member Lounge</div>
        <div v-if="showBoard==true">
          <div>
            <router-link to="/page1">게시판</router-link>
          </div>
          <div>
            <router-link to="/page1">FAQ</router-link>
          </div>
        </div>
        <br/><br/><br/>
        <div>Sign Up</div>
        <div>Login</div>
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
    console.log('beforeCreate')
   }
 }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#side{ transition:all .3s linear; right:0; width:200px; height:100%; position:fixed; border-top:1px #D8D8D8 solid; margin:0 auto; z-index:50; text-align:right; background-color:#41a432; }
    .side-show{ bottom:0; transition:all .3s linear; }
    .side-hide{ bottom:-70px; transition:all .3s linear; }
    .side-link{text-decoration: none;}
    .side-box div{ width:40px; height:40px; margin:10px; display: inline-block; line-height:40px; border-radius:50%; cursor:pointer; }
    .side-box div a{ text-decoration:none; }
    .side-box-default{ transition:all .1s linear; background-color:black; }
    .side-box-selected{ transition:all .1s linear; background-color:blue; }
router-link {
  font-size: 100pt;
}
</style>