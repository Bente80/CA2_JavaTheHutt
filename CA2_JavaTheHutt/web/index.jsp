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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Welcome to Java The Hutt!</h1>
        <div id="authors" style="color: blue;"> Mikkel Vig, Steffen Juhl Madsen, Bente Andersen</div>
        <div id="class" style="color: blue;">A Class Computer Sience</div>
        <div id= "group" style="color: blue;"> 1 </div>
        <div>
            <input id="personId" style=" width:10em; margin-top:1em;">
            <input id="personOutput" style="width:60em; margin-top:1em;">
            <br>
            <br>
            <button id="getOneP">Get one person</button>
            <button id="getAllP">Get all persons</button>
            <button id="create">Create a person</button>
            <button id="change">Change a person</button>
            <button id="delete">Delete a person</button>
            <div id="error" class="alert alert-danger" role="alert" style="width: 50%;margin-top: 1em;"></div>
            <br>
            <br>
            <table id="personTable"></table>
        </div>
    </body>
</html>
