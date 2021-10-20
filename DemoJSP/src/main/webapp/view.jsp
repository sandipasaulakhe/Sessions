<%@ page import="java.util.ArrayList,java.sql.Statement,com.Student" isErrorPage="true" %>

<%@ include file="header.html" %>
<%@ taglib uri=""prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
 
 
 <%
 ArrayList<Student> al=(ArrayList<Student>)request.getAttribute("studentlist");
 for(Student s:al)
 {
	 %>
<tr><td><% out.print(s.getName()); %></td>
	 <td><%=s.getQualification() %></td>
 </tr>
 <% }  %>
 
 
 
 %>
 
</body>
</html>




<!-- //jsp transalates into servlet.java  -->



