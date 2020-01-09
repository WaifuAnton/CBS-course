<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 09.01.2020
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Buy device</title>
</head>
<body>
    <table>
        <form method="post" action="controller?action=buy_device">
            <input type="hidden" name="device_id" value="${item.id}"/>
            <input type="hidden" name="device_name" value="${item.name}"/>
            <input type="hidden" name=""/>
        </form>
    </table>
</body>
</html>
