<template>
  <div id="Invention">
    <div class="title">Invention</div>
    <div class="subtitle">식물 가꾸기 관련 발명품들을 소개합니다.:)</div>
    <div class="invention-area">
			<div class="invention-content-area" v-for="n in invention" :key="n">
				<div class="invention-img">
					<a v-bind:href="n.url" target="_blank"><img v-bind:src="n.photo"></a>
				</div>
				<div class="invention-idea">
					<a v-bind:href="n.url" target="_blank">{{n.idea}}</a>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: 'Invention',
	data() {
		return {
			invention: []
		}
	},
	methods: {
		test: function() {
		}
	},
	beforeCreate: function() {
		console.log('beforeCreate')

		this.$axios.get('/invention')
			.then((res) => {
				let list = res.data

				for (var i in list) {
					this.invention.push(list[i])
				}
			})
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
img {
	width: 50%;
}
.invention-area {
	width: 80%;
	margin: 40pt auto;
	/* float: left; */
	text-align: center;
}
.invention-content-area {
	width: 30%;
	margin-left: 10px;
	/* float: left; */
	margin-right: 10px;
	color: white;
	margin: 30pt 0;
	vertical-align: middle;
	display: inline-block;
}
.invention-idea {
	margin: 20pt 0;
	font-size: 15pt;
	font-family: 'Noto Sans KR', sans-serif;
}
a {
	text-decoration: none;
	color: white;
}
</style>;