/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function()
{
    $("#registrarBus").click(registrarBus);
        function registrarBus()
        {
            var placa = $("#placa").val();
            var nombre_conductor = $("#nombre_conductor").val();
            var tipo = $("#tipo").val();
            var valor_pasaje = $("#valor_pasaje").val();

            if (placa !== null && nombre_conductor !== null && tipo !== null && valor_pasaje !== null)
            {
                $.post("Controladora1",
                        {
                            operacion: "registrarBus",
                            placa: placa,
                            nombre_conductor: nombre_conductor,
                            tipo: tipo,
                            valor_pasaje: valor_pasaje
                        },
                        function (data)
                        {
                            if (data)
                            {
                                alert("Se registro correctamente el bus");
                            } else
                            {
                                alert("Erro al registrar bus");
                            }
                        }, "json");
            } else
            {
                alert("Existe algun campo vacio");
            }
        }
});


