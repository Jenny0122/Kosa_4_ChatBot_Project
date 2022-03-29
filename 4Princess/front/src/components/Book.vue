<template>
  <div>
      <div>
        <h1>관련 서적</h1>
      </div>
      <div v-for="b in books" :key="b">
      <div>
      {{b.title}}
      </div>
      <div>
      {{b.author}}
      </div>
      <div>
      {{b.publisher}}
      </div>
      <div>
      {{b.thumnail}}
      </div>
  </div>
  </div>
</template>

<script>
export default {
  name: 'Book',
  data() {
    return {
      books: []
    }
  },
  methods: {
    test: function() {
    }
  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/book')
    .then((res) => {
      let list = res.data

      for (var i in list) {
        this.books.push(list[i])
      }
    })
  }
}
</script>
<style>
    table{
    width: 75%;
    text-align : left;
    }
    tanle th{
        padding : 12px;
        border-bottom: 2px solid  darkgray;
    }
    table td{
        padding : 12px;
    }
    table tr:nth-of-type(even){
        background-color: rgba(0,0,255,0.1);
    }
</style>