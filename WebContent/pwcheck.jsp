<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>본인 여부 확인</title>
</head>
<body>
<%
	String id = (String)request.getAttribute("id");
%>



<h3>본인 여부 확인</h3>
<hr>
<form action="pwcheck" method="post">
사용자 ID : <%= id %><br>
비밀 번호 : <input type="password" name = "pwd" value=""><br>
           <input type="submit" name = "operator" value="ID: <%=id %> 수정">           
</form>
</body>
</html>