<template>
  <div class="BoardDetail">
    <div class="title">BoardDetail</div>
    <div class="subtitle">회원전용 공간입니다.:)</div>
    <b-card>
      <div class="content-detail-content-info">
        <div class="content-detail-content-info-left">
          <div class="content-detail-content-info-left-number">{{contentId}}</div>
          <div class="content-detail-content-info-left-subject">{{title}}</div>
        </div>
        <div class="content-detail-content-info-right">
          <div class="content-detail-content-info-right-user">글쓴이: {{user}}</div>
          <div class="content-detail-content-info-right-created">등록일: {{created}}</div>
        </div>
      </div>
      <div class="content-detail-content">{{context}}</div>
      <div class="content-detail-button">
        <b-button variant="primary" @click="updateData">수정</b-button>&nbsp;
        <b-button variant="success" @click="deleteData">삭제</b-button>
      </div>
      <div class="content-detail-comment">
        <CommentList :comments="comments"></CommentList>
      </div>
    </b-card>
  </div>
</template>

<script>
import CommentList from './CommentList'
export default {
	name: 'BoardDetail',
	data() {
		return {
			contentId: '',
			title: '',
			context: '',
			user: '',
			created: '',
			comments: []
		}
	},
	methods: {
		async deleteData() {
      this.$axios.delete('/board/' + this.contentId).then((res) => {
          alert('게시물이 삭제되었습니다.')
        })
        .catch((err) => {
          console.log(err)
          return
        })

			this.$router.push({
				path: '/member/board'
		  })
		},
		updateData() {
      // 수정기능 어떻게 할지 디자인/액션 부분 피드백 주세요
		}
	},
	beforeCreate: function() {
		var no = this.$route.params.no
		this.$axios.get('/board/' + no).then((res) => {
			var board = res.data

			this.contentId = board.no
			this.title = board.title
			this.context = board.contents
			this.user = board.user_no.id
			this.created = board.created_at.replace('T', ' ')
			this.comments = board.comment
		}).catch()

	},
	components: {
		CommentList
	}
}
</script>

<style scoped>
.BoardDetail {
	text-align: left;
	width:80%;
	margin: 50pt auto;
  padding: 0 5%;
}
.content-detail-content-info {
  border: 1px solid black;
  display: flex;
  justify-content: space-between;
}

.content-detail-content-info-left {
  width: 720px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
}

.content-detail-content-info-right {
  width: 300px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 1rem;
}

.content-detail-content {
  border: 1px solid black;
  margin-top: 1rem;
  padding-top: 1rem;
  min-height: 500px;
}

.content-detail-button {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 1rem;
}

.content-detail-comment {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 1rem;
}
.content-detail-content-info-right-user {
  float: left;
}
</style>