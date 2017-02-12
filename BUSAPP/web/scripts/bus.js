/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function()     
{
    $("registrarBus").click(registrarBus);
    
    function registrarBus()
    {
        var placa=$("#placa").val();
        var nombreConductor=$("#nombreConductor").val();
        var tipo=$("#tipo").val();
        var valorPasaje=$("#valorPasaje").val();
        
        if (placa!=null && nombreConductor!=null && tipo!=null && valorPasaje!=null)
        {
            $.post("Controladora",
                {
                    operacion: "registrarBus",
                    placa:placa,
                    nombreConductor:nombreConductor,
                    tipo:tipo,
                    valorPasaje:valorPasaje
                },
                function (data)
                {
                    if (data)
                    {
                        alert("Se registro correctamente el bus");
                    }
                    else
                    {
                        alert("Erro al registrar bus");
                    }
                }, "json");
        }
        else
        {
            alert("Existe algun campo vacio");
        }
    }
});

