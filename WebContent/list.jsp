<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 목록</title>
    <style>    
        #visual .content-container{	
            height:inherit;
            display:flex; 
            align-items: center;
        }
    </style>
</head>

<body>
    <!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">
		<main class="main">
			<h2 class="main title">DBP 학생 목록</h2>
			
			<div class="notice margin-top">				
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>ID</th>
							<th>&nbsp;이름</th>
						</tr>
					</thead>
					<tbody>
						
					<%										
						int num=1;
						int cnt = (int)request.getAttribute("cnt");
						
						String ID[] = new String[cnt];
						String NAME[] = new String[cnt];
						
						while(true) {
						ID[0] = (String)request.getAttribute("ID[0]");
						NAME[0] = (String)request.getAttribute("NAME[0]");
						if(cnt==1) break;
						ID[1] = (String)request.getAttribute("ID[1]");
						NAME[1] = (String)request.getAttribute("NAME[1]");
						if(cnt==2) break;
						ID[2] = (String)request.getAttribute("ID[2]");
						NAME[2] = (String)request.getAttribute("NAME[2]");
						if(cnt==3) break;
						ID[3] = (String)request.getAttribute("ID[3]");
						NAME[3] = (String)request.getAttribute("NAME[3]");
						if(cnt==4) break;
						ID[4] = (String)request.getAttribute("ID[4]");
						NAME[4] = (String)request.getAttribute("NAME[4]");
						if(cnt==5) break;
						ID[5] = (String)request.getAttribute("ID[5]");
						NAME[5] = (String)request.getAttribute("NAME[5]");
						if(cnt==6) break;
						ID[6] = (String)request.getAttribute("ID[6]");
						NAME[6] = (String)request.getAttribute("NAME[6]");
						if(cnt==7) break;
						ID[7] = (String)request.getAttribute("ID[7]");
						NAME[7] = (String)request.getAttribute("NAME[7]");
						if(cnt==8) break;
						ID[8] = (String)request.getAttribute("ID[8]");
						NAME[8] = (String)request.getAttribute("NAME[8]");
						if(cnt==9) break;
						ID[9] = (String)request.getAttribute("ID[9]");
						NAME[9] = (String)request.getAttribute("NAME[9]");
						break;
						}
																											
						
						for(int i=0; i<cnt; i++) {
							out.print("<tr><td>" + num + "</td><td><a href=\"detail?id=" + ID[i] + "\">" + ID[i] + "</a>");
							out.print("</td><td>&nbsp;&nbsp;" + NAME[i] + "</td></tr>");
							num++;
						}
					%>
					</tbody>
				</table>
			</div>
			
			<div class="search-form margin-top first align-right">
			<br>	
				<form action="yourname" method=get>
					<fieldset>
						<legend class="hidden">학생 분류</legend>
						<label class="hidden">학과</label>
						<select name="f">
							<option  value="default">전체</option>
							<option  value="computer">컴퓨터공학부</option>
							<option  value="information">정보통신학부</option>
							<option  value="itcontents">IT콘텐츠학과</option>
							<option  value="korean">국어국문학과</option>							
						</select> 
						<input type="submit" value="검색" />
					</fieldset>
				</form>
			</div>
		</main>
		
			
		</div>
	</div>

    </body>
    
    </html>