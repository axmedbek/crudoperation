<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: axmedbek
  Date: 7/11/17
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Update for Users</title>
</head>
<body>
<form action="/register" method="post">
    <input type="hidden" name="action" value="update">
    <label>ID</label>
    <label><c:out value="${user.id}"/></label>
    <input type="hidden" name="id" value="${user.id}">
    <br>
    <label>Ad</label>
    <input type="text" name="fname" value="${user.firstName}">
    <br>
    <label>Soyad</label>
    <input type="text" name="lname" value="${user.lastName}">
    <br>
    <label>Email</label>
    <input type="text" name="email" value="${user.email}">
    <br><label>&nbsp;</label>

    <input type="submit" value="Update">
</form>
</body>
</html>
