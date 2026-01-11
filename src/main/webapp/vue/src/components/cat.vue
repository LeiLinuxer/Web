<!-- GlowBorder.vue -->
<template>
  <div 
    class="glow-box" 
    :style="computedBoxStyle"
    ref="boxRef"
  >
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted, computed } from 'vue'

// 定义组件属性
const props = defineProps({
  width: {
    type: Number,
    default: 400
  },
  height: {
    type: Number,
    default: 200
  },
  borderWidth: {
    type: Number,
    default: 2
  },
  borderRadius: {
    type: Number,
    default: 12
  },
  primaryColor: {
    type: String,
    default: '#3b82f6'
  },
  secondaryColor: {
    type: String,
    default: '#10b981'
  },
  transitionSpeed: {
    type: Number,
    default: 0.1
  }
})

// 响应式数据：存储鼠标的绝对坐标
const mouseX = ref(0)
const mouseY = ref(0)

// 响应式数据：存储元素的位置和尺寸信息
const boxX = ref(0)
const boxY = ref(0)
const boxWidth = ref(0)
const boxHeight = ref(0)

// 组件引用
const boxRef = ref(null)

// 更新元素位置信息
const updateBoxPosition = () => {
  if (boxRef.value) {
    const rect = boxRef.value.getBoundingClientRect()
    boxX.value = rect.left
    boxY.value = rect.top
    boxWidth.value = rect.width
    boxHeight.value = rect.height
  }
}

// 全局鼠标移动事件处理函数
const handleMouseMove = (event) => {
  mouseX.value = event.clientX
  mouseY.value = event.clientY
}

// 计算鼠标相对于元素的位置
const relativePosition = computed(() => {
  const relativeX = Math.max(0, Math.min(mouseX.value - boxX.value, boxWidth.value))
  const relativeY = Math.max(0, Math.min(mouseY.value - boxY.value, boxHeight.value))
  
  return {
    x: relativeX,
    y: relativeY
  }
})

// 计算CSS变量
const cssVariables = computed(() => {
  return {
    '--x': `${relativePosition.value.x}px`,
    '--y': `${relativePosition.value.y}px`,
    '--border-width': `${props.borderWidth}px`,
    '--border-radius': `${props.borderRadius}px`,
    '--primary-color': props.primaryColor,
    '--secondary-color': props.secondaryColor,
    '--transition-speed': `${props.transitionSpeed}s`
  }
})

// 计算组件样式
const computedBoxStyle = computed(() => {
  return {
    ...cssVariables.value,
    width: `${props.width}px`,
    height: `${props.height}px`
  }
})

// 组件挂载后的生命周期钩子
onMounted(() => {
  // 添加全局鼠标移动事件监听
  window.addEventListener('mousemove', handleMouseMove)
  
  // 初始更新元素位置
  updateBoxPosition()
  
  // 监听窗口大小变化，重新计算元素位置
  window.addEventListener('resize', updateBoxPosition)
  
  // 监听滚动事件，重新计算元素位置
  window.addEventListener('scroll', updateBoxPosition)
})

// 组件卸载前的生命周期钩子
onUnmounted(() => {
  // 清理事件监听，防止内存泄漏
  window.removeEventListener('mousemove', handleMouseMove)
  window.removeEventListener('resize', updateBoxPosition)
  window.removeEventListener('scroll', updateBoxPosition)
})
</script>

<style scoped>
/* GlowBorder组件的样式 */
.glow-box {
  background-color: #162447;
  border-radius: var(--border-radius, 12px);
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #e0e0e0;
  font-size: 1rem;
  text-align: center;
}

/* 动态边框效果 */
.glow-box::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  border-radius: var(--border-radius, 12px);
  padding: var(--border-width, 2px);
  background: radial-gradient(
    circle at var(--x) var(--y),
    var(--primary-color) 0%,
    var(--secondary-color) 30%,
    rgba(15, 23, 42, 0.1) 70%
  );
  -webkit-mask: 
    linear-gradient(#fff 0 0) content-box, 
    linear-gradient(#fff 0 0);
  -webkit-mask-composite: xor;
  mask-composite: exclude;
  opacity: 1;
  z-index: 0;
  transition: background var(--transition-speed, 0.1s) ease;
}

.content {
  position: relative;
  z-index: 1;
  padding: 20px;
}

.content h2, .content h3 {
  margin-top: 0;
  margin-bottom: 10px;
}

.content p {
  margin: 5px 0;
}
</style>