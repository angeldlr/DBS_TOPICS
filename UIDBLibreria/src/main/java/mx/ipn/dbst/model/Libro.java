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
public class Libro {
    int idLibro;
    String titulo;
    Autor autorLibro;
    Editorial editorialLibro;

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editorial getEditorialLibro() {
        return editorialLibro;
    }

    public void setEditorialLibro(Editorial editorialLibro) {
        this.editorialLibro = editorialLibro;
    }

    public Autor getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(Autor autorLibro) {
        this.autorLibro = autorLibro;
    }

    public Libro(int idLibro, String titulo, Autor autorLibro, Editorial editorialLibro) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autorLibro = autorLibro;
        this.editorialLibro = editorialLibro;
    }

    
    
    
}
