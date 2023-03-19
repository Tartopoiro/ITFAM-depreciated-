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
    <title>AccountX</title>
</head>

<body>
<header>
    <div><img src="https://zupimages.net/up/23/10/pb0g.png" alt="logo" width="110" height="68"></div>
    <div><h1>AccountX</h1></div>
</header>

<main>
    <a href="../dossier">Retour</a><a href="pdf">PDF</a>
    <h3>Balance des comptes de la société ${sessionScope.dossier.denominationSociale}:</h3>

    <table>
        <thead>
        <tr>
            <th>Num</th>
            <th>libellé</th>
            <th>Solde</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${compte}" var="compte">
            <tr>
                <td>${compte.numCompte}</td>
                <td>${compte.libelle}</td>
                <td>${compte.solde}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

</main>

<footer>
    <p>Contact : bbasset.benjamin@gmail.com <br/>
        Auteur : Benjamin BASSET
    <p/>
</footer>
</body>
</html>
