import Vue from 'vue'
import Router from 'vue-router'
import Book from '@/components/Book'
import Main from '@/components/Main'
import ColorFlower from '@/components/ColorFlower'
import MBTI from '@/components/MBTI'
import Tool from '@/components/Tool'
import Cook from '@/components/Cook'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [{
            path: '/life-style/book',
            name: 'Book',
            component: Book
        },
        {
            path: '/',
            name: 'Main',
            component: Main
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
        }
    ]
})