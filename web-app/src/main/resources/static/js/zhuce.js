//注册登录切换
function tab(a){
	var m=document.getElementById('btn').getElementsByTagName('div');
	var n=document.getElementsByTagName('li');
	if(a==0){
		m[0].className="on1";
		m[1].className="off2";
		n[2].style.display="none";
		$("#li3").attr("disabled",true);
		n[3].style.display="none";
        n[4].style.display="none";
        $("#li4").attr("disabled",true);
        $("#li5").attr("disabled",true);
        $("#form1").attr("action","/toLoginIn.html");
        $("#a3").text("登录");
	}
	if (a==1) {
	    m[0].className="off1";
		m[1].className="on2";
		n[2].style.display="block";
        $("#li3").attr("disabled",false);
		n[3].style.display="block";
        $("#li4").attr("disabled",false);
        n[4].style.display="block";
        $("#li5").attr("disabled",false);
        $("#form1").attr("action","/toRegist.html");
        $("#a3").text("立即注册");
	}
}

//表单验证
$(function(){
$("form :input.a1").each(function(){
            var $a1 = $("<strong class='high'> *</strong>"); //创建元素
            $(this).parent().append($a1); //然后将它追加到文档中
        });//文本框失去焦点后
        $('form :input').blur(function(){
             var $parent = $(this).parent();
             $parent.find(".formtips").remove();
             //验证用户名
             if( $(this).is('#name') ){
                    if( this.value=="" || this.value.length < 6 ){
                        var errorMsg = '请输入至少6位的用户名.';
                        $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                    }else{
                        var okMsg = '输入正确.';
                        $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                    }
             }
             //输入密码
             if( $(this).is('#password') ){
                    if( this.value=="" || this.value.length < 6 ){
                        var errorMsg = '请输入正确的密码.';
                        $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                    }else{
                        var okMsg = '输入正确.';
                        $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                    }
             }
             //验证邮件
             if( $(this).is('#email') ){
                if( this.value=="" || ( this.value!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value) ) ){
                      var errorMsg = '请输入正确的E-Mail地址.';
                      $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                      var okMsg = '输入正确.';
                      $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
             }
        }).keyup(function(){
           $(this).triggerHandler("blur");
        }).focus(function(){
             $(this).triggerHandler("blur");
        });
        //提交，最终验证。
         $('#a3').click(function(){
                $("form :input.a1").trigger('blur');
                var numError = $('formtips .onError').length;
                if(numError){
                    return false;
                } else {
                return true;
                }
         });
    })