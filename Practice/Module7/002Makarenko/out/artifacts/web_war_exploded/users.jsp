<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 07.12.2019
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hi, ${requestScope.user.login}</h1>
</body>
</html>
