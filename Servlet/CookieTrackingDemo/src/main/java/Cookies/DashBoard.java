package Cookies;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		Cookie cookie=null;
		Cookie cookies[]=null;
		boolean found = false;
        PrintWriter cout = response.getWriter();
        cookies=request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i]; 
            if ( cookie.getValue() != null) {
               cout.println("UserId read from cookie:" + cookie.getValue() );
                found = true;
            }
         }
    }
    if (!found) {
        cout.println("No UserId was found in cookie.<br>");
    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
