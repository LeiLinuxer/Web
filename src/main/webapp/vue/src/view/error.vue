<template>
  <div class="error-page">
    <div class="error-content">
      <h1>出错了</h1>
      <p>{{ errorMsg}}</p>
      <p>错误码:{{errorCode}}</p>
      <!-- 这里使用errorMsg获取,而不是errorMsg.value,因为这里errorMsg是string类型，它会被vue自动解包而下面那个是ref类形 -->
      <router-link to="/login">
        <button class="back-btn">返回登录</button>
      </router-link>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRoute } from 'vue-router';
const route = useRoute();
//获取正在使用的路由
const errorMsg = ref(route.params.errorMsg);
const errorCode = ref(route.params.errorCode);
//route.params.(参数名)获取传进来的路由参数
console.log(errorMsg.value);
console.log(errorCode.value);
</script>

<style scoped>
.error-page {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background: #f6f6f6;
}
.error-content {
  background: #fff;
  padding: 40px 60px;
  text-align: center;
  box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  border-radius: 8px;
}
.error-content h1 {
  color: #d93025;
  margin-bottom: 20px;
}
.error-content p {
  font-size: 16px;
  margin-bottom: 30px;
  color:gray;
}
.back-btn {
  background: #3eaf7c;
  color: #fff;
  border: none;
  padding: 8px 24px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}
.back-btn:hover {
  background: #359c6a;
}

@media (max-width: 640px) {
  .error-content {
    width: 90%;
    padding: 32px 24px;
    box-sizing: border-box;
  }
}
</style>
