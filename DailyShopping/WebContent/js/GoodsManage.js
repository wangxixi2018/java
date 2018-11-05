var index = 1;// 当前页数;
var num = 10;// 每页显示数目
var sum = null;// 总页数
var Goods=null;// 所有商品
var toop=0;
$(function (){
	//alert( $("#opol").attr("value"))
	//通过  cookie的长度来判断值    只有第一次进入后台时 cookie 长度为1 
	//当点击添加商品后 在后端在cookie中放入了值 长度就不是1了 从而达到了只有第一次进入后台时主页中间部分为空，
	//点击添加商品后 从定向会主页是判断cookie长度  就可以继续添加产品了
	if($("#opol").attr("value")!=0){AddGoods()}
	
})

//查看所有商品
function QueryGoods() { 
	//alert(88)
	$.post("../Goods.do?opr=queryAllGoods",{},function(data){
		Goods=data;
		//alert(data)
		GoodsPage();
		show();
	},"json")
	//alert($("#toopd table").attr("cellpadding"))
	//$("#toopd table").empty();// 先清空以前的数据
	delCookie("num");	// num 为  Cookie cookie = new Cookie("num", "num")  创建时的 name ()中的第一个
	
}

/*function delCookie(name){
	//为cookie name   
	var date = new Date();   
	date.setTime(date.getTime() - 10000);   
	document.cookie = name + "=a; expires=" + date.toGMTString();
}*/

//删除cookies  //toGMTString是一个电脑语言中的函数，是把Date对象转换为字符串
function delCookie(name) { 
	var myCookie = document.cookie; // 获取document中的cookies
	//alert(myCookie)
	var date=new Date(); 
    date.setTime(date.getTime()-10000); 
    document.cookie=name+"=v; expires="+date.toGMTString(); 

} 




//添加商品
function AddGoods(){ //Goods.do?opr=AddGoods

	//alert(7)
	$("#yutp").empty();
	$("#yutp").load("../Goods.do",{"opr":"AddGoods"}); //后台发起请求，后台转发到GoodsAlterGoods ，这里就通过load（）全程引入到#tookp中
}

/*function addGoods(){
	//alert($("#num1").val());
	var num=$("#num1").val();
	alert(typeof num.substring(0, num.indexOf(" "))); //拆分字符串 
	var G_sort1ID= parseInt(num.substring(0, num.indexOf(" "))); //转化成数值型 
	
}*/

