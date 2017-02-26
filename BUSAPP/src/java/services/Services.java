/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author JORGE_ALEJANDRO
 */
import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import models.Bus;
import models.CRUDBus;

@Path("/services")
public class Services {
    
//    @GET
//    @Path("/stringXML")
//    @Produces(MediaType.TEXT_XML)
//    public String stringXML() {
//        return "<?xml version='1.0' encoding='UTF-8'?><hola>Hola Mundo</hola>";
//    }
//
//    @GET
//    @Path("/stringJSON/{parameter}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String stringJSON(@PathParam("parameter") int msg) {
//        return "Hola Mundo JIJIJ: "+msg;
//    }
    
    @GET
    @Path("/stringJSON/{idbus}/{latitude}/{longitude}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLocationUpdate(@PathParam("idbus") int idbus, @PathParam("latitude") double latitude, @PathParam("longitude") double longitude) {
        return "Hola Mundo JIJIJ: ";
    }
    
    @GET
    @Path("/stringJSON/{idbus}/{plate}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLogIn(@PathParam("idbus") int idbus, @PathParam("plate") String plate) {
        return "Hola Mundo JIJIJ: ";
    }
    
    @GET
    @Path("/stringJSON/{plate}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLoginRegister(@PathParam("plate") String plate, @PathParam("password") String password) {
        Bus bus=new Bus(-1, plate, password, "", "", -1);
        CRUDBus crud=new CRUDBus();
        bus=crud.busLoginRegisterService(bus);
        Gson json=new Gson();
        String result=json.toJson(bus);
        return result;
    }
}
