webpackJsonp([0],{"9cUv":function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"BoardList"}},[a("div",{attrs:{id:"page-wrapper"}},[a("article",{attrs:{id:"main"}},[t._m(0),t._v(" "),a("section",{staticClass:"wrapper alt style2"},[a("div",{staticClass:"inner"},[a("b-table",{attrs:{hover:"",items:t.items,"per-page":t.perPage,"current-page":t.currentPage,fields:t.fields,"tbody-class":"text-black"},on:{"row-clicked":t.rowClick}}),t._v(" "),a("div",{attrs:{id:"customPagination"}},[a("b-pagination",{staticClass:"customPagination",attrs:{"total-rows":t.rows,"per-page":t.perPage,align:"center"},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}})],1),t._v(" "),a("div",{staticClass:"click-button"},[a("b-button",{on:{click:t.writeContent}},[t._v("글쓰기")])],1)],1)])])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("header",[e("h2",{staticClass:"title"},[this._v("게시판")]),this._v(" "),e("p",{staticClass:"subtitle"},[this._v("회원전용 게시판 공간입니다.")])])}]};var n=a("VU/8")({name:"BoardList",data:function(){return{currentPage:1,perPage:10,fields:[{key:"index",label:"번호",thClass:"text-center",tdClass:"text-center"},{key:"title",label:"제목"},{key:"user_name",label:"글쓴이",thClass:"text-center",tdClass:"text-center"},{key:"created_at",label:"작성일",thClass:"text-center",tdClass:"text-center"},{key:"counts",label:"조회수",thClass:"text-center",tdClass:"text-center"}],items:[]}},methods:{rowClick:function(t,e,a){this.$router.push({path:"/member/board/"+t.content_id})},writeContent:function(){this.$router.push({path:"/member/board/create"})}},computed:{rows:function(){return this.items.length}},created:function(){var t=this;this.$axios.get("/board").then(function(e){for(var a in t.items=[],e.data)t.items.push({index:e.data.length-a,content_id:e.data[a].no,title:e.data[a].title,context:e.data[a].contents,created_at:e.data[a].created_at.substring(0,10),counts:e.data[a].counts,updated_at:null,user_name:e.data[a].user_no.id})}).catch()}},s,!1,function(t){a("hU2L")},"data-v-08e4e5df",null);e.default=n.exports},hU2L:function(t,e){}});
//# sourceMappingURL=0.194ddf147b446ba00fde.js.map