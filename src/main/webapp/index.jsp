<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Strona Tytulowa</title>
    <link rel="stylesheet" href="css/indexPageStyle.css" type="text/css" />
</head>
<body>
    <div id="container">
        <%@include file="header.jsp" %>
            <div id="content"></br>
                <div id="welcome">
                    <p class="a"> Welcome to Prismat.</p></br>
                    Prismat is a web application dedicated to online lessons,
                     if you are a student who wants to join a lesson or a teacher who wants
                     to teach online is the right place for you.</br>

                    <p class="b"> &#9654; If you are a new member go to "Registration".</p>
                    <p class="c"> &#9654; If you are already with us press "Sign in" button.</p></br></br></br></br>

                    <a href="/registrationPageAction"><input type="submit" class="LogButton" value="Registration"></a>
                    <a href="/login"><input type="submit" class="LogButton" value="Sign in"></a>
                </div>
            </div>
        <%@include file="footer.jsp" %>
   </div>
</body>
</html>