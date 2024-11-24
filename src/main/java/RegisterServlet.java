import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
	Connection con;
	public void init(ServletConfig config) {
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url"); 
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		try {
            // Load the PostgreSQL JDBC driver
            Class.forName(driver);
            // Establish a connection to the PostgreSQL database
            con = DriverManager.getConnection(url,username,password);
	}
		catch (Exception e){
			System.out.println(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		String lname = request.getParameter("lname");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO OWNER (fname, mname, lname, username,phone, email, password) VALUES (?, ?, ?, ?, ?, ?,?)");
			st.setString(1, fname);
			st.setString(2, mname);
			st.setString(3, lname);
			st.setString(4, username);
			st.setString(5, phone);
			st.setString(6, email);
			st.setString(7, password);
			st.executeUpdate();
			out.println("Registered Successfully<br>");
			out.println("Click <a href=\"/WebProj/login.jsp\">here to login</a>");

		}
		catch (Exception e) {
			out.println(e);
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void destroy() {
		try {
			con.close();
		}
		catch (Exception e){
			
		}
	}

}
