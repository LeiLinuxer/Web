<template>
    <div class="body" ref="bodyref">
        <slot></slot>
    </div>
</template>
<style scoped>
.body{
    display:flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    gap:30px;
    box-sizing: border-box;
    background-color: var(--color);
    padding-bottom:80px;
    padding-top:80px;
    padding-left:var(--All-left-margin);
    padding-right:var(--All-right-margin);
    width: 100%;
 }
</style>
<script setup>
import {ref,onMounted}from 'vue'
const prop=defineProps({
    color:{
        type:String,
        default:''
    }
})
const bodyref=ref(null);
onMounted(()=>{
    
    bodyref.value.style.setProperty('--color', `var(${prop.color})`);
})
</script>