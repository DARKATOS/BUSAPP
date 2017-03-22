/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    var information = localStorage.getItem("attributes");
    var convertInformation = jQuery.parseJSON(information);
    var idbus=convertInformation.idBus;
//    alert(idbus);
    $.post("Controller1",
            {
                operation: "busPassword", 
                idbus: idbus
            },
            function (data)
            {
                if (data !== null)
                {
                    $("#plate").val(convertInformation.plate);
                    $("#password").val(data);
                    $("#passwordRepeat").val(data);
                    $("#driverName").val(convertInformation.driverName);
                    $("#busType").val(convertInformation.busType);
                    $("#ticketPrice").val(convertInformation.ticketPrice);
                } else
                {
                    alert("Error al cargar el bus");
                }
            }, "json");

});

$(function ()
{
    $("#busUpdate").on("click", busUpdate);
    function busUpdate()
    {
        var information = localStorage.getItem("attributes");
        var convertInformation = jQuery.parseJSON(information);
        var idbus=convertInformation.idBus;
        var password = $("#password").val();
        var passwordRepeat = $("#passwordRepeat").val();
        var driverName = $("#driverName").val();
        var busType = $("#busType").val();
        var ticketPrice = $("#ticketPrice").val();
        if (password != null && passwordRepeat != null && driverName != null && busType != null && ticketPrice != null)
        {
            $.post("Controller1",
                    {
                        idbus:idbus,
                        operation: "busUpdate",
                        password: password,
                        passwordRepeat: passwordRepeat,
                        driverName: driverName,
                        busType: busType,
                        ticketPrice: ticketPrice
                    },
                    function (data)
                    {
                        if (data)
                        {
                            alert("Se ha actualizado correctamente el bus");

                        } else
                        {
                            alert("Error al actualizar el bus");
                        }
                    }, "json");
        } else
        {
            alert("error en alguno de los campos");
        }


    }
});

