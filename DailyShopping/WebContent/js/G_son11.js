var num=0;
var pagedata=null;
$(function(){
	index0();
	index1();
})

function index0(){
	$.post("../Goods.do",{"opr":"showindex"},function(data){       
		$.each(data.listG_sort2,function(i,o){ //<a href="#">${RequestScope.list}</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a>
			$("#index1").append("<a href='javascript:GoodssInfo("+o.g_sort2ID+","+JSON.stringify(o.g_sName)+")'>"+o.g_sName+"</a>");
		})
		$.each(data.listG_sort1,function(i,o){ //<a href='javascript:GoodsInfo("+o.g_sonID+","+o.g_sName+","+o.g_describe+")'>"+o.g_sName+"</a>
				$("#"+i).html(o.g_sName);	
		})
		//$(".menu_r").empty();
		$.each(data.listG_son,function(i,o){ //<a href='javascript:GoodsInfo("+o.g_sonID+","+o.g_sName+","+o.g_describe+")'>"+o.g_sName+"</a>	
			$(".menu_r"+i).html(o.g_sName)
		})
	},"json")
}

function GoodssInfo(G_sort2ID,g_sName){
	switch (G_sort2ID) {
	case 1:
		window.location.href="G_sort1.jsp";
		break;
	case 2:
		window.location.href="G_sort2.jsp";
		break;
	case 3:
		window.location.href="G_sort3.jsp";
		break;
	case 4:
		window.location.href="G_sort4.jsp";
		break;
	case 5:
		window.location.href="G_sort5.jsp";
		break;
	}
	
}

/*<div class="img"><a href="#"><img src="${pageContext.request.contextPath}/images/per_1.jpg" width="210" height="185" /></a></div>
<div class="price">
    <font>￥<span>198.00</span></font> &nbsp; 26R
</div>
<div class="name"><a href="#">香奈儿邂逅清新淡香水50ml</a></div>
<div class="carbg">
	<a href="#" class="ss">收藏</a>
    <a href="#" class="j_car">加入购物车</a>
</div>*/

var allnews = null;// 所有新闻
var indexs = 1;// 当前页数;
var nums = 12;// 每页显示数目
var sum = null;// 总页数

function index1(){
	
	$.post("../Goods.do",{"opr":"showindex1","g_sonID":11},function(data){
		pagedata=data;
		/*$.each(data,function(i,o){	
			$.post("../Goods.do",{"opr":"showG_son","g_sonID":o.g_sonID},function(date){
				pagedate=date;
				$.each(date,function(j,k){
					$(".cate_list").append(
							"<li>"+
							" <div class='img'><a href='#'><img src='../downFile.do?opr="+o.g_ID+"' width='210' height='185' /></a></div>"+
							" <div class='price'>"+
							"  <font>￥<span>"+o.g_g_price+"</span></font> &nbsp; "+o.g_integral+"R"+
							" </div>"+		
							" <div class='name'><a href='#'>"+k.g_describe+"</a></div>"+
							" <div class='carbg'>"+
							"    <a href='#' class='ss'>收藏</a>"+
							"    <a href='#' class='j_car'>加入购物车</a>"+
							" </div>"+
							"</li>"
					)
				})
				
	},"json")			
		})*/
		pages(indexs);
		show();
		$(".num").html("<span>共发现"+pagedata.length+"件</span>");	
	},"json")
	
}



function pages(indexs){
	$(".cate_list").empty();										
			for (var i = nums * (indexs - 1); i < nums * indexs; i++) {	//循环中发起ajax请求 需要同步	
				if (i >= 0 && i < pagedata.length) {
						$.ajax({
							"url"       :  "../Goods.do?opr=showG_son", //请求路径
							"type"      :  "GET", //请求方式
							"data"      :  {"g_sonID":pagedata[i].g_sonID}, //要发送的数据
							"async"     :false,//同步
							"timeout"   :9000,//等待时间
							"dataType"  :  "json", // 请求成功后返回的数据类型
							"success"   :  function(date){
								$.each(date,function(j,k){
									$(".cate_list").append(
											"<li>"+
											" <div class='img'><a href='javascript:Product("+JSON.stringify(pagedata[i].g_ID)+")'><img src='../downFile.do?opr="+pagedata[i].g_ID+"' width='210' height='185' /></a></div>"+
											" <div class='price'>"+
											"  <font>￥<span>"+pagedata[i].g_g_price+"</span></font> &nbsp; "+pagedata[i].g_integral+"R"+
											" </div>"+		
											" <div class='name'><a href='#'>"+k.g_describe+"</a></div>"+
											" <div class='carbg'>"+
											"    <a href='#' class='ss'>收藏</a>"+
											"    <a href='#' class='j_car'>加入购物车</a>"+
											" </div>"+
											"</li>"
									)
								})								
							}})
				}else{
					$(".cate_list").append("<li>&nbsp;</li>")
				}
			}
}


