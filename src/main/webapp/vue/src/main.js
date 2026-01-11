import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import './style/commonstyle.css'
import './style/globalstyle.css'
import '../fontawsome/css/all.css'
import router from './router'
createApp(App)
.use(router)
.mount('#app')
