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
public class Sucursal {
    int idSucursal;
    String nombreSucursal;
    String direccion;

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Sucursal(int idSucursal, String nombreSucursal, String direccion) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.direccion = direccion;
    }
    
    
}
