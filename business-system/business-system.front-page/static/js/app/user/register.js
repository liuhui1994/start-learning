mui.init();
mui.ready(function(){
    $.cookie("sms", 1234, {
        expires: (1 / 86400) * 30
    });
    mui.toast($.cookie("sms"))

    //获取验证码按钮添加点击事件
    $("#getSMSBtn").click(function (){
        var phone = $("#phone").val();
        if(!phone || phone == ""){
            mui.toast("手机号码不能为空");
        }
        if(!checkMobileno(phone)){
            mui.toast("手机号码格式有误");
        }
        $.post("url",param,function(data){
            mui.toast("请求成功时执行的回调函数。");
            if(data.success){
                var currentTime = new Date().getTime();
                cookieKey = "registerSmsTime";
                addCookie(cookieKey,currentTime,60);
                refreshBtn("getSMSBtn",cookieKey);
            }
            else{
                mui.toast(data.message);
            }
        });

    });
});

mui.ready(function () {
    alert("aa");
});

mui.ready(function () {
    alert("bb");
});