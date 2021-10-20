<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String user=(String)request.getAttribute("user");
out.println("user from scriplet "+user); 

%>


<br/>

<p:if test="${user=='sandipa'}">
<h3>Welcome SANDIPA</h3>
</p:if>



<%="User FRom expression"+request.getAttribute("user")%>
<br/>
<h3>EL ${user} </h3>
<h4>Friend List</h4>
<ol>
<p:forEach items="${friendlist}" var="ob">
<li>${ob}</li>
</p:forEach>
</ol>


</body>
</html>