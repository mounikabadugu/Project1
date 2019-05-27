<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
    <%@ page isELIgnored="false" %>
    <%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Category Form</h2>


<sform:form action="addCat"  method="post" modelAttribute="cat">
<div class="form-group">
      <label for="catdis">CategoryName:</label>

 <sform:input  path="categoryName" />
    </div>

 <div class="form-group">
      <label for="catdis">CategoryDiscription:</label>

 <sform:input  path="categoryDiscription" />
    </div>
        
<div class="form-group">
      <label for="catdis"></label>

 <sform:input  path="categoryId" type="hidden"/>
    </div>

<input type="submit"   value="${buttonName}" />
</sform:form>

</body>
</html>
