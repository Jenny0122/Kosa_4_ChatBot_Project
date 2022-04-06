<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
/* eslint-disable */
export default {
name: 'App',
components: {
}
}
</script>

// css 수정
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.title {
  /* font-family: 'Noto Sans KR', sans-serif; */
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 900;
  font-size: 50pt;
  color: #00994C;
  text-align: center;

}
.subtitle {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 100;
  font-size: 15pt;
  text-align: center;
  margin: 10pt;
  color: white;
}
body {
  background-color: #212926;
}
</style>