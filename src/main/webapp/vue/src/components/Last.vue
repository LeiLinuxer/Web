<script setup lang="ts">
import Background from './Background.vue';
import Darkbutton from './darkbutton.vue';
import Lightbutton from './lightbutton.vue';
import TransparentCard from './transparentCard.vue';
const color="--color-gray-lighter"
const message='立即注册';
const liaojiehuiyuanquanyi='了解会员权益';
const items=[
    {
        iconClass:'fa-solid fa-filter fa-lg',
        text:'操你妈'
    },
    {
        iconClass:'fa-solid fa-lightbulb fa-lg',
        text:'操你妈'
    },
    {
        iconClass:'fa-solid fa-lightbulb fa-lg',
        text:'操你妈'
    },
    {
        iconClass:'fa-solid fa-lightbulb fa-lg',
        text:'操你妈'
    }
]
</script>

<template>
    <Background :color="color">
        <div class="main">
            <div class="右大区大字">加入 NOCTIS 暗黑美学社区</div>
            <div class="小字">注册成为会员，获取独家内容、参与社区活动、优先体验限量单品，开启你的暗黑美学之旅</div>
            <div class="button_group">
                <Lightbutton :msg="message"></Lightbutton>
                <Darkbutton :msg="liaojiehuiyuanquanyi"></Darkbutton>
            </div>
            <div class="cardgroup" >
                <TransparentCard v-for="(item,index) in items":key="index":item="item"></TransparentCard>
            </div>
        </div>
    </Background>
</template>    
<style scoped>
.button_group{
    display:flex;
    gap:20px;
}
.main{
    background:linear-gradient(to bottom right ,var(--color-neon-darker) 30%,var(--color-neon-green-darker));
    display: flex;
    flex-direction: column;
    align-items: center;
    padding:80px 60px;
    height:300px;
    border-radius: 20px;
    gap:30px;
    
}
.小字{
    text-wrap: wrap;
      font-size:var(--大字号);
      color:rgb(193, 193, 194);

}
.cardgroup{
    display: flex;
    flex-direction: row;
    gap:20px;
    width:100%;
}
</style>