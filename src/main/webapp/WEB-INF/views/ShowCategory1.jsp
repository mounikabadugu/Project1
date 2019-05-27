<%@page import="java.util.List"%>
<%@page import="com.mounika.model.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@page isELIgnored="false" %>
  <%@ include file="adminHeader.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  border="1">
<tr>
<th>
CategoryName
</th>

<th>
CategoryDiscription
</th>
<th>
Edit
</th>
<th>delete</th>
</tr>

<c:forEach items="${Catdata}" var="caat">
<tr>
<td>${caat.categoryName}</td>
<td>${caat.categoryDiscription}</td>
<td><a href="mmm?catid=${caat.categoryId}">edit</a></td>
<td><a href="sss?catid=${caat.categoryId}">delete</a></td>
</tr>
</c:forEach>

</table>

</body>
</html>