<%--
  Created by IntelliJ IDEA.
  User: yuriy
  Date: 18.09.19
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <p>User list</p>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Age</td>
            <td>Actions</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getAge()}</td>
                <td>
                    <form action="updateUser.jsp" method="post">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input type="hidden" name="name" value="${user.getName()}">
                        <input type="hidden" name="age" value="${user.getAge()}">
                        <input type="submit" value="Update" style="float:left">
                    </form>
                    <form action="deleteUser.jsp" method="post">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input type="submit" value="Delete" style="float:left">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="addUser.jsp">
        <input type="submit" value="Add new user">
    </form>
</body>
</html>
