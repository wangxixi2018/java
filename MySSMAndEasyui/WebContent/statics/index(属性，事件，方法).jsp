<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">   
<script type="text/javascript" src="easyui/jquery.min.js"></script>   
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script> 
<style type="text/css" >
   #div1{
     width: 200px;
     height: 200px;
     color: red;
     background: green;
     
   }
</style>
<script type="text/javascript">
  $(function(){//数据之间用逗号分开，和json一样
	  $("#div1").draggable({
		  //属性  和json一样  key:key值
		  cursor:"pointer",
		  revert:true,
		  //事件  1.和json一样  key:key值     2. 事件 先找到对象  再吧事件作为参数转入     后面的个函数  eg:   $('#main').accordion('onSelect',function(){});
		  onBeforeDrag:function(e){
			  if(e.pageX>100){//单击 
				  return false;
				  console.log("拖动超范围！！");
			  }
		  },
		  onDrag:function(e){
			  console.log(e.pageX);
		  },
		  //方法
		  onStopDrag:function(){
				//方法使用    先找到对象  再吧方法作为参数转入
				$("#div1").draggable("disable");
			}
	  }); 

  })
</script> 
<title>Insert title here</title>
</head>
<body>
   <div id="div1">
     sdfsdf
   </div>
</body>
</html>