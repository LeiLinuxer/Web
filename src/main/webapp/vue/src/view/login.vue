<template>
  <div class="背景">
    <div class="主盒的父">
      <div class="主盒">
        <div class="主盒头部">
          <!-- 用@click绑定切换事件，替代getElementById+addEventListener -->
          <button 
            id="注册tab" 
            class="标题" 
            :class="{ active: isRegisterActive, inactive: !isRegisterActive }"
            @click="switchToRegister"
          ><!-- :class的作用，绑定class,根据isRegisterActive的值动态赋class值 -->
            注册
          </button>
          <button 
            id="登录tab" 
            class="标题" 
            :class="{ active: !isRegisterActive, inactive: isRegisterActive }"
            @click="switchToLogin"
          >
            登录
          </button>
        </div>

        <!-- 注册表单：用v-if控制显示，@submit.prevent阻止默认提交 -->
        <form 
          id="registerForm" 
          class="注册表体" 
          @submit.prevent="handleRegister"
          v-if="isRegisterActive"
        >
          <div class="主盒主体">
            <!-- 账户名 -->
            <div class="用户名整体框">
              <label for="username" class="信息标题">账户名</label>
              <span class="星号">*</span>
              <div>
                <!-- 用v-model双向绑定输入值 -->
                <input 
                  type="text" 
                  id="username" 
                  v-model="registerForm.username"
                  class="信息输入框"
                  placeholder="请设置注册账户名"
                  @input="clearRegisterError('username')"
                >
              </div>
              <!-- 用v-if控制错误提示显示 -->
              <p 
                class="账户名错误显示" 
                v-if="registerErrors.username.show"
              >
                <span class="text-danger">{{ registerErrors.username.msg }}</span>
              </p>
            </div>

            <!-- 真实姓名 -->
            <div class="用户名整体框">
              <label for="realname" class="信息标题">真实姓名</label>
              <span class="星号">*</span>
              <div>
                <input 
                  type="text" 
                  id="realname" 
                  v-model="registerForm.realname"
                  class="信息输入框"
                  placeholder="输入你的真实姓名"
                  @input="clearRegisterError('realname')"
                >
              </div>
              <p 
                class="账户名错误显示" 
                v-if="registerErrors.realname.show"
              >
                <span class="text-danger">{{ registerErrors.realname.msg }}</span>
              </p>
            </div>

            <!-- 密码 -->
            <div class="用户名整体框">
              <label for="password" class="信息标题">密码</label>
              <span class="星号">*</span>
              <div>
                <input 
                  type="password" 
                  id="password" 
                  v-model="registerForm.password"
                  class="信息输入框"
                  placeholder="请输入你的密码"
                  @input="clearRegisterError('password')"
                >
              </div>
              <p 
                class="账户名错误显示" 
                v-if="registerErrors.password.show"
              >
                <span class="text-danger">{{ registerErrors.password.msg }}</span>
              </p>
            </div>

            <!-- 确认密码 -->
            <div class="用户名整体框">
              <label for="passwordcorrect" class="信息标题">确认密码</label>
              <span class="星号">*</span>
              <div>
                <input 
                  type="password" 
                  id="passwordcorrect" 
                  v-model="registerForm.confirmPassword"
                  class="信息输入框"
                  placeholder="请确认你的密码"
                  @input="clearRegisterError('confirmPassword')"
                >
              </div>
              <p 
                class="账户名错误显示" 
                v-if="registerErrors.confirmPassword.show"
              >
                <span class="text-danger">{{ registerErrors.confirmPassword.msg }}</span>
              </p>
            </div>

            <!-- 年龄 -->
            <div class="用户名整体框">
              <label for="age" class="信息标题">年龄</label>
              <div>
                <input 
                  type="number" 
                  id="age" 
                  v-model="registerForm.age"
                  class="信息输入框"
                  placeholder="请输入你的年龄(选填)"
                  @input="clearRegisterError('age')"
                >
              </div>
              <p 
                class="账户名错误显示" 
                v-if="registerErrors.age.show"
              >
                <span class="text-danger">{{ registerErrors.age.msg }}</span>
              </p>
            </div>

            <div class="提交按钮">
              <button type="submit" class="提交">提交</button>
            </div>
          </div>
        </form>

        <!-- 登录表单：同理用v-if和v-model -->
        <form 
          id="SignInForm" 
          class="注册表体" 
          @submit.prevent="handleLogin"
          v-if="!isRegisterActive"
        >
          <div class="主盒主体">
            <!-- 登录账户名 -->
            <div class="用户名整体框">
              <label for="username2" class="信息标题">账户名</label>
              <span class="星号">*</span>
              <div>
                <input 
                  type="text" 
                  id="username2" 
                  v-model="loginForm.username"
                  class="信息输入框"
                  placeholder="请输入账户名"
                  @input="clearLoginError('username')"
                >
              </div>
              <p 
                class="账户名错误显示" 
                v-if="loginErrors.username.show"
              >
                <span class="text-danger">{{ loginErrors.username.msg }}</span>
              </p>
            </div>

            <!-- 登录密码 -->
            <div class="用户名整体框">
              <label for="password2" class="信息标题">密码</label>
              <span class="星号">*</span>
              <div>
                <input 
                  type="password" 
                  id="password2" 
                  v-model="loginForm.password"
                  class="信息输入框"
                  placeholder="请输入你的密码"
                  @input="clearLoginError('password')"
                >
              </div>
              <p 
                class="账户名错误显示" 
                v-if="loginErrors.password.show"
              >
                <span class="text-danger">{{ loginErrors.password.msg }}</span>
              </p>
            </div>

            <!-- 记住我 -->
            <div class="用户名整体框">
              <input type="checkbox" id="复选框" v-model="loginForm.remember">
              <span class="信息标题">记住我</span>
              
              <!-- 登录失败提示 -->
              <p 
                class="账户名错误显示" 
                v-if="loginErrors.credentials.show"
              >
                <span class="text-danger">{{ loginErrors.credentials.msg }}</span>
              </p>

              <div class="提交按钮">
                <button type="submit" class="提交">提交</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from "axios";
