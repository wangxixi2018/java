var boolname=false;
var boolyzm=false;

function doregist() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var repassword = document.getElementById("repassword");
    var email = document.getElementById("email");
    var phoneNumber = document.getElementById("phoneNumber");
    var yzm = document.getElementById("yzm");
    
    if(password.value==""){
        $("#showInfo").html("密码不可为空").css("color","red");
        return false;
    }else{
        var pwd = password.value.trim();
        if(pwd.length>=6&&pwd.length<=16){
            reg = /^[a-zA-Z0-9_]+$/;
            if (reg.test(pwd)){
                $("#showInfo").html("");
            }else{
                $("#showInfo").html("密码格式不满足要求").css("color","red");
                return false;
            }
        }else{
            $("#showInfo").html("密码长度不满足要求").css("color","red");
            return false;
        }
    }
    if(repassword.value==""){
        $("#showInfo").html("确认密码不可为空").css("color","red");
        return false;
    }else{
        if(repassword.value==password.value){
            $("#showInfo").html("");
        }else{
            $("#showInfo").html("确认密码和密码不同，请重新输入！").css("color","red");
            return false;
        }
    }
    if(email.value==""){
        $("#showInfo").html("电子邮箱不可为空").css("color","red");
        return false;
    }else{
        reg = /\w+((-w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+/;
        if(reg.test(email.value)){
            $("#showInfo").html("");
        }else{
            $("#showInfo").html("电子邮箱格式输入错误").css("color","red");
            return false;
        }
    }
    if(phoneNumber.value==""){
        $("#showInfo").html("手机号码不可为空").css("color","red");
        return false;
    }else{
        reg=/0?(13|14|15|18)[0-9]{9}/;
        if(reg.test(phoneNumber.value)){
            $("#showInfo").html("");
        }else{
            $("#showInfo").html("手机号码格式错误").css("color","red");
            return false;
        }
    }
    if(yzm.value==""){
        $("#showInfo").html("验证码不可为空").css("color","red");
        return false;
    }else{
        $("#showInfo").html("");
        if(boolyzm==false){
            return false;
        }
    }
    if(username.value==""){
        $("#showInfo").html("用戶名不可为空").css("color","red");
        return false;
    }else{
        $("#showInfo").html("");
        if(boolname==false){
            return false;
        }
    }
    if($("#checkbox").get(0).checked){
    	$("#showInfo").html("");
    }else{
    	$("#showInfo").html("是否接受《用户协议》").css("color","red");
    	return false;
    }
    return true;
}

function chenkdousername() {
        var username = document.getElementById("username");
        if(username.value!=""){
            var name = username.value.trim();
            if(name.length>=6&&name.length<=16){
                reg = /^[a-zA-Z0-9_]+$/;
                if (reg.test(name)){
                    $.post(
                        "user.do?opr=doUserName",
                        {"name":username.value},
                        function (data) {
                            if(data=="true"){
                                $("#showInfo").html("用戶名不可用").css("color","red");
                                return false;
                            }else{
                                $("#showInfo").html("");
                                boolname=true;
                                return true;
                            }
                        },
                        "json"
                    );
                }else{
                    $("#showInfo").html("用戶名格式不满足要求").css("color","red");
                    return false;
                }
            }else{
                $("#showInfo").html("用戶名长度不满足要求").css("color","red");
                return false;
            }
        }else{
            $("#showInfo").html("用戶名不可为空").css("color","red");
            return false;
        }
    }
    
function doyzm() {
    var yzm = document.getElementById("yzm");
    if(yzm.value!=""){
        $.post(
            "user.do?opr=doyzm",
            {"yzmnum":yzm.value},
            function (data) {
                if(data==true){
                    boolyzm=true;
                    $("#showInfo").html("");
                	return true;
                }else{
                    $("#showInfo").html("验证码输入错误").css("color","red");
                    return false;
                }
            },
            "json"
        );
    }else{
        $("#showInfo").html("验证码不可为空").css("color","red");
        return false;
    } 
}
    