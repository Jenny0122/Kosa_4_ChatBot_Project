<template>
  <div class="BoardCreate">
    <div class="title">BoardCreate</div>
    <div class="subtitle">게시판을 작성하는 공간입니다.:)</div>
    <div class="textarea-title">
      <b-input v-model="subject" placeholder="제목을 입력해주세요."></b-input>
    </div>
    <div class="textarea-context">
      <b-form-textarea
          v-model="context"
          placeholder="내용을 입력해 주세요."
          rows="20"
      ></b-form-textarea>
    </div>
  <div class="button">
    <br>
    <b-button @click="uploadContent">저장</b-button>&nbsp;
    <b-button @click="cancle">취소</b-button>
  </div>
  </div>
</template>
<script>
// import data from '@/data'
export default {
	name: 'BoardCreate',
	data() {
		return {
			subject: '',
			context: '',
			user_id: 1,
			created_at: '2018-09-11',
			updated_at: null,
			updateObject: null,
			updateMode: this.$route.params.contentId > 0
		}
	},
	created() {
	},
	methods: {
		uploadContent() { // 저장
			var data = {
				'title': this.subject,
				'contents': this.context,
				'user_no': '1'
			}

			this.$axios.post('/board', data)
				.then((res) => {
					console.log('Board Created...')
				})
				.catch()

			this.$router.push({
				path: '/member/board'
			})
		},
		cancle() {
			this.$router.push({
				path: '/'
			})
		}
	}
}
</script>

<style scoped>
.BoardCreate {
	color: white;
	text-align: left;
	width:80%;
	margin: 50pt auto;
}
.textarea-title {
  padding: 0 10%;
  margin: 5pt auto;
}
.textarea-context{
  padding: 0 10%;
}
.button{
  display: inline-block;
  margin: 0 155px;
  float: right;
}
</style>