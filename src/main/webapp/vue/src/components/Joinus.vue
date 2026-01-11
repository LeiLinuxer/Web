<template>
    <Background >
        <tip  class="tipbackcolor1":msg="msg" ></tip>
        <div class="右大区大字">加入我们的暗黑爱好者社群</div>
        <div class="右大区中部小字">这里不只是购物平台，更是理念相通者的聚集地</div>
        <div class="group">
            <div class="image"><img src="../assets/picture09.jpg"></img></div>
            <div class="cardgroup"><Largeshow :layout-type="layout" :items="items" blockstyle="block2"></Largeshow></div>
        </div>
    </Background>
</template>
<script setup>
import tip from '../components/tips.vue';
import Background from './Background.vue';
import Largeshow from './largeshow.vue';
import Longshow from './longshow.vue';

const msg="用户社区";
const layout="quote";
const items=[
    {
        title: '理念筛选',
        description: '每件商品都经过理念审核，确保与暗黑美学精神一致，拒绝为了商业而妥协的平庸设计。',
        iconClass: 'fa-solid fa-filter fa-lg'
    },
    {
        title: '创作者社区',
        description: '我们为独立设计师提供展示平台，定期举办线上分享会，让用户与创作者直接对话。',
        iconClass: 'fa-solid fa-lightbulb fa-lg'
    },
    {
        title: '文化内容',
        description: '不止于购物，我们生产深度内容：暗黑美学解析、设计师访谈、风格搭配指南等。',
        iconClass: 'fa-solid fa-lightbulb fa-lg'
    }
]
</script>
<style >
.block2{
    position: relative;
    
    background-color: var(--color-gray-lighter);
    border-radius:20px;
    padding:20px;
    
    display: flex;
    flex:1 1 0;
    flex-direction: column;
    justify-content: flex-start;
    gap: var(--小间隙);
    
    border:1px solid var(--color-light-darker);
    transition-duration: 0.5s;
    transition-property: border;
    transition-timing-function: ease-in-out;
    
}
.block2::before {
    content: '';
    position:absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    border-radius: 20px;
    padding: 3px;
    /* 光源宽度 */
    
    background: radial-gradient(
        circle at var(--mouse-x) var(--mouse-y),
        rgba(122, 69, 245, var(--glow-intensity, 0.9)) 0%,     
        rgba(47, 24, 99, calc(var(--glow-intensity, 0.9) * 0.4)) 20%,     
        rgba(15, 23, 42, 0.1) 30%        
    );
    
    -webkit-mask: 
        linear-gradient(#fff 0 0) content-box,
        linear-gradient(#fff 0 0);
    -webkit-mask-composite: xor;
    mask-composite: exclude;
    
    opacity: 1; /* 始终显示 */
    z-index: 0;
    
    transition: background 0.1s ease;
    
    /* 根据强度调整模糊效果 */
    filter: blur(calc(1px + (1 - var(--glow-intensity, 1)) * 2px)) 
            brightness(calc(0.8 + 0.4 * var(--glow-intensity, 1)));
}

.block2:hover{
    border:1px solid var(--color-neon);
    transition-duration: 0.5s;
    transition-property: border;
    transition-timing-function: ease-in-out;
}
.group{
    display:flex;
    align-items: center;
    justify-content: center;
    gap:30px;
}

</style>
<style scoped>
.cardgroup{
    display:flex;
    flex-direction: column;
    gap:20px;
    height:400px;
}
.image{
    width:600px;
    height:600px;
}</style>