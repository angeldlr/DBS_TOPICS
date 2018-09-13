/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.dbst.main;
import mx.ipn.dbst.ui.mainView;
/**
 *
 * @author angeldlr
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainView mainWindow = new mainView();
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);
    }
    
}
