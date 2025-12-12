// vite.config.js
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { AntDesignVueResolver } from 'unplugin-vue-components/resolvers'

export default defineConfig({
    plugins: [
        vue(),
        // 自动导入 Vue 相关 API
        AutoImport({
            resolvers: [AntDesignVueResolver()],
        }),
        // 自动导入 Ant Design Vue 组件
        Components({
            resolvers: [AntDesignVueResolver()],
        }),
    ],
    // 解决 Capacitor 打包时的路径问题（重要）
    base: './',
})