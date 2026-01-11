<template>
    <div v-if="layoutType === 'default'" class="bao">
        <div :class="customclass3||'colorblock'">
            <i class="icon"
            :class="item.iconClass || 'fa-solid fa-lightbulb fa-lg'" 
            style="color: #7a45f5;"
            ></i>
        </div>
        <div :class="customclass1|| '图标下标题d'" v-if="item.title">{{ item.title }}</div>
        <div :class="customclass2||'图标下小字d'" v-if="item.description">{{ item.description }}</div>
    </div>


    <div v-else-if="layoutType === 'quote'" class="quote-layout">
      <div class="quote-upper">
        <div :class="customclass3||'colorblock'">
            <i class="icon"
            :class="item.iconClass || 'fa-solid fa-lightbulb fa-lg'"
            style="color: #7a45f5;"
            ></i>
        </div>

        <div :class="customclass1|| '图标下标题d'" >{{ item.title }}</div>
      </div>
      <div :class="customclass2||'图标下小字d'">—— {{ item.description }}</div>
    </div>
</template>
<style>
.bao{
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    
    gap: var(--小间隙);
}
.colorblock {
    width: clamp(50px, 2.1vw, 48px);
    aspect-ratio: 1/1;
    background-color: var(--color-neon-darker);
    border-radius: 12px;
    box-sizing: border-box;
    position: relative;
    flex-shrink: 0;
}
.图标下标题d{
    font-size: clamp(20px, 1vw, 30px);
    font-weight: 700;
    color: #fff;
}
.图标下小字d{
    font-size:clamp(14px,0.7vw,18px);
    color: #9CA3AF;
    line-height: 1.6;
}
.icon{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

.quote-upper {
    position:relative;
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 16px;
}
.quote-layout{
    display:flex;
    
    flex-direction: column;
}
@media (max-width: 960px) {
    .colorblock {
        width: 48px;
    }

    .图标下标题{
        font-size: clamp(20px, 4.8vw, 28px);
    }

    .图标下小字{
        font-size: clamp(14px, 3.6vw, 18px);
    }
}

</style>
<script setup>
const prop=defineProps({
    layoutType: {
      type: String,
      default: 'default', // 默认值：原有布局
      validator: (value) => ['default', 'quote'].includes(value) // 只允许两种模式
    },
    item:{
        type: Object,
        required: true
    },
    customclass1: {
        type:String,
        default:''
    },
    customclass2: {
        type:String,
        default:''
    },customclass3:{
        type:String,
        default:''
    }
});
console.log("lay"+prop.layoutType);
</script>