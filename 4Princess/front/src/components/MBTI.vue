<template>
  <div>
    {{msg}}
  </div>
</template>


<script>

export default {
  name: 'MBTI',
  data() {
    return {
      msg: ''
    }
  },
  methods: {
    test: function() {
    }
  },
  beforeMount() {
    console.log(123)
  },
  mounted: function() {
    this.msg = '여기는 NEW!!'
    console.log('mounted')
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>

<style global>

</style>