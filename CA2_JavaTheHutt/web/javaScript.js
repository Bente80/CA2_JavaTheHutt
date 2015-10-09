/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $("#error").hide();

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

    $("#getAllP").click(function () {
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

    function makeRow(person) {
        var row = "<tr><td>" + person.firstName + "</td><td>" + person.lastName + "</td><td>" + person.email + "</td>\n\
        <td>" + person.street + "</td><td>" + person.additionalInfo + "</td><td>" + person.zipCode + "</td><td>" + person.city + "</td></tr>";
        return row;
    }

      function savePerson() {
        var type = "POST";
        var data = {fName: $("#fname").val(), lName: $("#lname").val(), phone: $("#phone").val()};
        if (!isAdding()) {
          type = "PUT";
          data.id = $("#id").val();
        }
        $.ajax({
          url: "api/person",
          type: type,
          contentType: "application/json; charset=utf-8",
          dataType: "json",
          data: JSON.stringify(data)
        }).done(function (added) {
          initAddEditFields("", "", "", null);
          if (isAdding()) {
            $("#tbody").append(makeRow(added));
          }
          else {
            $("#" + data.id).replaceWith(makeRow(added));
          }
          setUpHandlers();
          setIsAdding(true);
        }).fail(function (jqXHR, textStatus, errorThrown) {
          $("#error").html(textStatus + ", " + errorThrown).show();
          setIsAdding(true);
        });
      }
      
});

