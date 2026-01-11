<template>
    <div class="blackframe">
        <i 
            :class="item.iconClass || 'fa-solid fa-filter fa-lg'" 
            style="color: #7a45f5;"
            ></i>
        <div>{{ item.text}}</div>
    </div>
</template>    
<style scoped>
.blackframe{
        height: 76px;
    border-radius: 20px;
    background-color: rgba(26, 26, 26, 0.658);
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 32px;
    padding-top: 32px;
    flex: 1 1 0;
    -webkit-backdrop-filter: blur(10px);
backdrop-filter: blur(10px);
border:1px solid rgb(0, 52, 82);
}
i{
    
}
</style>
<script setup>
    const props=defineProps({
        item:{
            type:Object,
            default:{
                
                title: '理念先行',
                description: '商品是理念的载体，而非目的',
                iconClass: 'fa-solid fa-filter fa-lg'
            }
            
        }
    })

</script>