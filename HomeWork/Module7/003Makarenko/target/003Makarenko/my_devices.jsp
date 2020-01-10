<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 10.01.2020
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My devices</title>
</head>
<body>
    <table>
        <tr>
            <td>Type</td>
            <td>Name</td>
        </tr>
        <jstl:forEach items="${requestScope.allMyItems}" var="item">
            <tr>
                <td>${item.type}</td>
                <td>${item.name}</td>
            </tr>
        </jstl:forEach>
    </table>
</body>
</html>
