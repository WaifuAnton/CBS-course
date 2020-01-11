<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 07.12.2019
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="client" action="form" method="post">
        <p>
            Name:<br>
            <input type="text" name="name" size="20"/>
        </p>

        <p>
            Age:<br>
            <input type="text" name="age" size="5"/>
        </p>

        <p>
        Phone:<br>
            <input type="text" name="phone" size="20"/>
        </p>

        <p>
        Password:<br>
            <input type="password" name="password" size="20"/>
        </p>

        <p><input type="submit" name="submit" value="Submit"></p>
    </form>
</body>
</html>
