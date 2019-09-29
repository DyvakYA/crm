import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import store from './store'

import VueResource from 'vue-resource'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import {library} from '@fortawesome/fontawesome-svg-core'
import {faEye, faPencilAlt, faPlusCircle, faTrash} from '@fortawesome/free-solid-svg-icons'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import axios from 'axios'

Vue.use(VueResource)

Vue.use(Vuetify)

// Bootstrap
Vue.use(BootstrapVue)

library.add(faTrash)
library.add(faPencilAlt)
library.add(faEye)
library.add(faPlusCircle)

Vue.component('font-awesome-icon', FontAwesomeIcon)


Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')



