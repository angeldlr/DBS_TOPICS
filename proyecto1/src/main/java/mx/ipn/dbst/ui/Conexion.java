package mx.ipn.dbst.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hector
 */
public class Conexion {
    public static Connection crearConexion() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/";
        String esquema = "DBLibreria";
        String usuario = "bases";
        String password = "escom";
        
        Connection connection = DriverManager.getConnection(url + esquema, usuario, password);
        return connection;
    }
}
