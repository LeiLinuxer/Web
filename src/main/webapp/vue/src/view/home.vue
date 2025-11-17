<template>
  
    <Navbar :list="menulist"></Navbar>
    <HeroSection :bigtitle-list="bigttlst"></HeroSection>
    <SecondSection></SecondSection>
    <router-link to="/about">关于我们</router-link>
    <router-link to="/login">登录</router-link>
</template>

<script setup>
import Navbar from '../components/daohanglan.vue'
import HeroSection from '../components/HeroSection.vue';
import SecondSection from '../components/SecondSection.vue';
import { ref } from 'vue';
const menulist=['关于我们','平台特色','暗黑美学','用户社区','加入我们'];
const bigttlst=['暗黑美学的','探索与表达'];
// 处理菜单点击
const handleMenu = (item) => {
  console.log('首页点击了菜单：', item.name)
}

// 处理按钮点击
const handleBtn = (btn) => {
  console.log('首页点击了按钮：', btn.text)
}

</script>
<style>

</style>