<template>
    <div class="bigbox">
    <div class="左大区">
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
    <div class="右大区 common-margin-right">
        <tips :msg="message" class="tipbackcolor"></tips>
        <div class="右大区大字 上外边隙">从理念到平台</div>
        <div class="右大区大字">我们为何存在</div>
        <div class="右大区中部小字 上外边隙">2020年，一群热爱暗黑文化的设计师、摄影师和文化研究者走到一起，
            发现市场上缺乏一个真正理解"暗黑美学"的平台——大多数电商只把"暗黑"当作一种颜色，
            而非一种态度。</div>
        <div class="右大区中部小字 小上外边隙">于是我们创立了 NOCTIS。在这里，"暗黑"不是阴郁的代名词，而是独立思考、拒绝盲从、追求深度的生活方式。我们筛选全球与我们理念契合的设计师品牌，也扶持本土新兴创作者，让每一件商品都承载独特的审美与故事。</div>
    </div>
    </div>
</template>
<script setup>
import tips from './tips.vue';
const message='关于Native';
</script>
<style scoped>
.bigbox{
    height:700px;
    width: 100%;
    background-color: rgb(20, 20, 20);
    padding:80px 0px;
}
.左大区{
    position:relative;
    height:100%;
    
    width: 550px;
    margin-left:180px;
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
.右大区{
    margin-top:40px;
    width:690px;
    height:100px;

    float:right;
    
}
img{
    border-radius: 10px;
    height:100%;
    width: 100%;
    object-fit: cover;
}
.tipbackcolor{
    background-color: var(--color-neon-background2);
}
.右大区大字{
    font-size:40px;
    color: white;
    font-family: var(--font-family);
    font-weight: 600;
}
.右大区中部小字{
    font-size:18px;
    color:var(--color-gray-light);
}
</style>