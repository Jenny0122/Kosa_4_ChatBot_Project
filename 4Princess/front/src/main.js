// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
/* eslint-disable */
import Vue from 'vue'
import './plugins/axios'
import App from './App'
import router from './router'

import { BootstrapVue, IconsPlugin, PaginationPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = true
    // Vue.prototype.$axios = axios
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(PaginationPlugin)

new Vue({
    render: h => h(App),
    router
}).$mount('#app')