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
                        var type = data[i].type;
                        var ticketPrice = data[i].ticketPrice;
                        var tr = $("<tr>");
                        var td1 = $("<td>", {text: idBus});
                        var td2 = $("<td>", {text: plate});
                        var td3 = $("<td>", {text: driverName});
                        var td4 = $("<td>", {text: type});
                        var td5 = $("<td>", {text: ticketPrice});

                        tr.append(td1);
                        tr.append(td2);
                        tr.append(td3);
                        tr.append(td4);
                        tr.append(td5);
                        tablaBuses.append(tr);
                    }
                } else
                {
                    alert("Error al mostrar buses");
                }
            }, "json");
}
);

