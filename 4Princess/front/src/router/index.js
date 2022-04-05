import Vue from 'vue'
import Router from 'vue-router'
<<<<<<< HEAD
import Main from '@/components/Main'
=======

import Home from '@/components/Home'
import Tip from '@/components/Tip'
import PlantDisease from '@/components/PlantDisease'
import GrowMethod from '@/components/GrowMethod'
import InsidePlant from '@/components/InsidePlant'
import DryPlant from '@/components/DryPlant'
>>>>>>> refs/remotes/origin/jihyeon

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [{
        path: '/',
<<<<<<< HEAD
        name: 'Main',
        component: Main
=======
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
        path: '/info/growmethod',
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
>>>>>>> refs/remotes/origin/jihyeon
    }]
})