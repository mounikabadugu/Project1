<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addUser"  method="post" modelAttribute="user">

Email<sform:input  path="email"  /> 
<br>
Password <sform:input  path="password" />
<br>
<br>
userName<sform:input  path="userName" />
<br>
MobileNo<sform:input  path="mobileNo" />
<br>
Address <sform:input  path="address" />
<br>
  <input type="submit"  value="submit"/>
</sform:form>
</body>
</html>