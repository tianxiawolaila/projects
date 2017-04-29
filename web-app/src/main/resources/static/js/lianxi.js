//输入框显示
$(function(){
	$(".right>ul>li #a1").click(function(){
		var text=$(this).text();
		$(this).val("");
	})
	$(".right>ul>li #a1").blur(function(){
		var text=$(this).text();
		$(this).val("请输入信息")
	})
})

//鼠标移动显示效果
window.onload=function(){
	var div1=document.getElementsByClassName("tip");
	for(var i=0;i<div1.length;i++){
		div1[i].onmouseover=function(event){
			var newdiv=document.createElement("div");
			newdiv.id="a";
			newdiv.innerHTML="<img src='"+this.href+"'>";
			newdiv.style.display="block";
			document.body.appendChild(newdiv);
			document.getElementById("a").style.left=(event.clientX+20)+"px";
            document.getElementById("a").style.top=(event.ceilentY+30)+"px";
		}
		div1[i].onmouseout=function(){
                  newdiv=document.getElementById("a");
                  newdiv.parentNode.removeChild(newdiv);
                }
                div1[i].onmousemove=function(event){
                  document.getElementById("a").style.left=(event.clientX+20)+"px";
                  document.getElementById("a").style.top=(event.clientY+30)+"px";
                }
	}
}

//二次导航
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