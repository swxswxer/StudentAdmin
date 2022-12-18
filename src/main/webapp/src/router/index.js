import VueRouter from "vue-router";
import Vue from "vue";

Vue.use(VueRouter)



const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        component: () => import('components/LoginPage')
    },
    {
        path: '/home',
        component: () => import('components/home/HomePage')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
