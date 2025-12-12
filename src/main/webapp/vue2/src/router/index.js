import {createRouter,createWebHistory} from 'vue-router'
import index from '../view/home.vue'
import login from '../view/login.vue'
import about from '../view/about.vue'
import error from '../view/error.vue'
import success from '../view/success.vue'
const routes=[
    {
        path:'/',
        name:'index',
        component:index
    },
    {
        path:'/login',
        name:'login',
        component:login
    },
    {
        path:'/about',
        name:'about',
        component:about
    },
    {
        path:'/error/:errorCode/:errorMsg?',//可选参数需要加问号
        name:'error',
        component:error
    },
    {
        path:'/success/:user?',
        name:'success',
        component:success
    }
]

const router=createRouter({
    history:createWebHistory(),
    routes
})

export default router