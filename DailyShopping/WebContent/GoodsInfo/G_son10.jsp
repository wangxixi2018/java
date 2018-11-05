<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/G_sort.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>    
            
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lrscroll_1.js"></script>
    
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/n_nav.js"></script>    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/milk_ban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/paper_ban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/baby_ban.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/G_son10.js"></script>
    
<title>才子男装</title>
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
        		&nbsp;<a href="${pageContext.request.contextPath}/user.do?opr=outLogin">退出</a>
        	</c:if>
        	<c:if test="${empty users}">
        		你好，请<a href="${pageContext.request.contextPath}/Login.html">登录</a>&nbsp; <a href="Regist.html" style="color:#ff4e00;">免费注册</a>
        	</c:if>
        	&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/Index.jsp">首页</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/user/user.jsp">个人中心</a>&nbsp;|</span>
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
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="${pageContext.request.contextPath}/images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="Index.html"><img src="${pageContext.request.contextPath}/images/titiyigou_logo.png" /></a></div>
    <div class="search">
    	<form>
        	<input type="text" value="" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn" />
        </form>                      
        <span class="fl" id="index1"></span>
    </div>
    <div class="i_car">
    	<div class="car_t">购物车 [ <span>3</span> ]</div>
        <div class="car_bg">
       		<!--Begin 购物车未登录 Begin-->
        	<div class="un_login">还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
            	<li>
                	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/car1.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/car2.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/car2.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>
            <div class="price_a"><a href="#">去购物车结算</a></div>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>
