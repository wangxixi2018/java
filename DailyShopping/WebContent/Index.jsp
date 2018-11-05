<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<!-- xmlns 是用来定义xml namespace属性的。xmlns 属性在 XHTML 中是必需的。不过即使你的 XHTML 文档没有使用此属性，W3C 的验证器也不会报错。因为 "xmlns=http://www.w3.org/1999/xhtml" 是一个固定值，所以，即使你没有包含它，此值也会被添加到 <html> 标签中。--><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]--> 
  
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="item/js/newstest.js"></script>
    
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
    
	<script type="text/javascript" src="js/lrscroll.js"></script>
    
    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>
    
	<script type="text/javascript" src="js/lrscroll_1.js"></script>
    <script type="text/javascript" src="js/indexGoods.js"></script>  
    <script type="text/javascript">
    	$(function(){
    		var counts=0;
        	for(var i=0;i<$(".goodscount").length;i=i+1){
        		counts = counts+parseInt(($(".goodscount:eq('"+i+"')")).html());
        	}
        	$("#shows_carcounts").html(counts);
        	total();
    	})
    	
    	function total(){
    		var pricses=0;
    		for(var i=0;i<$(".goodsprice").length;i=i+1){
    			pricses = pricses + (parseInt(jq(".goodscount:eq('"+i+"')").html())*parseFloat(jq(".goodsprice:eq('"+i+"')").html()));
    		}
    		var pricses1 = parseFloat(pricses).toFixed(2);
    		$("#showallgoodsprice").html(pricses1);
    	}
    </script>
<title>天天易购</title>
</head>
<body>  
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
    	<!--Begin 所在收货地区 Begin-->
    	<span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
        		<c:set var="users" value="${user}" scope="session"></c:set>
        	<span class="fl">
        	<c:if test="${not empty users}">
        		<c:if test="${not empty users.u_nc}">
        			欢迎您:<a href="${pageContext.request.contextPath}/user/user.jsp">${users.u_nc}</a>
        		</c:if>
        		<c:if test="${empty users.u_nc}">
        			欢迎您:<a href="${pageContext.request.contextPath}/user/user.jsp">${users.u_loginName}</a>
        		</c:if>	
        		&nbsp;<a href="user.do?opr=outLogin">退出</a>
        	</c:if>
        	<c:if test="${empty users}">
        		你好，请<a href="Login.html">登录</a>&nbsp; <a href="Regist.html" style="color:#ff4e00;">免费注册</a>
        	</c:if>
        	&nbsp;|&nbsp;<a href="Index.jsp">首页</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/user/user.jsp">个人中心</a>&nbsp;|</span>
        	<span class="ss">
            	<div class="ss_list">
                	<a href="#">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">我的收藏夹</a></li>
                                <li><a href="#">我的收藏夹</a></li>
                            </ul>
                        </div>
                    </div>     
                </div>
                <div class="ss_list">
                	<a href="#">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="Index.html"><img src="images/titiyigou_logo.png" /></a></div>
    <div class="search">
    	<form>
        	<input type="text" value="" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn" />
        </form>                     
        <span class="fl" id="index1"></span>
    </div>
    <div class="i_car">
    	<c:if test="${not empty users}">
    		<div class="car_t">购物车 [ <span id="shows_carcounts"></span> ]</div>
    	</c:if>
    	<c:if test="${empty users}">
    		<div class="car_t">购物车 [ <span>0</span> ]</div>
    	</c:if>
        <div class="car_bg">
       		<!--Begin 购物车已登录 Begin-->
       		<c:if test="${not empty users}">
       			<ul class="cars">
            <c:forEach items="${s_carList}" var="s_carLists">
            	<li>
                	<div class="img"><a href="#"><img src="images/car1.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">${s_carLists.g_name}  ${s_carLists.g_sortofsex }  ${s_carLists.g_sortofstyle}  ${s_carLists.g_size}  ${s_carLists.g_color}</a></div>
                    <div class="price"><font color="#ff4e00">￥<span class="goodsprice">${s_carLists.g_price}</span></font> X <span class="goodscount">${s_carLists.goods_count}</span></div>
                </li>
            </c:forEach>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span id="showallgoodsprice"></span></div>
            <div class="price_a"><a href="/DailyShopping/buycar/buycar.jsp">去购物车结算</a></div>
       		</c:if>
       		<!--End 购物车已登录 End-->
            <!--End 购物车未登录 End-->
            <c:if test="${empty users}">
            	<div class="un_login">还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
            </c:if>
            <!--Begin 购物车未登录 Begin-->
        </div>
    </div>
