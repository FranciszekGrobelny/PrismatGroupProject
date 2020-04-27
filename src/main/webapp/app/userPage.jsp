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
        <p> Moje informacje </p>
        <p> Login: ${personData.login}  </p>
        <p> Password: ${personData.password} </p>
        <p> Email: ${personData.email}</p>
        <p> Another Contact: ${personData.anotherContact}</p>
        <p> Lecturer Status: ${personData.permission}</p>

<form action="/app/userPage" method="post">
   <table>
                     <tr>
                        <td><p>Email:</p></td>            <td><input type="email"  placeholder="Enter your email" name="email" ></td>
                     </tr>
                     <tr>
                        <td><p>Another contact:</p></td>  <td><input type="text"  placeholder="Email or phone number" name="anotherContact"> </td>
                     </tr>
                     <tr>
                        <td><p>Password:</p></td>         <td><input type="password" name="password" placeholder="Enter your password" ></td>
                     </tr>

                  </table></br>
                    <button id="editButton" name ="editButton">Edit</button>
                  </form>
 </div>


    <div class="groups">
        <img id="groupLogo" src="css/groupLogo.png">
        <p class="textNearImage">Grupy zajęciowe:</p>
        <ul>
            <table>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td><li class="groupList"><a href="/">${group.name}</a></li></td>
                <td><a href="/app/delete?name=${group.name}" class="deleteGroupButton"><button >Usun grupe</button></a></td>
            </tr>
        </c:forEach>
            </table>
        </ul>
        <a href="/app/add" id="addGroupButton"><button > Dodaj grupe</button></a>
    </div>
</div>

<%--<script src="main/webapp/js/userPage.js"></script>--%>
</body>
</html>