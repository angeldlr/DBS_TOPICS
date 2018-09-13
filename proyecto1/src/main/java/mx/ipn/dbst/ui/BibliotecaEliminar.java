/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.dbst.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author hector
 */
public class BibliotecaEliminar extends javax.swing.JPanel {

    /**
     * Creates new form Libro
     */
    public BibliotecaEliminar() {
        initComponents();
        listaEditoriales();

    }

    private void listaEditoriales() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String resultados = new String();

        try {
            connection = Conexion.crearConexion();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT nombreSucursal FROM sucursalBiblioteca");
            while (resultSet.next()) {
                resultados += resultSet.getString("nombreSucursal") + ", ";
            }
            editorial.setModel(new DefaultComboBoxModel(resultados.split(", ")));
            //Conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecaEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        editorial = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        AltaLibro = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar Biblioteca"));
        jPanel2.setLayout(new java.awt.GridLayout(3, 2));

        jLabel2.setFont(new java.awt.Font("Cantarell", 3, 18)); // NOI18N
        jLabel2.setText("Listado de Bibliotecas :");
        jPanel2.add(jLabel2);

        editorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        editorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorialActionPerformed(evt);
            }
        });
        jPanel2.add(editorial);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        AltaLibro.setText("Eliminar");
        AltaLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarBiblioteca(evt);
            }
        });

        jLabel1.setName("mensaje"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(estado)
                .addGap(29, 29, 29)
                .addComponent(mensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(AltaLibro)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AltaLibro)
                        .addComponent(estado)
                        .addComponent(mensaje))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void editorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editorialActionPerformed

    private void eliminarBiblioteca(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarBiblioteca
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement;
        String query;
        String biblio = editorial.getSelectedItem().toString();
        try {
            connection = Conexion.crearConexion();
            query = "delete from sucursalBiblioteca where nombreSucursal = ?";
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, biblio);
            preparedStatement.execute();
            mensaje.setText("Se elimino la biblioteca " + biblio);

        } catch (SQLException ex) {
            Logger.getLogger(BibliotecaEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eliminarBiblioteca


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AltaLibro;
    private javax.swing.JComboBox<String> editorial;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mensaje;
    // End of variables declaration//GEN-END:variables
}
