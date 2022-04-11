<template>
	<div>
		<div :key="comment.co_no" v-for="comment in comments">
			<CommentListItem :commentObj="comment"></CommentListItem>
		</div>

    	<CommentCreate :contentId="$route.params.no"/>
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
		}
	},
	components: {
		CommentListItem,
		CommentCreate
	}
}
</script>

<style>
</style>