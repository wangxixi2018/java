var jq = jQuery.noConflict();
jq(function(){
	initprices();
});

function addUpdate(jia,s_carId){		
	var c = jia.parent().find(".car_ipt").val();
	c=parseInt(c)+1;	
	jia.parent().find(".car_ipt").val(c);
	dopost(s_carId,c);
}

function jianUpdate(jian,s_carId){    
	var c = jian.parent().find(".car_ipt").val();
	if(c==1){    
		c=1;    
	}else{    
		c=parseInt(c)-1;    
		jian.parent().find(".car_ipt").val(c);
	}
	dopost(s_carId,c);
}

function dopost(s_carId,c){
	jq.post(
			"../s_car.do?opr=updates_car",
			{"s_carId":s_carId,"g_count":c},
			function(data){
				
			},
			"json"
	);
	initprices();
}

function initprices(){
	var allprices=0;
	for(var i=0;i<jq(".car_ipt").length;i=i+1){
		allprices = allprices + (parseInt(jq(".car_ipt:eq('"+i+"')").val())*parseFloat(jq(".goodsprice:eq('"+i+"')").html()));
	}
	var allprices1 = parseFloat(allprices).toFixed(2);
	jq(".showgoodsprices").html(allprices1);
}

function deletes_car(s_carId,u_id){
	if(confirm('确定要删除该商品吗?')){
		jq.post(
				"../s_car.do?opr=deletes_car",
				{"s_carId":s_carId,"u_id":u_id},
				function(data){
					if(data=="true"){
						jq("#s_cartr"+s_carId+"").remove();
						initprices();
					}
				},
				"json"
		);
	}
}

function dobuygoods(u_id){
	jq.post(
		"../Consignee_Info.do?opr=showdefaultaddress",
		{"u_id":u_id},
		function(data){
			jq(".content").remove();
			jq(".i_bg").load("../buycar/orderBuy.jsp");
		},
		"json"
	);
}
