
const registerForm = document.getElementById('registerForm');
const usernameInput = document.getElementById('username'); // 账户名输入框
const realNameInput = document.getElementById('realname'); // 真实姓名输入框
const ageInput = document.getElementById('age'); // 年龄输入框
const usernameError = document.getElementById('usernameError'); // 账户名错误提示
const realnameError = document.getElementById('realnameError'); // 账户名错误提示
const ageError = document.getElementById('ageError'); // 账户名错误提示
const SignInForm=document.getElementById('SignInForm')
const successMessage = document.getElementById('SignInForm');
const passwordInput=document.getElementById('password'); 
const passwordBeCorrect=document.getElementById('确认密码');
const pCinput=document.getElementById('passwordcorrect');
const passwordError=document.getElementById('passwordError');
const passwordNoInput=document.getElementById('passwordNoInput');
const password2input=document.getElementById('password2');
const username2input=document.getElementById('username2');
const username2Error=document.getElementById('username2Error');
const password2Error=document.getElementById('password2Error');
const moment = require('moment');
const formattedTime = moment().format('YYYYMMDDHHmmss');
let isValid1 = true;
let isValid2=true;
const isEmpty = (passwordError) => {
  // null/undefined
  if (passwordError === null || passwordError === undefined) return true;
  // 其他类型（数字、布尔值等）
  return false;
};
console.log(isEmpty(passwordError));
registerForm.addEventListener('submit', async (e) => {//submit:事件类型 提交
    e.preventDefault(); // 阻止表单默认提交行为（关键：避免页面刷新）
   isValid1 = true; // 标记验证是否通过
    console.log('slkfj');
    // 1. 验证账户名（不能为空）
    if (!usernameInput.value.trim()) {
        showError(usernameError, '账户名不能为空'); // 显示错误提示
        isValid1 = false; // 验证失败
    } else {
        hideError(usernameError); // 隐藏错误提示
    }
    if(!passwordInput.value.trim()){
      isValid1=false;
      showError(passwordNoInput,"密码未输入");
    }
    // 后续步骤的代码会写在这里
    if (!realNameInput.value.trim()) {
        isValid1 = false;
        showError(realnameError, '真实姓名不能为空'); // 显示错误提示

      }
      
      // 3. 验证年龄（如果填写了，必须在0-120之间）
      if (ageInput.value.trim() && (ageInput.value < 0 || ageInput.value > 120)) {
        showError(ageError,'年龄数值范围错误');
        isValid1 = false;
      }
      if (!isValid1) {
        return;
      }
      const formData = {
        username: usernameInput.value.trim(),
        realName: realNameInput.value.trim(),
        password: passwordInput.value.trim(),
        age: ageInput.value.trim()
      };
      
      // 2. 转换为URLSearchParams（自动对应application/x-www-form-urlencoded格式）
      const searchParams = new URLSearchParams();
      for (const [key, value] of Object.entries(formData)) {
        searchParams.append(key, value);
      }
      
      
      
      try {
        // 3. 发送请求（不指定Content-Type，浏览器会自动设置正确格式）
      const response = await fetch('/RegisterServlet', {
        method: 'POST',
        body: searchParams // 用URLSearchParams替代FormData
      });
        const result = await response.text();

        // 步骤5：处理后端响应
        if (result === 'success') {
            console.log('注册成功');
        } else if (result === 'username_exists') {
            // 账户名已存在
            showError(usernameError, '该账户名已被注册，请更换');
        } else {
            // 其他错误
            console.log(result);
            alert('注册失败，请稍后重试');
        }
    } catch (error) {
        // 网络错误
        console.error('注册请求失败：', error);
        alert('网络连接失败，请检查服务器是否启动');
    }

    });
    usernameInput.addEventListener('input', () => {
      hideError(usernameError);
    });
    realNameInput.addEventListener('input', () => {
      hideError(realnameError);
    });
    ageInput.addEventListener('input', () => {
      hideError(ageError);
    });
    passwordInput.addEventListener('input',()=>{
      hideError(passwordNoInput);
    })
  passwordInput.addEventListener('input',()=>{
  passwordBeCorrect.classList.remove('账户名错误隐示');
    
  })
  passwordBeCorrect.addEventListener('focusout',()=>{
    console.log('fu');
    if(pCinput.value.trim()!=passwordInput.value.trim()){
      showError(passwordError,'两次输入密码不一致');
      isValid1=false;
    }
  });
  passwordBeCorrect.addEventListener('input',()=>{
    hideError(passwordError);
  })
SignInForm.addEventListener('submit',async(e)=>{
  
  e.preventDefault();
  console.log(`已提交，当前时间${formattedTime}`);
  if(!username2input.value.trim()){
    showError(username2Error,'请填写账户名');
    isValid2=false;
  }
  if(!password2input.value.trim()){
    showError(password2Error,'请填写密码');
    isValid2=false;
  }
  if(!isValid2){
    return;
  }
  const formData2 = {
    username: username2input.value.trim(),
    password: password2input.value.trim(),
  };
  
  // 2. 转换为URLSearchParams（自动对应application/x-www-form-urlencoded格式）
  const searchParams2 = new URLSearchParams();
  for (const [key, value] of Object.entries(formData2)) {
    searchParams2.append(key, value);
  }
  console.log(searchParams2.get('username'));
  console.log(searchParams2.get('password'))
  axios.post('/SignServlet', searchParams2)
  .then(response => {
    if(response.data=='invalid_credentials'){
      showError(invalid_credentials,'账户名或密码错误');
    
    }
    else if(response.data=='error'){
      window.location.href='error.html';
    }
    else{
      console.log(`收到！，当前时间${formattedTime}`);
      console.log(response.data);
      console.log('ok');
    }
  })
  .catch(error => {
    console.log(error);
  });
  
})
username2input.addEventListener('input',()=>{
  hideError(username2Error);
})
password2input.addEventListener('input',()=>{
  hideError(password2Error);
})
  登录tab.addEventListener('click',()=>{
    registerForm.style.display='none';
   SignInForm.style.display='block';
   注册tab.classList.remove('active');
   注册tab.classList.add('inactive');
   登录tab.classList.remove('inactive');
   登录tab.classList.add('active');


  }) 
  注册tab.addEventListener('click',()=>{
    SignInForm.style.display='none';
   registerForm.style.display='block';
   注册tab.classList.remove('inactive');
   注册tab.classList.add('active');
   登录tab.classList.remove('active');
   登录tab.classList.add('inactive');
  }) 
  function showError(errorElement, message) {
    errorElement.className="账户名错误显示";
    errorElement.querySelector('span').textContent = message;
    errorElement.querySelector('span').classList.add('text-danger');

    errorElement.closest('div').querySelector('input').classList.add('border-danger');

  }
  
  // 隐藏错误提示
  function hideError(errorElement) {
    errorElement.className="账户名错误隐示";
    errorElement.closest('div').querySelector('input').classList.remove('border-danger');
  }