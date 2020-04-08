<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/userPage.css" type="text/css" />
    <title>Strona uzytkownika</title>
</head>
<body>
<div id="userInfos">
    <img class="logo" src="css/noUserLogo.png">
    <p> Moje informacje </p>
    <p> Login: ...  </p>
    <p> Email: ...  </p>
    <button id="userInfosButton"> Edytuj dane</button>
</div>

<div class="groups">
    <img id="groupLogo" src="css/groupLogo.png">
    <p class="textNearImage">Grupy zajęciowe:</p>
    <ul>
        <li><a href="/">Analiza 2020</a> </li>
        <li><a href="/"> Technika Analogowa 2019</a></li>
    <c:forEach items="${groups}" var="group">
        <li><a href="/">${group}</a></li>
    </c:forEach>
    </ul>
</div>


<%--<script src="main/webapp/js/userPage.js"></script>--%>
</body>
</html>
