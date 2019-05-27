<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ page isELIgnored="false" %>
      <%@ include file="UserHeader.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

  
  <div class="container-fluid">
    <!-- Control the column width, and how they should appear on different devices -->
    <div class="row">
    <c:forEach items="${UserPro}" var="pro" >
    
      <div class="col-sm-4" style="background-color:white;">
      <img src="resources/ProductImages/${pro.productId}.jpg" height="50" width="50"/>
<br>
${pro.productId}
<br>
${pro.productName}
<br>
${pro.productDiscription}
<br>
${pro.productPrice}
<br>
${pro.productCategory}
<br>
${pro.productSupplier}
<br>
 <a href="view?proid=${pro.productId}">viewdetails</a>
 <br>     
      </div>
      
    
    
</c:forEach>
</div>
    </div>

</body>
</html>
