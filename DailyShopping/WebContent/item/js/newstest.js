$(function(){
	initNews();
})
function initNews(){
		$.post("news.do?opr=getAllNews",function(data){
		$.each(data,function(i,o){
			$(".newsList").append("<li><a href='news.do?opr=getNewsByIdf&n_id="+o.n_Id+"'><b>"+o.n_title+"</b></a></li>")
		})
	},"json")
}