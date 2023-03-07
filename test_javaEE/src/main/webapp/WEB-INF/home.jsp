<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/02/2023
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Home</p>

<h1>Enter Your Name and Surname</h1>
<form action="home" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br>
    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
