<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		public int show(int num){
		int number=0;
			for(;num<2013;num++){
				if((num % 4 == 0 && num % 100 != 0) || (num % 400 == 0)){
					number++;
				}
			}		
			return number;
	}
	 %>
	 <p>计算2000-2013年期间，共<%=show(2000) %>闰年</p>
	 
</body>
</html>