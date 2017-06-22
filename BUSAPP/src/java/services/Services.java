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
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import models.Bus;
import models.CRUDBus;
import models.CRUDLocation;
import models.BusLocation;
import models.BusWay;
import models.CRUDBusWay;

@Path("/services")
public class Services {
    
    @GET
    @Path("/busLogIn/{id}/{plate}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLogIn(@PathParam("id") int id, @PathParam("plate") String plate) {
        CRUDBus crud=new CRUDBus();
        String success=crud.busLoginService(id,plate);
        return success;
    }
    
    @GET
    @Path("/busLogInRegister/{plate}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLogInRegister(@PathParam("plate") String plate, @PathParam("password") String password) {
        CRUDBus crud=new CRUDBus();
        Bus bus=crud.busLoginRegisterService(plate,password);
        Gson json=new Gson();
        String result=json.toJson(bus);
        return result;
    }
    
    @GET
    @Path("/busLocationRegister/{idBus}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLocationRegister(@PathParam("idBus") int idBus) {
        CRUDBus crud=new CRUDBus();
        String success=crud.busLocationRegisterService(idBus);
        return success;
    }
    
    @GET
    @Path("/busLocationUpdate/{idBus}/{latitude}/{longitude}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLocationUpdate(@PathParam("idBus") int idBus, @PathParam("latitude") double latitude, @PathParam("longitude") double longitude) {
        CRUDBus crud=new CRUDBus();
        String success=crud.busLocationUpdateService(idBus, latitude, longitude);
        return success;
    }
    
    @GET
    @Path("/busLocationDelete/{idBus}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLocationDelete(@PathParam("idBus") int idBus) {
        CRUDBus crud=new CRUDBus();
        String success=crud.busLocationDeleteService(idBus);
        return success;
    }
    
    @GET
    @Path("/busUpdateGet")
    @Produces(MediaType.APPLICATION_JSON)
    public String busUpdateGet() {
        CRUDLocation crud=new CRUDLocation();
        ArrayList<BusLocation>locations=crud.busUpdateGetService();
        Gson json=new Gson();
        String result=json.toJson(locations);
        return result;
    }
    
    @GET
    @Path("/busWayRegister/{wayName}/{idBus}/{idBusLocation}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busWayRegister(@PathParam("wayName") String wayName, @PathParam("idBus") int idBus,@PathParam("idBusLocation") int idBusLocation) {
        CRUDBusWay crud=new CRUDBusWay();
        String success=crud.busWayRegister(wayName, idBus, idBusLocation);
        return success;
    }
    
    @GET
    @Path("/busWayShow/{idBus}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busWayShow(@PathParam("idBus") int idBus) {
        CRUDBusWay crud=new CRUDBusWay();
        ArrayList<BusWay>busWay=crud.busWayShow(idBus);
        Gson json=new Gson();
        String result=json.toJson(busWay);
        return result;
    }
    
    @GET
    @Path("/busWayDelete/{idBusWay}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busWayDelete(@PathParam("idBusWay") int idBusWay) {
        CRUDBusWay crud=new CRUDBusWay();
        String success=crud.busWayDelete(idBusWay);
        return success;
    }
}
