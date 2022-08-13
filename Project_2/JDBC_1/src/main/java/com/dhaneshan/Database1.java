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
@WebServlet("/Database1")
public class Database1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private Connection con;
	public void closeConnection()throws SQLException
	{
		if(this.con!=null)
			this.con.close();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			PrintWriter output=response.getWriter();
			InputStream in=getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props=new Properties();
			props.load(in);
			con=DriverManager.getConnection(props.getProperty("url"),props.getProperty("userid"),props.getProperty("password"));
			output.println("DB connection Initialized");
			closeConnection();
			output.println("DB connection Closed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
