
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

    <title>Home</title>
</head>




<body>

<header>
    <div><img src="https://zupimages.net/up/23/10/pb0g.png" alt="logo" width="110" height="68"></div>
    <div><h1>AccountX</h1></div>
</header>

<main>




<div class = "centeredContainer">
    <h2>Bienvenue ${sessionScope.utilisateur.prenom}</h2><br />
    <div class="avertissement">-- N'utilisez pas cet outil pour faire votre comptabilité sans des connaissances avancées en système d'information et en comptabilité --</div>
</div>
<form method="post" action="home">
    <c:set var="root" value=""/>
    <div class = centeredContainer>
        <input class="dossier" type ="text" id = "dossier" name="dossier" placeholder="N° Dossier">
        <button class="confirm" type="submit" name="root" value="dossier">Confirmer</button>
    </div>
<form/>

</main>

<footer>

    <p>Contact : bbasset.benjamin@gmail.com <br />
        Auteur : Benjamin BASSET<p/>
    <form method="post" action="home">
        <button id="confirm" class="exit" type="submit" name="root" value="exit">Deconnexion</button>
    </form>
</footer>



<script>
    var data = ${dossierlist} ;
    $(document).ready(function() {
        $("#dossier").autocomplete({
            source: data
        });
    });
</script>

</body>
</html>
