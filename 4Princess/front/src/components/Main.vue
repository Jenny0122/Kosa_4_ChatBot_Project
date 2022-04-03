<template>
  <div>
    <img src="../assets/logo.png">
    <button @click="getAllBooks">Get Books Info</button>
    <div>
      <table>
        <tr v-for="book in books" :key="book">
          <td>
            {{book.author}}
          </td>
          <td>
            <a href=''>{{book.title}}</a>
          </td>
          <td>
            {{book.publisher}}
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Main',
  data() {
    return {
      arr: [1, 3, 5, 7, 9],
      books: []
    }
  },
  methods: {
    crateBook: async function() {
      var data = {
        'id': 3,
        'value': 'Post TEST'
      }
      try {
        await this.$axios
        .post('/books', JSON.stringify(data), {
          headers: {'Content-Type': 'application/json'}
        })
        .then((res) => {
          let list = res.data
          console.log(list)
        })
        .catch((err) => {
          alert(err)
        })
      } catch (error) {
        alert(error)
      }
    },
    getAllBooks: function() {
      console.log('getAllbooks')

      this.$axios
      .get('/books')
      .then((res) => {
        let list = res.data
        this.books = []

        for (var i in res.data) {
          this.books.push(list[i])
        }
        history.go('/mbti')
      })
      .catch((err) => {
        alert(err)
      })
    }
  },
  beforeMount() {
    console.log(123)
  },
  mounted: function() {
    this.msg = '안녕 둥짱이!'
    console.log('mounted')
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
img {
  text-align: center;
  margin: 0 auto;
}
</style>