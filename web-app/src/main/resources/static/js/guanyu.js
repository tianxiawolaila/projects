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