<%-- 
    Document   : createEditDelete
    Created on : 09-10-2015, 12:16:56
    Author     : Bente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src ="http://code.jquery.com/jquery-1.11.3.min.js"></script> 
        <script src ="javaScript.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <title>Create Edit Delete</title>
    </head>
    <body>
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Create, edit or delete</a>
        </div>
        <ul class="nav nav-tabs">
            <li><a href="index.jsp">Index</a></li>
            <li><a href="doc.jsp">Documentation</a></li>
            <li><a href="tut.jsp">Tutorial</a></li>
        </ul>
        <h1>Create</h1>
        <div>
            <input id="personFName" type="text" placeholder="Enter Firstname" style=" width:10em; margin-top:1em;">
            <input id="personLName" type="text" placeholder="Enter Lastname" style=" width:10em; margin-top:1em;">
            <input id="personEmail" type="text" placeholder="Enter Email" style=" width:10em; margin-top:1em;">
            <input id="personStreet" type="text" placeholder="Enter Street" style=" width:10em; margin-top:1em;">
            <input id="personAdditionalInfo" type="text" placeholder="Enter Additional Info" style=" width:10em; margin-top:1em;">
            <input id="personZipCode" type="text" placeholder="Enter Zip code" style=" width:10em; margin-top:1em;">
            <input id="personCity" type="text" placeholder="Enter City" style=" width:10em; margin-top:1em;">
        </div><br><div>
            <button id="create">Create a person</button>
            <input id="OutputCreate" style="width:80em; margin-top:1em;">
        </div><h1>Edit</h1><div>
            <input id="nr" type="text" placeholder="Enter id number" style=" width:10em; margin-top:1em;">
            <input id="firstname" type="text" placeholder="Enter Firstname" style=" width:10em; margin-top:1em;">
        </div><br><div>
            <button id="edit">Edit a person</button>
            <input id="OutputEdit" style="width:80em; margin-top:1em;">
        </div>
        <h1>Delete</h1><div>
            <input id="deleteNr" type="text" placeholder="Enter id number" style=" width:10em; margin-top:1em;">
        </div><br><div>
            <button id="delete">Delete a person</button>
            <input id="OutputDelete" style="width:80em; margin-top:1em;">
        </div><br><br>
    <div id="error" class="alert alert-danger" role="alert" style="width: 50%;margin-top: 1em;"></div>
</body>
</html>
