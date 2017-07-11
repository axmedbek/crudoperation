<%--
  Created by IntelliJ IDEA.
  User: axmedbek
  Date: 7/9/17
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<form action="/register" method="post">
    <input type="hidden" name="action" value="register">
    <label>Email:</label>
    <input type="text" name="email" >
    <label>First Name:</label>
    <input type="text" name="firstname">
    <label>lastName:</label>
    <input type="text" name="lastname" >
    <label>&nbsp;</label>
    <input type="submit" value="Register">

</form>
</body>
</html>
