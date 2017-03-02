/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $.post("Controller1",
            {
                operation: "busShow"
            },
            function (data)
            {
                if (data !== null)
                {
                    var tablaBuses = $("#busTable");
                    for (var i = 0; i < data.length; i++) {
                        var idBus = data[i].id;
                        var plate = data[i].plate;
                        var driverName = data[i].driverName;
                        var busType = data[i].busType;
                        var ticketPrice = data[i].ticketPrice;
                        var tr = $("<tr>");
                        var td1 = $("<td>", {text: idBus});
                        var td2 = $("<td>", {text: plate});
                        var td3 = $("<td>", {text: driverName});
                        var td4 = $("<td>", {text: busType});
                        var td5 = $("<td>", {text: ticketPrice});
                        var td6 = $("<td>");
                        var a = $("<li>", {text: "Modifcar", class:"update"});
                        a.data("attributes",{idBus:idBus, plate: plate, driverName:driverName, busType: busType, ticketPrice:ticketPrice});
                        td6.append(a);
                        tr.append(td1);
                        tr.append(td2);
                        tr.append(td3);
                        tr.append(td4);
                        tr.append(td5);
                        tr.append(td6);
                        tablaBuses.append(tr);
                    }
                } else
                {
                    alert("Error al mostrar buses");
                }
            }, "json");
}
);

$(function ()
{
    $("#busTable").on("click", ".update", busUpdate);
    function busUpdate()
    {
        var informationBus = $(".update").data("attributes");
        var convertidos=JSON.stringify(informationBus);
        localStorage.setItem("attributes", convertidos);
        window.location.href="busUpdate.html";

    }
});