function GoodsPage(){
	//alert(Goods.length)
	$("#yutp").empty();
	$("#yutp").append("<table id='tookp' border='1' cellpadding='10px' cellspacing='0' align='center'></table>");
				var str=" <thead>";
				 	str+=" 	<tr>";
				    str+=" 	  <td>商品图片</td>";
				    str+=" 	  <td>序号</td>";
				    str+=" 	  <td>商品类型</td>";
				    str+=" 	  <td>商品类别</td>";
				    str+=" 	  <td>商品品牌</td>";
				    str+=" 	  <td>商品价格</td>";
				    str+=" 	  <td>商品积分</td>";
				    str+=" 	  <td>商品修改</td>";
				    str+=" 	</tr>";
				    str+=" </thead>";
				    str+="  <tr>";
	for (var i = num * (index - 1); i < num * index; i++) {   //news.do?opr=readNew&nid="+ Goods[i].nid+ "
		if (i >= 0 && i < Goods.length) { // 控制展示数据范围 eg: 如果i加到150了 但是数据只有140 // 就会丢失 后面的数据(上页 下页 ~~~)	
				 	str+="    <td><img  src='../downFile.do?opr="+Goods[i].g_ID+"' width='42px;' height='50px;'/></td>";
				 	str+="    <td>"+(i+1)+"<input type='hidden' name='opr' value='"+Goods[i].g_ID+"' /></td>";
			 	switch (Goods[i].g_sort1ID) {
				case 1:
					str+="    <td>男装</td>";
					break;
				case 2:
					str+="    <td>女装</td>";
					break;
				case 3:
					str+="    <td>童装</td>";
					break;
				case 4:
					str+="    <td>老年装</td>";
					break;
				}
			 	switch (Goods[i].g_sort2ID) {
			 	case 1:
			 		str+="    <td>外套</td>";
			 		break;
			 	case 2:
			 		str+="    <td>T恤</td>";
			 		break;
			 	case 3:
			 		str+="    <td>衬衣</td>";
			 		break;
			 	case 4:
			 		str+="    <td>长裤</td>";
			 		break;
			 	case 4:
			 		str+="    <td>牛仔裤</td>";
			 		break;
			 	}
			 	switch (Goods[i].g_sonID) {
			 	case 1:
			 		str+="    <td>雅鹿</td>";
			 		break;
			 	case 2:
			 		str+="    <td>南极人</td>";
			 		break;
			 	case 3:
			 		str+="    <td>红豆男装</td>";
			 		break;
			 	case 4:
			 		str+="    <td>花花公子</td>";
			 		break;
			 	case 5:
			 		str+="    <td>罗蒙</td>";
			 		break;
			 	case 6:
			 		str+="    <td>七匹狼</td>";
			 		break;
			 	case 7:
			 		str+="    <td>美特斯邦威</td>";
			 		break;
			 	case 8:
			 		str+="    <td>美国苹果</td>";
			 		break;
			 	case 9:
			 		str+="    <td>四川拍拍衣</td>";
			 		break;
			 	case 10:
			 		str+="    <td>才子男装</td>";
			 		break;
			 	case 11:
			 		str+="    <td>鼎度</td>";
			 		break;
			 	case 12:
			 		str+="    <td>尊尚鸟</td>";
			 		break;
			 	}	
			 		str+="    <td>"+Goods[i].g_g_price+"</td>";
			 		str+="    <td>"+Goods[i].g_integral+"</td>";
			 		str+="    <td><a href='javascript:alter("+Goods[i].g_ID+")'>修改</a></td>";
			 		str+="  </tr>";
			 		//str+="  <tr>";
			 		
			 				
			}else{// 添加空的标签占位，防止错乱
					str+="<tr><td>&nbsp;&nbsp;&nbsp;</td></tr>";
			}
		}
			$("#tookp").append(str);
			$("#tookp").append("<div class='classlist'></div>");
			
}
//修改
function alter(data){ //Goods.do?opr=AddGoods
	//alert($("div:not(.yuop)").html())
	//$("div:not(.yuop)").empty();      
	$("#tookp").load("Goods.do",{"opr":"GoodsAlterGoods","g_ID":data}); //后台发起请求，后台转发到GoodsAlterGoods ，这里就通过load（）全程引入到#tookp中
	//$.post("Goods.do?opr=AddGoods",{},function(data){},"json")
	//$("#tookp").load("GoodsManage/GoodsAlterGoods.jsp #yutp");  // 直接引入一个页面的某个元素到#tookp中  适用于静态页面
}
function show() {
	// 显示分页 （使用前端分页）
	sum = Math.ceil(Goods.length / num); //向上
	//alert(index)
	$(".classlist").append(
			"<ul><li><span>" +
			"<a onclick='onepaging(1)' style='cursor: pointer;'>首页&nbsp;&nbsp;&nbsp;</a>" +
			"<a onclick='onepaging(" + (index - 1)+ ")' style='cursor: pointer;'>上一页&nbsp;&nbsp;&nbsp;</a>" +
			"<a>当前页:" + index + "/"+ sum + "&nbsp;&nbsp;&nbsp;</a>" +
			"<a onclick='onepaging("+ (index + 1) + ")' style='cursor: pointer;'>下一页&nbsp;&nbsp;&nbsp;</a>" +
			"<a onclick='onepaging(" + (sum)+ ")' style='cursor: pointer;'>末页</a></span></li></ul>")
}
// 前端分页控制
function onepaging(data) {
	index = data;
	if (index < 1) {
		index = 1;
	} else if (index > sum) {
		index = sum;
	}
	GoodsPage();
	show();
}