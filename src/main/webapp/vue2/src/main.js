// src/main.js
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router' // 假设你已创建路由文件

const app = createApp(App)
app.use(createPinia())
app.use(router)
app.mount('#app')