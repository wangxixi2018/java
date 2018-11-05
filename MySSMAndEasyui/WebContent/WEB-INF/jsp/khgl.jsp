<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/icons/iconextension.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/easyui/locale/easyui-lang-zh_CN.js"></script> --%>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			//A: 加载树形菜单数据
			// alert("55");
			/* $("#khgl").tree({  //可以吧返回结果自动展示在页面上
			   url:'khgl.json'
			}) */
			$("#khgl").tree({
				url : 'getKhgls', //请求后台得到json数据（注意 返回的json数据格式并不与easyui中tree（树形） 要求的格式相对应，必须拼接成 tree（树形） 要求的格式）
				
				
				// 由于有 loadFilter 过滤 属性后,从后台返回的结果 就相当于把返回到前端的数据拦截了 
				//loadFilter 过滤作用： 把后台过来的数据（这里值不规范的）按 easyui 格式 来 处理后 在返回  
				//就是把传回的data数据转换成 easyui中tree 要求的格式
				//每个节点都具备以下属性：
				//1.  id：节点ID，对加载远程数据很重要。2.text：显示节点文本。3. state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
				//4. checked：表示该节点是否被选中。5.  attributes: 被添加到节点的自定义属性。6.  children:（子节点） 一个节点数组声明了若干节点。 parentId 父节点id 

				loadFilter : function(data) {
					// alert(data)
					//var treeJson=[];（单一一层的树形数据）  //注意json数据是[] 不是{} 里面的String 也必须是双引号  不是单引号
					//treeJson.push({"id":111,"text":"881"}); //push()可向数组的末尾添加一个或多个元素，并返回新的长度。
			        var treeJson=[{"id":0,"text":"所有客户","state":"open","children":[]}];//（带父节点的树形数据）
					$.each(data, function(i, o) {
						
						//console.log(o.text);
						//拼接easyui 格式是以数组的形式放json数据   这里treeJson只有一个数组 [0]
						treeJson[0].children.push({"id":o.khmc_id,"text":o.khmc_name});
					})
					return treeJson;
				},
				//树的事件   (用来 操作表格，也就是关联表格  )
				onClick:function(node){
					//alert(node.id+"|"+node.text)
					//把数的当前 node.id 作为参数传回后台  
					$("#gc").datagrid({
						 url:"getGcId/"+node.id
					})
				}

			})
			
			
			//加载表格数据   每次发起分页要求，自动传递参数 page: 跳转到第几页  rows: 每页显示条数
			//select * from table limit (page-1))*rows,rows
			 $("#gc").datagrid({				 
				 //回过滤数据显示。该函数带一个参数'data'用来指向源数据（即：获取的数据源，比如Json对象）。您可以改变源数据的标准数据格式。
				 //loadFilter:这个函数必须返回包含'total'和'rows'属性的标准数据对象。 
				 loadFilter:function(data){
					// alert(data)
					 return data; 
				 }
			}) 
			
			/* $("#gc").datagrid({
				url:"getListGcmc/0",
				loadFilter:function(data){
					//必须返回包含'total'和'rows'属性的标准数据对象。
					return data;
				}
			}) */
		
		})
		// 注意：Uncaught ReferenceError错误提示:1.以为是引入的jquery.js 文件版本的不匹配，更换后还是出错。2.有以为是导入的其他js文件产生冲突导致的。3. jquery.js文件的路径错误。4. 加载js文件的顺序的问题
		
		//不能把 function DanYuanGe_GeShiHuaQi 放在$(function(){中去} 会报错： Uncaught ReferenceError 
		//单元格formatter(格式化器)函数 (注意 ：th标签中写函数名)   带3个参数：value：字段值。row：行记录数据(已展示行的数据是th中的数据)index: 行索引。 
		    //列：操作
			function DanYuanGe_GeShiHuaQi_caozuo(value,row,index){
				//alert(value+"|"+row+"|"+index)
				//alert(row.gcmc_id)
				return "<a href='javascript:delGcmc("+row.gcmc_id+")' >删除</a>";
			}
			//列：客户名称	
			function DanYuanGe_GeShiHuaQi_khmc(value,row,index){
				//console.log(value); value对应的是 :field的值  eg： field:'khmc_id'  那么value就是：khmc_id
				//alert(value.khmc_name)
				return value.khmc_name;
			}
			//删除工程
			function delGcmc(id){
				var Gcid=[];
			 	//console.log(Gc)
			 	if(id){//单删
			 		//alert(id)
			 		Gcid.push(id)
			 	}else{//进一步判断是否是多删
			 		var Gc=$("#gc").datagrid("getSelections");
			 		if(Gc.length!=0){
			 			console.log(Gc)//查看为[{..}] 表示为json数据   就需要遍历去里面的值
			 			$(Gc).each(function(i,o){	
			 				 //alert(o.gcmc_id)
			 				Gcid.push(o.gcmc_id);
			 			})
			 		}else{
			 			$.messager.alert('删除工程','请至少选择一条信息');
			 			return; //注意中断方法 
			 		}		    
			 	}
			 //友情提示框
			  $.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
				    if (r){    
				        alert('确认删除'); 
				        //2种转换格式：  1.JSON的转换格式      alert(JSON.stringify(Gcid))  2.Gcid.join(",") 把数据Gcid按，分割后成为一个string 
				        $.post("delGc",{"Gcmcid":Gcid.join(",")},function(data){
				           //alert(typeof data.flag);
				           if(data.flag){
				        	   //刷新表格
				        	   $.messager.alert('删除工程',data.mistake);
				        	   $("#gc").datagrid("reload");
				           }else{
				        	   $.messager.alert('删除工程',data.mistake);
				           }
				        },"json")
				    }else{
				    	$.messager.alert('删除工程','取消成功');
				    }    
				})
			}
			//查询工程(方式一： 单一)
			 function selectGcmc(){
				var select=$("#select").val();
					// alert(data)
					//向后台发起请求
					$("#gc").datagrid({
						url:"selectGcmc/"+select,
						 loadFilter:function(data){
							   console.log(data)
								 return data; 
							 }
					})
				 
			 } 
			//查询工程(方式二： 带下拉条件的)
			//参数：  1.value 收缩框中输入的值       2.对应的下拉列表（下拉条件）的名称
				 function qq(value,name){
				 //alert(value+"|"+name)
				 //获取数型菜单的值
					var khmc=$("#khgl").tree("getSelected");
				 //条件字段 ：name  条件值 ：value
				   
					var khmc_id=khmc.id;
						// alert(data)
						//向后台发起请求
						$("#gc").datagrid({
							url:"selectGcmcs/"+khmc_id+"/"+name+"/"+value+"/",
							 loadFilter:function(data){
								   console.log(data)
									 return data; 
								 }
						}) 				 
				 } 
			 
			//添加工程方式1
			function addGcmc(){
				//alert(88)
				$('#addGcmc').window({    
				    width:300,    
				    height:110,    
				    modal:true
				});  	 
			 }
			 
			function addGcmcs(){
				//alert($("#gcmc_name").val())
				//alert($("#khmc_name").val())
				//获取数型菜单的值
				var khmc=$("#khgl").tree("getSelected")
				//关闭窗口
				$('#addGcmc').window('close'); 
					var add=[];
					//console.log(khmc)
					//alert(gcmc_id)
					
					add.push(khmc.id)
					add.push($("#khmc_name").val())
					add.push($("#gcmc_name").val())
					var gcmc_name=$("#gcmc_name").val();
					var khmc_name=$("#khmc_name").val();
					var khmc_id=khmc.id;
					//var adds={gcmc_id:gcmc.id,gcmc_name:$("#gcmc_name").val(),khmc_name:$("#khmc_name").val()};
					
					//向后台发起请求 方式1.拼接获取的数据    
					//alert(JSON.stringify(adds));
					/* $("#gc").datagrid({
						url:"addGcmc1/"+khmc_id+"/"+gcmc_name+"/"+khmc_name+"/",
						 loadFilter:function(data){
							   //console.log(data)
							 if(data.flag){
					        	   //刷新表格
					        	   $.messager.alert('添加工程成功',data.mistake);
					        	   return $("#gc").datagrid("reload");
					           }else{
					        	   $.messager.alert('添加工程失败',data.mistake);
					        	   return $("#gc").datagrid("reload");
					           } 
							 
							 }
					}) */
					//向后台发起请求 方式2.    ajax方式  
					 $.post("addGcmc2",{"add":add.join(",")},function(data){
				           //alert(typeof data.flag);
				           if(data.flag){
				        	   //刷新表格
				        	   $.messager.alert('删除工程',data.mistake);
				        	   $("#gc").datagrid("reload");
				           }else{
				        	   $.messager.alert('删除工程',data.mistake);
				           }
				        },"json")
				        
				      //向后台发起请求 方式3.拼接获取的数据    
						//alert(JSON.stringify(adds));
						 $("#gc").datagrid({
							url:"addGcmc2/"+khmc_id+"/"+gcmc_name+"/"+khmc_name+"/",
							 loadFilter:function(data){
								   //console.log(data)
								 if(data.flag){
						        	   //刷新表格
						        	   $.messager.alert('添加工程成功',data.mistake);
						        	   return $("#gc").datagrid("reload");
						           }else{
						        	   $.messager.alert('添加工程失败',data.mistake);
						        	   return $("#gc").datagrid("reload");
						           } 
								 
								 }
						})   
			}
			//添加工程方式2 使用easyui
			function addGcmc2(){
				//alert(88)
				// 注意不能删除div id=dd 标签的 class 属性  要不然就open 无效
				//获取客户名称id
				var khmc=$("#khgl").tree("getSelected");
				var khmc_id=khmc.id;
				$('#dd').dialog("open"); 
				$('#dd').dialog({    
				    title: '添加工程',    
				    width: 400,    
				    height: 200,  
				    closed: false,
				    cache: false,    
				   // href: 'get_content.php',    
				    modal: true,  
				     buttons:[{
						text:'提交',
						handler:function(){
							//alert(8)
							//这里需要绑定submit 方法与from表单，让它知道是哪个表单
							$('#ff').form("submit",{    
							    url:"addGcmc3", 
							    //传入后台数据（可以向后台传入自定义的数据： param ，及传入前的数据验证）
							    onSubmit: function(param){
							    	//1传入前的数据验证
							       alert("进行验证")  
							    	//2.向后台传入自定义的数据： param 
							    	//客户名称id
							    	param.khmc_id = khmc_id;
							       //return false;
							    }, 
							    //后台返回前端数据
							    success:function(data){ 
							    	var data = eval('(' + data + ')');// 将JSON字符串更改为javascript对象
							    	$("#dd").window('close');
							        console.log(data)
							        //var date=JSON.stringify(data)
							        console.log(data.flag)
							        alert(data)
							        alert(data.flag)
							       
							        if(data.flag){//添加成功 要做的事： 1.显示成功信息 2.是否继续新增  3.重置表单,关闭对话框 4.刷新(表格)分页表格
							        	//关闭表单窗口
							        	 //这里使用无效
							        	 //alert(888)
							        	 
							        	//$("#dd").window('close');
							        	//重置表单
							        	$('#ff').form("reset");
							       		//显示成功信息
							        	$.messager.alert('添加工程成功',data.mistake);
							       		//是否继续新增
							       		//confirm函数用于提供确认功能，它首先显示给定的message参数所包含的信息，并提供两个可选择的回答“ok”和“cancel”，
							       		//然后等待用户选择其中的一个。如果用户选择“ok”则返回true；否则，如若选择“cancel”则返回false
							       		var r=confirm("是否继续新增");
										  if (r==true){//继续添加
											  $("#dd").dialog("open");
										    }
										  else{//不继续添加
											  $("#dd").dialog("close");
												//刷新(表格)
									        	if(data.flag){
										        	   //刷新表格
										        	   //$.messager.alert('添加工程成功',data.mistake);
										        	   return $("#gc").datagrid("reload");
										           }else{
										        	  // $.messager.alert('添加工程失败',data.mistake);
										        	   return $("#gc").datagrid("reload");
										           }
										    }
							        }
							    }    
							});    

							}
					},{
						text:'关闭',
						handler:function(){
							alert(9)
							//重置表单
							$('#ff').form("reset");
							//关闭表单窗口
							$("#dd").dialog('close')
							}
					}] 
				})   
			}
	</script>
	<!--fit: 自动填满  -->
	<div  class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'west',title:'客户管理',width:140" >
		<!--使用动态是用id, 把class 删除掉 ， 如果不删除 就会想后台请求2次   eg:<ul id="tt" class="easyui-tree"> -->
			<ul id="khgl"></ul>
		</div>
		<div data-options="region:'center',title:'工程管理'">
					<!-- fitColumns:自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动  true: 开启 -->
					<!-- url:加载远程数据 -->
					<!-- singleSelect:如果为true，则只允许选择一行 -->
					<!-- pagination:如果为true，则在DataGrid控件底部显示分页工具栏 -->
					<!-- fit:自动填充内容 -->
			 <table id="gc"  data-options="rownumbers:true,toolbar:'#tb_oop',fitColumns:true,pagination:true,fit:true">   
			    <thead>   
			        <tr> 
			            <!--.json里面的key 必须与这里的field：列字段名称的值一样       checkbox:true,如果为true，则显示复选框。该复选框列固定宽度  -->  
			            <th data-options="field:'co',checkbox:true,width:80"></th>   
			            <th data-options="field:'gcmc_id',width:80">工程编码</th>   
			            <th data-options="field:'gcmc_name',width:80">工程名称</th>   
			            <th data-options="field:'khgl',width:80,formatter:DanYuanGe_GeShiHuaQi_khmc">客户名称</th>   
			            <th data-options="field:'caozuo',width:80,align:'center',formatter:DanYuanGe_GeShiHuaQi_caozuo">操作</th>   
			        </tr>   
			    </thead>   
			</table>     
		</div>
	</div>
	<!--表格工具条-->
	<div id="tb_oop">
	    <!--iconCls:'icon-edit:  为Easyui框架内置图标      （路劲位置在icons/iconextension.css 中）有很多   eg ：edit编辑图标      add添加图标 -->
		<a href="javascript:addGcmc()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加方式1</a>
		<a href="javascript:addGcmc2()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加方式2</a>
		<a href="javascript:delGcmc()" class="easyui-linkbutton" data-options="iconCls:'icon-delete',plain:true">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- 单一查询 -->
		<input id="select" type="text" name="opr" value=""/><span onclick="selectGcmc()">查询</span>
		<!--带条件性的 查询 -->
		<input id="ss" class="easyui-searchbox" style="width:300px" 
			data-options="searcher:qq,prompt:'请输入要查询的相关内容',menu:'#mm'"></input> 
			
		<div id="mm" style="width:120px"> 
			<div data-options="name:'khmc_id',iconCls:'icon-ok'">客户id</div> 
			<div data-options="name:'gcmc_name'">工程名称</div> 
			<div data-options="name:'khmc_name'">客户名称</div> 
			<div data-options="name:'all'">全部模糊查询</div> 
		</div>
	</div>
	<!--添加方式1窗口-->
	<div id="addGcmc"  title="添加工程"   
        data-options="iconCls:'icon-save',resizable:true,modal:true">   
         
		    <div>   
		        <label for="gcmc_name">工程名称:</label>   
		        <input class="easyui-validatebox" id="gcmc_name" type="text" name="gcmc_name" data-options="required:true" />   
		    </div>   
		    <div>  
		    <label for="gcmc_name">工程名称:</label>
		        <select id="khmc_name">
					<c:forEach items="${applicationScope.listKhgl}" var="khgl">
			              <option>${khgl.khmc_name}</option>
					</c:forEach>
				</select>   
		    </div>
		    <div><input type="submit" value="提交" onclick="addGcmcs()"/></div>   
		
	</div>  
	<!--添加方式2窗口-->
	<div id="dd" class="easyui-dialog" title="新增工程" style="width:400px;height:200px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
    		<form id="ff" method="post">   
			    <div>   
			        <label for="name">工程名称：</label>   
			        <input class="easyui-validatebox" type="text" name="gcmc_name" data-options="required:true" />   
			    </div>   
			    <div>   
			        <label for="email">客户名称：</label>   
			        <!-- <select name="khmc_name">
			          <option value="1">客户1</option>
    				  <option value="2">客户2</option>
			        </select>  --> 
			        <!--Easyui下拉列表  valueField： 不显示在页面上的数据 (这里是返回数据：list<Khgl>  中的 属性 khmc_id),textField: 显示在页面上的数据(这里是返回数据：list<Khgl>  中的 属性 khmc_name)    url 请求路径  （这里返回的是个list<Khgl> ）-->
			        <input id="cc" class="easyui-combobox" name="dept"   
    			data-options="valueField:'khmc_id',textField:'khmc_name',url:'getKhgls'" />  
			    </div>   
			</form>  	    
	</div>  
</body>
</html>