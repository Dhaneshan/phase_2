package Dhaneshan;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DashBoard")
public class DashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DashBoard() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter cout=response.getWriter();
		String user=request.getParameter("userid");
		if(user==null)
		{
			cout.println("No UserId was found in the URL.");
		}
	     else
		 {
	       cout.println("UserId obtained from URL Rewriting:" + user);
		}
	}
}
