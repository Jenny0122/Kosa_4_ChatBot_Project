import Vue from "vue"
import Vuex from "vuex"
import createPersistedState from 'vuex-persistedstate'
import { dataStore } from './data'

Vue.use(Vuex)
Vue.config.devtools = true

export const store = new Vuex.Store({
    modules: {
        dataStore
    },
    plugins: [
        createPersistedState({
            paths: ['dataStore', 'data', 'isLogin']
        })
    ]
})