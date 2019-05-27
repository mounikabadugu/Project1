<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
     <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="login"  method="post" modelAttribute="Login">
Email<sform:input  path="email"  /> 
<br>
Password <sform:input  path="password" />
<input type="submit"  value="submit"/>
</sform:form>

</body>
</html>