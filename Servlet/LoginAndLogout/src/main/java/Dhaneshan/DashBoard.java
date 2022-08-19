package Dhaneshan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/DashBoard")
public class DashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DashBoard() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
         out.println("<html><body>");
         
         HttpSession session=request.getSession(false);  
         String user = null;
         if (session.getAttribute("userid") != null)
             user =(String)session.getAttribute("userid");  
         if (user == null ) {
             out.println("No UserId was found in session.<br>");
         } else {
             out.println("UserId obtained from session :" + user + "<br>");
             out.println("<a href='Logout'>Logout of session</a><br>");
         }
         out.println("</body></html>");
	}
}
