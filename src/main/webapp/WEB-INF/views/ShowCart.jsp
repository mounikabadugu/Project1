<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
 </head>
<body>
 <table  border="5">
<tr>
<th>ProductName</th>
<th>ProductPrice</th>
<th>SupplierName</th>
<th>Quantity</th>
<th>TotalPrice</th>


</tr>

<c:forEach items="${cartdata}" var="cart" >
<tr>
<td>${cart.productName}</td>
<td>${cart.productPrice}</td>
<td>${cart.supplierName}</td>
<td>${cart.quantity}</td>
<td>${cart.totalPrice}</td>

</tr>
</c:forEach>
</table>
</body>
</html>