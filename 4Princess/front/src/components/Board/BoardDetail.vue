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
      <textarea v-model="context" rows="30" :readonly="isEdit"></textarea>
      <div class="content-detail-button">
        <b-button variant="primary" @click="button1 == '수정' ? updateData() : saveData()">{{button1}}</b-button>&nbsp;
        <b-button variant="success" @click="button1 == '삭제' ? deleteData() : cancel()">{{button2}}</b-button>
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
      button1: '수정',
      button2: '삭제',
      beforeEditTitle: '',
      beforeEditContext: '',
      isEdit: true,
			comments: []
		}
	},
	methods: {
    updateData: function(value) {
      this.button1 = '저장'
      this.button2 = '취소'
      this.isEdit = !this.isEdit
      this.beforeEditContext = this.context
      this.beforeEditTitle = this.title
		},
		deleteData: async function() {
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
    saveData: function() {
      if((this.beforeEditTitle == this.title) && (this.beforeEditContext == this.context)) {
        alert('변경된 내용이 없습니다')
        return
      }
      

      if(confirm('저장하시겠습니까?')){
        var data = {
          'title': this.title,
          'contents': this.context,
          'no': this.contentId
        }

        this.$axios.put('/board/' + this.contentId, data).then((res) => {
          alert('정보를 수정했습니다.')
          var newBoard = res.data
          this.title = newBoard.title          
          this.context = newBoard.contents

          this.beforeEditTitle = ''
          this.beforeEditContext = ''
          this.isEdit = !this.isEdit
          this.button2 = '삭제'
          this.button1 = '수정'
        })
        .catch((err) => {
        })
      } else {
      }
    },
    cancel: function() {
      this.title = this.beforeEditTitle
      this.context = this.beforeEditContext
      this.beforeEditContext = ''
      this.isEdit = !this.isEdit
      this.button2 = '삭제'
      this.button1 = '수정'
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
textarea{
  width: 100%;
}
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