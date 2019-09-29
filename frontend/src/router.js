import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Service from '@/components/Service'
import Bootstrap from '@/components/Bootstrap'
import User from '@/components/User'
import Login from '@/components/Login'
import Registration from '@/components/Registration'
import Organization from '@/components/Organization'
import Orders from '@/components/Orders'
import Leads from '@/components/Leads'
import Accounts from '@/components/Accounts'
import Contacts from '@/components/Contacts'
import Products from '@/components/Products'
import Opportunities from "./components/Opportunities"

import store from './store'

Vue.use(Router)

const router = new Router({
    mode: 'history',
    routes: [
        {
            // otherwise redirect to home
            path: '*', redirect: "/"
        },
        {
            path: '/',
            alias: '/home',
            name: 'Home',
            component: Home,
            meta: {title: 'Home'}
        },
        {
            path: '/login',
            name: 'Login',
            component: Login,
            meta: {title: 'Login'}
        },
        {
            path: '/registration',
            name: 'Registration',
            component: Registration,
            meta: {title: 'Registration'}
        },
        {
            path: '/callservice',
            name: 'Service',
            component: Service,
            meta: {title: 'Service'}
        },
        {
            path: '/bootstrap',
            name: 'Bootstrap',
            component: Bootstrap,
            meta: {title: 'Bootstrap'}
        },
        {
            path: '/user',
            name: 'User',
            component: User,
            meta: {title: 'User'}
        },
        {
            path: '/organization',
            name: 'Organization',
            component: Organization,
            meta: {
                title: 'Organization',
                requiresAuth: true
            },

        },
        {
            path: '/orders',
            name: 'Orders',
            component: Orders,
            meta: {title: 'Orders'}
        },
        {
            path: '/leads',
            name: 'Leads',
            component: Leads,
            meta: {title: 'Leads'}
        },
        {
            path: '/accounts',
            name: 'Accounts',
            component: Accounts,
            meta: {title: 'Accounts'}
        },
        {
            path: '/contacts',
            name: 'Contacts',
            component: Contacts,
            meta: {title: 'Contacts'}
        },
        {
            path: '/products',
            name: 'Products',
            component: Products,
            meta: {title: 'Products'}
        },
        {
            path: '/opportunities',
            name: 'Opportunities',
            component: Opportunities,
            meta: {title: 'Opportunities'}
        },

    ]
});

router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        // this route require  auth, check if logged in
        // if not, redirect to login page
        console.log(store.getters.isLoggedIn)
        if (!store.getters.isLoggedIn) {
            next({
                path: '/login'
            })
        } else {
            next();
        }
    } else {
        next(); // make sure to always call next();
    }
});

router.beforeEach((to, from, next) => {
    document.title = to.meta.title;
    next();
});


export default router;