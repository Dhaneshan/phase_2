import java.sql.*;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Database5")
public class Database5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			PrintWriter PW= response.getWriter();
			InputStream IS=getServletContext().getResourceAsStream("WEB-INF/Properties1");
			Properties prop=new Properties();
			prop.load(IS);
			Connection con=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userid"),prop.getProperty("password"));
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into Ecommerce_product(name,price) values('Best laptop',45639)");
			PW.print("Insert In the Ecommerce_product Table is Successfull<br>");
			stmt.executeUpdate("update Ecommerce_product set name='Galaxy Laptop' where id=7");
			PW.print("Updation In the Ecommerce_product Table is Successfull<br>");
			stmt.executeUpdate("delete from Ecommerce_product where name='Best laptop'");
			PW.print("Deletion In the Ecommerce_product Table is Successfull<br>");			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
