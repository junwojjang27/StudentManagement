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

@WebServlet("/pwcheck")
public class pwcheck extends HttpServlet {

	@SuppressWarnings("deprecation")
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int type=0;
		String a = req.getParameter("operator");		
		String id = "";		
		id = a.substring(4, a.length()-7);		
		String password = req.getParameter("pwd");
		
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/databasetest?serverTimezone=UTC";

		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			
			ResultSet rv = st.executeQuery("SELECT * FROM databasetest.member");
			while (rv.next()) {
				if (id.equals(rv.getString("id"))) {
					if (password.equals(rv.getString("password"))) {
						System.out.println("패스워드일치");
						req.setAttribute("id", id);
						req.setAttribute("name", rv.getString("name"));
						
						req.getRequestDispatcher("member.jsp").forward(req, resp);
						
					}
					else {
						System.out.println("실패");
						type=3;
						req.setAttribute("type", type);
						req.getRequestDispatcher("output.jsp").forward(req, resp);
						
					}
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

		String op = req.getParameter("operator");

		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String dept = req.getParameter("dept");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		String intro = req.getParameter("introduction");

		System.out.println(id);

		int type = 0;

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
			
			
			String b = " password = '" + password + "', " + " tel = '" + tel + "', " + "email = '" + email + "', " + "dept = '" + dept
					+ "', " + "gender = '" + gender + "', " + "birth = '" + birth + "', "
					+ "introduction = '" + intro + "'";

			String c = " WHERE (id = '" + id + "')";
			System.out.println(b+c);
			PreparedStatement sx = con.prepareStatement("update databasetest.member set" + b + c);
			sx.executeUpdate();
			
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
