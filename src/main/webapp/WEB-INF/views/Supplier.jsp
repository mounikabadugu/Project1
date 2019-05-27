<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
     <%@ page isELIgnored="false" %>
     <%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addSat"  method="post" modelAttribute="sat">
SupplierName <sform:input  path="supplierName" />
SupplierSalary<sform:input  path="supplierSalary" />
SupplierAddress<sform:input  path="supplierAddress" />
<sform:input  path="supplierId" type="hidden"/>
<input type="submit"  value="${buttonName}" />
</sform:form>
</body>
</html>