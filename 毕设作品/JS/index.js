//二级导航栏
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

//banner轮播图
 $(function(){
    var index=0;
    var adTimer;
    $("#number li").mouseover(function(){
      index=$("#number li").index(this); //获取现在鼠标所在的索引值
      showImg(index);
    }).eq(0).mouseover();
    $(".banner").hover(function(){
      clearInterval(adTimer);
    },function(){
      adTimer=setInterval(function(){
        showImg(index)
        index++;
        if(index==4){
        	index=0;
        }
      },2000);
    }).trigger("mouseleave");
  })
  function showImg(index){
    var sliderWidth=$("#show>li").width();
    $("#show").stop(true,false).animate({left:-sliderWidth*index},800);
    $("#number li").removeClass("on").eq(index).addClass("on");
  }
