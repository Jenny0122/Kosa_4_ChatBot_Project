import Vue from 'vue'
import Router from 'vue-router'
import BoardCreate from '@/components/Board/BoardCreate'
import BoardDetail from '@/components/Board/BoardDetail'

/* eslint-disable */
Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [{
            path: '/community/neologism',
            name: 'Neologism',
            component: () =>
                import ( /* webpackChunkName: 'Community' */ '../components/Neologism.vue'),
        },
        {
            path: '/community/invention',
            name: 'Invention',
            component: () =>
                import ( /* webpackChunkName: 'Community' */ '../components/Invention.vue'),
        },
        {
            path: '/member/board/create',
            name: 'BoardCreate',
            component: BoardCreate,
        },
        {
            path: '/member/board/:no',
            name: 'BoardDetail',
            component: BoardDetail,
        },
        {
            path: '/member/board',
            name: 'BoardList',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/Board/BoardList.vue'),
        },
        {
            path: '/member/comment/create',
            name: 'CommentCreate',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/Board/CommentCreate.vue'),
        },
        {
            path: '/member/comment',
            name: 'CommentList',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/Board/CommentList.vue'),
        },
        {
            path: '/member/commentlistitem',
            name: 'CommentListItem',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/Board/CommentListItem.vue'),
        }
    ]
})