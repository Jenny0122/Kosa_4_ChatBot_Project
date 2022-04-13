<template>
  <div>
    <div class="comment-list-item">
      <div class="comment-list-item-name">
        <div>{{name}}</div>
        <div>{{commentObj.day}}</div>
      </div>

      <div class="comment-list-item-context">{{commentObj.comment}}</div>

      <div class="comment-list-item-button">
        <b-button >!</b-button>
        <b-button >x</b-button>
      </div>
    </div>

    <template v-if="subCommentList.length > 0">
      <div
        class="comment-list-item-subcomment-list"
        :key="item.subcomment_id"
        v-for="item in subCommentList"
      >
        <div class="comment-list-item-name">
          <div>{{item.user_no}}</div>
          <div>{{item.created_at}}</div>
        </div>

        <div class="comment-list-item-context">{{item.context}}</div>

        <div class="comment-list-item-button">
          <b-button variant="info">수정</b-button>
          <b-button variant="info">삭제</b-button>
        </div>
      </div>
    </template>
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
		subCommentToggle() {
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
  width: 45em;
  border: 0.5px solid black;
  max-height: 5em;
}

.comment-list-item-button {
  display: inline-block;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 0.5px solid black;
  /* padding: 1em; */
  max-height: 5em;
  width: 8em;
  text-align: center;
}
.btn {
  margin-bottom: 1em;
}
.btn-secondary {
  color: #fff;
  background-color: #557571;
  border-color: #557571;
}
.comment-list-item-subcomment-list {
  display: flex;
  justify-content: space-between;
  padding-bottom: 1em;
  margin-left: 10em;
}
</style>