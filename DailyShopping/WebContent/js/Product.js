var GoodsID=0; //  商品id
var G_Size=null; // 商品尺码
var g_colors=null; // 商品颜色
var User=null; //用户昵称
var numss=0; //商品数量
$(function(data){
	index();
})

function index(){
	$.post("Goods.do",{"opr":"showindex"},function(data){
		$.each(data.listG_sort2,function(i,o){ //<a href="#">${RequestScope.list}</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a>
			$("#index1").append("<a href='javascript:GoodssInfo("+o.g_sort2ID+","+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"</a>");
			$(".Info"+i).html(
					"<span>"+o.g_sName+"</span>"
			);
			
		})
		$.each(data.listG_sort1,function(i,o){ //<a href='javascript:GoodsInfo("+o.g_sonID+","+o.g_sName+","+o.g_describe+")'>"+o.g_sName+"</a>
				$("#"+i).html(o.g_sName);	
		})
		//$(".menu_r").empty();
		$.each(data.listG_son,function(i,o){ //<a href='javascript:GoodsInfo("+o.g_sonID+","+o.g_sName+","+o.g_describe+")'>"+o.g_sName+"</a>		
			$(".menu_r"+i).html(o.g_sName)	
			//$(".Info"+i).next().html("<a href='#' class=''>"+o.g_sName+"</a>")
		})
	},"json")
}
//获取尺码  //注意Product传值只能是数值  eg: 传参：${Goods.g_size} 值为 SDF 报错    传参：${Goods.g_sizeID}值为 1 正确 
//(obj:当前对象   num：尺码ID )
function GoodsCol(obj,num){
	//alert(obj) 
	$(obj).siblings().removeAttr("class");
	$(obj).attr("class","checked");
	switch (num) {
	case 1:
		G_Size="S";
		break;
	case 2:
		G_Size="M";
		break;
	case 3:
		G_Size="L";
		break;
	case 4:
		G_Size="XL";
		break;
	case 5:
		G_Size="XXL";
		break;
	}

}

//获取颜色   (date :商品ID  num：颜色ID  obj:当前对象)
function GoodsColors(date,num,obj){
		$("#tsImgSCon ul li[id='img_"+num+"']").find("img").click();
		$(obj).siblings().removeAttr("class");
		$(obj).attr("class","checked")
		switch (num) {
		case 1:
			g_colors="红色";
			break;
		case 2:
			g_colors="白色";
			break;
		case 3:
			g_colors="黑色";
			break;
		case 4:
			g_colors="灰色";
			break;
		case 5:
			g_colors="蓝色";
			break;
		case 6:
			g_colors="绿色";
			break;

		default:
			break;
		}
	$.post("Goods.do",{"opr":"showProductColors","g_ID":date},function(data){
		$.each(data,function(i,o){
			GoodsID=o.g_ID;
			//alert(o.g_ID);		
		})
	},"json")
}

//跳转类型2 sort
function GoodssInfo(G_sort2ID,g_sName){
	switch (G_sort2ID) {
	case 1:
		window.location.href="GoodsInfo/G_sort1.jsp";
		break;
	case 2:
		window.location.href="GoodsInfo/G_sort2.jsp";
		break;
	case 3:
		window.location.href="GoodsInfo/G_sort3.jsp";
		break;
	case 4:
		window.location.href="GoodsInfo/G_sort4.jsp";
		break;
	case 5:
		window.location.href="GoodsInfo/G_sort5.jsp";
		break;
	}
	
}

function addScar(){
	//alert($("#index99").length)
	if($("#index99").length>0){//没登录  $("#index99").length 存在 就会>0
		lockScreen();
        $("html,body").animate({scrollTop:0},1000);//滚动条回到顶端   animate（位子 ， 移动速度1000=1秒）
      //禁止滚动条
        $(document.body).css({
            "overflow-y": "hidden"
        });
        
	}else{
		User=$("#opol").attr("value")
		numss=$(".j_nums input:nth-of-type(1)").attr("value")
		/*alert("商品ID："+GoodsID);
		alert("商品颜色："+g_colors);
		alert("商品尺码："+G_Size);
		alert("用户ID："+User);
		alert("商品数量："+numss);*/
		$.post("s_car.do?opr=addUsers_car",{"g_id":GoodsID,"u_id":User,"g_count":numss,"g_colors":g_colors,"G_Size":G_Size},function(data){
			alert("添加成功")
	},"json")
	}
	
}
function longin(){
	//alert(88)
	var user=$(".l_user").val();
	var pwd=$(".l_pwd").val();
	$.post("user.do?opr=doLogin",{"username":user,"password":pwd},function lonin(data){
			//alert(data.booleans)
			if(data.booleans=='false'){
				$("#longin").html("账号密码不正确,请重新输入")
			}else{
				
				//启用滚动条
		        $(document.body).css({
		            "overflow-y": "auto"
		        })
		        $("#bgDiv").remove();;//移除覆盖整个窗口的div层
		        $(".log_bg89").css("display","none"); //隐藏登录小窗口
		        $.post("../user.do?opr=doLogin",{"username":user,"password":pwd},function(data){
		        	alert(data)
		        },"json")
		        window.location.reload()//刷新当前页面
			}		
    },"json")
}

//锁屏
function lockScreen(){
	//alert(1111);
	//$("#bgDiv").empty();
	var sWidth, sHeight;
    sWidth = document.body.offsetWidth;//获取窗口宽度
    sHeight = screen.height;//获取屏幕高度
    var bgObj= document.createElement("div");//关键在这里，原理：在body中创建一个div，并将其宽度与高度设置为覆盖整个窗体，如此一来就无法对其它窗口时行操作
    bgObj.setAttribute('id', 'bgDiv');
    bgObj.style.position = "absolute";
    bgObj.style.top = "0";
    bgObj.style.background = "#777";
    bgObj.style.opacity = "0.6";
    bgObj.style.left = "0";
    bgObj.style.width = sWidth + "px";
    bgObj.style.height = sHeight + "px";
    bgObj.style.zIndex = "900";
    document.body.appendChild(bgObj);
    $(".log_bg89").css("display","block");
}
