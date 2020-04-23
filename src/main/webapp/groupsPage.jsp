<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/userPageStyle.css" type="text/css" />
    <title>WEB RTC</title>
</head>
<body>
<script>
    function onVidyoClientLoaded(status){
        console.log("VidyoClient load state -" + status.state);
        if(status.state = "READY"){
            VC.CreateVidyoConnector({
             viewId:"render",
             viewStyle:"VIDYO_CONNECTORVIEWSTYLE_Default",
             remoteParticipants:16,
             logFileFilter})
        }
    }
</script>
<script src="https://static.vidyo.io/latest/javascript/VidyoClient/VidyoClient.js?onload=onVidyoClientLoaded"></script>
<div id="render"></dir>
</body>
</html>