<template><!-- html -->
  
  <nav class="navbar">
    <span class="logo">{{Title}}</span>

    <span id="middletag" ref="tagWrap">
      <span id="uptag" v-for="(item,index) in list":key="index">

        <a class="texttag greyTag"href="#"@click="handleClick(item,index)">{{ item }}</a>

      </span>
    </span>

  </nav>
</template>

<script setup>// javascript

import {onMounted,ref} from "vue";

const menulist=defineProps({
  list:Array,
  Title:String
});
const tagWrap = ref(null)
onMounted(()=>{
  const shouye=tagWrap.value.querySelectorAll(".greyTag").item(0)

  shouye.classList.remove("greyTag");
  shouye.classList.add("whiterTag");
})


 const handleClick=(menuName,index)=>{//定义点击函数
   const items=tagWrap.value.getElementsByClassName("texttag");
   const currentitem=tagWrap.value.getElementsByClassName("whiterTag").item(0);
   console.log(currentitem);
   currentitem.classList.remove("whiterTag");
   currentitem.classList.add("greyTag");
   console.log(items.item(index));
   items.item(index).classList.remove("greyTag");
   items.item(index).classList.add("whiterTag");//给现在点中的添加
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

.texttag{

  text-decoration: none;
}
.whiterTag{
  color: rgb(255, 255, 255);
}
.greyTag{
  color:rgb(146, 146, 146);
}
.greyTag:hover{
  color: rgb(175, 175, 175);
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