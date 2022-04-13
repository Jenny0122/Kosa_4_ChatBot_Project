<template>
  <div>
    <div class="comment-list-item">
      <div class="comment-list-item-name">
        <div>{{name}}</div>
        <div>{{commentObj.day}}</div>
      </div>

      <div class="comment-list-item-context">{{commentObj.comment}}</div>

      <div class="comment-list-item-button">
        <b-button variant="info">수정</b-button>
        <b-button variant="info" @click="deleteComment">삭제</b-button>
      </div>
    </div>
  </div>
</template>

<script>
import CommentCreate from './CommentCreate'

export default {
	name: 'CommentListItem',
	props: {
		'commentObj': Object
	},
	components: {
		CommentCreate
	},
	data() {
		return {
			name: this.commentObj.user_no,
			subCommentList: []
		}
	},
	methods: {
		deleteComment: function() {
      if(confirm('정말로 삭제하시겠습니까?')){
        this.$axios.delete('/comment/' + this.commentObj.co_no)
        .then((res) => {
          alert('댓글이 삭제되었습니다.')
          this.$router.go();
        })
        .catch((err) => {})
      } else {
      }
		},
		reloadSubComments() {
		}
	}
}
</script>

<style scoped>
.comment-list-item {
  display: flex;
  justify-content: space-between;
  padding-bottom: 1em;
}

.comment-list-item-name {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 0.5px solid black;
  padding: 1em;
}

.comment-list-item-context {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50em;
  border: 0.5px solid black;
}

.comment-list-item-button {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 0.5px solid black;
  padding: 1em;
}

.btn {
  margin-bottom: 1em;
}

.comment-list-item-subcomment-list {
  display: flex;
  justify-content: space-between;
  padding-bottom: 1em;
  margin-left: 10em;
}
</style>