function show(){
		//$(".pages").empty();	
	    $('.pages').pageList({
	        prevText: '前一页',
	        nextText: '下一页',
	        recordText: '共{0}页，共{1}件',
	        totalCount: pagedata.length,
	        goInputType: 'text',
	        //showGoLink: true,
	        showPageRange: 3,
	        renderPerCall: true,
	        clickCallback: function (currentPage) {	  	
	        	pages(currentPage);
	            
	        }
	    });	
}


//分页
$.fn.pageList = function (arg, methodName) {
    if (typeof methodName === "string" && $.trim(methodName) != "") {  // trim(参数, 【str】); 去除参数
        switch (methodName) {
            case 'refresh'://刷新当前页,一般用于删除或者更新后
                $(this).each(function () {
                    var arg = $(this).data('pageListArg');
                    if (arg != null && typeof arg.clickCallback === "function") {
                        arg.clickCallback(arg.currentPage);
                    }
                });
                break;
        }
    }
    else {
        var defaultSettings = {
            prevText: 'Prev',//显示的前一页文本
            nextText: 'Next',//显示的下一页文本
            showGoLink: 'auto',//是否显示快速跳转，可能的值为auto 自动判断；true 永远显示；false 永不显示
            goInputType: 'select',//如何显示快速跳转输入，可能的值为select 下拉列表；text 输入框，默认值为select
            goText: 'Go',//显示的快速跳转文本
            recordText: '',//显示记录数，为空时不显示，否则按照占位符显示文本，{0}表示总页数，{1}表示总记录数
            clickCallback: function (currentPage) { },//链接被点击时触发的事件，currentPage表示当前点击的是第几页，索引从1开始
            renderPerCall: true,//是否每次点击都重新绘制，如果每次clickCallback事件中都会重新绘制pageList，此处请设置为false减少绘制消耗
            pageSize: 12,//每页显示的数据条数
            currentPage: 1,//当前第几页，索引从1开始
            totalCount: 0,//总记录数
            currentPageCenter: true,//当前页是否居中，true表示居中,false表示按showPageRange倍率范围显示,注意此值会导致完全不同的显示方式
            showPageRange: 5//允许最小值3，当currentPageCenter设置为true时，表示去除第一页，最后一页后，还需显示的页面数量；为false时,表示在倍率范围内应当显示的页面链接数量,
        };
        arg = $.extend({}, defaultSettings, arg); //合并对象
        var totalPages = ~~(arg.totalCount / arg.pageSize) + (~~(arg.totalCount % arg.pageSize) == 0 ? 0 : 1);//获取总页数
        if (arg.currentPage < 1) {//修正当前页页码为第一页
            arg.currentPage = 1;
        }
        if (arg.currentPage > totalPages) {//修正当前页页码为最后一页
            arg.currentPage = totalPages;
        }
        if (!(arg.showPageRange > 2)) {
            arg.showPageRange = 3;
        }

        $(this).data('pageListArg', arg); //给标签<div> 添加数据
        $(this).each(function () {
            $(this).empty();//无数据
            if (totalPages > 0) {
                var ul = $('<ul class="pager"></ul>'); // 把jquery转换成 javascript
                var startPage = 2, endPage = totalPages - 1;//排除首页最后一页后显示的第一个超链接，最后一个超链接
                var prevS = false, nextS = false;//是否需要显示…对应的超链接
                if (arg.showPageRange + 4 < totalPages) {//因为页面链接最多包含arg.showPageRange + 4个，所以如果总页数大于时，才显示对应的…
                    if (!arg.currentPageCenter) {
                        var rangeIdx = ~~(arg.currentPage / arg.showPageRange) + (~~(arg.currentPage % arg.showPageRange) == 0 ? 0 : 1);
                        startPage = (rangeIdx - 1) * arg.showPageRange + 1;
                        endPage = rangeIdx * arg.showPageRange;
                        if (startPage < 2) { startPage = 2; }//修正
                        if (endPage >= totalPages) { endPage = totalPages - 1; }//修正
                        if (startPage >= endPage) { startPage = startPage - arg.showPageRange; }//修正
                        if (endPage == totalPages - 2) { endPage++; }//修正
                        prevS = startPage >= arg.showPageRange;  //判断开始...
                        nextS = endPage < totalPages - 1; // 判断结束 ...
                    }
                    else {
                        var prevReduce = ~~(arg.showPageRange / 2);
                        var nextAdd = prevReduce;
                        if (~~(arg.showPageRange % 2) == 0) {
                            prevReduce--;//showPageRange为偶数时，currentPage前面显示的页码链接数比后面显示的链接数少一个
                        }
                        if (prevReduce < 0) {//修正当showPageRange被设置为1导致的负数
                            prevReduce = 0;
                        }
                        startPage = arg.currentPage - prevReduce;
                        if (startPage < 2) { startPage = 2; }//修正startPage
                        endPage = arg.currentPage + nextAdd;
                        if (endPage - startPage < arg.showPageRange) { endPage = startPage + arg.showPageRange - 1; }//根据startPage修正endPage
                        if (endPage > totalPages - 1) { endPage = totalPages - 1; startPage = endPage - arg.showPageRange + 1; }//修正endPage,并同步修正startPage
                        if (startPage <= 3) {//再次修正startPage
                            startPage = 2;
                        }
                        if (endPage > totalPages - 3) {//再次修正endPage
                            endPage = totalPages - 1;
                        }
                        prevS = startPage - 1 > 1;
                        nextS = endPage + 1 < totalPages;
                    }
                }
                var li = renderDoms(arg.prevText, arg.currentPage == 1, false, arg.currentPage - 1, arg);//前一页
                li.addClass("prev");  //添加class属性 : prev
                ul.append(li); // ul标签内添加li标签
                ul.append(renderDoms("1", arg.currentPage == 1, arg.currentPage == 1, 1, arg));//第一页
                if (prevS) {
                    ul.append(renderDoms('…', false, false, startPage - 1, arg));//…页
                }
                for (var i = startPage; i <= endPage; i++) {
                    ul.append(renderDoms(i, arg.currentPage == i, arg.currentPage == i, i, arg));//第i页
                }
                if (nextS) {
                    ul.append(renderDoms('…', false, false, endPage + 1, arg));//…页
                }
                if (totalPages > 1) {
                    ul.append(renderDoms(totalPages, arg.currentPage == totalPages, arg.currentPage == totalPages, totalPages, arg));//最后一页
                }
                li = renderDoms(arg.nextText, arg.currentPage == totalPages, false, arg.currentPage + 1, arg);//下一页
                li.addClass("next");
                ul.append(li);
                var showGo;
                switch ((arg.showGoLink + '').toLowerCase()) {
                    case "true":
                        showGo = true; break;
                    case "false":
                        showGo = false; break;
                    default:
                        showGo = arg.showPageRange + 4 < totalPages; break;
                }
                if (showGo) {
                    li = $('<li class="text"><span class="go">' + arg.goText + '</span></li>');
                    var sel;
                    if (arg.goInputType.toLowerCase() != 'text') {
                        sel = $('<select class="go"></select>');//<input tyle="text" class="go" />
                        for (var i = 1; i <= totalPages; i++) {
                            sel.append('<option value="' + i + '">' + i + '</option>');
                        }
                        sel.val(arg.currentPage);
                    }
                    else {
                        sel = $('<input tyle="text" class="go" />');
                        sel.focus(function () {
                            $(this).val('');
                        }).change(function () {
                            var num = parseInt($(this).val());
                            if (num && num > 0) {
                                if (num > totalPages) {
                                    num = totalPages;
                                }
                                $(this).val(num);
                            }
                            else {
                                $(this).val('');
                            }
                        }).keyup(function () { $(this).change(); });
                    }
                    var sp = li.find('span');
                    sel.insertBefore(sp);
                    sp.click(function () {
                        var pageNumber = ~~$(this).parent().find('.go:eq(0)').val();
                        if (pageNumber > 0) {
                            clickEvent($(this).parent(), arg, pageNumber);
                        }
                    });
                    ul.append(li);
                }
                if (typeof arg.recordText === "string" && $.trim(arg.recordText) != "") {
                    ul.append('<li class="text">' + arg.recordText.replace(/\{0\}/g, totalPages).replace(/\{1\}/g, arg.totalCount) + '</li>');
                }
                $(this).append(ul);
            }
        });
    }
    function renderDoms(text, disable, active, pageNumber, arg) {
        var li = $('<li><a style="cursor:' + (disable ? "" : "pointer") + ';">' + text + '</a></li>');
        if (active) {
            li.addClass("active");
        }
        if (disable) {
            li.addClass("disable");
        }
        else {
            li.click(function () {
                clickEvent(this, arg, pageNumber);
            });
        }
        return li;
    }
    function clickEvent(dom, arg, pageNumber) {
        if (typeof arg.clickCallback === "function") {
            arg.clickCallback(pageNumber);
        }
        if (arg.renderPerCall) {
            arg.currentPage = pageNumber;
            $(dom).parent().parent().pageList(arg);
        }
    }
};




//按价钱排序
function toolp(){
	$(".cate_list").empty();
	if(num==0){	
		$.post("../Goods.do",{"opr":"GoodsG_g_priceSonDown","g_sonID":11},function(data){
			pagedata=data;
			pages(indexs);
			show();
		},"json")
		num=num+1;
	}else{	
		$.post("../Goods.do",{"opr":"GoodsG_g_priceSonUp","g_sonID":11},function(data){
			pagedata=data;
			pages(indexs);
			show();
		},"json")
		num=num-1;
	}
}


//商品详情
function Product(g_ID){              
	window.location.href="../Goods.do?opr=showProduct&g_ID="+g_ID
	//document.location.href="../Product.jsp?id="+data;
 
}




