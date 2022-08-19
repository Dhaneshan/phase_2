<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
    String i=request.getParameter("name");
    for(int h=0;h<5;h++)
    {
    	out.println("Welcome "+i);
    	 
    }
     %>
</body>
</html>