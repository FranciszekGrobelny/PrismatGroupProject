<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logowanie</title>
</head>
<body>
<form action="/login" method="post">
    Username: <input type="username" name="username" placeholder="Podaj nazwe">
    Password: <input type="password" name="password" placeholder="Podaj haslo">
    <input type="submit" value="Zaloguj">
</form>
</body>
</html>
