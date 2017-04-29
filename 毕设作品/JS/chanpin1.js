// 今日推荐
$(function(){
    $(".jiri ul li").mouseover(function(){
      if(this.className=="on"){
        return false;
      }
      $(".jiri ul li").removeClass('on');
      $(this).addClass('on');
      $(".tab").hide();
      $(".tab").eq($(".jiri ul li").index($(this))).show();
    })
  })

//二级导航栏
$(function(){
  $(".one>li").mouseover(function(){
            $(".one>li").removeClass("on")
            $(this).addClass('on');
            $(this).find(".subitem").show();
          })
      $(".one>li").mouseout(function(){
            $(".one>li").removeClass("on")
            $(this).addClass('on');
            $(this).find(".subitem").hide();
  })
      })

//返回顶部效果
$(function(){
  var tophtml="<div id='izl_rmenu' class='izl-rmenu'><div class='btn btn-phone'></div><div class='btn btn-top'></div></div>";
  $("#top").html(tophtml);
  $(this).find(".btn-top").click(function(){
      $("html, body").animate({
        "scroll-top":0
      },"fast");
    });
});


 