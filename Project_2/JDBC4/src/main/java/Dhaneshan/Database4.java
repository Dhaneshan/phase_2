package Dhaneshan;
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

@WebServlet("/Database4")
public class Database4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		PrintWriter PW=response.getWriter();
		InputStream IS=getServletContext().getResourceAsStream("WEB-INF/Properties");
		Properties prop=new Properties();
		prop.load(IS);
		Connection con=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userid"),prop.getProperty("password"));
		Statement stmt = con.createStatement();
        stmt.executeUpdate("create database mydatabase");
        PW.println("Created database: mydatabase<br>");
        stmt.executeUpdate("use mydatabase");
        PW.println("Selected database: mydatabase<br>");
        stmt.executeUpdate("drop database mydatabase");
        stmt.close();
        PW.println("Dropped database: mydatabase<br>");
        con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
