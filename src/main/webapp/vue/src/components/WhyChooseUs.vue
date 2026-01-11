<template>
    <div class="main">
        <tips :msg="whychooseus" class="tipbackcolor1"></tips>
        <div class="右大区大字">{{ Title }}的独特之处</div>
        <div class="右大区中部小字">我们不只提供商品，更构建了一个属于暗黑美学爱好者的生态</div>
        <div class="他妈的父级我操你妈逼的 上外边隙" >
            <div class="cardgroup " >
            <largeshow :items="items"></largeshow>
            
            </div>
        </div>    
        
    </div>
</template>   
<script setup>
import tips from './tips.vue';
import Title from '../script/globalvar';
import largeshow from './largeshow.vue';
import cat from '../components/cat.vue';

const whychooseus='为什么选择我们';
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
    },
    {
        title: '专属体验',
        description: '会员可参与限量单品预售、线下展览预览，享受专属定制服务，深度融入暗黑文化圈。',
        iconClass: 'fa-solid fa-lightbulb fa-lg'
    },
    {
        title: '持续理念',
        description: '优先选择环保材料与 ethical 生产方式，拒绝快时尚浪费，让暗黑美学与可持续并行。',
        iconClass: 'fa-solid fa-lightbulb fa-lg'
    },
    {
        title: '风格诊断',
        description: '独特的风格测试工具，帮助你找到最适合自己的暗黑表达，避免盲目跟风。',
        iconClass: 'fa-solid fa-lightbulb fa-lg'
    }
]
</script> 
<style scoped>
.main{
    display:flex;
    flex-direction: column;
    gap:20px;
    align-items: center;
    /* 垂直居中,默认横向排列，所以交叉轴是竖直的 */
    justify-content: center;
    /* 水平居中,默认横向排列，所以主轴是水平的 */
    width:100%;
    box-sizing: border-box;
    padding-top:80px;
    padding-bottom: 80px;
    padding-left: var(--All-left-margin);
    padding-right:var(--All-right-margin);
}
.cardgroup{
    display:flex;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
    gap:30px;
    width:100%;
    
}
.他妈的父级我操你妈逼的{
    
    width:100%;
    display:flex;
    align-items: center;
    justify-content: center;
}
@media( max-width:1024px){
    .右大区大字{
        font-size: clamp(28px, 6vw, 40px);
        text-align: center;
    }
    .右大区中部小字{
        line-height: 1.8;
        text-align: center;
        padding:6px 0px;
    }

}
</style>