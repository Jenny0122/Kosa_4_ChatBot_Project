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
    <b-button @click="updateMode ? updateContent() : uploadContent()">저장</b-button>&nbsp;
    <b-button @click="cancle">취소</b-button>
  </div>
  </div>
</template>
<script>
import data from '@/data'
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
		if (this.$route.params.contentId > 0) {
			const contentId = Number(this.$route.params.contentId)
			this.updateObject = data.Content.filter(contentItem => contentItem.content_id === contentId)[0]
			this.subject = this.updateObject.title
			this.context = this.updateObject.context
		}
	},
	methods: {
		uploadContent() { // 저장
			// let contentItems = data.Content.sort((a, b) => { return b.content_id - a.content_id })
			// // eslint-disable-next-line camelcase
			// const content_id = contentItems[0].content_id + 1 // 마지막 데이터의 id + 1

			// data.Content.push({
			// 	content_id: content_id,
			// 	user_id: this.user_id,
			// 	title: this.subject,
			// 	context: this.context,
			// 	created_at: this.created_at,
			// 	updated_at: this.updated_at
			// })

			var data = {
				'counts': 0,
				'title': this.subject,
				'contents': this.context,
				'day': '2022-04-06',
				'user_no': '1'
			}

			this.$axios.post('/board', data)
				.then((res) => {
				})
				.catch()

			this.$router.push({
				path: '/'
			})
		},
		updateContent() { // 수정
			this.updateObject.title = this.subject
			this.updateObject.context = this.context
			this.$router.push({
				path: '/'
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