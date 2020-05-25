<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<link rel="stylesheet" href="css/registrationPageStyle.css" type="text/css" />
<body>
 <%@include file="header.jsp" %>
     <div id="container">
        <div id="registrationStyle">
            <h1>Registration</h1>
            <hr></br>
            <p>Please fill in this form to create an account.</p></br></br>
                <form action="/registrationPageAction" method="post">
                <table>
                   <tr>
                      <td><p>Login:</p></td>            <td><input type="text"  placeholder="Enter your login" name="login" required/></td>
                   <tr>
                      <td><p>Email:</p></td>            <td><input type="mail"  placeholder="Enter your email" name="email" required></td>
                   </tr>
                   <tr>
                      <td><p>Another contact:</p></td>  <td><input type="text"  placeholder="Email or phone number" name="anotherContact"> </td>
                   </tr>
                   <tr>
                      <td><p>Password:</p></td>         <td><input type="password" name="password" placeholder="Enter your password" required></td>
                   </tr>
                   <tr>
                      <td><p>Confirm password:</p></td> <td><input placeholder="Confirm your password" required type="password"></td>
                   </tr>
                </table></br>

                    <font size="3">If you are a lecturer please check the field.</font>
                    <input type="checkbox" name="isTeacher"> </br></br></br>

                    <input  type="submit" value="Register" class = "registrationButton" > </br>
                </form>
        </div>
     </div>

</body>
<%@include file="footer.jsp" %>
</html>