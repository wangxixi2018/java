function checkLogin(){
    var username=document.getElementById("username");
    var password=document.getElementById("password");
    var userspan=document.getElementById("userspan");
    var pwdspan=document.getElementById("pwdspan");
    if(username.value==""){
        userspan.innerHTML="用户名不能为空";
        return false;
    }else{
        userspan.innerHTML="";
    }
    if (password.value==""){
        pwdspan.innerHTML="密码不能为空";
        return false;
    }else{
        pwdspan.innerHTML="";
    }
    return true;
}

function doUserName(){
    var username=document.getElementById("username");
    var password=document.getElementById("password");
    var userspan=document.getElementById("userspan");
    var pwdspan=document.getElementById("pwdspan");
    if(checkLogin()){
        $.post(
            "../user.do?opr=doUserName",
            {"name":username.value,"password":password.value},
            function(data){
                if (data=="用户不存在") {
                    userspan.innerHTML="用户名不存在";
                }
                if(data=="密码不正确"){
                	pwdspan.innerHTML="密码不正确";
                }
            },
            "json"
        )
    }
}

