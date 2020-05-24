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
<div class="bg-modal">
    <div class="modal-content">
        <form method="post" action="/app/messageSaveGroup">
            ${exceptions}</br>
            <input type="submit" value="OK">
        </form>
    </div>
</div>
</body>
</html>