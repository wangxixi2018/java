$(function(){
	initInfobuy();
	initjifen();
})

function initInfobuy(){
	var allprices=0;
	for(var i=0;i<$(".price2").length;i=i+1){
		allprices = allprices + (parseInt($(".count2:eq('"+i+"')").html())*parseFloat($(".price2:eq('"+i+"')").html()));
	}
	var allprices1 = parseFloat(allprices).toFixed(2);
	$("#showgoodsprices1").html(allprices1);
	$("#showgoodsprices2").html(allprices1);
	$("#showgoodsprices3").html(allprices1);
}

function initjifen(){
	var initdo = 0;
	for(var i=0;i<$(".integral2").length;i=i+1){
		initdo = initdo + (parseInt($(".count2:eq('"+i+"')").html())*parseInt($(".integral2:eq('"+i+"')").html()));
	}
	$("#showthisjifen").html(initdo);
	$("#showthisjifen2").html(initdo);
}

function suerbuygoods(){
	var s = $("li[class=checked]").html();
	var s1 = s.indexOf("<");
	var s2 = s.substr(0,s1);
	var uid =$("#do_u_id").val();
	var money = $("#showgoodsprices1").html();
	var name = $(".takeinfo:eq(0)").val();
	var add1 = $(".takeinfo:eq(2)").val();
	var add2 = $(".takeinfo:eq(3)").val();
	var phone = $(".takeinfo:eq(1)").val();
	var add = add1+add2;
	$.post(
		"../order.do?opr=addorders",
		{"u_id":uid,"money":money,"payment":s2,"name":name,"add":add,"phone":phone},
		function(data){
				jq(".content").remove();
				jq(".i_bg").load("../buycar/dobuy.jsp");
		},
		"json"
		);
}

$("#pay_do1").click(function(){
	$(this).attr("class","checked");
	$("#pay_do2").removeAttr("class");
	$("#pay_do3").removeAttr("class");
})
$("#pay_do2").click(function(){
	$(this).attr("class","checked");
	$("#pay_do1").removeAttr("class");
	$("#pay_do3").removeAttr("class");
})
$("#pay_do3").click(function(){
	$(this).attr("class","checked");
	$("#pay_do1").removeAttr("class");
	$("#pay_do2").removeAttr("class");
})

