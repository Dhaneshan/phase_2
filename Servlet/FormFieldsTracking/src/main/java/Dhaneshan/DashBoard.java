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
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String userId = request.getParameter("userid");
        if (userId == null) {
            out.println("No UserId was found in hidden form field.<br>");
        } else {
            out.println("UserId found in hidden form field: " + userId + "<br>");
            
        }
        out.println("</body></html>");
	}
}
