<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/streamPageStyle.css" type="text/css" />
    <title>Logowanie</title>
    <script type='text/javascript' src='https://cdn.scaledrone.com/scaledrone.min.js'></script>
</head>

<body>
<div id="container">
<%@include file="../tmpHeader.jsp" %>
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
        <style>
            video {
              max-width: calc(50% - 100px);
              margin: 0 50px;
              box-sizing: border-box;
              border-radius: 4px;
              padding: 0;
              box-shadow: rgba(156, 172, 172, 0.2) 0px 2px 2px, rgba(156, 172, 172, 0.2) 0px 4px 4px, rgba(156, 172, 172, 0.2) 0px 8px 8px, rgba(156, 172, 172, 0.2) 0px 16px 16px, rgba(156, 172, 172, 0.2) 0px 32px 32px, rgba(156, 172, 172, 0.2) 0px 64px 64px;
            }
            .copy {
              position: fixed;
              top: 10px;
              left: 50%;
              transform: translateX(-50%);
              font-size: 16px;
              color: rgba(0, 0, 0, 0.5);
            }
          </style>
            <video id="localVideo" autoplay muted></video>
            <video id="remoteVideo" autoplay></video>
            <script src="script.js"></script>
        </div>
    </div>
    <%@include file="../footer.jsp" %>
</div>
</body>
</html>
