/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.ipn.dbst.ui.prestamos;

import mx.ipn.dbst.controlador.PrestamoCon;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mx.ipn.dbst.model.Lector;
import mx.ipn.dbst.model.*;
import mx.ipn.dbst.ui.Conexion;

/**
 *
 * @author angeldlr
 */
public class DevolucionView extends javax.swing.JFrame {

    private List<Libro> libros = new ArrayList<Libro>();
    private List<Lector> listLectores = new ArrayList<Lector>();
    private List<Sucursal> listSuc = new ArrayList<Sucursal>();
    /** Creates new form DevolucionView */
    public DevolucionView() {
        initComponents();
        setLocationRelativeTo(null);
        addLectores();
    }
    private void addLibro()
    {
        PrestamoCon shwpres = new PrestamoCon();
        Conexion c = new Conexion();
        try {
            Connection con = c.crearConexion();
            List<String[]> prestamos = shwpres.getLecPrestamos(con, listLectores.get(cbLector.getSelectedIndex()));
            if (prestamos != null) {
                Object[] tuples = new Object[8];

                for (int i = 0; i < prestamos.size(); i++) {
                    libros.add(new Libro(Integer.parseInt(prestamos.get(i)[2]),prestamos.get(i)[3],null,null));
                    listSuc.add(new Sucursal(Integer.parseInt(prestamos.get(i)[5]), prestamos.get(i)[6], null));
                    cbLibro.addItem(prestamos.get(i)[3]);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MostrarPrestamosView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void addLectores(){
        PrestamoCon querySuc = new PrestamoCon();
        Conexion c = new Conexion();
        
        try {
            Connection con = c.crearConexion();
            listLectores = querySuc.getLectores(con);
        } catch (SQLException ex) {
            Logger.getLogger(RealizarPrestamoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<listLectores.size();i++){
            int numL= listLectores.get(i).getNumTarjeta();
            String nom = listLectores.get(i).getNombre();
            cbLector.addItem(nom+",Número de lector: "+numL);
        }
            
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbLector = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbLibro = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setTitle("Devolucion");

        cbLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLectorActionPerformed(evt);
            }
        });

        jLabel1.setText("Lector");

        jLabel2.setText("Libros:");

        jButton1.setText("Realizar Devolución");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbLector, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLectorActionPerformed
        cbLibro.removeAllItems();
        addLibro();
        
    }//GEN-LAST:event_cbLectorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Lector lec = listLectores.get(cbLector.getSelectedIndex());
        Libro lib = libros.get(cbLibro.getSelectedIndex());
        Sucursal suc = listSuc.get(cbLibro.getSelectedIndex());
        PrestamoCon querySuc = new PrestamoCon();
        Conexion c = new Conexion();
        try {
            Connection con = c.crearConexion();
            if(querySuc.deletePrestamo(con, suc.getIdSucursal(), lec.getNumTarjeta(), lib.getIdLibro()))
                JOptionPane.showMessageDialog(null, "Libro "+lib.getTitulo()+" entregado", "INFO PRESTAMO", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Error al devolver", "INFO PRESTAMO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(DevolucionView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLector;
    private javax.swing.JComboBox<String> cbLibro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}