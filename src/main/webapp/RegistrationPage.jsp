<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<link rel="stylesheet" href="css/registrationPageStyle.css" type="text/css" />
<body>
    <%@include file="header.jsp" %>
    <div id="registrationStyle">
        <h1>Registration</h1>
        <p>Please fill in this form to create an account.</p>
    <form action="/registrationPageAction" method="post">
    Login:<input type="text"  placeholder="Enter your login" name="login" required/>  </br>
    Email:<input type="mail"  placeholder="Enter your email" name="email" required>  </br>
    Another contact:<input type="text"  placeholder="Email or phone number" name="anotherContact" required="false">  </br>
    Password:<input type="password" name="password" placeholder="Enter your password" required> </br>
    Confirm password:<input placeholder="Confirm your password" required type="password">  </br>
        <font size="3">If you are a lecturer please check the field.</font>
    <input type="checkbox" name="isTeacher"> </br>
    <input  type="submit" value="Register" class = "registrationButton" > </br>
    </form>
    </div>
        <%@include file="footer.jsp" %>
</body>
</html>