<template>
  <Navbar :list="menulist" :Title="title"></Navbar>
  <router-view></router-view>
</template>

<script setup>
import Navbar from "./components/daohanglan.vue"
import Title from "./script/globalvar.js"

const menulist = ['品牌首页', '商品主页', '关于我们', '平台特色', '精选商品']
const title = Title
</script>