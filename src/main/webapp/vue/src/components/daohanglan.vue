<template><!-- html -->
  
  <nav class="navbar">
    <span class="logo">{{Title}}</span>

    <span id="middletag">
      <span id="uptag" v-for="(item,index) in list":key="index">

        <a id="texttag"href="#"@click="handleClick(item)">{{ item }}</a>

      </span>
    </span>

  </nav>
</template>

<script setup>// javascript
const menulist=defineProps({
  list:Array,
  Title:String
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
  left:var(--All-left-margin);
  z-index: 1000;
  color:white;
  font-size:20px;
  font-weight: 900;
}
#uptag{
  margin-right: 10px;
}

#texttag{
  color:rgb(146, 146, 146);
  text-decoration: none;
}

@media (max-width: 960px) {
  .navbar{
    justify-content: flex-start;
    padding: 0 20px;
    height: 64px;
  }

  .navbar>.logo{
    position: static;
    
  }

  #middletag{
    display: none;
  }
}
</style>