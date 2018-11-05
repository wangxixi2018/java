var num=0;
var maxtime = 60 * 60*3; 
$(function(){
	index(); //头部1
	index1(); //头部2
	index2(); //头部3
	index3(); //限时特卖
    timer0 = setInterval("CountDown0()", 1000); //倒计时
    timer1 = setInterval("CountDown1()", 1000); //倒计时
    timer2 = setInterval("CountDown2()", 1000); //倒计时
    timer3 = setInterval("CountDown3()", 1000); //倒计时
    timer4 = setInterval("CountDown4()", 1000); //倒计时
    timer5 = setInterval("CountDown5()", 1000); //倒计时
    index4(); //男装
    index5(); //女装
    index6(); //童装
    index7(); //老年装
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



function index1(){
	$.post("Goods.do",{"opr":"showImg","g_ID":9},function(data){
		$.each(data,function(i,o){
			$("#img20").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='236' height='200'/></a>")
			$(".pri_bg").append(
					"<span class='price fl'>￥"+o.g_g_price+"</span>"+
	                "<span class='fr'>"+o.g_integral+"R</span>"
			)
		})
	},"json")
}

function index2(){
	var p=-1;
	$.post("Goods.do",{"opr":"showindex1","g_sonID":2},function(data){
		$.each(data,function(i,o){	
			num=o.g_ID;
			$(".hoop"+i).append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='160' height='136'/></a>");
			$(".price"+i).append(
					"<font>￥<span>"+o.g_g_price+"</span></font> &nbsp; "+o.g_integral+"R"
			)
			$.post("Goods.do",{"opr":"showG_son","g_sonID":6},function(date){
				p++;
				$.each(date,function(i,k){
					$(".name"+p).append(
							"<a href='javascript:imgInfo("+o.g_ID+")'><h2>"+k.g_sName+"</h2>"+k.g_describe+"</a>"
					)
				})
	},"json")
		})
	},"json")
}
//限时特卖
function index3(){
	$.post("Goods.do",{"opr":"showImg","g_ID":10},function(data){
		$.each(data,function(i,o){
			$(".img2"+i).append(
					"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='211' height='357' /></a>"
			)	
			$(".img2"+(i+1)).append(
					"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='211' height='357' /></a>"
			)	
			$(".img2"+(i+2)).append(
					"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='211' height='357' /></a>"
			)	
		})
	},"json")
	
	var number=[6,8,12,14,17,21];
	$.ajax({
		"url"       :  "Goods.do?opr=showG_son1", //请求路径
		"type"      :  "GET", //请求方式
		"data"      :  {"number":JSON.stringify(number)}, //要发送的数据
		"async"     :false,//同步
		"timeout"   :9000,//等待时间
		"dataType"  :  "json", // 请求成功后返回的数据类型
		"success"   :  function(data){ //请求成功后调用的函数
			//alert(data.map0.listGoods)
			var num0=0;
			$.each(data.map0.listGoods,function(i, o){
				//alert(o.g_ID)
					num0=o.g_ID;
					$(".s_img0").append(//<a href="#"><img src="images/tm_b2.jpg" width="242" height="356" /></a>							
							"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='242' height='356' /></a>"
					)
					$(".s_price0").append(//<a href="#"><img src="images/tm_3.jpg" width="185" height="155" /></a>
							"￥<span>"+o.g_g_price+"</span>"
					)	
			})
			$.each(data.map0.listG_son,function(i, o){
				$(".s_name0").append(// <h2><a href="#">沙宣洗发水</a></h2>倒计时：<span>1200</span> 时 <span>30</span> 分 <span>28</span> 秒
						"<h2><a href='javascript:imgInfo("+num0+")'>"+o.g_describe+"</a></h2><span id='timer0' style='color:red'></span>"
				)
			})
				
			var num1=0;
			$.each(data.map1.listGoods,function(i, o){
				//alert(o.g_ID)
				num1=o.g_ID;
					$(".s_img1").append(//<a href="#"><img src="images/tm_b2.jpg" width="242" height="356" /></a>
							"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='242' height='356' /></a>"
					)
					$(".s_price1").append(//<a href="#"><img src="images/tm_3.jpg" width="185" height="155" /></a>
							"￥<span>"+o.g_g_price+"</span>"
					)	
			})
			$.each(data.map1.listG_son,function(i, o){
				$(".s_name1").append(// <h2><a href="#">沙宣洗发水</a></h2>倒计时：<span>1200</span> 时 <span>30</span> 分 <span>28</span> 秒
						"<h2><a href='javascript:imgInfo("+num1+")'>"+o.g_describe+"</a></h2><span id='timer1' style='color:red'></span>"
				)
			})
			
			
			var num2=0;
			$.each(data.map2.listGoods,function(i, o){
				//alert(o.g_ID)
				num2=o.g_ID;
					$(".s_img2").append(//<a href="#"><img src="images/tm_b2.jpg" width="242" height="356" /></a>
							"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a>"
					)
					$(".s_price2").append(//<a href="#"><img src="images/tm_3.jpg" width="185" height="155" /></a>
							"￥<span>"+o.g_g_price+"</span>"
					)	
			})
			$.each(data.map2.listG_son,function(i, o){
				$(".s_name2").append(// <h2><a href="#">沙宣洗发水</a></h2>倒计时：<span>1200</span> 时 <span>30</span> 分 <span>28</span> 秒
						"<h2><a href='javascript:imgInfo("+num2+")'>"+o.g_describe+"</a></h2><span id='timer2' style='color:red'></span>"
				)
			})
			
			var num3=0;
			$.each(data.map3.listGoods,function(i, o){
				//alert(o.g_ID)
				num3=o.g_ID;
					$(".s_img3").append(//<a href="#"><img src="images/tm_b2.jpg" width="242" height="356" /></a>
							"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='242' height='356' /></a>"
					)
					$(".s_price3").append(//<a href="#"><img src="images/tm_3.jpg" width="185" height="155" /></a>
							"￥<span>"+o.g_g_price+"</span>"
					)	
			})
			$.each(data.map3.listG_son,function(i, o){
				$(".s_name3").append(// <h2><a href="#">沙宣洗发水</a></h2>倒计时：<span>1200</span> 时 <span>30</span> 分 <span>28</span> 秒
						"<h2><a href='javascript:imgInfo("+num3+")'>"+o.g_describe+"</a></h2><span id='timer3' style='color:red'></span>"
				)
			})
			
			var num4=0;
			$.each(data.map4.listGoods,function(i, o){
				//alert(o.g_ID)
				num4=o.g_ID;
					$(".s_img4").append(//<a href="#"><img src="images/tm_b2.jpg" width="242" height="356" /></a>
							"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='242' height='356' /></a>"
					)
					$(".s_price4").append(//<a href="#"><img src="images/tm_3.jpg" width="185" height="155" /></a>
							"￥<span>"+o.g_g_price+"</span>"
					)	
			})
			$.each(data.map4.listG_son,function(i, o){
				$(".s_name4").append(// <h2><a href="#">沙宣洗发水</a></h2>倒计时：<span>1200</span> 时 <span>30</span> 分 <span>28</span> 秒
						"<h2><a href='javascript:imgInfo("+num4+")'>"+o.g_describe+"</a></h2><span id='timer4' style='color:red'></span>"
				)
			})
			
			var num5=0;
			$.each(data.map5.listGoods,function(i, o){
				//alert(o.g_ID)
				num5=o.g_ID;
					$(".s_img5").append(//<a href="#"><img src="images/tm_b2.jpg" width="242" height="356" /></a>
							"<a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a>"
					)
					$(".s_price5").append(//<a href="#"><img src="images/tm_3.jpg" width="185" height="155" /></a>
							"￥<span>"+o.g_g_price+"</span>"
					)	
			})
			$.each(data.map5.listG_son,function(i, o){
				$(".s_name5").append(// <h2><a href="#">沙宣洗发水</a></h2>倒计时：<span>1200</span> 时 <span>30</span> 分 <span>28</span> 秒
						"<h2><a href='javascript:imgInfo("+num5+")'>"+o.g_describe+"</a></h2><span id='timer5' style='color:red'></span>"
				)
			})
			
		}
	})
}

//倒计时方法
function CountDown0() {
    if (maxtime >= 0) {
        hour=Math.floor(maxtime/60/60%24)
        minutes = Math.floor(maxtime /60%60);
        seconds = Math.floor(maxtime % 60);
        msg = "倒计时：" +hour+"小时"+minutes + "分" + seconds + "秒";
        document.all["timer0"].innerHTML = msg;
        if (maxtime == 5 * 60) alert("还剩5分钟");
        --maxtime;
    } else {
        clearInterval(timer0);
        alert("时间到，结束!");
    }
}
function CountDown1() {
    if (maxtime >= 0) {
        hour=Math.floor(maxtime/60/60%24)
        minutes = Math.floor(maxtime /60%60);
        seconds = Math.floor(maxtime % 60);
        msg = "倒计时：" +hour+"小时"+minutes + "分" + seconds + "秒";
        document.all["timer1"].innerHTML = msg;
        if (maxtime == 5 * 60) alert("还剩5分钟");
        --maxtime;
    } else {
        clearInterval(timer1);
        alert("时间到，结束!");
    }
}
function CountDown2() {
	if (maxtime >= 0) {
		hour=Math.floor(maxtime/60/60%24)
		minutes = Math.floor(maxtime /60%60);
		seconds = Math.floor(maxtime % 60);
		msg = "倒计时：" +hour+"小时"+minutes + "分" + seconds + "秒";
		document.all["timer2"].innerHTML = msg;
		if (maxtime == 5 * 60) alert("还剩5分钟");
		--maxtime;
	} else {
		clearInterval(timer2);
		alert("时间到，结束!");
	}
}
function CountDown3() {
	if (maxtime >= 0) {
		hour=Math.floor(maxtime/60/60%24)
		minutes = Math.floor(maxtime /60%60);
		seconds = Math.floor(maxtime % 60);
		msg = "倒计时：" +hour+"小时"+minutes + "分" + seconds + "秒";
		document.all["timer3"].innerHTML = msg;
		if (maxtime == 5 * 60) alert("还剩5分钟");
		--maxtime;
	} else {
		clearInterval(timer3);
		alert("时间到，结束!");
	}
}
function CountDown4() {
	if (maxtime >= 0) {
		hour=Math.floor(maxtime/60/60%24)
		minutes = Math.floor(maxtime /60%60);
		seconds = Math.floor(maxtime % 60);
		msg = "倒计时：" +hour+"小时"+minutes + "分" + seconds + "秒";
		document.all["timer4"].innerHTML = msg;
		if (maxtime == 5 * 60) alert("还剩5分钟");
		--maxtime;
	} else {
		clearInterval(timer4);
		alert("时间到，结束!");
	}
}
function CountDown5() {
	if (maxtime >= 0) {
		hour=Math.floor(maxtime/60/60%24)
		minutes = Math.floor(maxtime /60%60);
		seconds = Math.floor(maxtime % 60);
		msg = "倒计时：" +hour+"小时"+minutes + "分" + seconds + "秒";
		document.all["timer5"].innerHTML = msg;
		if (maxtime == 5 * 60) alert("还剩5分钟");
		--maxtime;
	} else {
		clearInterval(timer5);
		alert("时间到，结束!");
	}
}

//男装
function index4(){//<a href="#">进口咖啡</a>&nbsp; &nbsp; &nbsp; <a href="#">进口酒</a>&nbsp; &nbsp; &nbsp; <a href="#">进口母婴</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜蔬菜</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜水果</a>
	//alert(456)              
	$.post("Goods.do",{"opr":"showindex"},function(data){
		$.each(data.listG_sort2,function(i,o){ 
			//alert(999)
			$("#toom").append("<a href='javascript:GoodssInfo("+o.g_sort2ID+","+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"&nbsp; &nbsp; &nbsp;</a>");
		})
	},"json")
	//<a href="#"><img src="images/fre_r.jpg" width="211" height="286" />
	$.post("Goods.do",{"opr":"showindex1","g_sonID":6},function(data){
		$.each(data,function(i,o){		
			$(".Nanzhuang0").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			$(".Nanzhuang1").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			$(".Nanzhuang2").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			
			
		})
	},"json")
	$.post("Goods.do",{"opr":"shownanzhuang","g_sort1ID":1},function(date){
			
				$.each(date,function(i,o){
					$(".nan_txt_c").append( //<a href="#">进口水果</a><a href="#">奇异果</a><a href="#">西柚</a><a href="#">海鲜水产</a><a href="#">品质牛肉</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">进口酒</a><a href="#">进口奶粉</a><a href="#">鲜活禽蛋</a>
							"<a href='javascript:showopo("+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"</a>"
					)
				})
	},"json")
	
	
	/*<div class="name"><a href="#">新鲜美味  进口美食</a></div>
    <div class="price">
    	<font>￥<span>198.00</span></font> &nbsp; 26R
    </div>
    <div class="img"><a href="#"><img src="images/fre_1.jpg" width="185" height="155" /></a></div>*/
	var number=[1,2,3,4,5,6];
	$.ajax({
		"url"       :  "Goods.do?opr=showG_son1", //请求路径
		"type"      :  "GET", //请求方式
		"data"      :  {"number":JSON.stringify(number)}, //要发送的数据
		"async"     :false,//同步
		"timeout"   :9000,//等待时间
		"dataType"  :  "json", // 请求成功后返回的数据类型
		"success"   :  function(data){ //请求成功后调用的函数
			var num0=0;
			$.each(data.map0.listGoods,function(i, o){
				num0=o.g_ID;
				//alert(o.g_ID)
					$(".nan_zhuang0").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map0.listG_son,function(i, o){
				$(".nan_zhuang0").append(
						"<div class='name'><a href='javascript:imgInfo("+num0+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num1=0;
			$.each(data.map1.listGoods,function(i, o){
				num1=o.g_ID;
				//alert(o.g_ID)
					$(".nan_zhuang1").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map1.listG_son,function(i, o){
				$(".nan_zhuang1").append(
						"<div class='name'><a href='javascript:imgInfo("+num1+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num2=0;
			$.each(data.map2.listGoods,function(i, o){
				//alert(o.g_ID)
				num2=o.g_ID;
					$(".nan_zhuang2").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map2.listG_son,function(i, o){
				$(".nan_zhuang2").append(
						"<div class='name'><a href='javascript:imgInfo("+num2+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num3=0;
			$.each(data.map3.listGoods,function(i, o){
				//alert(o.g_ID)
				num3=o.g_ID;
					$(".nan_zhuang3").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map3.listG_son,function(i, o){
				$(".nan_zhuang3").append(
						"<div class='name'><a href='javascript:imgInfo("+num3+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num4=0;
			$.each(data.map4.listGoods,function(i, o){
				//alert(o.g_ID)
				num4=o.g_ID;
					$(".nan_zhuang4").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map4.listG_son,function(i, o){
				$(".nan_zhuang4").append(
						"<div class='name'><a href='javascript:imgInfo("+num4+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num5=0;
			$.each(data.map5.listGoods,function(i, o){
				//alert(o.g_ID)
				num5=o.g_ID;
					$(".nan_zhuang5").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map5.listG_son,function(i, o){
				$(".nan_zhuang5").append(
						"<div class='name'><a href='javascript:imgInfo("+num5+")'>"+o.g_describe+"</a></div>"
				)
			})
		}
	})	
	$.post("Goods.do",{"opr":"showImg","g_ID":10},function(data){
		//<a href="#"><img src="images/fre_b2.jpg" width="260" height="220" /></a>
		$($.parseJSON(data)).each(function(i,o){ 		//错误： Uncaught TypeError: Cannot use 'in'  解决方案：JSON字符串转换为JavaScript对象 $.each($.parseJSON(json), function(idx, obj) {     alert(obj.tagName); }); 还有一种就是使用eval
			$(".nan_zhuang6").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='260' height='220'/></a>");	
		})
	})
	$.post("Goods.do",{"opr":"showImg","g_ID":13},function(data){
		//alert(datt)<a href="#"><img src="images/fre_b1.jpg" width="260" height="220" /></a>
		$.each($.parseJSON(data),function(i,o){	//错误： Uncaught TypeError: Cannot use 'in'  解决方案：JSON字符串转换为JavaScript对象 $.each($.parseJSON(json), function(idx, obj) {     alert(obj.tagName); }); 还有一种就是使用eval
			$(".nan_zhuang7").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='260' height='220'/></a>");	
		})		
	})
}





//女装
function index5(){//<a href="#">咖啡</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">休闲零食</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">饼干糕点</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">冲饮谷物</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">营养保健</a>
	//alert(456)
	$.post("Goods.do",{"opr":"showindex"},function(data){
		$.each(data.listG_sort2,function(i,o){ 
			//alert(999)
			$("#toom1").append("<a href='javascript:GoodssInfo("+o.g_sort2ID+","+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"&nbsp; &nbsp; | &nbsp; &nbsp;</a>");
		})
	},"json")
	//<a href="#"><img src="images/fre_r.jpg" width="211" height="286" />
	$.post("Goods.do",{"opr":"showindex1","g_sonID":6},function(data){
		$.each(data,function(i,o){		
			$(".Nanzhuang3").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			$(".Nanzhuang4").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			$(".Nanzhuang5").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			
			
		})
	},"json")
	$.post("Goods.do",{"opr":"shownanzhuang","g_sort1ID":2},function(date){
			
				$.each(date,function(i,o){
					$(".nan_txt_c1").append( //<a href="#">洗发护发</a><a href="#">牙刷牙膏</a><a href="#">面膜</a><a href="#">补水面膜</a><a href="#">香水</a><a href="#">面霜</a><a href="#">洗面奶</a><a href="#">脱毛膏</a><a href="#">沐浴露</a>
							"<a href='javascript:showopo("+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"</a>"
					)
				})
	},"json")
	
	
	/*<div class="name"><a href="#">美宝莲粉饼</a></div>
                    <div class="price">
                    	<font>￥<span>260.00</span></font> &nbsp; 16R
                    </div>
                    <div class="img"><a href="#"><img src="images/make_1.jpg" width="185" height="155" /></a></div>*/
	var number=[7,8,9,10,11,12];
	$.ajax({
		"url"       :  "Goods.do?opr=showG_son1", //请求路径
		"type"      :  "GET", //请求方式
		"data"      :  {"number":JSON.stringify(number)}, //要发送的数据
		"async"     :false,//同步
		"timeout"   :9000,//等待时间
		"dataType"  :  "json", // 请求成功后返回的数据类型
		"success"   :  function(data){ //请求成功后调用的函数
			var num0=0;
			$.each(data.map0.listGoods,function(i, o){
				num0=o.g_ID;
				//alert(o.g_ID)
					$(".nan_zhuang8").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map0.listG_son,function(i, o){
				$(".nan_zhuang8").append(
						"<div class='name'><a href='javascript:imgInfo("+num0+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num1=0;
			$.each(data.map1.listGoods,function(i, o){
				//alert(o.g_ID)
				num1=o.g_ID;
					$(".nan_zhuang9").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map1.listG_son,function(i, o){
				$(".nan_zhuang9").append(
						"<div class='name'><a href='javascript:imgInfo("+num1+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num2=0;
			$.each(data.map2.listGoods,function(i, o){
				//alert(o.g_ID)
				num2=o.g_ID;
					$(".nan_zhuang10").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map2.listG_son,function(i, o){
				$(".nan_zhuang10").append(
						"<div class='name'><a href='javascript:imgInfo("+num2+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num3=0;
			$.each(data.map3.listGoods,function(i, o){
				//alert(o.g_ID)
				num3=o.g_ID;
					$(".nan_zhuang11").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map3.listG_son,function(i, o){
				$(".nan_zhuang11").append(
						"<div class='name'><a href='javascript:imgInfo("+num3+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num4=0;
			$.each(data.map4.listGoods,function(i, o){
				//alert(o.g_ID)
				num4=o.g_ID;
					$(".nan_zhuang12").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map4.listG_son,function(i, o){
				$(".nan_zhuang12").append(
						"<div class='name'><a href='javascript:imgInfo("+num4+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num5=0;
			$.each(data.map5.listGoods,function(i, o){
				//alert(o.g_ID)
				num5=o.g_ID;
					$(".nan_zhuang13").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map5.listG_son,function(i, o){
				$(".nan_zhuang13").append(
						"<div class='name'><a href='javascript:imgInfo("+num5+")'>"+o.g_describe+"</a></div>"
				)
			})
		}
	})	
	$.post("Goods.do",{"opr":"showImg","g_ID":16},function(data){
		//<a href="#"><img src="images/make_b1.jpg" width="260" height="220" /></a>
		$($.parseJSON(data)).each(function(i,o){ 		//错误： Uncaught TypeError: Cannot use 'in'  解决方案：JSON字符串转换为JavaScript对象 $.each($.parseJSON(json), function(idx, obj) {     alert(obj.tagName); }); 还有一种就是使用eval
			$(".nan_zhuang14").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='260' height='220'/></a>");	
		})
	})
	$.post("Goods.do",{"opr":"showImg","g_ID":17},function(data){
		//alert(datt)<a href="#"><img src="images/fre_b1.jpg" width="260" height="220" /></a>
		$.each($.parseJSON(data),function(i,o){	//错误： Uncaught TypeError: Cannot use 'in'  解决方案：JSON字符串转换为JavaScript对象 $.each($.parseJSON(json), function(idx, obj) {     alert(obj.tagName); }); 还有一种就是使用eval
			$(".nan_zhuang15").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='260' height='220'/></a>");	
		})		
	})
}

//童装
function index6(){//<a href="#">进口咖啡</a>&nbsp; &nbsp; &nbsp; <a href="#">进口酒</a>&nbsp; &nbsp; &nbsp; <a href="#">进口母婴</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜蔬菜</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜水果</a>
	//alert(456)
	$.post("Goods.do",{"opr":"showindex"},function(data){
		$.each(data.listG_sort2,function(i,o){ 
			//alert(999)
			$("#toom2").append("<a href='javascript:GoodssInfo("+o.g_sort2ID+","+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"&nbsp; &nbsp; &nbsp;</a>");
		})
	},"json")
	//<a href="#"><img src="images/fre_r.jpg" width="211" height="286" />
	$.post("Goods.do",{"opr":"showindex1","g_sonID":6},function(data){
		$.each(data,function(i,o){		
			$(".Nanzhuang6").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			$(".Nanzhuang7").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			$(".Nanzhuang8").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			
			
		})
	},"json")
	$.post("Goods.do",{"opr":"shownanzhuang","g_sort1ID":3},function(date){
			
				$.each(date,function(i,o){
					$(".nan_txt_c2").append( //<a href="#">进口水果</a><a href="#">奇异果</a><a href="#">西柚</a><a href="#">海鲜水产</a><a href="#">品质牛肉</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">进口酒</a><a href="#">进口奶粉</a><a href="#">鲜活禽蛋</a>
							"<a href='javascript:showopo("+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"</a>"
					)
				})
	},"json")
	
	
	/*<div class="name"><a href="#">新鲜美味  进口美食</a></div>
    <div class="price">
    	<font>￥<span>198.00</span></font> &nbsp; 26R
    </div>
    <div class="img"><a href="#"><img src="images/fre_1.jpg" width="185" height="155" /></a></div>*/
	var number=[1,2,3,4,5,6];
	$.ajax({
		"url"       :  "Goods.do?opr=showG_son1", //请求路径
		"type"      :  "GET", //请求方式
		"data"      :  {"number":JSON.stringify(number)}, //要发送的数据
		"async"     :false,//同步
		"timeout"   :9000,//等待时间
		"dataType"  :  "json", // 请求成功后返回的数据类型
		"success"   :  function(data){ //请求成功后调用的函数
			var num0=0;
			$.each(data.map0.listGoods,function(i, o){
				//alert(o.g_ID)
				num0=o.g_ID;
					$(".nan_zhuang16").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map0.listG_son,function(i, o){
				$(".nan_zhuang16").append(
						"<div class='name'><a href='javascript:imgInfo("+num0+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num1=0;
			$.each(data.map1.listGoods,function(i, o){
				//alert(o.g_ID)
				num1=o.g_ID;
					$(".nan_zhuang17").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map1.listG_son,function(i, o){
				$(".nan_zhuang17").append(
						"<div class='name'><a href='javascript:imgInfo("+num1+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num2=0;
			$.each(data.map2.listGoods,function(i, o){
				//alert(o.g_ID)
				num2=o.g_ID;
					$(".nan_zhuang18").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map2.listG_son,function(i, o){
				$(".nan_zhuang18").append(
						"<div class='name'><a href='javascript:imgInfo("+num2+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			
			var num3=0;
			$.each(data.map3.listGoods,function(i, o){
				//alert(o.g_ID)
				num3=o.g_ID;
					$(".nan_zhuang19").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map3.listG_son,function(i, o){
				$(".nan_zhuang19").append(
						"<div class='name'><a href='javascript:imgInfo("+num3+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num4=0;
			$.each(data.map4.listGoods,function(i, o){
				//alert(o.g_ID)
				num4=o.g_ID;
					$(".nan_zhuang20").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map4.listG_son,function(i, o){
				$(".nan_zhuang20").append(
						"<div class='name'><a href='javascript:imgInfo("+num4+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			var num5=0;
			$.each(data.map5.listGoods,function(i, o){
				//alert(o.g_ID)
				num5=o.g_ID;
					$(".nan_zhuang21").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map5.listG_son,function(i, o){
				$(".nan_zhuang21").append(
						"<div class='name'><a href='javascript:imgInfo("+num5+")'>"+o.g_describe+"</a></div>"
				)
			})
		}
	})	
	$.post("Goods.do",{"opr":"showImg","g_ID":10},function(data){
		//<a href="#"><img src="images/fre_b2.jpg" width="260" height="220" /></a>
		$($.parseJSON(data)).each(function(i,o){ 		//错误： Uncaught TypeError: Cannot use 'in'  解决方案：JSON字符串转换为JavaScript对象 $.each($.parseJSON(json), function(idx, obj) {     alert(obj.tagName); }); 还有一种就是使用eval
			$(".nan_zhuang22").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='260' height='220'/></a>");	
		})
	})
	$.post("Goods.do",{"opr":"showImg","g_ID":13},function(data){
		//alert(datt)<a href="#"><img src="images/fre_b1.jpg" width="260" height="220" /></a>
		$.each($.parseJSON(data),function(i,o){	//错误： Uncaught TypeError: Cannot use 'in'  解决方案：JSON字符串转换为JavaScript对象 $.each($.parseJSON(json), function(idx, obj) {     alert(obj.tagName); }); 还有一种就是使用eval
			$(".nan_zhuang23").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='260' height='220'/></a>");	
		})		
	})
}

//老年装
function index7(){//<a href="#">进口咖啡</a>&nbsp; &nbsp; &nbsp; <a href="#">进口酒</a>&nbsp; &nbsp; &nbsp; <a href="#">进口母婴</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜蔬菜</a>&nbsp; &nbsp; &nbsp; <a href="#">新鲜水果</a>
	//alert(456)
	$.post("Goods.do",{"opr":"showindex"},function(data){
		$.each(data.listG_sort2,function(i,o){ 
			//alert(999)
			$("#toom3").append("<a href='javascript:GoodssInfo("+o.g_sort2ID+","+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"&nbsp; &nbsp; &nbsp;</a>");
		})
	},"json")
	//<a href="#"><img src="images/fre_r.jpg" width="211" height="286" />
	$.post("Goods.do",{"opr":"showindex1","g_sonID":1},function(data){
		//alert(data)
		$.each(data,function(i,o){		
			$(".Nanzhuang9").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			$(".Nanzhuang10").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			$(".Nanzhuang11").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='211' height='286'/></a>");
			
			
		})
	},"json")
	$.post("Goods.do",{"opr":"shownanzhuang","g_sort1ID":4},function(date){
			
				$.each(date,function(i,o){
					$(".nan_txt_c3").append( //<a href="#">进口水果</a><a href="#">奇异果</a><a href="#">西柚</a><a href="#">海鲜水产</a><a href="#">品质牛肉</a><a href="#">奶粉</a><a href="#">鲜活禽蛋</a><a href="#">进口酒</a><a href="#">进口奶粉</a><a href="#">鲜活禽蛋</a>
							"<a href='javascript:showopo("+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"</a>"
					)
				})
	},"json")
	
	
	/*<div class="name"><a href="#">新鲜美味  进口美食</a></div>
    <div class="price">
    	<font>￥<span>198.00</span></font> &nbsp; 26R
    </div>
    <div class="img"><a href="#"><img src="images/fre_1.jpg" width="185" height="155" /></a></div>*/
	var number=[12,13,15,20,22,23];
	$.ajax({
		"url"       :  "Goods.do?opr=showG_son1", //请求路径
		"type"      :  "GET", //请求方式
		"data"      :  {"number":JSON.stringify(number)}, //要发送的数据
		"async"     :false,//同步
		"timeout"   :9000,//等待时间
		"dataType"  :  "json", // 请求成功后返回的数据类型
		"success"   :  function(data){ //请求成功后调用的函数
			var num0=0;
			$.each(data.map0.listGoods,function(i, o){
				//alert(o.g_ID)
				num0=o.g_ID;
					$(".nan_zhuang24").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map0.listG_son,function(i, o){
				$(".nan_zhuang24").append(
						"<div class='name'><a href='javascript:imgInfo("+num0+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			
			var num1=0;
			$.each(data.map1.listGoods,function(i, o){
				//alert(o.g_ID)
				num1=o.g_ID;
					$(".nan_zhuang25").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map1.listG_son,function(i, o){
				$(".nan_zhuang25").append(
						"<div class='name'><a href='javascript:imgInfo("+num1+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			
			var num2=0;
			$.each(data.map2.listGoods,function(i, o){
				//alert(o.g_ID)
				num2=o.g_ID;
					$(".nan_zhuang26").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map2.listG_son,function(i, o){
				$(".nan_zhuang26").append(
						"<div class='name'><a href='javascript:imgInfo("+num2+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			
			var num3=0;
			$.each(data.map3.listGoods,function(i, o){
				//alert(o.g_ID)
				num3=o.g_ID;
					$(".nan_zhuang27").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map3.listG_son,function(i, o){
				$(".nan_zhuang27").append(
						"<div class='name'><a href='javascript:imgInfo("+num3+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			
			var num4=0;
			$.each(data.map4.listGoods,function(i, o){
				//alert(o.g_ID)
				num4=o.g_ID;
					$(".nan_zhuang28").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map4.listG_son,function(i, o){
				$(".nan_zhuang28").append(
						"<div class='name'><a href='javascript:imgInfo("+num4+")'>"+o.g_describe+"</a></div>"
				)
			})
			
			
			var num5=0;
			$.each(data.map5.listGoods,function(i, o){
				//alert(o.g_ID)
				num5=o.g_ID;
					$(".nan_zhuang29").append(
							 "<div class='price'><font>￥<span>"+o.g_g_price+"</span></font> &nbsp;"+o.g_integral+"R</div>"+
							 "<div class='img'><a href='javascript:imgInfo("+o.g_ID+")'><img src='downFile.do?opr="+o.g_ID+"' width='185' height='155' /></a></div>"
					)
			})
			$.each(data.map5.listG_son,function(i, o){
				$(".nan_zhuang29").append(
						"<div class='name'><a href='javascript:imgInfo("+num5+")'>"+o.g_describe+"</a></div>"
				)
			})
		}
	})	
	$.post("Goods.do",{"opr":"showImg","g_ID":20},function(data){
		//<a href="#"><img src="images/fre_b2.jpg" width="260" height="220" /></a>
		$($.parseJSON(data)).each(function(i,o){ 		//错误： Uncaught TypeError: Cannot use 'in'  解决方案：JSON字符串转换为JavaScript对象 $.each($.parseJSON(json), function(idx, obj) {     alert(obj.tagName); }); 还有一种就是使用eval
			$(".nan_zhuang30").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='260' height='220'/></a>");	
		})
	})
	$.post("Goods.do",{"opr":"showImg","g_ID":23},function(data){
		//alert(datt)<a href="#"><img src="images/fre_b1.jpg" width="260" height="220" /></a>
		$.each($.parseJSON(data),function(i,o){	//错误： Uncaught TypeError: Cannot use 'in'  解决方案：JSON字符串转换为JavaScript对象 $.each($.parseJSON(json), function(idx, obj) {     alert(obj.tagName); }); 还有一种就是使用eval
			$(".nan_zhuang31").append("<a href='javascript:imgInfo("+o.g_ID+")'><img  src='downFile.do?opr="+o.g_ID+"' width='260' height='220'/></a>");	
		})		
	})
}
//跳转类型1 son
function showopo(key){
	switch (key) {
	case "雅鹿":
		window.location.href="GoodsInfo/G_son1.jsp";
		break;
	case "南极人":
		window.location.href="GoodsInfo/G_son2.jsp";
		break;
	case "红豆男装":
		window.location.href="GoodsInfo/G_son3.jsp";
		break;
	case "花花公子":
		window.location.href="GoodsInfo/G_son4.jsp";
		break;
	case "罗蒙":
		window.location.href="GoodsInfo/G_son5.jsp";
		break;
	case "七匹狼":
		window.location.href="GoodsInfo/G_son6.jsp";
		break;
	case "美特斯邦威":
		window.location.href="GoodsInfo/G_son7.jsp";
		break;
	case "美国苹果":
		window.location.href="GoodsInfo/G_son8.jsp";
		break;
	case "四川拍拍衣":
		window.location.href="GoodsInfo/G_son9.jsp";
		break;
	case "才子男装":
		window.location.href="GoodsInfo/G_son10.jsp";
		break;
	case "鼎度":
		window.location.href="GoodsInfo/G_son11.jsp";
		break;
	case "尊尚鸟":
		window.location.href="GoodsInfo/G_son12.jsp";
		break;
	}
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

//跳转类型3 商品详情
function imgInfo(g_ID){
	window.location.href="Goods.do?opr=showProduct&g_ID="+g_ID
}