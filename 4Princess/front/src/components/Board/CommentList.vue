<template>
  <div>
    <div :key="comment.co_no" v-for="comment in comments">
      <CommentListItem :commentObj="comment"></CommentListItem>
    </div>
    <CommentCreate :contentId="comments.board_no" :reloadComment="reloadComment"/>
  </div>
</template>

<script>
import CommentListItem from './CommentListItem'
import CommentCreate from './CommentCreate'

export default {
	name: 'CommentList',
	props: {
		'comments': Array
	},
	data() {
		return {
			commentList: this.comments
			// commentId: this.comments[0].board_no
			// comments: data.Comment.filter(commentItem => {
			// 	return commentItem.content_id === this.contentId
			// })
		}
	},
	components: {
		CommentListItem,
		CommentCreate
	},
	methods: {
		// reloadComment() {
		// 	this.comments = data.Comment.filter(commentItem => {
		// 		return commentItem.content_id === this.contentId
		// 	})
		// }
	}
}
</script>

<style>
</style>