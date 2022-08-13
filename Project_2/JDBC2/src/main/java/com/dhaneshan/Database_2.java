package com.dhaneshan;
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
@WebServlet("/Database_2")
public class Database_2 extends HttpServlet {
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
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate("insert into Ecommerce_product(name,price)values( 'Acer Laptop',45896)");
		    ResultSet rs=stmt.executeQuery("select * from Ecommerce_product");
		    out.print("Product ID" + "," + "Product Name");
		    out.print("<br>");
			while(rs.next())
			{
				out.print("<br>");
				out.print(rs.getInt("id") + "\t\t\t\t\t" +rs.getString("name"));
				out.print("<br>");  
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}

