<%@ page import="crudoperation.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="crudoperation.dao.UserDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>List of Albums</title>
</head>
<body>

<h1>List of Users</h1>

<%

    UserDaoImpl userDaoImpl = new UserDaoImpl();
    List<User> userList = userDaoImpl.allUser();
    HttpSession s = request.getSession();
    s.setAttribute("userList",userList);

%>
<table style="border:seagreen 1px solid;">
    <tr style="border:1px solid">
        <th>Sil</th>
        <th>Update</th>
        <th>ID</th>
        <th>Ad</th>
        <th>Soyad</th>
        <th>Email</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <th><a href="/register/?action=delete&user_id=${user.id}">sil</a></th>
            <th><a href="/register/?action=update&user_id=${user.id}">Update</a></th>
            <th>${user.id}</th>
            <th>${user.firstName}</th>
            <th>${user.lastName}</th>
            <th>${user.email}</th>
        </tr>
    </c:forEach>
</table>

<a href="<c:url value="register.jsp" />">Register Page</a>
</body>
</html>
