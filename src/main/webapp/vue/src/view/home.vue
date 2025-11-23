<template>
  
    <Navbar :list="menulist" :Title="title"></Navbar>
    <HeroSection :bigtitle-list="bigttlst"></HeroSection>
    <SecondSection></SecondSection>
    <WhyChooseUs></WhyChooseUs>
     
    <router-link to="/about">关于我们</router-link>
    <router-link to="/login">登录</router-link>
</template>

<script setup>
import Navbar from '../components/daohanglan.vue'
import HeroSection from '../components/HeroSection.vue';
import SecondSection from '../components/SecondSection.vue';
import WhyChooseUs from '../components/WhyChooseUs.vue';

import { ref } from 'vue';
import Title from '../script/globalvar.js';
const menulist=['关于我们','平台特色','暗黑美学','用户社区','加入我们'];
const bigttlst=['暗黑美学的','探索与表达'];
const title=Title;
// 处理菜单点击


</script>
<style>

</style>