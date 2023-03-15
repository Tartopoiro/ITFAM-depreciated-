<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="${pageContext.request.contextPath}/webjars/jQuery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery-ui/dist/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/alertbox.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css?v=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/jquery-ui/themes/base/all.css?v=1">

    <title>AccountX</title>
</head>




<body>

<header>
    <div><img src="https://zupimages.net/up/23/10/pb0g.png" alt="logo" width="110" height="68"></div>
    <div><h1>AccountX</h1></div>
</header>

<nav class="navbar">
    <ul class="nav-menu">
        <li class="nav-item dropdown">
            <a id="confirm" href="../home">Accueil</a>
        </li>
        <li class="nav-item dropdown">
            <a href="#" class="dropdown-toggle">Modifier</a>
            <ul class="dropdown-menu">
                <li><a href="dossier/representant">Représentant</a></li>
                <li><a href="dossier/info">Information Dossier</a></li>
            </ul>
        </li>
        <li class="nav-item dropdown">
            <a href="#" class="dropdown-toggle">Saisir</a>
            <ul class="dropdown-menu">
                <li><a href="#">Achat</a></li>
                <li><a href="#">Vente</a></li>
            </ul>
        </li>
        <li class="nav-item dropdown">
            <a href="#" class="dropdown-toggle">Editer</a>
            <ul class="dropdown-menu">
                <li><a href="#">Balance</a></li>
                <li><a href="#">Journal/FEC</a></li>
                <li><a href="#">Détail compte</a></li>
            </ul>
        </li>
    </ul>
</nav>

<main>

 <div class="centeredContainer ">

     <table class="customTable">
         <thead>
             <tr>
                 <th colspan="2">${sessionScope.dossier.iddossier} ${sessionScope.dossier.denominationSociale}</th>
             </tr>
         </thead>
         <tbody>
             <tr>
                 <td>Telephone : </td>
                 <td>${sessionScope.dossier.tel}</td>
             </tr>
             <tr>
                 <td>Mail : </td>
                 <td>${sessionScope.dossier.mail}</td>

             </tr>
             <tr>
                 <td>Siège social : </td>
                 <td>${sessionScope.dossier.adresse.numero} ${sessionScope.dossier.adresse.rue}, ${sessionScope.dossier.adresse.ville} ${sessionScope.dossier.adresse.pays}</td>
             </tr>
             <tr>
                 <td>Forme Juridique : </td>
                 <td>${sessionScope.dossier.formeJuridique}</td>
             </tr>
             <tr>
                 <td>Note : </td>
                 <td>${sessionScope.dossier.commentaire}</td>
             </tr>
         </tbody>
     </table>
     <table class="customTable">
         <thead>
         <tr>
             <th colspan="2">Représentant</th>
         </tr>
         </thead>
         <tbody>
         <tr>
             <td>Nom : </td>
             <td>${sessionScope.dossier.representant.nom}</td>
         </tr>
         <tr>
             <td>Prénom : </td>
             <td>${sessionScope.dossier.representant.prenom}</td>

         </tr>
         <tr>
             <td>Qualité : </td>
             <td>${sessionScope.dossier.representant.qualite}</td>
         </tr>
         <tr>
             <td>Téléphone : </td>
             <td>${sessionScope.dossier.representant.tel}</td>
         </tr>
         <tr>
             <td>Mail : </td>
             <td>${sessionScope.dossier.representant.mail}</td>
         </tr>
         <tr>
             <td>Adresse : </td>
             <td>${sessionScope.dossier.representant.adresse.numero} ${sessionScope.dossier.representant.adresse.rue}, ${sessionScope.dossier.representant.adresse.ville} ${sessionScope.dossier.representant.adresse.pays}</td>
         </tr>
         </tbody>
     </table>
 </div>

</main>

<footer>

    <p>Contact : bbasset.benjamin@gmail.com <br />
        Auteur : Benjamin BASSET<p/>
</footer>

</body>
</html>
