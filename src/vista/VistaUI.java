/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;

/**
 *
 * @author ZOMBY
 */
public class VistaUI {
    public static void main(String[] args) {
        initMaterialDesign();
        //V_DatosPaciente v=new V_DatosPaciente();
       // V_DatosPersonales v=new V_DatosPersonales();
        V_DatosPersonales v=new V_DatosPersonales();
       //V_Historial v=new V_Historial();
       //V_BuscarPaciente v=new V_BuscarPaciente();
//       V_Cobrar v=new V_Cobrar();
  //V_ListaPacientes v=new V_ListaPacientes();     
  //PrubaComponentes v=new PrubaComponentes();
 // V_Presupuesto v=new V_Presupuesto();
       v.setVisible(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
        public static void initMaterialDesign() {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
