import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/InterfaceDemo")
public class InterfaceDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config=null;

    public InterfaceDemo()
    {
       
    }

	public void init(ServletConfig config) throws ServletException {
	this.config=config;
	
	System.out.println("Intialization Complete");
	}

	public void destroy() {
		  System.out.println("In destroy() method");
	}

	public ServletConfig getServletConfig() {
		
		  return config;
	}

	public String getServletInfo() {
		
		   return "This is a sample servlet info";
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter cout=response.getWriter();
         cout.print("<html>");
         cout.print("<body>");
         cout.print("In the service() method<br>");
         cout.print("</body>");
         cout.print("</html>");

	}

}
