<template><!-- html -->
  
  <nav class="navbar">
    <span class="logo">Native</span>

    <span id="middletag">
      <span id="uptag" v-for="(item,index) in list":key="index">

        <a id="texttag"href="#"@click="handleClick(item)">{{ item }}</a>

      </span>
    </span>

  </nav>
</template>

<script setup>// javascript
const menulist=defineProps({
  list:Array

});

 const handleClick=(menuName)=>{//定义点击函数
 console.log('触发点击函数');
  }

 
</script>


<style scoped>/* css */

.navbar{
  display: flex;      /* 开启 Flex 布局 */
  align-items: center;
  justify-content: center;
  background-color: black;
  position:fixed;
  height:80px;
  width: 100%;
  z-index: 999;
}
.navbar>.logo{
  font-family: '微软雅黑';
position:absolute;
  left:180px;
  z-index: 1000;
  color:white;
  font-size:20px;
  font-weight: 400;
}
#uptag{
  margin-right: 10px;
}

#texttag{
  color:rgb(146, 146, 146);
  text-decoration: none;
}
</style>