
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/loginPageStyle.css" type="text/css" />
    <title>Logowanie</title>
</head>

<body>
<div id="container">
<%@include file="header.jsp" %>
    <div id= "content">
        <div id="login"></br>
            <hr>
                <h1>Login</h1>
            <hr>
            <h1>Prismat</h1>
            <p>E-learning platform</h6></p></br>
            <form action="/login" method="post">
                Username: </br>
                    <input type="text" name="login" placeholder="Username"></br>
                Password: </br>
                    <input type="password" name="password" placeholder="Password"></br></br>
                    <input type="submit" class="LogButton" value="Sign in">
            </form>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
