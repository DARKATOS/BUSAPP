/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function ()
{
    $("#busTable").on("click", ".update", busUpdate);
    function busUpdate()
    {
        var informationBus = $(".update").data("attributes");
        var plate=informationBus.plate;
        var driverName=informationBus.driverName;
        var busType=informationBus.busType;
        var ticketPrice=informationBus.ticketPrice;
        
        localStorage.setItem("attributes", plate);
        localStorage.setItem("attributes", driverName);
        localStorage.setItem("attributes", busType);
        localStorage.setItem("attributes", ticketPrice);
        window.location.href="busUpdate.html";

    }
});

