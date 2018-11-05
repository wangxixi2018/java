
function changepic(){
	$("#upload").click();
	$("#ghbutton").remove();
	$("#uploadForm").append("<input type='button'  id='scpic' value='上传' onclick='doUpload();'>" +
        "<input type='button'  id='notscpic' value='取消' onclick='calloffup();'>");
}

	function doUpload() {
        var upload = document.getElementById("upload");
        if(upload.value==""||upload.value==null){
        	$("#noxzpic").empty();
            $("#noxzpic").html("没有选中图片！！");
        }else{
            var formData = new FormData($("#uploadForm")[0]);
            $.ajax({
                url:"../uploadPic.do",  /*这是处理文件上传的servlet*/
                type: 'POST',
                data: formData,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (data) {
                	if(data=="true"){
                		document.getElementById("showuserpic").src="../uploadPic.do?picture=showpic";/*这是预览图片用的，自己在文件上传表单外添加*/
                        $("#scpic").remove();
                        $("#notscpic").remove();
                        $("#uploadForm").append("<input type='button' id='ghbutton' value='更换头像' style='margin-left:10px' onclick='changepic()'>");
                	}
                },
                error: function (returndata) {
                    alert(returndata);
                }
            });
        }
	}

function show(f) {
	document.getElementById("showuserpic").src="";
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            document.getElementById("showuserpic").src=e.target.result;
        }
    }
}

function calloffup(){
   $("#scpic").remove();
    $("#notscpic").remove();
    $("#uploadForm").append("<input type='button' id='ghbutton' value='更换头像' style='margin-left:10px' onclick='changepic()'>");
    document.getElementById("showuserpic").src="../user.show";
}

function updateUserInfo(){
	$(".updateUserInfo").hide();
	$("#updateButton").hide();
	$(".userInfo").after("<div class='showUpdateUserInfo'></div>");
	$(".showUpdateUserInfo").css({"width":"870px","height":"200px","border":"1px solid red","margin-left":"50px"});
	$(".showUpdateUserInfo").load("userInfo.jsp");
}

function refurbishusers(){
	window.location.reload();   
}

function usersafe(){
	$(".m_right").empty();
	$(".m_right").load("../user/usersafe.jsp");
}

function aginreaduserpage(){
	$(".m_right").remove();
	if($(".re_m_right").length>0){
		$(".re_m_right").remove();
	}
	$(".m_content").append("<div class='re_m_right'></div>");
	$(".re_m_right").load("../user/user.jsp .m_right");
}

function douseraddress(){
	$(".m_right").empty();
	$(".m_right").load("../user/useraddress.jsp");
}

function myorders1(u_id){
	$.post(
			"../order.do?opr=getorders",
			{"u_id":u_id},
			function(data){
				$(".m_right").empty();
				$(".m_right").load("../user/userorder.jsp");
			},
			"json"
	);
}
