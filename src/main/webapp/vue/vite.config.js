import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'  // 引入路径处理模块

// https://vite.dev/config/
export default defineConfig({
   base: './',
  plugins: [vue()],
  build: {
    // 配置打包输出路径（相对路径或绝对路径均可）
    // 注意：路径要根据你的实际目录结构调整！
    outDir: path.resolve(__dirname, '../static'),
    
   
    emptyOutDir: true,
    assetsDir: 'assets'
  }
})
