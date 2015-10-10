/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $("#error").hide();
    $("#personTable").hide();
    
//Get one person complete
    $("#getOneP").click(function () {
        $.ajax({
            url: "api/person/complete/" + $("#personId").val(),
            type: "GET",
            dataType: "json"
        }).done(function (dataFromServer) { //called when ready

            var pers = dataFromServer.firstName + ", " + dataFromServer.lastName + ", " + dataFromServer.email + ", " + dataFromServer.street + ", "
                    + dataFromServer.additionalInfo + ", " + dataFromServer.zipCode + ", " + dataFromServer.city;
            $("#personOutput").val(pers);
        }).fail(function (error) {
            var json = error.responseJSON;
            $("#error").show().html(json.Message);
        });
    });

//Get all persons complete
    $("#getAllP").click(function () {
        $("#personTable").show();
        $.ajax({
            url: "api/person/complete"
        }).done(function (result) {
            result.forEach(function (person) {
                $("#personTable").append(makeRow(person));
            });

        }).fail(function (error) {
            var json = error.responseJSON;
            $("#error").show().html(json.Message);
        });
    });
// Help function to GET all persons, that makes rows. 
    function makeRow(person) {
        var row = "<tr><td>" + person.firstName + "</td><td>" + person.lastName + "</td><td>" + person.email + "</td>\n\
        <td>" + person.street + "</td><td>" + person.additionalInfo + "</td><td>" + person.zipCode + "</td><td>" + person.city + "</td></tr>";
        return row;
    }
// Create a person (POST).  
    $("#create").click(function () {
    $("#error").hide();
    $("#OutputCreate").val("");
    
        var perso = JSON.stringify({firstName: $("#personFName").val(), lastName: $("#personLName").val(), email: $("#personEmail").val(), 
         street: $("#personStreet").val(), additionalInfo: $("#personAdditionalInfo").val(), 
         zipCode: $("#personZipCode").val(), city: $("#personCity").val()});

        $.ajax({
            url: "api/person/",
            type: "POST",
            data: perso,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
       }).done(function (dataFromServer) { // (datafromServer)
            $("#personFName").val(""); $("#personLName").val(""); $("#personEmail").val(""); $("#personStreet").val("");
            $("#personAdditionalInfo").val(""); $("#personZipCode").val(""); $("#personCity").val("");  
            $("#OutputCreate").val(perso);
        }).fail(function (error) {
            var json = error.responseJSON;
            $("#error").show().html(json.Message);
        }); 
    });

// Edit name on a person (PUT).
$("#edit").click(function () {
        $("#error").hide();
        $("#OutputEdit").val("");
        var p = JSON.stringify({firstName: $("#firstname").val()});

        $.ajax({
            url: "api/person/" + $("#nr").val(),
            type: "PUT",
            data: p,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (dataFromServer) { //called when ready
            var p = dataFromServer.firstName + ", " + dataFromServer.lastName + ", " + dataFromServer.email + ", " + dataFromServer.street + ", "
                    + dataFromServer.additionalInfo + ", " + dataFromServer.zipCode + ", " + dataFromServer.city;
            $("#firstname").val(""); $("#nr").val("");
            $("#OutputEdit").val(p);
        }).fail(function (error) {
            var json = error.responseJSON;
            $("#error").show().html(json.Message);
        });
    });
    
// Delete a person(DELETE)
$("#delete").click(function () {
        $("#error").hide();
        $("#OutputDelete").val("");
        $.ajax({
            url: "api/person/" + $("#deleteNr").val(),
            type: "DELETE",
            dataType: "json"
        }).done(function (dataFromServer) { //called when ready
            var p = dataFromServer.firstName + ", " + dataFromServer.lastName + ", " + dataFromServer.email + ", " + dataFromServer.street + ", "
                    + dataFromServer.additionalInfo + ", " + dataFromServer.zipCode + ", " + dataFromServer.city;
            $("#deleteNr").val("");
            $("#OutputDelete").val(p);
        }).fail(function (error) {
            var json = error.responseJSON;
            $("#error").show().html(json.Message);
        });
    });
});

