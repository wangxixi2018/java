
$(function(){
	  //假设是后台返回的json数据
	  var _menus = {
				"menus":[{
					"menuid":"1",
					"icon":"icon-sys", 
					"menuname":"系统管理",
					"menus":[{
				     	"menuname":"客户管理",
				     	"icon":"icon-bullet_right",
				     	"url":"khgl"  //由于静态页面与动态页面分开：一般用于js中的请求后台地址（动态页面，直接访问不到：就需要通过后台方法再返回到动态页面中）用于静态页面到动态页面
					     },
					     {
					     	"menuname":"原材料入库",
					     	"icon":"icon-bullet_right",
					     	"url":"khgl2.jsp"
					     },
					     {
					     	"menuname":"货架管理",
					     	"icon":"icon-bullet_right",
					     	"url":"khgl3.jsp"
					     }]
				}]	
		};

	  
	  //菜单加载
	  /* $('#main').accordion('add', {
			title: '一级菜单',
			content: '<p>1</p><p>2</p><p>3</p><p>4</p><p>5</p>',
			selected: false
		});
	  $('#main').accordion('add', {
			title: '一级菜单',
			content: '<p>1</p><p>2</p><p>3</p><p>4</p><p>5</p>',
			selected: false
		}); */
		//遍历 加载菜单
		
		$.each(_menus.menus,function(i,o){
			//alert(o.menuname)
			//拼接2级菜单
			var contents="<ul>";
			$(o.menus).each(function(j,k){
				//alert(k.menuname)
				contents+="<li><div  onclick='main(this)' href='"+k.url+"'><span class='"+k.icon+"'>&nbsp;&nbsp;</span>"+k.menuname+"</div></li>"
			})
			contents+="</ul>"
			$('#main').accordion('add', {
				title: o.menuname,
				content: contents,
				selected: false,
			});
			//展开菜单
			$('#main').accordion('select',0);
			
		})
  })
  
  function main(obj){
	//alert(titles);
	//alert($(obj).attr("href")) //    $(obj): 把传入的对象转换成jqery 对象
	var titles=($(obj).text());
	var url=$(obj).attr("href"); //注意加载过来的指定body内部的（不包括body标签），不是整个网页， 所有加载过来的那个页面不用引入外部的其他资源（js,scc~~等）
	//判断页面是否已经加载
	if($('#index_title').tabs('exists',titles)){ //exists方法：判断面板是否存在 
		//alert("该页面已经存在")
		$('#index_title').tabs('select',titles) //select方法：选中该菜单
	}else{
		$('#index_title').tabs('add',{    
		    title:titles,     
		    href:url,
		    closable:true,     
		}); 
	}
	
	 

}
  