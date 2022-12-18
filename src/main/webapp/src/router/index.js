import VueRouter from "vue-router";
import Vue from "vue";

Vue.use(VueRouter)

const Login = () => import('components/LoginPage')
const HomePage = () => import('components/home/HomePage')


const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        component: Login
    },
    {
        path: '/home',
        component: HomePage
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
