<template>
  <div class="Neologism">
    <div class="title">Neologism</div>
    <div class="subtitle">신조어를 통해 식물 가꾸기 트렌드를 알아볼까요?:)</div>
    <div class="neologism-text" v-for="n in neologism" :key="n">
      <div class="neologism-name">
				# {{n.neologism}}
      </div>
      <div class="neologism-meaning">
				{{n.meaning}}
      </div>
    </div>
  </div>
</template>

<script>
export default {
	name: 'Neologism',
	data() {
		return {
			neologism: []
		}
	},
	methods: {
		test: function() {
		}
	},
	beforeCreate: function() {
		console.log('beforeCreate')

		this.$axios.get('/neologism')
			.then((res) => {
				let list = res.data

				for (var i in list) {
					this.neologism.push(list[i])
				}
			})
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
.neologism-text {
	color: white;
	text-align: left;
	width:80%;
	margin: 50pt auto;
}
.neologism-name {
	font-size: 30pt;
	font-weight: 700;
	color:gray;
	font-style: italic;
	font-family: 'Noto Sans KR', sans-serif;
}
.neologism-meaning {
	margin: 20pt 0;
	font-size: 15pt;
  font-family: 'Noto Sans KR', sans-serif;
}
</style>