</div>
<!--End Header End--> 
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品品牌详情 Begin-->    
    	<div class="nav">
    	  <div class="nav_t">天天易购全部商品</div>
            <div class="leftNav">
                <ul>      
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="images/nav1.png" /></span>
                            <span class="fl"  id="0"></span>
                        </div>      
                        <div class="zj">
                         <div class="zj_l">
                                <div class="zj_l_c">                               
                                    <h2 class="Info0"></h2>
                                    <c:forEach items="${applicationScope.listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach> 
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info1"></h2>  
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info2"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info3"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info4"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="zj_r1">   
                            	<c:url value="downFile.do?opr=1"  var="img1"></c:url>
                       				 <a href="Goods.do?opr=showProduct&g_ID=1"><img src="${img1}" width="236" height="200" /></a>
                    			<c:url value="downFile.do?opr=2" var="img2"></c:url>    
                       				 <a href="Goods.do?opr=showProduct&g_ID=2"><img src="${img2}" width="236" height="200" /></a>         
                            </div>                  
                        </div>
                    </li>
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="images/nav2.png" /></span>
                            <span class="fl"  id="1"></span>
                        </div>
                        <div class="zj" style="top:-40px;">
                            <div class="zj_l">
                                <div class="zj_l_c">                               
                                    <h2 class="Info0"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info1"></h2>  
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info2"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info3"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info4"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="zj_r1">   
                            	<c:url value="downFile.do?opr=3"  var="img1"></c:url>
                       				 <a href="Goods.do?opr=showProduct&g_ID=3"><img src="${img1}" width="236" height="200" /></a>
                    			<c:url value="downFile.do?opr=4" var="img2"></c:url>    
                       				 <a href="Goods.do?opr=showProduct&g_ID=4"><img src="${img2}" width="236" height="200" /></a>         
                            </div>  
                        </div>
                    </li>
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="images/nav3.png" /></span>
                            <span class="fl"  id="2"></span>
                        </div>
                        <div class="zj" style="top:-80px;">
                            <div class="zj_l">
                                <div class="zj_l_c">                               
                                    <h2 class="Info0"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info1"></h2>  
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info2"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info3"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info4"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="zj_r1">   
                            	<c:url value="downFile.do?opr=5"  var="img1"></c:url>
                       				 <a href="Goods.do?opr=showProduct&g_ID=5"><img src="${img1}" width="236" height="200" /></a>
                    			<c:url value="downFile.do?opr=6" var="img2"></c:url>    
                       				 <a href="Goods.do?opr=showProduct&g_ID=6"><img src="${img2}" width="236" height="200" /></a>         
                            </div>  
                        </div>
                    </li>
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="images/nav4.png" /></span>
                            <span class="fl"  id="3"></span>
                        </div>
                        <div class="zj" style="top:-120px;">
                            <div class="zj_l">
                                <div class="zj_l_c">                               
                                    <h2 class="Info0"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info1"></h2>  
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info2"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info3"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                                <div class="zj_l_c">
                                    <h2 class="Info4"></h2>
                                    <c:forEach items="${listG_son}" var="u" varStatus="num">
                                   	 <a href="${pageContext.request.contextPath}/GoodsInfo/G_son${num.count}.jsp" class="">${u.g_sName }</a>|
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="zj_r1">   
                            	<c:url value="downFile.do?opr=7"  var="img1"></c:url>
                       				 <a href="Goods.do?opr=showProduct&g_ID=7"><img src="${img1}" width="236" height="200" /></a>
                    			<c:url value="downFile.do?opr=8" var="img2"></c:url>    
                       				 <a href="Goods.do?opr=showProduct&g_ID=8"><img src="${img2}" width="236" height="200" /></a>         
                            </div>
                        </div>       
                    </li>           	
                </ul>            
            </div>    
        </div>  
        <!--End 商品分类详情 End-->                                                     
    	<ul class="menu_r">                                                                                                                                               
        	<li><a href="Index.jsp">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/GoodsInfo/G_son1.jsp" class="menu_r0"></a></li>
            <li><a href="${pageContext.request.contextPath}/GoodsInfo/G_son2.jsp" class="menu_r1"></a></li>
            <li><a href="${pageContext.request.contextPath}/GoodsInfo/G_son3.jsp" class="menu_r2"></a></li>
            <li><a href="${pageContext.request.contextPath}/GoodsInfo/G_son4.jsp" class="menu_r3"></a></li>
            <li><a href="${pageContext.request.contextPath}/GoodsInfo/G_son5.jsp" class="menu_r4"></a></li>
            <li><a href="${pageContext.request.contextPath}/GoodsInfo/G_son6.jsp" class="menu_r5"></a></li>
            <li><a href="${pageContext.request.contextPath}/GoodsInfo/G_son7.jsp" class="menu_r6"></a></li>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End--> 
