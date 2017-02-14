/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
//        $("registrarBus").click(registrarBus);
//        function registrarBus()
//        {
//            var placa = $("#placa").val();
//            var nombreConductor = $("#nombreConductor").val();
//            var tipo = $("#tipo").val();
//            var valorPasaje = $("#valorPasaje").val();
//
//            if (placa != null && nombreConductor != null && tipo != null && valorPasaje != null)
//            {
//                $.post("Controladora",
//                        {
//                            operacion: "registrarBus",
//                            placa: placa,
//                            nombreConductor: nombreConductor,
//                            tipo: tipo,
//                            valorPasaje: valorPasaje
//                        },
//                        function (data)
//                        {
//                            if (data)
//                            {
//                                alert("Se registro correctamente el bus");
//                            } else
//                            {
//                                alert("Erro al registrar bus");
//                            }
//                        }, "json");
//            } else
//            {
//                alert("Existe algun campo vacio")
//            }
//        }

    $.post("Controladora1",
            {
                operacion: "mostrarBuses",
            },
            function (data)
            {
                if (data != null)
                {
                    var tablaBuses = $("#tablaBuses");
                    for (var i = 0; i < data.length; i++) {
                        var idBus = data[i].id;
                        var placa = data[i].placa;
                        var nombreConductor = data[i].nombreConductor;
                        var tipo = data[i].tipo;
                        var valorPasaje = data[i].valorPasaje;
                        var tr = $("<tr>");
                        var td1 = $("<td>", {text: idBus});
                        var td2 = $("<td>", {text: placa});
                        var td3 = $("<td>", {text: nombreConductor});
                        var td4 = $("<td>", {text: tipo});
                        var td5 = $("<td>", {text: valorPasaje});

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

