<template>
    <div class="secondsection-bigbox">
        <div class="左大区 ">
            <div id="左上" class="图片">
                <img src="../assets/picture01.jpg"></img>
            </div>
            <div id="左下" class="图片">
                <img src="../assets/picture02.jpg"></img>
            </div>
            <div id="右上" class="图片">
                <img src="../assets/picture03.jpg"></img>
            </div>
            <div id="右下" class="图片">
                <img src="../assets/picture04.jpg"></img>
            </div>
        </div>
        <div class="右大区 ">
            <tips :msg="message" class="tipbackcolor2"></tips>
            <div class="右大区大字 ">
                <div>从理念到平台</div>
                <div>我们为何存在</div>
            </div>
            
            <div class="右大区中部小字 ">2020年，一群热爱暗黑文化的设计师、摄影师和文化研究者走到一起，
                发现市场上缺乏一个真正理解"暗黑美学"的平台——大多数电商只把"暗黑"当作一种颜色，
                而非一种态度。</div>
            <div class="右大区中部小字">于是我们创立了 NOCTIS。在这里，"暗黑"不是阴郁的代名词，而是独立思考、拒绝盲从、追求深度的生活方式。我们筛选全球与我们理念契合的设计师品牌，也扶持本土新兴创作者，让每一件商品都承载独特的审美与故事。</div>
            <div class="右底部">
                <Show :items="featureList" />
            </div>
        </div>
    </div>
</template>
<script setup>
import Show from './show.vue';
import tips from './tips.vue';

const message = '关于Native';

const featureList = [
    {
        title: '理念先行',
        description: '商品是理念的载体，而非目的',
        iconClass: 'fa-solid fa-lightbulb fa-lg'
    },
    {
        title: '美学先行',
        description: '拒绝平庸，追求独特表达',
        iconClass: 'fa-solid fa-paintbrush fa-lg'
    }
];
</script>
<style scoped>
/*当 SecondSection 渲染 <Show> 时，Show 的根节点会同时带上父组件的 scope 和子组件自己的 scope*/
.secondsection-bigbox{
    height:700px;
    width: 100%;
    background-color: var(--color-gray-lighter);
    padding:80px 0px;
}
.左大区{
    position:relative;
    height:100%;
    margin-left:var(--All-left-margin);
    width: 550px;
    
    float:left;
}
.图片{
width: 180px;
    height: 280px;
    
}
#左上{
        position: absolute;
        left:0%;
        top:0%;
}
#左下{
    position: absolute;
        
        left:0%;
        top:100%;
        transform: translateY(-100%);
}
#右下{
    position: absolute;
        right:0%;
        top: 96%;
        transform: translateY(-100%);
}
#右上{
    position: absolute;
        
        right:0%;
        top: 5.4%;
        
}
.右大区 {
    display: flex;
    flex-direction: column;
    gap:50px;
    padding-top:40px;
    margin-right:var(--All-right-margin);
    width:var(--右大区整体宽度);
    height:660px; /* 按需可改为100%等 */
    float:right;
    min-height:0;
}
.右大区大字>div{
    margin-bottom:9px;
}
.右底部 {
    flex: 1 1 0;
    min-height: 0;
    display: flex; /* 保证里面show的flex也生效 */
}
img{
    border-radius: 10px;
    height:100%;
    width: 100%;
    object-fit: cover;
}




@media (max-width: 1024px) {
    .secondsection-bigbox{
        min-height: 700px;
        height: 1650px;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 60px 5vw;
        box-sizing: border-box;

    }

    .左大区{
        float: none;
        width: 100%;
        max-width: 560px;
        height: auto;
        margin: 0 auto 50px;
        display: grid;
        grid-template-columns: repeat(2, minmax(0, 1fr));
        gap: 16px;
        position: relative;
    }

    .图片{
        width: 100%;
        height: auto;
    }

    #左上,
    #左下,
    #右上,
    #右下{
        position: static;
        transform: none;
    }

    .右大区{
        float: none;
        width: 100%;
        margin: 0;
    }

    .右大区大字{
        font-size: clamp(28px, 6vw, 40px);
        text-align: center;
    }

    .右大区中部小字{
        line-height: 1.8;
        text-align: left;
    }
}
</style>