<template>
    <Background :color="color">
        <tips :msg="msg" class="tipbackcolor2"></tips>
        <div class="右大区大字">我们理解的「暗黑」是什么</div>
        <div class="右大区中部小字">它不是简单的黑白灰，而是一种对深度、独立与质感的追求</div>
        <div class="ImageGroup 上外边隙">
            <div>
                <div>质感与肌理</div>
                <img src="../assets/picture05.jpg"></img>
            </div>
            <div>
                <div>质感与肌理</div>
                <img src="../assets/picture06.jpg"></img>
            </div>
            <div>
                <div>质感与肌理</div>
                <img src="../assets/picture07.jpg"></img>
            </div>
            <div>
                <div>质感与肌理</div>
                <img src="../assets/picture08.jpg"></img>
            </div>
        </div>
        <longshow></longshow>
    </Background>
    
</template>    
<script setup>
import tips from './tips.vue';
import longshow from './longshow.vue';
import Background from './Background.vue';
const msg="暗黑美学"
const color="--color-gray-lighter";
</script>
<style scoped>

 .ImageGroup{
    display: flex;
    flex:1 1 0;
    width: 100%;
    gap:20px;
 }
 .ImageGroup>div{
   height: 350px;
    position: relative;
    flex:1 1 0;
    
 }
 .ImageGroup>div>div{
    position: absolute;
    color:transparent;
    transition: all 1s ease; 
    bottom:10px;
    z-index: 100;
 }
 .ImageGroup>div:hover>div{
    position: absolute;
    bottom:10px;
    color:white;
    transition: all 1s ease; 
    z-index: 100;
 }
 .ImageGroup>div::after{
    position:absolute;
    content:'';
    top:0px;
    left:0px;
    bottom:0px;
    right:0px;
    height: 350px;
     background: linear-gradient(
    to bottom,
    rgba(255, 255, 255, 0) 0%,
    rgba(0, 0, 0, 0.418) 60%,
    rgb(0, 0, 0) 100%
  );
  opacity: 0; 
  transition: opacity 1s ease; 
  z-index: 1; 
  border-radius: 10px; 
 }
    .ImageGroup>div:hover::after {
    opacity: 1;
    }
 img{
    border-radius: 10px;
    height:100%;
    width: 100%;
    object-fit: cover;
    
}
</style>