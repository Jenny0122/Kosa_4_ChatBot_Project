<template>
  <div class="BoardList">
		<div class="title">BoardList</div>
    <div class="subtitle">회원전용 게시판 공간입니다.:)</div>
		<b-table
		hover
		:items="items"
		:per-page="perPage"
		:current-page="currentPage"
		:fields="fields"
		tbody-class="text-white"
		@row-clicked="rowClick"
	></b-table>

	<b-pagination
		v-model="currentPage"
		:total-rows="rows"
		:per-page="perPage"
		align="center"
	></b-pagination>
	<div class="click-button">
	<b-button @click="writeContent">글쓰기</b-button>
	</div>
  </div>
</template>

<script>
import data from '@/data'

export default {
	name: 'BoardList',
	data() {
		// 정렬 : https://blog.naver.com/haskim0716n/221681695401
		let contentItems = data.Content.sort((a, b) => {
			return b.content_id - a.content_id
		}) // 내림차순

		// User 와 Content 의 user_id 의 같은 번호를 찾아 Content 에 기존자료 + 'user_name' 으로 추가한다.
		let items = contentItems.map((contentItem) => {
			return {
				...contentItem,
				user_name: data.User.filter((userItem) => {
					return contentItem.user_id === userItem.user_id
				})[0].name
			}
		})

		return {
			currentPage: 1, // 현재 페이지
			perPage: 10, // 페이지당 보여줄 갯수
			// bootstrap 'b-table' 필드 설정
			fields: [
				{
					key: 'content_id',
					label: '번호'
				},
				{
					key: 'title',
					label: '제목'
				},
				{
					key: 'user_name',
					label: '글쓴이'
				},
				{
					key: 'created_at',
					label: '작성일'
				}
			],
			items: items
		}
	},
	methods: {
		rowClick(item, index, e) {
			this.$router.push({
				path: `/memberlounge/boarddetail/${item.content_id}`
			})
		},
		writeContent() {
			this.$router.push({
				path: `/memberlounge/boardcreate`
			})
		}
	},
	computed: {
		rows() {
			return this.items.length
		}
	}
}
</script>

<style scoped>
.BoardList {
	color: white;
	text-align: left;
	width:80%;
	margin: 50pt auto;
}
.click-button{
	float:right;
}


</style>