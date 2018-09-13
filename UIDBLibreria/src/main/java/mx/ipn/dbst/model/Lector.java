/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.dbst.model;

/**
 *
 * @author angeldlr
 */
public class Lector {
    int numTarjeta;
    String nombre;
    String direccion;
    String telefono;

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Lector(int numTarjeta, String nombre, String direccion, String telefono) {
        this.numTarjeta = numTarjeta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
}
