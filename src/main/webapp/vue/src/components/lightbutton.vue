<template>
    <button  class="了解更多 Buttons" type="button">{{ msg }}</button>
</template>    
<style >
.了解更多{
    background:linear-gradient(50deg,var(--color-neon),var(--color-neon-green));
    border-style:hidden;
    width: 120px;
    background-color: var(--color-neon);
    transition: all 0.5s ease-in-out;
}
.了解更多:hover{
    box-shadow: -4px 4px 20px 0px #300495;
    transition: box-shadow 0.2s ease-in-out;
}
</style>
<script setup>
const props=defineProps({
    msg:String
})
</script>