axios.defaults.baseURL = '/api'
// 响应式变量：控制注册/登录表单切换
const isRegisterActive = ref(true); // true显示注册，false显示登录

// 响应式变量：注册表单数据
const registerForm = ref({
  username: '',
  realname: '',
  password: '',
  confirmPassword: '',
  age: ''
});

// 响应式变量：注册表单错误信息
const registerErrors = ref({
  username: { show: false, msg: '' },
  realname: { show: false, msg: '' },
  password: { show: false, msg: '' },
  confirmPassword: { show: false, msg: '' },
  age: { show: false, msg: '' }
});

// 响应式变量：登录表单数据
const loginForm = ref({
  username: '',
  password: '',
  remember: false
});

// 响应式变量：登录表单错误信息
const loginErrors = ref({
  username: { show: false, msg: '' },
  password: { show: false, msg: '' },
  credentials: { show: false, msg: '' } // 账户密码错误提示
});

// 切换到注册表单
const switchToRegister = () => {
  isRegisterActive.value = true;
};

// 切换到登录表单
const switchToLogin = () => {
  isRegisterActive.value = false;
};

// 清除注册表单指定字段的错误
const clearRegisterError = (field) => {
  registerErrors.value[field].show = false;
  registerErrors.value[field].msg = '';
};

// 清除登录表单指定字段的错误
const clearLoginError = (field) => {
  loginErrors.value[field].show = false;
  loginErrors.value[field].msg = '';
};

// 处理注册表单提交
const handleRegister = async () => {
  let isValid = true;

  // 验证账户名
  if (!registerForm.value.username.trim()) {
    registerErrors.value.username = { show: true, msg: '账户名不能为空' };
    isValid = false;
  }

  // 验证真实姓名
  if (!registerForm.value.realname.trim()) {
    registerErrors.value.realname = { show: true, msg: '真实姓名不能为空' };
    isValid = false;
  }

  // 验证密码
  if (!registerForm.value.password.trim()) {
    registerErrors.value.password = { show: true, msg: '密码未输入' };
    isValid = false;
  }

  // 验证确认密码
  if (registerForm.value.confirmPassword.trim() !== registerForm.value.password.trim()) {
    registerErrors.value.confirmPassword = { show: true, msg: '两次输入密码不一致' };
    isValid = false;
  }

  // 验证年龄（如果填写）
  if (registerForm.value.age && (registerForm.value.age < 0 || registerForm.value.age > 120)) {
    registerErrors.value.age = { show: true, msg: '年龄数值范围错误（0-120）' };
    isValid = false;
  }

  // 验证不通过则终止
  if (!isValid) return;

  try {
    // 准备表单数据（application/x-www-form-urlencoded格式）
    const formData = new URLSearchParams();
    formData.append('username', registerForm.value.username.trim());
    formData.append('realName', registerForm.value.realname.trim());
    formData.append('password', registerForm.value.password.trim());
    formData.append('age', registerForm.value.age || '');

    // 发送注册请求
    const response = await fetch('/RegisterServlet', {
      method: 'POST',
      body: formData
    });
    const result = await response.text();

    if (result === 'success') {
      alert('注册成功！');
      // 注册成功后切换到登录表单
      switchToLogin();
    } else if (result === 'username_exists') {
      registerErrors.value.username = { show: true, msg: '该账户名已被注册，请更换' };
    } else {
      alert('注册失败，请稍后重试');
    }
  } catch (error) {
    console.error('注册请求失败：', error);
    alert('网络连接失败，请检查服务器');
  }
};

