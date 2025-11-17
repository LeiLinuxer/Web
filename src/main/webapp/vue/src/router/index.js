import {createRouter,createWebHistory} from 'vue-router'
import index from '../view/home.vue'
import login from '../view/login.vue'
import about from '../view/about.vue'

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
    }
]

const router=createRouter({
    history:createWebHistory(),
    routes
})

export default router