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
public class Editorial {
    String nombreEditorial;
    String direccion;
    String telefono;

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
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

    public Editorial(String nombreEditorial, String direccion, String telefono) {
        this.nombreEditorial = nombreEditorial;
        this.direccion = direccion;
        this.telefono = telefono;
    }

}
