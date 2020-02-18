<%--
  Created by IntelliJ IDEA.
  User: xing
  Date: 2020/2/18
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/loginUser" method="post">
    <h1>欢迎登录</h1>
    <input type="text" name="username"/><br/>
    <input type="password" name="password"><br/>
    <input type="submit" name="提交"/>
</form>
</body>
</html>
