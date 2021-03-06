/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.dbst.ui;

import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import mx.ipn.dbst.ui.prestamos.*;

/**
 *
 * @author angeldlr
 */
public class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public mainView() {
        initComponents();
        setLocationRelativeTo(null);
        iniciaMenuBar();
    }

    private void iniciaMenuBar(){
        JMenuItem Editorial = new JMenuItem("Editorial");
        JMenuItem Autor = new JMenuItem("Autor");
        JMenuItem LibroAlta = new JMenuItem("Libro");
        JMenuItem LibroBaja = new JMenuItem("Libro");
        JMenuItem Biblioteca = new JMenuItem("Biblioteca");
        JMenuItem Prestamo = new JMenuItem("Realizar prestamo");
        JMenuItem Devolucion = new JMenuItem("Realizar devolución");
        JMenuItem ConsultaPrestamos = new JMenuItem("Consultar prestamos");
        JMenuItem eliminarBiblioteca = new JMenuItem("Biblioteca");
        /*Menu items lector*/
        JMenuItem ConsultaLector = new JMenuItem("CRUD lector");
        
        
        Editorial.setActionCommand("E");
        Autor.setActionCommand("A");
        LibroAlta.setActionCommand("LA");
        LibroBaja.setActionCommand("LB");
        Biblioteca.setActionCommand("B");
        eliminarBiblioteca.setActionCommand("EB");
        /*action comands prestamo*/
        Prestamo.setActionCommand("P");
        Devolucion.setActionCommand("D");
        ConsultaPrestamos.setActionCommand("CP");
        /*action comands lector*/
        ConsultaLector.setActionCommand("LEC");
        
        
        Editorial.setMnemonic(KeyEvent.VK_E);
        Autor.setMnemonic(KeyEvent.VK_A);
        LibroAlta.setMnemonic(KeyEvent.VK_L);
        LibroBaja.setMnemonic(KeyEvent.VK_L);
        Biblioteca.setMnemonic(KeyEvent.VK_B);
        eliminarBiblioteca.setMnemonic(KeyEvent.VK_B);
        Editorial.addActionListener(new ListenerMenus());
        Autor.addActionListener(new ListenerMenus());
        LibroAlta.addActionListener(new ListenerMenus());
        LibroBaja.addActionListener(new ListenerMenus());
        Biblioteca.addActionListener(new ListenerMenus());
        eliminarBiblioteca.addActionListener(new ListenerMenus());
        Prestamo.addActionListener(new ListenerMenus());
        Devolucion.addActionListener(new ListenerMenus());
        ConsultaPrestamos.addActionListener(new ListenerMenus());
        ConsultaLector.addActionListener(new ListenerMenus());
       
                
        Altas.setMnemonic(KeyEvent.VK_A);
        Altas.add(Editorial);
        Altas.add(Autor);
        Altas.add(LibroAlta);
        Altas.add(Biblioteca);   
        
        bajas.add(LibroBaja);
        bajas.add(eliminarBiblioteca);
        
        menPrestamos.add(Prestamo);
        menPrestamos.add(Devolucion);
        menPrestamos.add(ConsultaPrestamos);
        
        menLector.add(ConsultaLector);
        
    }
    class ListenerMenus implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String opcion = e.getActionCommand();
            System.out.println(opcion);
            JPanel panel = null;
            switch(opcion){
                case "E":                    
                    panel = new Editorial();
                    break;
                case "LA":
                    panel = new LibroAlta();
                    break;
                case "LB":
                    panel = new LibroBaja();
                    break;
                case "A":
                    panel = new Autor();
                    break;
                case "B":
                    panel = new Biblioteca();
                    break;
                case "EB":
                    panel = new BibliotecaEliminar();
                    break;
                case "P":
                    RealizarPrestamoView pv = new RealizarPrestamoView();
                    pv.setVisible(true);
                    break;
                 case "D":
                    DevolucionView dv = new DevolucionView();
                    dv.setVisible(true);
                    break;
                case "CP":
                    MostrarPrestamosView cp = new MostrarPrestamosView();
                    cp.setVisible(true);
                    break;
                case "LEC":
                    panel = new LectorPanel();
                    break;    
                    
            }
            getContentPane().removeAll();
            add(panel,BorderLayout.CENTER);
            pack();
            validate();
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

        jPanel1 = new javax.swing.JPanel();
        gif = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        Altas = new javax.swing.JMenu();
        bajas = new javax.swing.JMenu();
        menPrestamos = new javax.swing.JMenu();
        menLector = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LIBRERIA DBST");
        getContentPane().setLayout(new java.awt.BorderLayout(20, 20));

        gif.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(gif)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(gif)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        Altas.setText("altas");
        MenuBar.add(Altas);

        bajas.setText("Bajas");
        MenuBar.add(bajas);

        menPrestamos.setText("Prestamos");
        MenuBar.add(menPrestamos);

        menLector.setText("Lectores");
        MenuBar.add(menLector);

        setJMenuBar(MenuBar);
        MenuBar.getAccessibleContext().setAccessibleName("menuBar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        Conexion a = new Conexion();
        try {
            a.crearConexion();
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Altas;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu bajas;
    private javax.swing.JLabel gif;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menLector;
    private javax.swing.JMenu menPrestamos;
    // End of variables declaration//GEN-END:variables
}
