<template>
  <div class="BoardDetail">
    <div class="title">게시판</div>
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
        <b-button class='updatdData' @click="updateData">수정</b-button>&nbsp;
        <b-button class='deleteData' @click="deleteData">삭제</b-button>
      </div>
      <div class="content-detail-comment">
        <CommentList :comments="comments"></CommentList>
      </div>
    </b-card>
  </div>
</template>

<script>
// import data from '@/data/index.js'
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
		deleteData() {
		// 	// eslint-disable-next-line camelcase
		// 	const content_index = data.Content.findIndex(
		// 		contentItem => contentItem.content_id === this.contentId
		// 	)
		// 	data.Content.splice(content_index, 1) // 데이터 삭제
		// 	this.$router.push({
		// 		path: '/'
		// 	})
		},
		updateData() {
		// 	this.$router.push({
		// 		path: `/board/create/${this.contentId}`
		// 	})
		}
	},
	beforeCreate: function() {
		var no = this.$route.params.no
		this.$axios.get('/board/' + no).then((res) => {
			var board = res.data
			this.contentId = board.no
			this.title = board.title
			this.context = board.contents
			this.user = board.user_no
			this.created = board.day
			this.comments = board.comment
		}).catch()
	},
	components: {
		CommentList
	}
}
</script>

<style scoped>
.subtitle{
	padding-bottom: 3%;
}
.BoardDetail {
	text-align: left;
	width:80%;
	margin: 50pt auto;
  padding: 0 8%;
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
  margin-top: 1rem;
  padding: 1rem;
  border: none;
  text-align: right;
}

.content-detail-comment {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 1rem;
}
.btn-secondary{
  border-color:white;
}

.btn.updatdData.btn-secondary{
  background-color: #21b2a6;
}

.btn.deleteData.btn-secondary{
  background-color: #6c757d;
}

</style>