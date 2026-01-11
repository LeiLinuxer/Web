<template>
<div class="wraper">
    <Basecard :item="item" :layoutType="layout"
            
            customclass1="图标下标题3" 
            customclass2="图标下小字3" 
            >
    </Basecard>
</div>
            </template>
<style>
.图标下标题3{
    font-style:italic;
    font-size: clamp(20px, 1vw, 30px);
    flex: 1;
    white-space: normal; /* 默认值，允许换行 */
  word-break: break-word; /* 长单词/句子自动换行 */
    color: #a7a7a7;
}
.图标下小字3{
    color: #fff;
    font-weight: 900;
    margin-top:20px;
    text-align:right;
}
.wraper{
    padding-top:40px;
    padding-bottom:30px;
    padding-left:40px;
    padding-right:40px;
    border-radius: 20px;
    border:1px solid var(--color-light-darker);
    background-color: black;
    width:800px;
    
}
</style>
<script setup>
    
import title from '../script/globalvar';
import Basecard from './basecard.vue';
    const item={
        title:"\"暗黑美学不是对光明的否定，而是对深度的探索。它拒绝浮于表面的鲜亮，选择在沉静中沉淀质感；不追求瞬间的视觉冲击，而在意长久的情感共鸣。\"",
        description:`—— ${title} 美学团队`,
        iconClass:"fa-solid fa-book-bookmark"
    }
    const layout='quote';
</script>