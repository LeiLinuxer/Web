<template>
    <div class="bigbox">
        <div
          class="bigblackframe"
          v-for="(item,index) in props.items":key="index">
            <basecard :item="item"></basecard>
        </div>
    </div>
    
</template>

<script setup>
import basecard from './basecard.vue';
const props = defineProps({
    items: {
        type: Array,
        default: () => ([
            {
                title: '理念先行',
                description: '商品是理念的载体，而非目的',
                iconClass: 'fa-solid fa-lightbulb fa-lg'
            },
            {
                title: '美学先行',
                description: '商品是理念的载体，而非目的',
                iconClass: 'fa-solid fa-lightbulb fa-lg'
            }
        ])
    }
});
</script>

<style scoped>
.bigbox {
    flex: 1 1 0;
    display: flex;
    gap: var(--较大间隙);
    min-height: 0;
    padding-bottom: var(--小边隙);
    align-items: stretch;
    /* 填满 */
}

.bigblackframe {
    flex:1 1 0;
    min-width: 0;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    /* 从左开始 */
    gap: var(--小间隙);
    background-color: #050505;
    border-radius: 20px;
    padding: calc(var(--left-top-padding) * 1.3);
    box-shadow: 0 0 25px rgba(0,0,0,0.35);
}


@media (max-width: 960px) {
    .bigbox {
        flex-direction: column;
        gap: var(--中间隙);
        width: 100%;
    }

    .bigblackframe {
        padding: 20px;
        gap: 12px;
        border-radius: 16px;
    }

    
}
</style>

