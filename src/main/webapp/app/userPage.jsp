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
 <%@include file="../tmpHeader.jsp" %>

    <div id="allPage">

        <div id="userInfos">
            <img id="userLogo" src="css/noUserLogo.png">
            <p> User information </p>
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
            <p class="textNearImage">Groups:</p>
                <div class="tab"  style="position: relative; left:40px;">
                <table  cellspacing="1" border="1" margin-left:"100px">
                    <c:forEach items="${groups}" var="group">
                    <tr>
                        <td style="min-width:450px" style="max-width:451px"><li class="groupList"><a href="/">${group.getName()}</a></li></td>
                        <td><input type="submit" href="/app/delete?name=${group.name}" class="deleteGroupButton" value="Delete Group" style="padding:4px 30px;   position: relative; left:0px;"></br></td>

                    </tr>
                    </c:forEach>
                </table>
                </div>
            <a href="/app/addGroup" id="addGroupButton"> Add Group</a>
        </div>

    <%--<script src="main/webapp/js/userPage.js"></script>--%>
    </div>
<%@include file="../footer.jsp" %>
</body>
</html>