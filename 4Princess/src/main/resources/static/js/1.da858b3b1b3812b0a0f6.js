webpackJsonp([1],{MIUw:function(t,e){},ObFc:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i={name:"Invention",data:function(){return{invention:[]}},methods:{test:function(){}},beforeCreate:function(){var t=this;console.log("beforeCreate"),this.$axios.get("/invention").then(function(e){var n=e.data;for(var i in n)t.invention.push(n[i])})}},s={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"Invention"}},[n("div",{attrs:{id:"page-wrapper"}},[n("article",{attrs:{id:"main"}},[t._m(0),t._v(" "),n("section",{staticClass:"wrapper alt style2"},[n("div",{staticClass:"inner"},[n("div",{staticClass:"invention-area"},t._l(t.invention,function(e,i){return n("div",{key:i,staticClass:"invention-content-area"},[n("div",{staticClass:"invention-img"},[n("a",{attrs:{href:e.url,target:"_blank"}},[n("img",{attrs:{src:e.photo}})])]),t._v(" "),n("div",{staticClass:"invention-idea"},[n("a",{attrs:{href:e.url,target:"_blank"}},[t._v(t._s(e.idea))])])])}),0)])])])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("header",[e("h2",{staticClass:"title"},[this._v("Invention")]),this._v(" "),e("p",{staticClass:"subtitle"},[this._v("식물 가꾸기 관련 발명품들을 소개합니다.:)")])])}]};var a=n("VU/8")(i,s,!1,function(t){n("MIUw")},"data-v-775e88d8",null);e.default=a.exports},TXMR:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i={name:"Neologism",data:function(){return{neologism:[]}},methods:{test:function(){}},beforeCreate:function(){var t=this;console.log("beforeCreate"),this.$axios.get("/neologism").then(function(e){var n=e.data;for(var i in n)t.neologism.push(n[i])})}},s={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"Neologism"}},[n("div",{attrs:{id:"page-wrapper"}},[n("article",{attrs:{id:"main"}},[t._m(0),t._v(" "),n("section",{staticClass:"wrapper alt style2"},[n("div",{staticClass:"inner"},t._l(t.neologism,function(e,i){return n("div",{key:i},[n("div",{staticClass:"neologism-name"},[t._v("\n                        # "+t._s(e.neologism)+"\n                    ")]),t._v(" "),n("div",{staticClass:"neologism-meaning"},[t._v("\n                        "+t._s(e.meaning)+"\n                    "),n("hr")])])}),0)])])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("header",[e("h2",{staticClass:"title"},[this._v("신조어")]),this._v(" "),e("p",{staticClass:"subtitle"},[this._v("신조어를 통해 식물 가꾸기 트렌드를 알아볼까요?:)")])])}]};var a=n("VU/8")(i,s,!1,function(t){n("ttkr")},"data-v-27fdf686",null);e.default=a.exports},ttkr:function(t,e){}});
//# sourceMappingURL=1.da858b3b1b3812b0a0f6.js.map