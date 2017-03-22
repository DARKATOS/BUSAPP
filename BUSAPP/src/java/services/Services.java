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
    @Path("/busLocationRegister/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLocationRegister(@PathParam("id") int id) {
        CRUDBus crud=new CRUDBus();
        String success=crud.busLocationRegisterService(id);
        return success;
    }
    
    @GET
    @Path("/busLocationUpdate/{id}/{latitude}/{longitude}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLocationUpdate(@PathParam("id") int id, @PathParam("latitude") double latitude, @PathParam("longitude") double longitude) {
        CRUDBus crud=new CRUDBus();
        String success=crud.busLocationUpdateService(id, latitude, longitude);
        return success;
    }
    
    @GET
    @Path("/busLocationDelete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLocationDelete(@PathParam("id") int id) {
        CRUDBus crud=new CRUDBus();
        String success=crud.busLocationDeleteService(id);
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
}
