<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/userPageStyle.css" type="text/css" />
    <title>Strona uzytkownika</title>
</head>
<body>
<div id="allPage">
    <div id="userInfos">
        <img id="userLogo" src="css/noUserLogo.png">
        <p> Moje informacje </p> <%--    jak bedzie dao to dane beda pobierane z sesji--%>
        <p> Login: ${login}  </p>
        <p> Email: ...  </p>
        <button id="userInfosButton"> Edytuj dane</button>
    </div>

    <div class="groups">
        <img id="groupLogo" src="css/groupLogo.png">
        <p class="textNearImage">Grupy zajęciowe:</p>
        <ul>
            <table>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td><li class="groupList"><a href="/">${group}</a></li></td>
                <td><button class="deleteGroupButton">Usun grupe</button></td>
            </tr>
        </c:forEach>
            </table>
        </ul>
        <button id="addGroupButton"> Dodaj grupę</button>
    </div>
</div>

<%--<script src="main/webapp/js/userPage.js"></script>--%>
</body>
</html>
