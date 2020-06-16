
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/yourname")
public class yourname extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String op = req.getParameter("operator");
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String depts[] = req.getParameterValues("dept"); // 배열 나중에 처리해야됨 string으로 변환
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		String intro = req.getParameter("introduction");

		int type = 0;
		int cnt = 0;

		String userId = "";
		String userPwd = "";
		String userName = "";
		String userTel = "";
		String userEmail = "";
		String userDept = "";
		String userGender = "";
		String userBirth = "";
		String userIntroduction = "";

		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/databasetest?serverTimezone=UTC";

		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();

			if (op.equals("로그인")) {
				ResultSet rv = st.executeQuery("SELECT * FROM databasetest.member");

				while (rv.next()) {
					if (id.equals(rv.getString("id"))) {
						if (password.equals(rv.getString("password"))) {
							System.out.println("로그인성공");
							type = 1;
							rv.close();
							break;	
						}
						else {
							System.out.println("패스워드 오류");
							type = 2;
							req.setAttribute("type", type);
							req.getRequestDispatcher("output.jsp").forward(req, resp);
						}
					}
				}
				
				if(type==1) {
					ResultSet rb = st.executeQuery("select count(*) From member");
					if (rb.next()) {
						cnt = rb.getInt(1);
						rb.close();
					}

					String ID[] = new String[cnt];
					String NAME[] = new String[cnt];
					int j=0;
					
					ResultSet rw = st.executeQuery("SELECT * FROM databasetest.member");
					while (rw.next()) {
						userId = rw.getString("id");
						userName = rw.getString("name");
						System.out.print(userId+"\t");
						System.out.println(userName);
						ID[j] = userId;
						NAME[j] = userName;
						j++;
					}
				
					while(true) {
						req.setAttribute("ID[0]", ID[0]);
						req.setAttribute("NAME[0]", NAME[0]);
						if(cnt==1) break;						
						req.setAttribute("ID[1]", ID[1]);
						req.setAttribute("NAME[1]", NAME[1]);
						if(cnt==2) break;
						req.setAttribute("ID[2]", ID[2]);
						req.setAttribute("NAME[2]", NAME[2]);
						if(cnt==3) break;
						req.setAttribute("ID[3]", ID[3]);
						req.setAttribute("NAME[3]", NAME[3]);
						if(cnt==4) break;
						req.setAttribute("ID[4]", ID[4]);
						req.setAttribute("NAME[4]", NAME[4]);
						if(cnt==5) break;
						req.setAttribute("ID[5]", ID[5]);
						req.setAttribute("NAME[5]", NAME[5]);
						if(cnt==6) break;
						req.setAttribute("ID[6]", ID[6]);
						req.setAttribute("NAME[6]", NAME[6]);
						if(cnt==7) break;
						req.setAttribute("ID[7]", ID[7]);
						req.setAttribute("NAME[7]", NAME[7]);
						if(cnt==8) break;
						req.setAttribute("ID[8]", ID[8]);
						req.setAttribute("NAME[8]", NAME[8]);
						if(cnt==9) break;
						req.setAttribute("ID[9]", ID[9]);
						req.setAttribute("NAME[9]", NAME[9]);
						break;
					}									
					
					req.setAttribute("cnt", cnt);
					req.getRequestDispatcher("list.jsp").forward(req, resp);
				}
			}
			
			if(op.equals("가입")) {
				ResultSet ry = st.executeQuery("SELECT * FROM databasetest.member");

				while (ry.next()) {
					if (id.equals(ry.getString("id"))) {					
						System.out.println("아이디중복");
						type = 4;
						req.setAttribute("type", type);
						req.getRequestDispatcher("output.jsp").forward(req, resp);
						break;
					}
					else {
						type = 20;
						
					}
				}
				if(type==20) {
					req.setAttribute("id", id);
					req.getRequestDispatcher("insert.jsp").forward(req, resp);
				}
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String dept = req.getParameter("f");
		System.out.println(dept);
		
		String op = req.getParameter("operator");
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String depts[] = req.getParameterValues("dept"); // 배열 나중에 처리해야됨 string으로 변환
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		String intro = req.getParameter("introduction");

		int type = 0;
		int cnt = 0;
		
		String userId = "";
		String userPwd = "";
		String userName = "";
		String userTel = "";
		String userEmail = "";
		String userDept = "";
		String userGender = "";
		String userBirth = "";
		String userIntroduction = "";
		
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/databasetest?serverTimezone=UTC";

		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
		
			ResultSet rx = st.executeQuery("select count(*) From member where dept = '" + dept + "'");
			if (rx.next()) {
				cnt = rx.getInt(1);
				rx.close();
			}

			String ID[] = new String[cnt];
			String NAME[] = new String[cnt];
			int j=0;
			
			ResultSet rb = st.executeQuery("select * from member where dept = '" + dept + "'");
			while (rb.next()) {
				userId = rb.getString("id");
				userName = rb.getString("name");
				System.out.print(userId+"\t");
				System.out.println(userName);
				ID[j] = userId;
				NAME[j] = userName;
				j++;
			}
			
			while(true) {
				req.setAttribute("ID[0]", ID[0]);
				req.setAttribute("NAME[0]", NAME[0]);
				if(cnt==1) break;						
				req.setAttribute("ID[1]", ID[1]);
				req.setAttribute("NAME[1]", NAME[1]);
				if(cnt==2) break;
				req.setAttribute("ID[2]", ID[2]);
				req.setAttribute("NAME[2]", NAME[2]);
				if(cnt==3) break;
				req.setAttribute("ID[3]", ID[3]);
				req.setAttribute("NAME[3]", NAME[3]);
				if(cnt==4) break;
				req.setAttribute("ID[4]", ID[4]);
				req.setAttribute("NAME[4]", NAME[4]);
				if(cnt==5) break;
				req.setAttribute("ID[5]", ID[5]);
				req.setAttribute("NAME[5]", NAME[5]);
				if(cnt==6) break;
				req.setAttribute("ID[6]", ID[6]);
				req.setAttribute("NAME[6]", NAME[6]);
				if(cnt==7) break;
				req.setAttribute("ID[7]", ID[7]);
				req.setAttribute("NAME[7]", NAME[7]);
				if(cnt==8) break;
				req.setAttribute("ID[8]", ID[8]);
				req.setAttribute("NAME[8]", NAME[8]);
				if(cnt==9) break;
				req.setAttribute("ID[9]", ID[9]);
				req.setAttribute("NAME[9]", NAME[9]);
				break;
			}		
			req.setAttribute("cnt", cnt);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
