<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과는
<br/>
JAVA로 출력
<%
String str = (String)request.getAttribute("msg");
out.println(str);
%>
<br/>
El로 출력 : ${requestScope.msg},${msg}
</body>
</html>