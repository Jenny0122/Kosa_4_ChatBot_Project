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
        <b-button class="write" @click="createComment">작성하기</b-button>
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
			name: '',
			context: '',
			comment: ''
		}
	},
	methods: {
		createComment: function () {
			if(this.comment.length == 0)
				return
			var data = {
				'comment': this.comment,
				'board_no': this.contentId,
				'user_no': {id: this.$store.state.dataStore.loginAccount.id}
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
.write:hover {
	background: #557571;
}
</style>