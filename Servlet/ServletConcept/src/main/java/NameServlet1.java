
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/NameServlet1")
public class NameServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NameServlet1() 
    {
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter cout=response.getWriter();
		   String fname = request.getParameter("fname");
           String lname = request.getParameter("lname");
           cout.println("My Full Name is :"+fname+" "+lname);
	}

}
