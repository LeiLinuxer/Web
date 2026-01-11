<template>
    <div v-for="(item,index) in items" 
        :class="blockstyle|| 'block'"
        :key="index" 
        :ref="el => setBlockRef(el, index)"
    >
        <basecard 
            :item="item" :layout-type="layoutType"
            customclass1="图标下标题2" 
            customclass2="图标下小字2" 
            customclass3="colorblock2"
        ></basecard>
    </div>
</template>    

<style>
.block{
    position: relative;
    float:left;
    background-color: var(--color-gray-lighter);
    border-radius:20px;
    padding:35px;
    width:420px;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    gap: var(--小间隙);
    
    border:1px solid var(--color-light-darker);
    transition-duration: 0.5s;
    transition-property: border;
    transition-timing-function: ease-in-out;
    
}

/* 为每个block添加光效层 */
.block::before {
    content: '';
    position:absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    border-radius: 20px;
    padding: 3px;
    /* 光源宽度 */
    
    background: radial-gradient(
        circle at var(--mouse-x) var(--mouse-y),
        rgba(122, 69, 245, var(--glow-intensity, 0.9)) 0%,     
        rgba(47, 24, 99, calc(var(--glow-intensity, 0.9) * 0.4)) 20%,     
        rgba(15, 23, 42, 0.1) 30%        
    );
    
    -webkit-mask: 
        linear-gradient(#fff 0 0) content-box,
        linear-gradient(#fff 0 0);
    -webkit-mask-composite: xor;
    mask-composite: exclude;
    
    opacity: 1; /* 始终显示 */
    z-index: 0;
    
    transition: background 0.1s ease;
    
    /* 根据强度调整模糊效果 */
    filter: blur(calc(1px + (1 - var(--glow-intensity, 1)) * 2px)) 
            brightness(calc(0.8 + 0.4 * var(--glow-intensity, 1)));
}

.block:hover{
    border:1px solid var(--color-neon);
    transition-duration: 0.5s;
    transition-property: border;
    transition-timing-function: ease-in-out;
}

.colorblock2 {
    width: clamp(53px, 2.9vw, 60px);
    aspect-ratio: 1/1;
    background-color: var(--color-neon-darker);
    border-radius: 12px;
    position: relative;
}

.图标下标题2{
    font-size: clamp(23.04px, 1.2vw, 25px);
    font-weight: 700;
    color: #fff;
}
.图标下小字2{
    font-size:clamp(14.4px,0.75vw,15px);
    color: #9CA3AF;
    line-height: 1.4;
}
</style>
<script setup>
import basecard from './basecard.vue';
import { ref, onMounted, onUnmounted } from 'vue'

const props=defineProps({
    items:{
        type: Array,
        default: () => ([
            {
                title: '理念先行',
                description: '商品是理念的载体，而非目的',
                iconClass: 'fa-solid fa-lightbulb fa-lg'
            },
        ])
    },
    layoutType: {
      type: String,
      default: 'default', // 默认值：原有布局
      validator: (value) => ['default', 'quote'].includes(value) // 只允许两种模式
    },
    blockstyle:{
      type:String,
      default:''
    }
});

// 鼠标位置
const mouseX = ref(0);
const mouseY = ref(0);

// 为每个block存储位置信息
const blockRefs = ref([]);

// 设置block引用
const setBlockRef = (el, index) => {
  if (el) {
    blockRefs.value[index] = el;
    // 初始化时设置默认样式
    updateBlockGlow(el);
  }
};

// 计算鼠标到block的距离并返回强度
const calculateDistanceIntensity = (blockRect) => {
  
  const elLeft = blockRect.left;    // 元素左边界
  const elTop = blockRect.top;      // 元素上边界
  const elRight = blockRect.right;  // 元素右边界（left + width）
  const elBottom = blockRect.bottom;// 元素下边界（top + height）
  const cx = Math.max(elLeft, Math.min(mouseX.value, elRight));
      const cy = Math.max(elTop, Math.min(mouseY.value, elBottom));
  // 计算鼠标到block中心的距离
  const distance = Math.sqrt(Math.pow(mouseX.value - cx, 2) + Math.pow(mouseY.value - cy, 2));
      const distanceFixed = distance.toFixed(2);
  
  // 使用指数衰减函数，距离越远光效越弱
  // 这里使用200px作为参考距离，可以根据需要调整
  const intensity = Math.max(0, 1 - (distanceFixed / 400));
  
  // 使用平方衰减使效果更自然
  return Math.pow(intensity, 1.5);
};

// 更新单个block的光效
const updateBlockGlow = (block) => {
  const rect = block.getBoundingClientRect();
  const intensity = calculateDistanceIntensity(rect);
  
  // 计算鼠标相对于该block的位置
  const relativeX = mouseX.value - rect.left;
  const relativeY = mouseY.value - rect.top;
  
  // 设置CSS变量
  block.style.setProperty('--mouse-x', `${relativeX}px`);
  block.style.setProperty('--mouse-y', `${relativeY}px`);
  block.style.setProperty('--glow-intensity', intensity*0.7);
};

// 更新所有block的光效
const updateAllBlocksGlow = () => {
  blockRefs.value.forEach(block => {
    if (block) {
      updateBlockGlow(block);
    }
  });
};

// 全局鼠标移动处理
const handleGlobalMouseMove = (event) => {
  mouseX.value = event.clientX;
  mouseY.value = event.clientY;
  updateAllBlocksGlow();
};

// 组件挂载后添加全局鼠标监听
onMounted(() => {
  window.addEventListener('mousemove', handleGlobalMouseMove);
});

// 组件卸载前移除全局鼠标监听
onUnmounted(() => {
  window.removeEventListener('mousemove', handleGlobalMouseMove);
});
</script>