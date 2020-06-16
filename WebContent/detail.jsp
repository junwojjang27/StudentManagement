<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세정보</title>
    <style>    
        #visual .content-container{	
            height:inherit;
            display:flex; 
            align-items: center;
        }
    </style>
</head>

<body>

<%
	String id = (String)request.getAttribute("id");
	String name = (String)request.getAttribute("name");
	String tel = (String)request.getAttribute("tel");
	String email = (String)request.getAttribute("email");
	String dept = (String)request.getAttribute("dept");
	String gender = (String)request.getAttribute("gender");
	String birth = (String)request.getAttribute("birth");
	String introduction = (String)request.getAttribute("introduction");		
%>

    <div id="body">
		<div class="content-container clearfix">
		<main class="main">
			<h2 class="main title">DBP 학생 정보</h2>
			
			<div class="notice margin-top">
				학생 아이디 : <%= id %> </br>
				학생 이름 : <%= name %> </br>
				학생 전화번호 : <%= tel %> </br>
				학생 이메일 : <%= email %> </br>
				학생 전공 : <%= dept %> </br>
				학생 성별 : <%= gender %> </br>
				학생 탄생계절 : <%= birth %> </br>
				학생 소개 : <%= introduction %> </br>
			</div>
			
			
			</br>
			<div class="search-form margin-top first align-right">
			<form action="list" method=get>
			<input type="submit" name="operator" value="목록" />
			</form>
			<form action="detail" method=post>
			<input type="submit" name="operator" value="ID: <%=id %> 수정" />
			</form>
			</div>
		</main>
		
			
		</div>
	</div>

    </body>
    
    </html>