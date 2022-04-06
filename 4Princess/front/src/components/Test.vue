<template>
  <div class="Test">
    <div class="title">Test</div>
    <div class="subtitle">Test페이지입니다.</div>
    <div class="test">
    <div v-for="n in faq" :key="n">
      <div>
      {{n.counts}}
      </div>
      <div>
      {{n.title}}
      </div>
      <div>
      {{n.contents}}
      </div>
      <div>
      {{n.day}}
      </div>
      <div>
      {{n.user_no}}
      </div>
    </div>
    </div>
  </div>
</template>

<script>
export default {
	name: 'Test',
	data() {
		return {
			test: []
		}
	},
	methods: {
		// test: function() {
		// }
	},
	beforeCreate: function() {
		console.log('beforeCreate')

		this.$axios.get('/test')
			.then((res) => {
				let list = res.data

				for (var i in list) {
					this.test.push(list[i])
				}
			})
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.BoardList {
	color: white;
	text-align: left;
	width:80%;
	margin: 50pt auto;
}
</style>