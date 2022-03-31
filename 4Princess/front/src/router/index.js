import Vue from 'vue'
import Router from 'vue-router'

import SignUp from '@/components/SignUp'
import Test from '@/components/Test'

import Home from '@/components/Home'
import Tip from '@/components/Tip'
import PlantDisease from '@/components/PlantDisease'
import GrowMethod from '@/components/GrowMethod'
import InsidePlant from '@/components/InsidePlant'
import DryPlant from '@/components/DryPlant'
import AirPlant from '@/components/AirPlant'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [{
        path: '/',
        name: 'Home',
        component: Home
    }, {
        path: '/signup',
        name: 'SignUp',
        component: SignUp
    }, {
        path: '/signup/user',
        name: 'Test',
        component: Test
    }, {
        path: '/tip',
        name: 'Tip',
        component: Tip
    }, {
        path: '/plantdisease',
        name: 'PlantDisease',
        component: PlantDisease
    }, {
        path: '/growmethod',
        name: 'GrowMethod',
        component: GrowMethod
    }, {
        path: '/insideplant',
        name: 'InsidePlant',
        component: InsidePlant
    }, {
        path: '/dryplant',
        name: 'DryPlant',
        component: DryPlant
    }, {
        path: '/airplant',
        name: 'AirPlant',
        component: AirPlant
    }]
})