<template>
    <div class="主体">
        <div id="中间光芒"></div>
        <div class="左英雄区 common-margin-left">
            <tips :msg="message" class="tipbackcolor"></tips>
            <div class="左英雄区大标题 上外边隙" >
                <div class="上文本">{{ bigtitleList[0] }}</div>
                <div class="下文本" v-if=" bigtitleList.length>=2">{{bigtitleList[1]}}</div>
            </div>
            <div class="大标题下 上外边隙">
                <div class="大标题下-上">Native 是专为暗黑风格爱好者打造的文化电商平台</div>
                    <div class="大标题下-下">我们不只销售商品，更致力于传递独立、前卫、不被定义的生活态度</div>
            </div> 
            <div class="大标题下按钮 上外边隙" >
                <button  id="了解更多" type="button">了解更多</button>
                <button class="左外边隙"id="加入社区" type="button">加入社区</button>
            </div> 
            <div class="按钮下 上外边隙">
                <div class="黑色的提示">暗黑美学</div>
                <div class="黑色的提示">独立设计</div>
                <div class="黑色的提示">小众文化</div>
                <div class="黑色的提示">个性表达</div>
            </div>
        </div>
        <div class="右英雄区 common-margin-right">
            <div class="轮播图容器">
                <img src="../../src/assets/banner01.jpg" alt="">
			    <img src="../../src/assets/banner02.jpg" alt="">
            </div>
        </div>
    </div>
    
</template>
<script setup>
import tips from './tips.vue';
const message='不止于购物，更是一种态度';
defineProps({
    bigtitleList:{
        type:Array,
        required:true,
        validator: (list) => list.length >= 1
    }
})
</script>
<style scoped>

#中间光芒{
        position: absolute;
    left: 420px;
    top: 280px;
    width: 700px;
    height: 540px;
    border-radius: 50%;
background: radial-gradient(circle, rgb(168 30 255 / 30%) 10%, transparent 60%);    filter: blur(100px);
    z-index: 0;
}

.主体{
    
    
    height:1050px;
    
    
}
.左英雄区{
margin-top:300px;
width: max-content;float: left;
}
.左英雄区大标题{
    font-size:60px;
    font-weight:900;
    line-height: 1.1;
    width:max-content;
}
.左英雄区大标题>.上文本{
    color:white;
}
.左英雄区大标题>.下文本{
    background: linear-gradient(135deg,var(--color-neon),var(--color-neon-green));
    -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
    
}

.大标题下{
    font-size:20px;
    color:white;
}
.大标题下按钮>button{
    color:white;
    border-radius: 10px;
    height:60px;
    font-size:16px;
    font-weight: 500;
    
}
.大标题下按钮>#了解更多{
    background:linear-gradient(50deg,var(--color-neon),var(--color-neon-green));
    border-style:hidden;
    width: 120px;
    background-color: var(--color-neon);
    transition: all 0.5s ease-in-out;
}
.大标题下按钮>#了解更多:hover{
    box-shadow: -4px 4px 20px 0px #300495;
    transition: box-shadow 0.2s ease-in-out;
}
.大标题下按钮>#加入社区{
border:1px solid rgb(69, 87, 95);
background-color: #0A0A0A;
 width:150px;
}
.左外边隙{
    margin-left:15px;
}
.黑色的提示{
    position:relative;
    padding:var(--junior-title-padding);
    font-size:var(--junior-title-size);
    width: max-content;
    border-radius: 20px;
    color:white;
    background-color: #1f1f1f;
    float:left;
    margin-right: 15px;
    overflow: hidden;
}
.黑色的提示::after{
        content: '';
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 2px;
    background: linear-gradient(90deg, #7B2CF9, #00DCC1);
    transform: scaleX(0);
    transform-origin: right;
    transition: transform 0.3s ease;
    clear:both;
    display: block;
}

.黑色的提示:hover::after{
    transform: scaleX(1);
    transform-origin: left;
}
.按钮下::after{
    content:'';
    clear:both;
    display: block;
}



.tipbackcolor{
    background-color: var(--color-neon-background1);
}

.右英雄区{
            height: 900px;
    width: 690px;
    float: right;
    
    margin-top: 100px;
    border-radius: 25px;
    overflow: hidden;
    position: relative;
    box-shadow: -8px 12px 100px #371093;
    border: 5px solid black;

}
.右英雄区 .轮播图容器 {
	width:1400px;
	height:100%;
	overflow: hidden;
	position: absolute;
	/* 开启弹性盒，让图片横向排列 */
	display: flex;
	animation: run 10s ease infinite;
}
.右英雄区 .轮播图容器 img {
	width:100%;
    height:100%;
    object-fit: cover;
}
@keyframes run {
	0%,50%{
		/* margin-left: 0; */
		transform: translateX(0);
	}
    60%,90%{
        transform: translateX(-700px);
    }
    }
</style>