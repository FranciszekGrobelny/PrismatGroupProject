
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <title>Logowanie</title>
</head>
<body>
<%@include file="header.jsp" %>
<form action="/login" method="post">
    Username: <input type="username" name="username" placeholder="Podaj nazwe">
    Password: <input type="password" name="password" placeholder="Podaj haslo">
    <input type="submit" value="Zaloguj">
</form>
<%@include file="footer.jsp" %>
</body>
</html>