<div class="i_bg bg_color">
	<div class="i_ban_bg">
		<!--Begin Banner Begin-->
    	<div class="banner">    	
            <div class="top_slide_wrap">
                <ul class="slide_box bxslider"> <!-- 轮播图片 -->
                    <li><img src="images/timg111.jpg" width="740" height="401" /></li>
                    <li><img src="images/timg222.jpg" width="740" height="401" /></li> 
                    <li><img src="images/timg333.jpg" width="740" height="401" /></li> 
                </ul>	
                <div class="op_btns clearfix">
                    <a href="#" class="op_btn op_prev"><span></span></a>
                    <a href="#" class="op_btn op_next"><span></span></a>
                </div>        
            </div>
        </div>
        <script type="text/javascript">
        //var jq = jQuery.noConflict();
        (function(){
            $(".bxslider").bxSlider({
                auto:true,
                prevSelector:jq(".top_slide_wrap .op_prev")[0],nextSelector:jq(".top_slide_wrap .op_next")[0]
            });
        })();
        </script>
        <!--End Banner End-->
        <div class="inews">
        	<div class="news_t">
            	<span class="fr"><a href="#">更多 ></a></span>新闻资讯
            </div>
            <ul class="newsList">
            	<!-- <li><span>[ 特惠 ]</span><a href="#">掬一轮明月 表无尽惦念</a></li>
            	<li><span>[ 公告 ]</span><a href="#">好奇金装成长裤新品上市</a></li>
            	<li><span>[ 特惠 ]</span><a href="#">大牌闪购 · 抢！</a></li>
            	<li><span>[ 公告 ]</span><a href="#">发福利 买车就抢千元油卡</a></li>
            	<li><span>[ 公告 ]</span><a href="#">家电低至五折</a></li> -->
            </ul>
            <div class="charge_t">
            	话费充值<div class="ch_t_icon"></div>
            </div>
            <form>
            <table border="0" style="width:205px; margin-top:10px;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td width="33">号码</td>
                <td><input type="text" value="" class="c_ipt" /></td>
              </tr>
              <tr height="35">
                <td>面值</td>
                <td>
                	<select class="jj" name="city">
                      <option value="0" selected="selected">100元</option>
                      <option value="1">50元</option>
                      <option value="2">30元</option>
                      <option value="3">20元</option>
                      <option value="4">10元</option>
                    </select>
                    <span style="color:#ff4e00; font-size:14px;">￥99.5</span>
                </td>
              </tr>
              <tr height="35">
                <td colspan="2"><input type="submit" value="立即充值" class="c_btn" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
    <!--Begin 热门商品 Begin-->
    <div class="content mar_10">
    	<div class="h_l_img">
        	<div class="img" id="img20"></div>
            <div class="pri_bg">
            </div>
        </div>
        <div class="hot_pro">        	
        	<div id="featureContainer">
                <div id="feature">
                    <div id="block">
                        <div id="botton-scroll">
                            <ul class="featureUL">
                                <li class="featureBox">
                                    <div class="box">
                                    	<div class="h_icon"><img src="images/hot.png" width="50" height="50" /></div>
                                        <div  class="imgbg hoop0">
                                        	
                                        </div>                                        
                                        <div class="name name0">
                                        	
                                        </div>
                                        <div class="price price0">
                                           
                                        </div>
                                    </div>
                                </li>
                                <li class="featureBox">
                                    <div class="box">
                                        <div class="h_icon"><img src="images/hot.png" width="50" height="50" /></div>
                                        <div class="imgbg hoop1" >
                                        	
                                        </div>                                        
                                        <div class="name name1" >
                                        
                                        </div>
                                        <div class="price price1">
                                            
                                        </div>
                                    </div>
                                </li>
                                <li class="featureBox">
                                    <div class="box">
                                        <div class="h_icon"><img src="images/hot.png" width="50" height="50" /></div>
                                        <div class="imgbg hoop2">
                                        	
                                        </div>                                        
                                        <div class="name name2">
                                      
                                        </div>
                                        <div class="price price2">
                                            
                                        </div>
                                    </div>
                                </li>
                                <li class="featureBox">
                                    <div class="box">
                                        <div class="h_icon"><img src="images/hot.png" width="50" height="50" /></div>
                                        <div class="imgbg hoop3">
                                        	
                                        </div>                                        
                                        <div class="name name3">
                                        	
                                        </div>
                                        <div class="price price3" >
                                           
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <a class="h_prev" href="javascript:void();">Previous</a>
                    <a class="h_next" href="javascript:void();">Next</a>
                </div>
            </div>
        </div>
    </div>
    <!--Begin 限时特卖 Begin-->
    <div class="i_t mar_10">
    	<span class="fl">限时特卖</span>
        <span class="i_mores fr"><a href="#">更多</a></span>
    </div>
    <div class="content">
    	<div class="i_sell">
            <div id="imgPlay">
                <ul class="imgs" id="actor">
                    <li class="img20"></li>
                    <li class="img21"></li>
                    <li class="img22"></li>
                </ul>
                <div class="previ">上一张</div>
                <div class="nexti">下一张</div>
            </div>        
        </div>
        <div class="sell_right">
        	<div class="sell_1">
            	<div class="s_img s_img0"></div>
            	<div class="s_price s_price0" ></div>
                <div class="s_name s_name0">
                	
                </div>
            </div>
            <div class="sell_2">
            	<div class="s_img s_img1"></div>
            	<div class="s_price s_price1"></div>
                <div class="s_name s_name1">
                	
                </div>
            </div>
            <div class="sell_b1">
            	<div class="sb_img s_img2"></div>
            	<div class="s_price s_price2"></div>
                <div class="s_name s_name2">
                </div>
            </div>
            <div class="sell_3" >
            	<div class="s_img s_img3"></div>
            	<div class="s_price s_price3"></div>
                <div class="s_name s_name3">
                </div>
            </div>
            <div class="sell_4">
            	<div class="s_img s_img4"></div>
            	<div class="s_price s_price4"></div>
                <div class="s_name s_name4">
                </div>
            </div>
            <div class="sell_b2">
            	<div class="sb_img s_img5"></div>
            	<div class="s_price s_price5"></div>
                <div class="s_name s_name5">
                </div>
            </div>
        </div>
    </div>
    <!--End 限时特卖 End-->
    <div class="content mar_20">
    	<img src="images/mban_1.jpg" width="1200" height="110" />
    </div>
	<!--Begin 男装 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">1F</span>
    	<span class="fl"> <b>·</b> 男装</span>                
        <span class="i_mores fr" id="toom"></span>
    </div>
    <div class="content">
    	<div class="fresh_left">
        	<div class="fre_ban">
            	<div id="imgPlay1">
                    <ul class="imgs" id="actor1">
                        <li class="Nanzhuang0"></li>
                        <li class="Nanzhuang1"></li>
                        <li class="Nanzhuang2"></li>
                    </ul>
                    <div class="prevf">上一张</div>
                    <div class="nextf">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c nan_txt_c">
                	
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<li class="nan_zhuang0">
                	
                </li>
                <li class="nan_zhuang1">
                	
                </li>
                <li class="nan_zhuang2">
                	
                </li>
                <li class="nan_zhuang3">
                	
                </li>
                <li class="nan_zhuang4">
                	
                </li>
                <li class="nan_zhuang5">
                	
                </li>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li class="nan_zhuang6"></li>
                <li class="nan_zhuang7"></li>
            </ul>
        </div>
    </div>    
    <!--End 进口 生鲜 End-->
    <!--Begin 食品饮料 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">2F</span>
    	<span class="fl">女装</span>                                
        <span class="i_mores fr" id="toom1"></span>
    </div>
    <div class="content">
    	<div class="food_left">
        	<div class="food_ban">
            	<div id="imgPlay2">
                    <ul class="imgs" id="actor2">
                        <li class="Nanzhuang3"></li>
                        <li class="Nanzhuang4"></li>
                        <li class="Nanzhuang5"></li>
                    </ul>
                    <div class="prev_f">上一张</div>
                    <div class="next_f">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c nan_txt_c1">
                	
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<li class="nan_zhuang8">
                	
                </li>
                <li class="nan_zhuang9">
                	
                </li>
                <li class="nan_zhuang10">
                	
                </li>
                <li class="nan_zhuang11">
                	
                </li>
                <li class="nan_zhuang12">
                	
                </li>
                <li class="nan_zhuang13">
                	
                </li>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li class="nan_zhuang14"></li>
                <li class="nan_zhuang15"></li>
            </ul>
        </div>
    </div>    
    <!--End 食品饮料 End-->
    <!--Begin 个人美妆 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">3F</span>
    	<span class="fl">童装</span>                                
        <span class="i_mores fr" id="toom2"></span>                
    </div>
    <div class="content">
    	<div class="make_left">
        	<div class="make_ban">
            	<div id="imgPlay3">
                    <ul class="imgs" id="actor3">
                        <li class="Nanzhuang6"></li>
                        <li class="Nanzhuang7"></li>
                        <li class="Nanzhuang8"></li>
                    </ul>
                    <div class="prev_m">上一张</div>
                    <div class="next_m">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c nan_txt_c2">
                	
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<li class="nan_zhuang16">
                	
                </li>
                <li class="nan_zhuang17">
                	
                </li>
                <li class="nan_zhuang18">
                	
                </li>
                <li class="nan_zhuang19">
                	
                </li>
                <li class="nan_zhuang20">
                	
                </li>
                <li class="nan_zhuang21">
                	
                </li>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li class="nan_zhuang22"></li>
                <li class="nan_zhuang23"></li>
            </ul>
        </div>
    </div>    
    <!--End 个人美妆 End-->
    <div class="content mar_20">
    	<img src="images/mban_1.jpg" width="1200" height="110" />
    </div>
    <!--Begin 母婴玩具 Begin-->
    <div class="i_t mar_10">
    	<span class="floor_num">4F</span>
    	<span class="fl">老年装</span>                                
        <span class="i_mores fr" id="toom3"></span>                               
    </div>
    <div class="content">
    	<div class="baby_left">
        	<div class="baby_ban">
            	<div id="imgPlay4">
                    <ul class="imgs" id="actor4">
                        <li class="Nanzhuang9"></li>
                        <li class="Nanzhuang10"></li>
                        <li class="Nanzhuang11"></li>
                    </ul>
                    <div class="prev_b">上一张</div>
                    <div class="next_b">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c nan_txt_c3">
                	
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<li class="nan_zhuang24">
                	
                </li>
                <li class="nan_zhuang25">
                	
                </li>
                <li class="nan_zhuang26">
                	
                </li>
                <li class="nan_zhuang27">
                	
                </li>
                <li class="nan_zhuang28">
                	
                </li>
                <li class="nan_zhuang29">
                	
                </li>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li class="nan_zhuang30"></li>
                <li class="nan_zhuang31"></li>
            </ul>
        </div>
    </div>
    
        
        
        
        
        
    <!--End 母婴玩具 End-->
    <!--Begin 家居生活 Begin-->
    <!-- <div class="i_t mar_10">
    	<span class="floor_num">5F</span>
    	<span class="fl">家居生活</span>                                
        <span class="i_mores fr"><a href="#">床上用品</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">家纺布艺</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">餐具</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">沙发</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">汽车用品</a></span>                                              
    </div>
    <div class="content">
    	<div class="home_left">
        	<div class="home_ban">
            	<div id="imgPlay5">
                    <ul class="imgs" id="actor5">
                        <li><a href="#"><img src="images/home_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/home_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/home_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prev_h">上一张</div>
                    <div class="next_h">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
                	<a href="#">床上用品</a><a href="#">家纺布艺</a><a href="#">餐具水具</a><a href="#">锅具厨具</a><a href="#">沙发</a><a href="#">书柜</a><a href="#">狗粮</a><a href="#">家装建材</a><a href="#">汽车用品</a>
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<li>
                	<div class="name"><a href="#">品质蓝色沙发</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 50R
                    </div>
                    <div class="img"><a href="#"><img src="images/home_1.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">品质蓝色沙发</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 50R
                    </div>
                    <div class="img"><a href="#"><img src="images/home_2.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">品质蓝色沙发</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 50R
                    </div>
                    <div class="img"><a href="#"><img src="images/home_3.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">品质蓝色沙发</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 50R
                    </div>
                    <div class="img"><a href="#"><img src="images/home_4.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">品质蓝色沙发</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 50R
                    </div>
                    <div class="img"><a href="#"><img src="images/home_5.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">品质蓝色沙发</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 50R
                    </div>
                    <div class="img"><a href="#"><img src="images/home_6.jpg" width="185" height="155" /></a></div>
                </li>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/home_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/home_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
    </div>    
    End 家居生活 End
    Begin 数码家电 Begin
    <div class="i_t mar_10">
    	<span class="floor_num">6F</span>
    	<span class="fl">数码家电</span>                                
        <span class="i_mores fr"><a href="#">手机</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">苹果</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">华为手机</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">洗衣机</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">数码配件</a></span>                                               
    </div>
    <div class="content">
    	<div class="tel_left">
        	<div class="tel_ban">
            	<div id="imgPlay6">
                    <ul class="imgs" id="actor6">
                        <li><a href="#"><img src="images/tel_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/tel_r.jpg" width="211" height="286" /></a></li>
                        <li><a href="#"><img src="images/tel_r.jpg" width="211" height="286" /></a></li>
                    </ul>
                    <div class="prev_t">上一张</div>
                    <div class="next_t">下一张</div> 
                </div>   
            </div>
            <div class="fresh_txt">
            	<div class="fresh_txt_c">
                	<a href="#">手机</a><a href="#">平板电脑</a><a href="#">空调</a><a href="#">合约机</a><a href="#">电风扇</a><a href="#">数码配件</a><a href="#">洗衣机</a><a href="#">电视</a><a href="#">充电器</a><a href="#">耳线</a>
                </div>
            </div>
        </div>
        <div class="fresh_mid">
        	<ul>
            	<li>
                	<div class="name"><a href="#">乐视高清电视</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 25R
                    </div>
                    <div class="img"><a href="#"><img src="images/tel_1.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">乐视高清电视</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 25R
                    </div>
                    <div class="img"><a href="#"><img src="images/tel_2.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">乐视高清电视</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 25R
                    </div>
                    <div class="img"><a href="#"><img src="images/tel_3.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">乐视高清电视</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 25R
                    </div>
                    <div class="img"><a href="#"><img src="images/tel_4.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">乐视高清电视</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 25R
                    </div>
                    <div class="img"><a href="#"><img src="images/tel_5.jpg" width="185" height="155" /></a></div>
                </li>
                <li>
                	<div class="name"><a href="#">乐视高清电视</a></div>
                    <div class="price">
                    	<font>￥<span>2160.00</span></font> &nbsp; 25R
                    </div>
                    <div class="img"><a href="#"><img src="images/tel_6.jpg" width="185" height="155" /></a></div>
                </li>
            </ul>
        </div>
        <div class="fresh_right">
        	<ul>
            	<li><a href="#"><img src="images/tel_b1.jpg" width="260" height="220" /></a></li>
                <li><a href="#"><img src="images/tel_b2.jpg" width="260" height="220" /></a></li>
            </ul>
        </div>
    </div>    
    End 数码家电 End
    Begin 猜你喜欢 Begin
    <div class="i_t mar_10">
    	<span class="fl">猜你喜欢</span>
    </div>    
    <div class="like">        	
        <div id="featureContainer1">
            <div id="feature1">
                <div id="block1">
                    <div id="botton-scroll1">
                        <ul class="featureUL">
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot1.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>德国进口</h2>
                                        德亚全脂纯牛奶200ml*48盒
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>189</span></font> &nbsp; 26R
                                    </div>
                                </div>
                            </li>
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot2.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>iphone 6S</h2>
                                        Apple/苹果 iPhone 6s Plus公开版
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>5288</span></font> &nbsp; 25R
                                    </div>
                                </div>
                            </li>
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot3.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>倩碧特惠组合套装</h2>
                                        倩碧补水组合套装8折促销
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>368</span></font> &nbsp; 18R
                                    </div>
                                </div>
                            </li>
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot4.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>品利特级橄榄油</h2>
                                        750ml*4瓶装组合 西班牙原装进口
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>280</span></font> &nbsp; 30R
                                    </div>
                                </div>
                            </li>
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot4.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>品利特级橄榄油</h2>
                                        750ml*4瓶装组合 西班牙原装进口
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>280</span></font> &nbsp; 30R
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <a class="l_prev" href="javascript:void();">Previous</a>
                <a class="l_next" href="javascript:void();">Next</a>
            </div>
        </div>
    </div> -->
    <!--End 猜你喜欢 End-->
    
    <!--Begin Footer Begin -->
    <div class="b_btm_bg b_btm_c">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>
              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b4.png" width="62" height="62" /></td>
                <td><h2>准时送达</h2>收货时间由你做主</td>
              </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
    	<dl>                                                                                            
        	<dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
        	<a href="#" class="b_sh1">新浪微博</a>            
        	<a href="#" class="b_sh2">腾讯微博</a>
            <p>
            服务热线：<br />
            <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="images/er.gif" width="118" height="118" /></div>
            <img src="images/ss.png" />
        </div>
    </div>    
    <div class="btmbg">
		<div class="btm">
        	备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
        </div>    	
    </div>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>


