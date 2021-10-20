<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${user=='Pranav'}">
<h1>Welcome Pranav</h1>
</c:if>



<table border=1>
<tr>
<td>Id</td>
<td>Name</td>
<td>Qualification</td>
<td>Placed</td>
</tr>


<c:forEach items="${studentlist}" var="sobj">
<c:if test="${sobj.getPlaced()=='P'}">
<tr>
<td>${sobj.getSid()}</td>
<td>${sobj.getName()}</td>
<td>${sobj.getQualification()}</td>
<td>${sobj.getPlaced()}</td>
</tr>
</c:if>
</c:forEach>

</table>
</body>
</html>