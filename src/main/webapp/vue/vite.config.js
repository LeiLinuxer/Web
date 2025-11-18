// Vite的配置文件，ES模块语法（必须用export default）
import { defineConfig } from 'vite'  // 导入Vite的定义配置工具
import vue from '@vitejs/plugin-vue'  // 导入Vue插件

// 导出配置对象
export default defineConfig({
  plugins: [vue()],  // 启用Vue插件（固定写法）
  
  // 1. 静态资源基础路径（对应打包后资源的引用路径）
  base: '/',  // 部署在Nginx根目录（http://localhost），必须用'/'
  
  // 2. 开发环境配置（解决开发时跨域）
  server: {
    proxy: {  // 代理规则：前端请求/api开头的路径，转发到后端
      '/api': {
        target: 'http://localhost:8080',  // 后端Spring Boot运行的地址
        changeOrigin: true,  // 允许跨域（固定为true）
        rewrite: (path) => path.replace(/^\/api/, '')  // 去掉路径中的/api前缀（Vite用rewrite，不是pathRewrite）
      }
    }
  },
  
  // 3. 打包配置（可选，默认即可）
  build: {
    outDir: 'dist'  // 打包后生成的文件夹名（默认就是dist，这里明确写出）
  }
})