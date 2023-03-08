
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="${pageContext.request.contextPath}/webjars/jQuery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery-ui/dist/jquery-ui.min.js"></script>


<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/jquery-ui/themes/base/all.css?v=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css?v=1">
        <meta charset="utf-8" />
        <title>Login</title>
    </head>
    <body>
        <header>
            <div><img src="https://zupimages.net/up/23/10/pb0g.png" alt="logo" width="110" height="68"></div>
            <div><h1>AccountX</h1></div>
        </header>

        <main>
            <form class="login" method="post" action="login">
                <fieldset>
                    <legend>Connexion</legend>


                    <label for="email">Adresse email : </label>
                    <input class="entry" type="email" id="email" name="email" value="<c:out value="${utilisateur.mail}"/>" size="20" maxlength="60" />

                    <br />

                    <label for="motdepasse">Mot de passe : </label>
                    <input class="entry" type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />

                    <br />

                    <span class = "avertissement">${connexion.erreur}</span>

                    <br />

                    <input class="form-submit" type="submit" />

                    <br />
                </fieldset>
            </form>
        </main>

        <footer>

            <p>Contact : bbasset.benjamin@gmail.com <br />
            Auteur : Benjamin BASSET<p/>
        </footer>

    </body>
</html>
