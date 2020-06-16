import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class detail extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

//		String a = (String)req.getAttribute("id");
		String a = req.getParameter("id");
		String op = req.getParameter("operator");
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String depts = req.getParameter("dept"); // 배열 나중에 처리해야됨 string으로 변환
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
			
			String sql = "SELECT * FROM databasetest.member where id = '" + a + "'";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				userId = rs.getString("id");
				userPwd = rs.getString("password");
				userName = rs.getString("name");
				userTel = rs.getString("tel");
				userEmail = rs.getString("email");
				userDept = rs.getString("dept");
				userGender = rs.getString("gender");
				userBirth = rs.getString("birth");
				userIntroduction = rs.getString("introduction");
				System.out.printf("data: %s %s %s %s %s %s %s %s\n", userId, userName, userTel, userEmail, userDept,
						userGender, userBirth, userIntroduction);
				req.setAttribute("id", userId);
				req.setAttribute("name", userName);
				req.setAttribute("tel", userTel);
				req.setAttribute("email", userEmail);
				req.setAttribute("dept", userDept);
				req.setAttribute("gender", userGender);
				req.setAttribute("birth", userBirth);
				req.setAttribute("introduction", userIntroduction);
				
				req.getRequestDispatcher("detail.jsp").forward(req, resp);								
				
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String a = req.getParameter("operator");		
		String b = "";		
		b = a.substring(4, a.length()-7);		//id
		
		req.setAttribute("id", b);
		req.getRequestDispatcher("pwcheck.jsp").forward(req, resp);
		
	}
	
}
