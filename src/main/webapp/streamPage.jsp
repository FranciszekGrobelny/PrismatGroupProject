
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/streamPageStyle.css" type="text/css" />
    <title>Logowanie</title>
</head>

<body>
<%@include file="tmpHeader.jsp" %>
<div id="container">

    <div id= "content">
        <div id= "info">
            <div id="course"></br>
                <h1>Course</h1>
                <hr>
                <p>Choose a course:</p>

                <select id="courseList" >
                  <option value="Matematyka">Matematyka</option>
                  <option value="Polski">Polski</option>
                  <option value="Analiza">Analiza</option>
                  <option value="Angielski">Angielski</option>
                </select></br></br>
                <form action="/joinToStream" method="post">
                    <input type="submit" class="joinToStream" value="Join to stream">
                </form>
            </div>
            <div id="onlineStudents"></br>
            
                    <h2>Online Students</h2>

                <select id="studentsList" size="10">
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                    <option>Nameofstudents</option>
                    <option>Nameofstudents</option>
                    <option>Nameofstudents</option>
                    <option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                	<option>Nameofstudents</option>
                    <option>Nameofstudents</option>
                    <option>Nameofstudents</option>
                    <option>Nameofstudents</option>
                    <option>Nameofstudents</option>
            </select>
            </div>
        </div>
        <div id="streamWindow"></br>

                            <h1>stramWindow</h1>


                    </div>
    </div>

</div>
<%@include file="footer.jsp" %>
</body>
</html>
