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
            var plate = $("#plate").val();
            var password = $("#password").val();
            var driverName = $("#driverName").val();
            var type = $("#type").val();
            var ticketPrice = $("#ticketPrice").val();

            if (plate !== null && driverName !== null && type !== null && ticketPrice !== null && password!==null)
            {
                $.post("Controller1",
                        {
                            operation: "busRegister",
                            plate: plate,
                            password:password,
                            driverName: driverName,
                            type: type,
                            ticketPrice: ticketPrice
                        },
                        function (data)
                        {
                            if (data)
                            {
                                alert("Se registro correctamente el bus");
                            } else
                            {
                                alert("Error al registrar bus");
                            }
                        }, "json");
            } else
            {
                alert("Existe algun campo vacio");
            }
        }
});


