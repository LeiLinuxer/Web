<template>
  <div class="success-page">
    <div class="success-content">
      <h1>登录成功！</h1>
      <p>欢迎回来，祝您使用愉快。</p>
      <p>{{ user.username }}</p>
      <p>{{ user.realName }}</p>
      <p>{{ user.age }}</p>
      <router-link to="/home">
        <button class="home-btn">进入首页</button>
      </router-link>
    </div>
  </div>
</template>

<script setup>
import { ref, } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const user = ref(null)//响应式对象


user.value = JSON.parse(route.params.user);//要把字符串转换为对象才能使用，才能访问属性值
</script>

<style scoped>
.success-page {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background: #f6fff6;
}
.success-content {
  background: #fff;
  padding: 40px 60px;
  text-align: center;
  box-shadow: 0 2px 8px rgba(34,197,94,0.15);
  border-radius: 8px;
}
.success-content h1 {
  color: #22c55e;
  margin-bottom: 20px;
}
.success-content p {
  font-size: 16px;
  margin-bottom: 16px;
  color: #333;
}
.user-info {
  text-align: left;
  margin: 0 auto 24px auto;
  display: inline-block;
  background: #f0fdf4;
  border-radius: 6px;
  padding: 12px 20px;
  color: #166534;
  font-size: 15px;
  box-shadow: 0 1px 3px rgba(22,101,52,0.08);
}
.home-btn {
  background: #22c55e;
  color: #fff;
  border: none;
  padding: 8px 24px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  transition: background .2s;
}
.home-btn:hover {
  background: #16a34a;
}

@media (max-width: 640px) {
  .success-content {
    width: 90%;
    padding: 32px 24px;
    box-sizing: border-box;
  }
}
</style>

