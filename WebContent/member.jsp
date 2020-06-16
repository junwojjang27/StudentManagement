<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title></head>
<body>
<%
	String id = (String)request.getAttribute("id");
	String name = (String)request.getAttribute("name");
%>


    <h3>회원 정보수정</h3>
    <form action="update?id=<%=id %>&name=<%=name %>" method=post>
	     ID : <%= id %><br/>
	        비밀번호 : <input type="password" name="pwd" /> <br/>
	        이름 :  <%= name %> <br/>
	        전화번호 :  <input type="text"  name="tel" /> <br/>
	        이메일 :  <input type="text"  name="email" /> <br/>
	        학부 : 
              <input type="checkbox" name="dept" value="computer" /> 컴퓨터공학부 
              <input type="checkbox" name="dept" value="information" /> 정보통신학부  
              <input type="checkbox" name="dept" value="itcontents" /> IT콘텐츠학과  
              <input type="checkbox" name="dept" value="korean" /> 국어국문학과 <br/>
	        성별 :
              <input type="radio"  name="gender"  value="Male" />남자 
              <input type="radio"  name="gender"  value="Female" />여자<br/>
	        
	        태어난 계절:
              <select name="birth">
                 <option value="spring"> 봄 
                 <option value="summer"> 여름 
                 <option value="fall"> 가을 
                 <option value="winter"> 겨울                 
              </select>  <br/>
	        자기소개:<br/>
              <textarea cols="30" rows="10" name="introduction"></textarea> <br/>
        <input type="submit" value="전송" />        
    </form>
</body>
</html>