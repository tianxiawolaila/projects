// 二级导航
$(function(){
  $(".nav>ul>li:not(#n1)").mouseover(function(){
          	$(".nav>ul>li:not(#n1)").removeClass("on");
          		$(this).addClass("on");
          		$(this).find(".jnNav").show();
          })
      $(".nav>ul>li:not(#n1)").mouseout(function(){
        $(".nav>ul>li:not(#n1)").removeClass("on");
        $(this).find(".jnNav").hide();
  })
      })

//底部选项卡
  $(function(){
    $(".hi>ul>li").click(function(){
      $(this).addClass("on").siblings().removeClass("on");
      var now=$(".hi>ul>li").index(this);
      $(".tab>div").eq(now).show().siblings().hide();
    })
  })

//折叠侧边栏
$(function(){
  $(".content1").hide();
  $(".tog:first").addClass("one").next().show();
  $(".tog").click(function(){
          if($(this).next().is(':hidden')){
            $(".tog").removeClass('one').next().slideUp();
            $(this).toggleClass('one').next().slideDown();
          }
          return false;
  })
})

//文字滚动
var speed=40 
window.onload=function(){
var demo=document.getElementById("body1"); 
var demo2=document.getElementById("body1_2"); 
var demo1=document.getElementById("body1_1"); 
demo2.innerHTML=demo1.innerHTML 
function Marquee(){ 
if(demo.scrollTop>=demo1.offsetHeight){
demo.scrollTop=0; 
}
else{ 
demo.scrollTop=demo.scrollTop+1;
} 
} 
var MyMar=setInterval(Marquee,speed) 
demo.onmouseover=function(){
  clearInterval(MyMar)
} 
demo.onmouseout=function(){
  MyMar=setInterval(Marquee,speed)
} 
}