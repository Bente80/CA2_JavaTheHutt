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
    
    $("#create").click(function () {
        $("#error").hide();
        var p = JSON.stringify({firstName: $("#personFName").val(),lastName: $("#personLName").val(),email: $("#personemail").val()});

        $.ajax({
            url: "api/quote/",
            type: "POST",
            data: p,
            contentType: "application/json",
            dataType: "json"
        }).done(function (dataFromServer) { //called when ready
            $("#thequote").val(dataFromServer.quote);
        }).fail(function (error) {
            var json = error.responseJSON;
            $("#error").show().html(json.Message);
        });

    });

//// Create and save a person (POST)
//      function savePerson() {
//        var type = "POST";
//        var data = {fName: $("#fname").val(), lName: $("#lname").val(), phone: $("#phone").val()};
////        if (!isAdding()) {
////          type = "PUT";
////          data.id = $("#id").val();
////        }
//        $.ajax({
//          url: "api/person",
//          type: type,
//          contentType: "application/json; charset=utf-8",
//          dataType: "json",
//          data: JSON.stringify(data)
//        }).done(function (added) {
//          initAddEditFields("", "", "", null);
//          if (isAdding()) {
//            $("#tbody").append(makeRow(added));
//          }
//          else {
//            $("#" + data.id).replaceWith(makeRow(added));
//          }
//          setUpHandlers();
//          setIsAdding(true);
//        }).fail(function (jqXHR, textStatus, errorThrown) {
//          $("#error").html(textStatus + ", " + errorThrown).show();
//          setIsAdding(true);
//        });
//      }
      
});

