
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/addGroupStyle.css" type="text/css" />
    <title>Grupy</title>
</head>
<body>
<%@include file="../tmpHeader.jsp" %>
<div id="container">


    <div id="content"></br>
        <div id="left"></br>
            <div id="addGroup">

                <form method="post" action="/app/addGroup">
                            <table>
                                <tr>
                                    <td><p>Nazwa grupy:</p></td> <td><input type="text" name="name"></td>
                                </tr>
                                <tr>
                                    <td><p>Opis:</p></td> <td><input type="text" name="description"></td>
                                </tr>
                                <tr>
                                    <td><p>Maksymalna liczba uczniow:</p></td> <td><input type="number" name="maxNumberOfPlaces"></td>
                                </tr>
                                <tr>
                                    <td><p>Password do grupy:</p></td> <td><input type="text" name="passwordGroup"></td>
                                </tr>
                            </table></br>
                                <input type="submit" class= "addButton" value="Add Group"></br>
                </form>
            </div>
        </div>

        <div id="right"></br>
            <div id="createdGroups">


                                <table cellspacing="0" cellpadding="1" border="1" width="700" style="width:500px">
                                   <tr style="color:white;background-color:grey">
                                     <th width = "130 px">Name:</th>
                                     <th width = "270 px">Password:</th>
                                     <th width = "130 px">Join</th>
                                   </tr>
                                </table>
                            <div style="width:500px; height:450px; overflow:auto;">
                         <c:forEach items="${groups}" var="group">
                             <tr>

                                <td>

                                    <form method="post" action="/app/saveGroup" >


                                     <table cellspacing="1" cellpadding="1" border="1"  >
                                                <tr>
                                                  <th style="min-width:122px" style="max-width:123px">${group.name}</br></th>
                                                  <th ><input type="password" name="passwordGroup" ></th>
                                                  <th ><input type="submit" value="Join" style="padding:4px 30px;"></br></th>
                                                  <input type="hidden" name="groupName" value="${group.name}">
                                                </tr></div>
                                              </table>


                                    </form>



                                     </td>
                                </tr>
                            </c:forEach>
                        </table>
</div>
</div>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>
