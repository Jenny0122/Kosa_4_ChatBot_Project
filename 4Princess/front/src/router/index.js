import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/components/Home'
import BoardCreate from '@/components/Board/BoardCreate'
import BoardDetail from '@/components/Board/BoardDetail'

import Test from '@/components/Test'
/* eslint-disable */
Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [{
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        },
        {
            path: '/',
            name: 'Home',
            component: Home,
        },
        {
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
            path: '/memberlounge/boardcreate',
            name: 'BoardCreate',
            component: BoardCreate,
        },
        {
            path: '/memberlounge/boarddetail/',
            name: 'BoardDetail',
            component: BoardDetail,
        },
        {
            path: '/memberlounge/boardlist',
            name: 'BoardList',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/Board/BoardList.vue'),
        },
        {
            path: '/memberlounge/commentcreate',
            name: 'CommentCreate',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/Board/CommentCreate.vue'),
        },
        {
            path: '/memberlounge/commentlist',
            name: 'CommentList',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/Board/CommentList.vue'),
        },
        {
            path: '/memberlounge/commentlistitem',
            name: 'CommentListItem',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/Board/CommentListItem.vue'),
        },
        {
            path: '/memberlounge/faq',
            name: 'FAQ',
            component: () =>
                import ( /* webpackChunkName: 'Memberlounge' */ '../components/FAQ.vue'),
        }, {
            path: '/test',
            name: 'TEST',
            component: Test
        }
    ]
})