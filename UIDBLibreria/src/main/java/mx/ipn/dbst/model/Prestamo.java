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
public class Prestamo {
    Libro libroP;
    Lector lectorP;
    Sucursal sucursalP;
    String fechaSalida;
    String fechaDevolucion;

    public Libro getLibroP() {
        return libroP;
    }

    public void setLibroP(Libro libroP) {
        this.libroP = libroP;
    }

    public Lector getLectorP() {
        return lectorP;
    }

    public void setLectorP(Lector lectorP) {
        this.lectorP = lectorP;
    }

    public Sucursal getSucursalP() {
        return sucursalP;
    }

    public void setSucursalP(Sucursal sucursalP) {
        this.sucursalP = sucursalP;
    }

    public Prestamo(Libro libroP, Lector lectorP, Sucursal sucursalP, String fechaSalida, String fechaDevolucion) {
        this.libroP = libroP;
        this.lectorP = lectorP;
        this.sucursalP = sucursalP;
        this.fechaSalida = fechaSalida;
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
}
