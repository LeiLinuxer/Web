<template>
    <div class="上提示">{{ msg }}</div>
</template>
<script setup>
const dick=defineProps({msg:String})
</script>
<style scoped>
.上提示{
    
    padding:var(--junior-title-padding);
    width: max-content;
    border-radius: 20px;
    font-family: var(--font-family);
    font-size:var(--junior-title-size);
    font-weight:900;
    color:var(--color-neon);
}</style>