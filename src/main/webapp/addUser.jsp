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
    <title>Add new User</title>
</head>
<body>
    <form action="/users" method="post">
        <input required type="text" name="name" placeholder="Name">
        <input required type="text" name="age" placeholder="Age">
        <input type="submit" value="Add">
    </form>
</body>
</html>
