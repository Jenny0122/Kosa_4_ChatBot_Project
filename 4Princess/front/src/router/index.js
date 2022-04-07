import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Tip from '@/components/Tip'
import PlantDisease from '@/components/PlantDisease'
import GrowMethod from '@/components/GrowMethod'
import InsidePlant from '@/components/InsidePlant'
import DryPlant from '@/components/DryPlant'
import Book from '@/components/Book'
import ColorFlower from '@/components/ColorFlower'
import MBTI from '@/components/MBTI'
import Tool from '@/components/Tool'
import Cook from '@/components/Cook'
import FAQ from '@/components/FAQ'
import BoardCreate from '@/components/Board/BoardCreate'
import BoardDetail from '@/components/Board/BoardDetail'


Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [{
            path: '/',
            name: 'Home',
            component: Home
        }, {
            path: '/info/tip',
            name: 'Tip',
            component: Tip
        }, {
            path: '/info/plantdisease',
            name: 'PlantDisease',
            component: PlantDisease
        }, {
            path: '/info/growmethod/',
            name: 'GrowMethod',
            component: GrowMethod
        }, {
            path: '/plant/insideplant',
            name: 'InsidePlant',
            component: InsidePlant
        }, {
            path: '/plant/dryplant',
            name: 'DryPlant',
            component: DryPlant
        },
        {
            path: '/life-style/book',
            name: 'Book',
            component: Book
        },
        {
            path: '/community/colorflower',
            name: 'ColorFlower',
            component: ColorFlower
        },
        {
            path: '/community/mbti',
            name: 'MBTI',
            component: MBTI
        },
        {
            path: '/life-style/cook',
            name: 'Cook',
            component: Cook
        },
        {
            path: '/life-style/tool',
            name: 'Tool',
            component: Tool
        },
        {
            path: '/memberlounge/faq',
            name: 'FAQ',
            component: FAQ
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
            path: '/memberlounge/boarddetail/:no',
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
        }
    ]
})