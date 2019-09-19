<%--
  Created by IntelliJ IDEA.
  User: yuriy
  Date: 18.09.19
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
    <form action="/users/${param.id}" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <input type="text" name="name" value="${param.name}">
        <input type="text" name="age" value="${param.age}">
        <input type="hidden" name="_method" value="put">
        <input type="submit" value="Update">
    </form>
</body>
</html>
