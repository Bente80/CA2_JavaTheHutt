/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $("#error").hide();
    
    $("#getAllInfo").click(function () {
                    $.ajax({
                        url: "api/person/complete/" + $("#personId").val(),
                        type: "GET",
                        dataType: "json"
                    }).done(function (dataFromServer) { //called when ready
                        
                    var pers = dataFromServer.firstName+", "+dataFromServer.lastName+", "+dataFromServer.email+", "+dataFromServer.street+", "
                        +dataFromServer.additionalInfo+", "+dataFromServer.zipCode+", "+dataFromServer.city+", "+dataFromServer.PersonTlf;
                //+", "+datafromServer.hobby
                        $("#personOutput").val(pers);
//                        $("#personOutput").val(dataFromServer.lastName);
                    }).fail(function (error) {
                        var json = error.responseJSON;
                        $("#error").show().html(json.Message);
                    });
                });
    
//    $.ajax({
//        url: "api/person/complete",
//        type: "GET",
//        dataType: "json"
//    }).done(function (dataFromServer) { //called when ready
//        $("#thequote").val(dataFromServer.quote);
//    }).fail(function (error) {
//        var json = error.responseJSON;
//        $("#error").show().html(json.Message);
//    });
});

