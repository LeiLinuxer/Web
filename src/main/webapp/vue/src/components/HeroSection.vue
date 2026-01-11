<template>
    <div class="主体">
        <div id="中间光芒"></div>
        <div class="左英雄区">
            <tips :msg="message" class="tipbackcolor1"></tips>
            <div class="左英雄区大标题 上外边隙" >
                <div class="上文本">{{ bigtitleList[0] }}</div>
                <div class="下文本" v-if=" bigtitleList.length>=2">{{bigtitleList[1]}}</div>
            </div>
            <div class="大标题下 上外边隙">
                <div class="大标题下-上">Native 是专为暗黑风格爱好者打造的文化电商平台</div>
                    <div class="大标题下-下">我们不只销售商品，更致力于传递独立、前卫、不被定义的生活态度</div>
            </div> 
            <div class="大标题下按钮 上外边隙" >
                <Lightbutton :msg="liaojiegengduo"></Lightbutton>
                <Darkbutton :msg="jiarushequ"></Darkbutton>
            </div> 
            <div class="按钮下 上外边隙">
                <div class="黑色的提示">暗黑美学</div>
                <div class="黑色的提示">独立设计</div>
                <div class="黑色的提示">小众文化</div>
                <div class="黑色的提示">个性表达</div>
            </div>
        </div>
        <div class="右英雄区 ">
            <div class="轮播图容器">
                <img src="../../src/assets/banner01.jpg" alt="">
			    <img src="../../src/assets/banner02.jpg" alt="">
            </div>
        </div>
    </div>
    
</template>
<script setup>
import Darkbutton from './darkbutton.vue';
import Lightbutton from './lightbutton.vue';
import tips from './tips.vue';
const message='不止于购物，更是一种态度';
const liaojiegengduo='立即购物';
const jiarushequ='加入社区';
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
margin-left:var(--All-left-margin);
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
    background-clip: text;
  -webkit-text-fill-color: transparent;
    
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
    margin-right: var(--中间隙);
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




.右英雄区{
            height: 83.33333333vh;
    width: var(--右大区整体宽度);
    float: right;
    margin-right:var(--All-right-margin);
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

@media (max-width: 1024px) {
    #中间光芒{
        left: 50%;
        transform: translateX(-50%);
        width: 90%;
    }

    .主体{
        min-height: 100vh;
        height: auto;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 100px 5vw 60px;
        box-sizing: border-box;
    }

    .左英雄区{
        float: none;
        width: 100%;
        margin: 0;
        text-align: center;
    }

    .左英雄区大标题{
        width: 100%;
        font-size: clamp(40px, 8vw, 60px);
    }

    .大标题下{
        margin-top: 20px;
        font-size: clamp(16px, 4vw, 20px);
    }

    .大标题下按钮{
        margin-top: 30px;
        display: flex;
        flex-direction: column;
        gap: 16px;
        align-items: center;
    }

    .按钮下{
        margin-top: 30px;
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 12px;
    }

    .黑色的提示{
        float: none;
        margin: 0;
    }

    .右英雄区{
        float: none;
        width: 100%;
        height: 360px;
        margin: 60px 0 0;
    }

    .右英雄区 .轮播图容器{
        position: relative;
        width: 200%;
    }

    .右英雄区 .轮播图容器 img{
        width: 50%;
    }

    @keyframes run {
        0%, 45% {
            transform: translateX(0);
        }
        55%, 95% {
            transform: translateX(-50%);
        }
    }
}
</style>