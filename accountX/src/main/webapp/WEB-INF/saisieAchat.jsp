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
    <form method="post" action="#" class="centeredContainer">
        <fieldset>
            <legend> Nouvelle facture : </legend>
            <table>
                <tr>
                    <td><label for="numFacture" >Numéro de facture </label></td>
                    <td><input class="entry" maxlength="80" id="numFacture" name="numFacture"  type="text"></td>
                </tr>
                <tr>
                    <td><label for="fournisseur" >Fournisseur </label></td>
                    <td><input class="entry" maxlength="80" id="fournisseur" name="fournisseur"  type="text"></td>
                </tr>
                <tr>
                    <td><label for="montantTTC" >Montant TTC (- si avoir) </label></td>
                    <td><input class="entry" maxlength="12" id="montantTTC" name="montantTTC" type="number"></td>
                </tr>
                <tr>
                    <td><label for="montantTVA" >Montant TVA (- si avoir) </label></td>
                    <td><input class="entry" maxlength="12" id="montantTVA" name="montantTVA" type="number"></td>
                </tr>
                <tr>
                    <td><label for="dateFacture" >Date de facturation </label></td>
                    <td><input class="entry" maxlength="45" id="dateFacture" name="dateFacture"  type="date"></td>
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
