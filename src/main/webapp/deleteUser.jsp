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
    <title>Delete user</title>
</head>
<body>
    Delete user ${param.id}?
    <form action="/users/${param.id}" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>
</body>
</html>
