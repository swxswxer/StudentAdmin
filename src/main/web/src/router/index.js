import VueRouter from "vue-router";
import Vue from "vue";

Vue.use(VueRouter)

const Login = () => import('components/LoginPage')
const HomePage = () => import('components/home/HomePage')
const StudentInfoPage = () => import('components/student/StudentInfo')
const CourseInfo = () => import('components/course/CourseInfo')


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
        component: HomePage,
        children: [
            {
                path: 'student_info',
                component: StudentInfoPage,
            },
            {
                path: 'course_info',
                component: CourseInfo,
            }
        ]
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
