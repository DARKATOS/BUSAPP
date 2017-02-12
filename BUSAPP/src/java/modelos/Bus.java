/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class Bus {
    private int id;
    private String placa;
    private String nombreConductor;
    private String tipo;
    private int valorPasaje;

    public Bus(int id, String placa, String nombreConductor, String tipo, int valorPasaje) {
        this.id = id;
        this.placa = placa;
        this.nombreConductor = nombreConductor;
        this.tipo = tipo;
        this.valorPasaje = valorPasaje;
    }

    

    public int getId() {
        return id;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getValorPasaje() {
        return valorPasaje;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setValorPasaje(int valorPasaje) {
        this.valorPasaje = valorPasaje;
    }
    
    
    
}
