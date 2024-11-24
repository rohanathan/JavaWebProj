import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletContextDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	ServletContext context = getServletContext();
	String goldrate = context.getInitParameter("goldrate");
	out.println("goldrate: "+ goldrate);
	}


}
