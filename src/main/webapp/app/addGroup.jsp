<%--
  Created by IntelliJ IDEA.
  User: franciszek
  Date: 20.04.2020
  Time: 04:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/groupsPageStyle.css" type="text/css" />
    <title>Grupy</title>
</head>
<body>
<div id="container">
        <div id="content"></br>
            <div id="registrationStyle">

                    <ul>
                        <table>
                    <c:forEach items="${groups}" var="group">
                        <tr>
                            <td><li class="groupList"><a href="/">${group.name}</a></li></td>
                        </tr>
                    </c:forEach>
                        </table>
                    </ul>

                <form method="post" action="/app/addGroup">
                <table>
                    <tr>
                        <td><p>Nazwa grupy:</p></td> <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td><p>Opis:</p></td> <td><input type="text" name="description"></td>
                    </tr>
                    <tr>
                        <td><p>Maksymalna liczba uczniow:</p></td> <td><input type="number" name="maxNumberOfPlaces"></td>
                    </tr>
                    <tr>
                        <td><p>Password do grupy:</p></td> <td><input type="text" name="passwordGroup"></td>
                    </tr>
                </table></br>
                    <input type="submit" value="Dodaj"></br>
                </form>
            </div>
        </div>
</div>
</body>
</html>
