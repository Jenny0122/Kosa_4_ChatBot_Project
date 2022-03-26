<template>
  <div>
    {{msg}}
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
    <!--<div v-for="t in 16" :key="t">
      <MBTI />
    </div>-->
  </div>
</template>


<script>
import MBTI from './MBTI'

export default {
  name: 'Main',
  data() {
    return {
      msg: '뿌우짱~~~',
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
        for (var i in list) {
          this.books.push(list[i])
        }
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
  },
  components: {
    'MBTI': MBTI
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