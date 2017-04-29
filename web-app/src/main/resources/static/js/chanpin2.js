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

//点击选取变价
$(function(){
  var price=$(".price strong").text();
  $("#num_sort").change(function(){
    var total=($(this).val())*price
    $(".price strong").text(total);
  })
})

//点击评分
$(function () {
  $(".rating li").bind({mouseout:function () {
   $(this).css("color", "black").html("☆").prevAll().css("color", "black").html("☆")
 },mouseover: function () {
   $(this).css("color", "red").html("★").prevAll().css("color", "red").html("★")
 }
  });
  //鼠标按下时，确定分数。
 $(".rating li").mousedown(function () {
   $("#score").html(("你的评分是" + (parseInt($(this).index(".rating li")) + 1)));
   $(this).css("color", "yellow").html("★").prevAll().css("color", "yellow").html("★")
   //全部li标签的绑定事件全部清除--unbind方法可以加参数清除特定的事件。不加全部清除
   $(this).unbind().prevAll().unbind().nextAll().unbind();
 });
  })

//点击变换大图
$(function(){
  $(".xijie>li").click(function(){
    if(this.className=="on"){
      return false;
    }
    $(this).addClass("on");
    $(".xijie>li").removeClass('on');
    $(".img>li>img").hide();
    $(".img>li>img").eq($(".xijie>li").index($(this))).show();
  })
})
