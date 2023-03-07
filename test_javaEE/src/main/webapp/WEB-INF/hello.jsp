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
<p>Hello</p>

<form method="post" action="hello">
    <c:set var="root" value=""/>
    <button type="submit" name="root" value="home">Accueil</button>
</form>

</body>
</html>
