<template>
  <div class="BoardList">
		<div class="title">게시판</div>
    <div class="subtitle">회원전용 게시판 공간입니다:)</div>
		<div class="table" >
		<b-table
		hover
		:items="items"
		:per-page="perPage"
		:current-page="currentPage"
		:fields="fields"
		tbody-class="text-white"
		@row-clicked="rowClick"
	></b-table>
	</div>
	<div id="customPagination">
			<b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" align="center" class="customPagination"></b-pagination>
	</div>
		<div class="click-button">
			<b-button @click="writeContent">글쓰기</b-button>
		</div>
  </div>
</template>

<script>
// import data from '@/data'

export default {
	name: 'BoardList',
	data() {
		return {
			currentPage: 1, // 현재 페이지
			perPage: 10, // 페이지당 보여줄 갯수
			// bootstrap 'b-table' 필드 설정
			fields: [
				{
					key: 'content_id',
					label: '번호',
					thClass: 'text-center',
					tdClass: 'text-center'
				},
				{
					key: 'title',
					label: '제목',
					thClass: 'text-center',
					tdClass: 'text-center'
				},
				{
					key: 'user_name',
					label: '글쓴이',
					thClass: 'text-center',
					tdClass: 'text-center'
				},
				{
					key: 'created_at',
					label: '작성일',
					thClass: 'text-center',
					tdClass: 'text-center'
				},
				{
					key: 'counts',
					label: '조회수',
					thClass: 'text-center',
					tdClass: 'text-center'
				}
			],
			items: []
		}
	},
	methods: {
		rowClick(item, index, e) {
			this.$router.push({
				path: `/member/board/${item.content_id}`
			})
		},
		writeContent() {
			this.$router.push({
				path: `/member/board/create`
			})
		}
	},
	computed: {
		rows() {
			return this.items.length
		}
	},
	created: function() {
		// DB에서 정보 불러와서 items에 저장
		this.$axios.get('/board')
			.then((res) => {
				this.items = []
				for (var i in res.data) {
					this.items.push({
						'content_id': res.data[i].no,
						'title': res.data[i].title,
						'context': res.data[i].contents,
						'created_at': res.data[i].day.toString().substring(0, 10),
						'counts': res.data[i].counts,
						'updated_at': null,
						'user_id': res.data[i].user_no
					})
				}
			})
			.catch()
	}
}


</script>

<style>
.subtitle{
	padding-bottom: 5%;
}
.BoardList {
	color: white;
	text-align: left;
	width:80%;
	margin: 50pt auto;
	padding: 0 10%
}
.click-button {
	float:right;
}
.table{
	color: white;
	--bs-table-hover-color: 0;
	--bs-table-hover-bg: #21b2a64f;
}
.page-item.active .page-link {
    color: #f8f9fa;
		background-color: #21b2a6 !important;
    border-color: #21b2a6 !important;
}
.page-item .page-link, .page-item .disabled {
		border-color: #212926 !important;
		background-color: #212926 !important;
		color: #f8f9fa;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 17px;
    margin: 0 2px 5px;
    min-width: 20px;
    padding: 0 10px;
    height: 40px;
    text-decoration: none;
    position: relative;
    border-radius: 5px;
    font-family: Helvetica, Arial, sans-serif;
}
</style>