// 处理登录表单提交
const handleLogin = async () => {
  let isValid = true;

  // 验证登录账户名
  if (!loginForm.value.username.trim()) {
    loginErrors.value.username = { show: true, msg: '请填写账户名' };
    isValid = false;
  }

  // 验证登录密码
  if (!loginForm.value.password.trim()) {
    loginErrors.value.password = { show: true, msg: '请填写密码' };
    isValid = false;
  }

  // 验证不通过则终止
  if (!isValid) return;

  try {
    // 准备登录数据
    const formData = new URLSearchParams();
    formData.append('username', loginForm.value.username.trim());
    formData.append('password', loginForm.value.password.trim());

    // 发送登录请求
    const response = await axios.post('/SignServlet', formData);
    
    if (response.data === 'invalid_credentials') {
      loginErrors.value.credentials = { show: true, msg: '账户名或密码错误' };
    } else if (response.data === 'error') {
      window.location.href = 'error.html';
    } else {
      window.location.href = 'success.html';
    }
  } catch (error) {
    console.error('登录请求失败：', error);
    alert('网络连接失败，请检查服务器');
  }
};
</script>

<style>
/* 保留原CSS样式，仅调整错误提示默认显示状态 */
:root {
  --color-dark: #121212;
  --color-darker: #0A0A0A;
  --color-neon: #8B5CF6;
  --color-neon-green: #10B981;
  --color-gray-cool: #374151;
  --color-gray-light: #9CA3AF;
  --spacing-sm: 8px;
  --spacing-md: 16px;
  --spacing-lg: 24px;
  --spacing-xl: 32px;
  --border-radius: 8px;
  --border-radius-lg: 16px;
}

.背景 {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: var(--color-dark);
}

.主盒的父 {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.主盒 {
  border: 1px solid rgba(55, 65, 81, 0.3);
  height: auto;
  width: auto;
  border-radius: 15px;
  background-color: var(--color-darker);
  box-shadow: 0px 0px 15px 5px rgba(0, 0, 0, 0.2);
  margin-right: 100px;
  margin-left: auto;
  padding: 30px;
}

.主盒头部 {
  background-color: transparent;
  width: auto;
  height: auto;
  margin-bottom: 20px;
}

.标题 {
  background: none;
  border: none;
  border-bottom: 2px solid transparent;
  padding: 8px 0;
  margin-right: 32px;
  font-size: 23px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
}

.标题.active {
  color: white;
  border-bottom-color: var(--color-neon);
}

.标题.inactive {
  color: var(--color-gray-light);
}

.标题:hover {
  color: white;
}

.主盒主体 {
  background-color: transparent;
}

.信息标题 {
  font-size: 15px;
  color: var(--color-gray-light);
}

.信息输入框 {
  margin-top: 10px;
  width: 280px;
  max-width: 280px;
  height: 20px;
  padding: 10px;
  border: 1px solid var(--color-gray-cool);
  border-radius: 5px;
  padding-left: 20px;
  background-color: transparent;
  color: var(--color-gray-light);
}

.信息输入框:focus {
  color: var(--color-neon);
  outline-color: var(--color-neon);
  box-shadow: 0px 0px 10px var(--color-neon);
  transition: box-shadow 0.5s;
}

.信息输入框::placeholder {
  font-size: 16px;
}

.星号 {
  color:dimgray;
}

.用户名整体框 {
  margin-top: 10px;
}

.提交按钮 {
  width: 315px;
  position: relative;
  margin-top: 22px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.提交 {
  border-radius: 10px;
  background: linear-gradient(90deg, var(--color-neon), var(--color-neon-green));
  color: white;
  font-size: 17px;
  width: 355px;
  height: 45px;
  font-weight: bold;
  border: none;
}

.提交:hover {
  box-shadow: -7px 0px 20px rgba(139, 92, 246, 0.7), 7px 0px 20px rgba(4, 255, 100, 0.5);
  transition: box-shadow 0.2s;
}

/* 错误提示样式：默认隐藏，通过v-if控制显示 */
.账户名错误显示 {
  margin-top: 5px;
  margin-bottom: 0;
}

.text-danger {
  color: red;
  font-size: 15px;
}
</style>