<!--End Header End--> 
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">天天易购全部商品</div>
            <div class="leftNav">
                <ul>      
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="../images/nav1.png" /></span>
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
                            	<c:url value="../downFile.do?opr=1"  var="img1"></c:url>
                       				 <a href="../Goods.do?opr=showProduct&g_ID=1"><img src="${img1}" width="236" height="200" /></a>
                    			<c:url value="../downFile.do?opr=2" var="img2"></c:url>    
                       				 <a href="../Goods.do?opr=showProduct&g_ID=2"><img src="${img2}" width="236" height="200" /></a>         
                            </div>                  
                        </div>
                    </li>
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="../images/nav2.png" /></span>
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
                            	<c:url value="../downFile.do?opr=3"  var="img1"></c:url>
                       				 <a href="../Goods.do?opr=showProduct&g_ID=3"><img src="${img1}" width="236" height="200" /></a>
                    			<c:url value="../downFile.do?opr=4" var="img2"></c:url>    
                       				 <a href="../Goods.do?opr=showProduct&g_ID=4"><img src="${img2}" width="236" height="200" /></a>         
                            </div>  
                        </div>
                    </li>
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="../images/nav3.png" /></span>
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
                            	<c:url value="../downFile.do?opr=5"  var="img1"></c:url>
                       				 <a href="../Goods.do?opr=showProduct&g_ID=5"><img src="${img1}" width="236" height="200" /></a>
                    			<c:url value="../downFile.do?opr=6" var="img2"></c:url>    
                       				 <a href="../Goods.do?opr=showProduct&g_ID=6"><img src="${img2}" width="236" height="200" /></a>         
                            </div>  
                        </div>
                    </li>
                    <li>
                    	<div class="fj">
                        	<span class="n_img"><span></span><img src="../images/nav4.png" /></span>
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
                            	<c:url value="../downFile.do?opr=7"  var="img1"></c:url>
                       				 <a href="../Goods.do?opr=showProduct&g_ID=7"><img src="${img1}" width="236" height="200" /></a>
                    			<c:url value="../downFile.do?opr=8" var="img2"></c:url>    
                       				 <a href="../Goods.do?opr=showProduct&g_ID=8"><img src="${img2}" width="236" height="200" /></a>         
                            </div>
                        </div>       
                    </li>           	
                </ul>            
            </div>
        </div>  
        <!--End 商品分类详情 End-->                                                     
    	<ul class="menu_r">                                                                                                                                               
        	<li><a href="${pageContext.request.contextPath}/Index.jsp">首页</a></li>
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
<div class="i_bg">
	<div class="postion">
    	<!-- <span class="fl">全部 > 美妆个护 > 香水 > 香奈儿</span> -->
    </div>
    
    <div class="content mar_20">
    	<div class="l_history">
        	<div class="his_t">
            	<span class="fl">浏览历史</span>
                <span class="fr"><a href="#">清空</a></span>
            </div>
        	<ul>
            	<li>
                    <div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/his_1.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>368.00</span></font> &nbsp; 18R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/his_2.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>768.00</span></font> &nbsp; 18R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/his_3.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>680.00</span></font> &nbsp; 18R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/his_4.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>368.00</span></font> &nbsp; 18R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/his_5.jpg" width="185" height="162" /></a></div>
                	<div class="name"><a href="#">Dior/迪奥香水2件套装</a></div>
                    <div class="price">
                    	<font>￥<span>368.00</span></font> &nbsp; 18R
                    </div>
                </li>
        	</ul>
        </div>
        <div class="l_list">
        	<table border="0" style="width:100%; margin-bottom:30px; border:1px solid #eaeaea;" cellspacing="0" cellpadding="0">
              <tr valign="top">
                <td width="248"><div class="brand_img"><img src="${pageContext.request.contextPath}/images/brand5.jpg" width="226" height="108" /></div></td>
                <td class="td_b" style="padding:15px 40px;">
                	<!-- 所有分类<br />
                    <a href="#" class="now">香水（10）</a><a href="#">彩妆套装（2）</a><a href="#">洁面（1）</a><a href="#">精华（1）</a><a href="#">化妆水（2）</a><a href="#">嫩肤（3）</a> -->
                </td>
              </tr>
            </table>
        	<div class="list_t">
            	<span class="fl list_or">
                	<a href="#" class="now">默认</a>
                   <!--  <a href="#">
                    	<span class="fl">销量</span>                        
                        <span class="i_up">销量从低到高显示</span>
                        <span class="i_down">销量从高到低显示</span>                                                     
                    </a> -->
                    <a href="#">
                    	<span class="fl" onclick="toolp()">价格</span>                        
                        <span class="i_up">价格从低到高显示</span>
                        <span class="i_down">价格从高到低显示</span>     
                    </a>
                    <!-- <a href="#">新品</a> -->
                </span>
                <span class="fr num"></span>
            </div>
            <div class="list_c">
            	
                <ul class="cate_list">
                <%-- <li>
                    	
                    </li>
                    
                    
                    
                     <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_2.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_3.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_4.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_5.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_6.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_7.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_8.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_9.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_10.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_11.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_12.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_5.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_6.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_7.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_8.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_9.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_10.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_11.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_12.jpg" width="210" height="185" /></a></div>
                        <div class="price">
                            <font>￥<span>198.00</span></font> &nbsp; 26R
                        </div>
                        <div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
                        <div class="carbg">
                        	<a href="#" class="ss">收藏</a>
                            <a href="#" class="j_car">加入购物车</a>
                        </div>
                    </li> --%>
                </ul>
                
                <div class="pages"></div><div style="clear: both;"></div>
                
                
                
            </div>
        </div>
    </div>
    
    <!--Begin Footer Begin -->
    <div class="b_btm_bg bg_color">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="${pageContext.request.contextPath}/images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>
              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="${pageContext.request.contextPath}/images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="${pageContext.request.contextPath}/images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="${pageContext.request.contextPath}/images/b4.png" width="62" height="62" /></td>
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
            <div class="b_er_c"><img src="${pageContext.request.contextPath}/images/er.gif" width="118" height="118" /></div>
            <img src="${pageContext.request.contextPath}/images/ss.png" />
        </div>
    </div>    
    <div class="btmbg">
		<div class="btm">
        	备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="${pageContext.request.contextPath}/images/b_1.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/images/b_2.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/images/b_3.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/images/b_4.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/images/b_5.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/images/b_6.gif" width="98" height="33" />
        </div>    	
    </div>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
    