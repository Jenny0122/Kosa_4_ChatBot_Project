<template>
  <div class="FAQ">
    <h1>FAQ</h1>
    <h2>사용자의 편의를 위한 질의응답 서비스를 제공합니다.</h2>
    <div v-for="n in faq" :key="n">
      <div>
      {{n.question}}
      </div>
      <div>
      {{n.answer}}
      </div>
    </div>
  </div>
</template>

<script>
export default {
	name: 'FAQ',
	data() {
		return {
			faq: []
		}
	},
	methods: {
		test: function() {
		}
	},
	beforeCreate: function() {
		console.log('beforeCreate')

		this.$axios.get('/faq')
			.then((res) => {
				let list = res.data

				for (var i in list) {
					this.faq.push(list[i])
				}
			})
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