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
    <form method="post" action="representant" class="centeredContainer">
        <fieldset>
            <legend> Modifier les informations </legend>
            <table>
                <tr>
                    <td><label for="nom" >Nom </label></td>
                    <td><input class="entry" maxlength="45" id="nom" name="nom"  type="text" value="${sessionScope.dossier.representant.nom}"></td>
                </tr>
                <tr>
                    <td><label for="prenom" >Prénom </label></td>
                    <td><input class="entry" maxlength="45" id="prenom" name="prenom"  type="text" value="${sessionScope.dossier.representant.prenom}"></td>
                </tr>
                <tr>
                    <td><label for="tel" >Numéro de téléphone</label></td>
                    <td><input class="entry" maxlength="10" minlength="9" id="tel" name="tel" type="number" value="${sessionScope.dossier.representant.tel}"></td>
                </tr>
                <tr>
                    <td><label for="mail" >Mail </label></td>
                    <td><input class="entry" maxlength="80" id="mail" name="mail"  type="email" value="${sessionScope.dossier.representant.mail}"></td>
                </tr>
                <tr>
                    <td><label for="qualite" >Qualité </label></td>
                    <td><input class="entry" maxlength="45" id="qualite" name="qualite" value="${sessionScope.dossier.representant.qualite}"></td>
                </tr>
                <tr>
                    <th colspan="2"> <h4>Adresse</h4> </th>
                </tr>
                <tr>
                    <td><label for="numadresse" >Numéro</label></td>
                    <td><input class="entry" maxlength="10" id="numadresse" name="numadresse"  type="text" value="${sessionScope.dossier.representant.adresse.numero}"></td>
                </tr>
                <tr>
                    <td><label for="rue" >Rue</label></td>
                    <td><input class="entry" maxlength="45" id="rue" name="rue"  type="text" value="${sessionScope.dossier.representant.adresse.rue}"></td>
                </tr>
                <tr>
                    <td><label for="ville" >Ville</label></td>
                    <td><input class="entry" maxlength="45" id="ville" name="ville"  type="text" value="${sessionScope.dossier.representant.adresse.ville}"></td>
                </tr>
                <tr>
                    <td><label for="pays" >Pays</label></td>
                    <td><input class="entry" maxlength="45" id="pays" name="pays"  type="text" value="${sessionScope.dossier.representant.adresse.pays}"></td>
                </tr>
                <tr>
                    <td><label for="complement" >Complement</label></td>
                    <td><input class="entry" maxlength="90" id="complement" name="complement"  type="text" value="${sessionScope.dossier.representant.adresse.complement}"></td>
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
