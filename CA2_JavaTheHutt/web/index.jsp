<%-- 
    Document   : index
    Created on : 06-10-2015, 05:49:22
    Author     : Bente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index page with PUT,POST, DELETE person</title>
        <script src ="http://code.jquery.com/jquery-1.11.3.min.js"></script> 
        <script src ="javaScript.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Welcome to Java The Hutt!</h1>
        <div id="authors"> Mikkel Vig, Steffen Juhl Madsen, Bente Andersen</div>
        <div id="class">A Class Computer Sience</div>
        <div id= "group"> 1 </div>
        <div>
            <input id="personInput" style=" width:60em; margin-top:1em;">
            <br>
            <button id="getoneperson">Get one person</button>
        </div>
    </body>
</html>
