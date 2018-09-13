/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.dbst.controlador;

import java.sql.*;
import java.util.*;
import mx.ipn.dbst.model.*;

/**
 *
 * @author angeldlr
 */
public class PrestamoCon {

    //Para el procedure
    private String callPrestamo = "{call nuevoPrestamo(?,?,?,?,?)}";
    //Query sucursales
    private String getSucursales = "SELECT * FROM sucursalBiblioteca";
    //Querys lector
    private String getLectores = "SELECT * FROM lector";
    private String getLector = "SELECT * FROM lector WHERE numTarjeta = ?";
    private String insertLector = "INSERT INTO lector values (null,?,?,?)";
    private String updateLector = "UPDATE lector set nombre=?,direccion=?,telefono=? WHERE numTarjeta=?";
    private String deleteLector = "DELETE FROM lector WHERE numTarjeta = ?";
    //Query vista libros disponibles
    private String getLibrosSuc = "SELECT * FROM librosDisponiblesVista WHERE idSucursal = ?";
    private String getPrestamos = "SELECT * FROM librosEnPrestamoVista";
    private String getPrestamosSuc = "SELECT * FROM librosEnPrestamoVista WHERE idSucursal = ?";
    private String getPrestamosLec = "SELECT * FROM librosEnPrestamoVista WHERE numTarjeta = ?";
    private String getlibroPrestdo = "SELECT idLibro,titulo WHERE idLibro=? AND numTarjeta=? AND idSucursal=?";
    private String deletePrestamo = "DELETE FROM prestamo WHERE idLibro = ? AND numTarjeta = ? AND idSucursal=?";

    public List<String[]> getAllPrestamos(Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(getPrestamos);
            rs = ps.executeQuery();
            List prestamos = getResultPres(rs);
            if (prestamos.size() > 0) {
                return prestamos;
            } else {
                return null;
            }
        } finally {
            close(ps);
            close(rs);
        }
    }

    public List<String[]> getSucPrestamos(Connection con, Sucursal suc) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(getPrestamosSuc);
            ps.setInt(1, suc.getIdSucursal());
            rs = ps.executeQuery();
            List prestamos = getResultPres(rs);
            if (prestamos.size() > 0) {
                return prestamos;
            } else {
                return null;
            }
        } finally {
            close(ps);
            close(rs);
        }
    }

    public List<String[]> getLecPrestamos(Connection con, Lector lec) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(getPrestamosLec);
            ps.setInt(1, lec.getNumTarjeta());
            rs = ps.executeQuery();
            List prestamos = getResultPres(rs);
            if (prestamos.size() > 0) {
                return prestamos;
            } else {
                return null;
            }
        } finally {
            close(ps);
            close(rs);
        }
    }

    public boolean newLector(Connection con, Lector le) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(insertLector);
            ps.setString(1, le.getNombre());
            ps.setString(2, le.getDireccion());
            ps.setString(3, le.getTelefono());
            ps.execute();
            return true;
        } finally {
            close(ps);
        }
    }
    public boolean rmLector(Connection con, Lector le) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(deleteLector);
            ps.setInt(1, le.getNumTarjeta());
            ps.execute();
            return true;
        } finally {
            close(ps);
        }
    }
    public boolean updtLector(Connection con, Lector le) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(updateLector);
            ps.setString(1, le.getNombre());
            ps.setString(2, le.getDireccion());
            ps.setString(3, le.getTelefono());
            ps.setInt(4, le.getNumTarjeta());
            ps.execute();
            return true;
        } finally {
            close(ps);
        }
    }

    public boolean deletePrestamo(Connection con, int idSuc, int idlec, int idlib) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(deletePrestamo);
            ps.setInt(1, idlib);
            ps.setInt(2, idlec);
            ps.setInt(3, idSuc);
            ps.execute();
            return true;
        } finally {
            close(ps);
        }
    }

    public String nuevoPrestamo(Connection con, Prestamo pres) throws SQLException {
        CallableStatement st = null;
        //System.out.println("Llegue al callable");
        try {
            st = con.prepareCall(callPrestamo);
            st.setInt(1, pres.getLibroP().getIdLibro());
            st.setString(2, pres.getLibroP().getAutorLibro().getNombreAutor());
            st.setInt(3, pres.getSucursalP().getIdSucursal());
            //System.err.println("Num tarjeta:"+pres.getLectorP().getNumTarjeta());
            st.setInt(4, pres.getLectorP().getNumTarjeta());
            st.registerOutParameter("estatusProc", Types.VARCHAR);
            st.executeUpdate();
            String status = st.getString("estatusProc");
            return status;
        } finally {
            close(st);
        }
    }

    public List<Libro> getLibrosSuc(Connection con, int idSucursal) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(getLibrosSuc);
            ps.setInt(1, idSucursal);
            rs = ps.executeQuery();
            List libros = getResultLib(rs);
            if (libros.size() > 0) {
                return libros;
            } else {
                return null;
            }
        } finally {
            close(ps);
            close(rs);
        }
    }

    public List<Lector> getLectores(Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(getLectores);
            rs = ps.executeQuery();
            List lectores = getResultLec(rs);
            if (lectores.size() > 0) {
                return lectores;
            } else {
                return null;
            }
        } finally {
            close(ps);
            close(rs);
        }
    }

    public Lector getLector(Connection con, int le) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(getLector);
            ps.setInt(1, le);
            rs = ps.executeQuery();
            if (rs.next()) {
                Lector lec = new Lector(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return lec;
            } else {
                return null;
            }

        } finally {
            close(ps);
            close(rs);
        }
    }

    public List<Sucursal> getSucursales(Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(getSucursales);
            rs = ps.executeQuery();
            List sucursales = getResultSuc(rs);
            if (sucursales.size() > 0) {
                return sucursales;
            } else {
                return null;
            }
        } finally {
            close(ps);
            close(rs);
        }
    }

    private List<String[]> getResultPres(ResultSet rs) throws SQLException {

        List<String[]> results = new ArrayList<String[]>();
        while (rs.next()) {
            String[] bean = new String[7];
            bean[0] = String.valueOf(rs.getInt(1));
            bean[1] = rs.getString(2);
            bean[2] = String.valueOf(rs.getInt(3));
            bean[3] = rs.getString(4);
            bean[4] = rs.getString(5);
            bean[5] = String.valueOf(rs.getInt(6));
            bean[6] = rs.getString(7);
            results.add(bean);
        }
        return results;
    }

    private List<Sucursal> getResultSuc(ResultSet rs) throws SQLException {
        List results = new ArrayList<Sucursal>();
        while (rs.next()) {
            Sucursal bean = new Sucursal(rs.getInt(1), rs.getString(2), rs.getString(3));
            results.add(bean);
        }
        return results;
    }

    private List<Lector> getResultLec(ResultSet rs) throws SQLException {
        List results = new ArrayList<Lector>();
        while (rs.next()) {
            Lector bean = new Lector(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            results.add(bean);
        }
        return results;
    }

    private List<Libro> getResultLib(ResultSet rs) throws SQLException {
        List results = new ArrayList<Libro>();
        while (rs.next()) {
            Libro bean = new Libro(rs.getInt(1), rs.getString(2), new Autor(rs.getInt(1), rs.getString("nombreAutor")), new Editorial(rs.getString("editorialNom"), null, null));
            results.add(bean);
        }
        return results;
    }

    protected void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
    }

    protected void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }
}
