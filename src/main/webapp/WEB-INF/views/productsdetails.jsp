<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ page isELIgnored="false" %>
    <%@ include file="UserHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="resources/ProductImages/${Prodetails.productId}.jpg" height="200" width="200" />
<br>
${Prodetails.productId}
<br>
${Prodetails.productName}
<br>
${Prodetails.productDiscription}
<br>
${Prodetails.productPrice}
<br>
${Prodetails.productCategory}
<br>
${Prodetails.productSupplier}
<br>

<form  action="savecartdata">
Quantity<input type="number" name="quantity" min="1" max="3" >
<input type="hidden" name="cartid" value="${Prodetails.productId}">
<input type="submit" value="AddToCart">
</form>

<a href="#">Buy</a>
</body>
</html>