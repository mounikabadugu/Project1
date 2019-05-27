<%@page import="java.util.List"%>
<%@page import="com.mounika.model.SupplierPOJO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ page isELIgnored="false" %>
 <%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  border="5">
<tr>
<th>SupplierName</th>
<th>SupplierSalary</th>
<th>SupplierAddress</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<c:forEach items="${SupData}" var="supp">
<tr>
<td>${supp.supplierName}</td>
<td>${supp.supplierSalary}</td>
<td>${supp.supplierAddress}</td>
<td><a href="edit?satid=${supp.supplierId}">edit</a></td>
<td><a href="del?satid=${supp.supplierId}">delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>