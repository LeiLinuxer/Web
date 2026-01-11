<template>
    <button class="左外边隙 Buttons 加入社区" type="button">{{msg}}</button>
    </template>
    <style>
.加入社区{
border:1px solid rgb(69, 87, 95);
background-color: #0A0A0A;
 width:150px;
}
</style>
<script setup>
    const prop=defineProps({
        msg:String
    })
</script>