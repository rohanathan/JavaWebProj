import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ServletConfigDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();//implemented by generic servlet class--httpservlet is a subclass of servlet
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		out.println("username: "+username);
		out.println("\npassword: "+password);
		
	}


}
