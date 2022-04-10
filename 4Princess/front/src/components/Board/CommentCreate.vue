<template>
  <div class="comment-create">
    <b-input-group :prepend="name" class="mt-3">
      <b-form-textarea
        id="textarea"
        v-model="comment"
        :placeholder="isSubComment ? '댓글에 댓글을 달아주세요~!' : '코멘트를 달아주세요~!'"
        rows="3"
        max-rows="6"
      ></b-form-textarea>
      <b-input-group-append>
        <b-button variant="secondary" class="mt-auto" @click="isSubComment ? createSubComment() : createComment()">▲</b-button>
      </b-input-group-append>
    </b-input-group>
  </div>
</template>

<script>
export default {
	name: 'CommentCreate',
	props: {
		contentId: Number,
		reloadComment: Function,
		reloadSubComments: Function,
		subCommentToggle: Function,
		isSubComment: Boolean,
		commentId: Number
	},
	data() {
		return {
			name: '인성',
			context: '',
			comment: ''
		}
	},
	methods: {
		createComment() {
			// eslint-disable-next-line camelcase
			// const comment_id = data.Comment[data.Comment.length - 1].comment_id + 1
			// data.Comment.push({
			// 	comment_id: comment_id,
			// 	user_id: 1,
			// 	content_id: this.contentId,
			// 	context: this.context,
			// 	created_at: '2019-04-19',
			// 	updated_at: null
			// })
			// this.reloadComment()
			// // this.subCommentToggle();
			// this.context = ''

			var data = {
				'comment': this.comment,
				'day': '2022-04-06',
				'board_no': '1',
				'user_no': '1'
			}
			this.$axios.post('/comment', data)
				.then((res) => {
					alert('정상 메세지로 변경')
				})
				.catch(() => {

				})
		},
		createSubComment() {
			// // eslint-disable-next-line camelcase
			// const subcomment_id =
		// data.SubComment[data.SubComment.length - 1].subcomment_id + 1
			// data.SubComment.push({
			// 	subcomment_id: subcomment_id,
			// 	comment_id: this.commentId,
			// 	user_id: 1,
			// 	context: this.context,
			// 	created_at: '2019-04-20',
			// 	updated_at: null
			// })
			// this.reloadSubComments()
			// this.subCommentToggle()
			// this.context = ''
		}
	}
}
</script>

<style scoped>
.comment-create {
  display: flex;
  margin-bottom: 1em;
}
.input-group-prepend .input-group-text {
  background: unset;
	border: 0;
}
</style>