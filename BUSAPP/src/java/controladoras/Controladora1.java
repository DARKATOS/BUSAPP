/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoras;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Bus;
import modelos.CRUDBus;

/**
 *
 * @author NIYIRETH_OSORIO
 */
@WebServlet(name = "Controladora1", urlPatterns = {"/Controladora1"})
public class Controladora1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operacion = request.getParameter("operacion");
        if ("registrarBus".equals(operacion)) {
            String placa = request.getParameter("placa");
            String nombreConductor = request.getParameter("nombre_Conductor");
            String tipo = request.getParameter("tipo");
            int valorPasaje = Integer.parseInt(request.getParameter("valor_Pasaje"));
            Bus bus = new Bus(-1, placa, nombreConductor, tipo, valorPasaje);
            CRUDBus crud = new CRUDBus();
            boolean mensaje = crud.registrarBus(bus);
            Gson json = new Gson();
            String resultado = json.toJson(mensaje);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        } else if ("mostrarBuses".equals(operacion)) {
            CRUDBus crud = new CRUDBus();
            ArrayList<Bus> buses = crud.mostrarBuses();
            Gson json = new Gson();
            String resultado = json.toJson(buses);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
