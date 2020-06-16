<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>본인 여부 확인</h3>
<hr></br>
<%
	String msg="";
	int type = (int)request.getAttribute("type");
	if(type == 2) {
		msg = "비밀번호가 일치하지 않거나 존재하지 않는 ID입니다.";
	}
	if(type == 3) {
		msg = "비밀번호가 일치하지 않아 정보를 수정할 수 없습니다.";
	}
	if(type == 4) {
		msg = "해당 ID가 이미 존재합니다.";
	}
	if(type == 5) {
		msg = "저장이 완료되었습니다.";
	}
%>
</br><h4><%= msg %></h4>


</body>
</html>