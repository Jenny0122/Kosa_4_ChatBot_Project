import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/components/Home'
import Tip from '@/components/Tip'
import PlantDisease from '@/components/PlantDisease'
import GrowMethod from '@/components/GrowMethod'
import InsidePlant from '@/components/InsidePlant'
import DryPlant from '@/components/DryPlant'

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
    }]
})