package Dhaneshan;
import java.sql.*;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Database3")
public class Database3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			PrintWriter out=response.getWriter();
			InputStream in=getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props=new Properties();
			props.load(in);
			Connection con=DriverManager.getConnection(props.getProperty("url"),props.getProperty("userid"),props.getProperty("password"));
			CallableStatement stmt = con.prepareCall("{call add_product(?, ?)}");
            stmt.setString(1, "Omen Laptop");
            stmt.setBigDecimal(2, new BigDecimal(10900.50));
            stmt.executeUpdate();
            out.print("Stored procedure has been executed.");
		}
		catch(Exception e)
		{
			
		}	
	}
}
