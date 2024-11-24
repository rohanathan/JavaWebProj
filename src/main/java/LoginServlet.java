import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class LoginServlet extends HttpServlet {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM OWNER WHERE username=? AND password=?");
			st.setString(1, username);  // Set the username
			st.setString(2, password);  // Set the password
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
			    String name = rs.getString("username");
			    System.out.println("Welcome " + name);
			    out.println("Logged in Successfully<br>");
			    out.println("Click <a href=\"/WebProj/login.jsp\">here to login</a>");
			} else {
			    out.println("Login failure due to wrong username/password");
			    out.println("Click <a href=\"/WebProj/login.jsp\">here to login</a>");
			}
		
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
		catch (Exception e) {
		}
	}
}
