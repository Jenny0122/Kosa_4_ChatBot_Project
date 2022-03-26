import Vue from 'vue'
import Router from 'vue-router'
import Book from '@/components/Book'
import Main from '@/components/Main'
import ColorFlower from '@/components/ColorFlower'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [{
            path: '/book',
            name: 'Book',
            component: Book
        },
        {
            path: '/',
            name: 'Main',
            component: Main
        },
        {
            path: '/colorflower',
            name: 'ColorFlower',
            component: ColorFlower
        }
    ]
})