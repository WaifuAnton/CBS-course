<%@ page import="entity.Client" %><%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 07.12.2019
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="clients.css"/>
</head>
<body>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Age</td>
            <td>Phone</td>
        </tr>
        <c:forEach items="${requestScope.clients}" var="client">
            <tr>
                <td>${client.name}</td>
                <td>${client.age}</td>
                <td>${client.phone}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
