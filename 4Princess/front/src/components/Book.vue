<template>
<div id="book">
  <div class="title">관련 서적</div>>
  <div class="subtitle">홈가드닝과 관련된 책에 대하여 알고 싶으신가요? :)</div>
  <div class="book-area">
    <div class="book-content-area" v-for="(book, index) in books" :key="index">
      <div class="book-img">
        <a v-bind:href="book.url" target="_blank"><img v-bind:src="book.thumbnail"></a>
      </div>
      <div class="book-text">
        <div class="book-title subtitle">
          <a v-bind:href="book.url" target="_blank">{{book.no}}. {{book.title}}</a>
        </div>
        <div class ="book-desc">
          저자 : {{book.author.replaceAll('\'', '').replace(/\[/g, '').replace(/\]/g, '')}} <br>
          출판사 : {{book.publisher}}
        </div>
      </div>
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
  },
  beforeCreate: function() {
    console.log('Book.vue is created')

    this.$axios.get('/books')
    .then((res) => {
      let list = res.data

      for (var i in list) {
        this.books.push(list[i])
      }
    })
  }
}
</script>

<style scoped>
img {
    width: 10%;
    /* height: 100pt; */
    object-fit: cover;
}
.book-area {
  margin: 30pt 0;
}
.book-content-area {
  margin: 20pt auto;
  width: 80%;
  text-align: center;
}
.book-img {
  display: inline;
  margin: 20pt;
}
.book-text {
  display: inline-block;
  width: 60%;
  vertical-align: middle;
  color: white;
  margin-bottom: 15pt;
}
.book-title {
  font-size: 20pt;
  font-weight: 500;
  text-align: left;
  color: white;

}
.book-desc {
  font-size: 15pt;
  text-align: left;

}
a {
  text-decoration: none;
  color: white;
}
.subtitle {
  margin: 10pt 0;
}
</style>