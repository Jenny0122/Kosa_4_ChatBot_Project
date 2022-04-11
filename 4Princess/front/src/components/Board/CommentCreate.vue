<template>
  <div class="comment-create">
    <b-input-group :prepend="name" class="mt-3">
      <b-form-textarea
        id="textarea"
        v-model="comment"
        :placeholder="'코멘트를 달아주세요~!'"
        rows="3"
        max-rows="6"
      ></b-form-textarea>
      <b-input-group-append>
        <b-button variant="info" @click="createComment">작성하기</b-button>
      </b-input-group-append>
    </b-input-group>
  </div>
</template>
<script>
export default {
	name: 'CommentCreate',
	props: {
		'contentId': String
	},
	data() {
		return {
			name: '인성',
			context: '',
			comment: ''
		}
	},
	methods: {
		createComment: function () {
			var data = {
				'comment': this.comment,				
				'board_no': this.contentId,
				'user_no': '1'
			}
			this.$axios.post('/comment', data)
				.then((res) => {
					alert('댓글이 등록되었습니다')
					this.$router.go()
				})
				.catch(() => {
				})
		},
		createSubComment() {
		}
	}
}
</script>

<style scoped>
.comment-create {
  display: flex;
  margin-bottom: 1em;
}
</style>