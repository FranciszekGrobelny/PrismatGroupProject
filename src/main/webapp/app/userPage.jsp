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
<div>
    <%@include file="../tmpHeader.jsp" %>
</div>
<div id="allPage">
    <div id="userInfos">
        <img id="userLogo" src="css/noUserLogo.png">
        <p> Moje informacje </p>
        <p> Login: ${personData.login}  </p>
        <p> Password: ${personData.password} </p>
        <p> Email: ${personData.email}</p>
        <p> Another Contact: ${personData.anotherContact}</p>
        <p> Lecturer Status: ${personData.permission}</p>

<form action="/app/userPageEdit" method="post">
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
                    <input type="submit" name="Edytuj">
                  </form>
 </div>


    <div class="groups">
        <img id="groupLogo" src="css/groupLogo.png">
        <p class="textNearImage">Grupy zajęciowe:</p>
        <ul>
            <table>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td><li class="groupList"><a href="/app/streamPage">${group.getName()}</a></li></td>
                <td><a href="/app/deleteGroupFromUser?id=${group.id}" class="deleteGroupButton"><button >Usun grupe</button></a></td>
           </c:forEach>
               </table>
           </ul>
           <a href="/app/addGroup" id="addGroupButton"><button >Dodaj grupe</button></a>
       </div>
   </div>
</div>
<div>
    <%@include file="../footer.jsp" %>
</div>
</body>
</html>