<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 18.12.2019
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <jstl:choose>
        <jstl:when test="${not empty sessionScope.user}">
            <p>${sessionScope.user.login}</p>
            <!--<p><a href="controller?action=">My bunch</a></p>-->
            <p><a href="controller?action=logout">Logout</a></p>
            <table>
                <tr>
                    <td>Type</td>
                    <td>Name</td>
                    <td>Rent cost</td>
                    <td>Total cost</td>
                </tr>
                <jstl:forEach items="${requestScope.items}" var="item">
                    <tr>
                        <td>${item.type}</td>
                        <td>${item.name}</td>
                        <td>${item.rentCost}</td>
                        <td>${item.totalCost}</td>
                    </tr>
                </jstl:forEach>
            </table>
        </jstl:when>
        <jstl:otherwise>
            <p><a href="register.jsp">Register</a></p>
            <p><a href="login.jsp">Login</a></p>
        </jstl:otherwise>
    </jstl:choose>
    <p>Choose your device</p>
</body>
</html>