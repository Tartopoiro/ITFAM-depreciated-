<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="${pageContext.request.contextPath}/webjars/jQuery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery-ui/dist/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/alertbox.js"></script>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/jquery-ui/themes/base/all.css?v=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css?v=1">
    <meta charset="utf-8"/>
    <title>Contact</title>
</head>

<body>

<header>
    <div><img src="https://zupimages.net/up/23/09/e3hw.png" alt="logo" width="110" height="68"></div>
    <div><h1>AccountX</h1></div>
</header>

<main>

    <form method="post" action="info" class="centeredContainer">
        <fieldset>
            <legend> Changement de contact </legend>
            <table>
                <tr>
                    <td><label for="mail" >Email</label></td>
                    <td><input class="entry" maxlength="80" id="mail" name="mail"  type="email" value="${sessionScope.dossier.mail}"></td>
                </tr>
                <tr>
                    <td><label for="numero" >Numéro de téléphone</label></td>
                    <td><input class="entry" maxlength="10" minlength="9" id="numero" name="numero" type="number" value="${sessionScope.dossier.tel}"></td>
                </tr>
                <tr>
                    <td><input class="form-submit" id="confirm" type="submit"></td>
                </tr>
            </table>
        </fieldset>
    </form>

</main>

<footer>
    <p>Contact : bbasset.benjamin@gmail.com <br/>
        Auteur : Benjamin BASSET
    <p/>
</footer>
</body>
</html>
