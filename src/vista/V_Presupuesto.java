/**
 * Vista presupuestos
 */
package vista;

import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author BereniceAnai
 */
public class V_Presupuesto extends javax.swing.JFrame {

    /**
     * Creates new form V_Presupuesto
     */
    public V_Presupuesto() {
        initComponents();
          Shape forma=new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jl_total = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtf_p_prostotoncia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtf_p_amalgama = new javax.swing.JTextField();
        jtf_p_recina = new javax.swing.JTextField();
        jtf_p_incrustacion = new javax.swing.JTextField();
        jtf_p_corona = new javax.swing.JTextField();
        jtf_p_endodoncia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtf_p_extraccion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtf_p_otro2 = new javax.swing.JTextField();
        jtf_p_limpieza = new javax.swing.JTextField();
        jtf_p_curetas = new javax.swing.JTextField();
        jtf_p_otro1 = new javax.swing.JTextField();
        jtf_c_prostodoncia = new javax.swing.JTextField();
        jtf_c_amalgama = new javax.swing.JTextField();
        jtf_c_recina = new javax.swing.JTextField();
        jtf_c_incrustacion = new javax.swing.JTextField();
        jtf_c_corona = new javax.swing.JTextField();
        jtf_c_endodoncia = new javax.swing.JTextField();
        jtf_c_exraccion = new javax.swing.JTextField();
        jtf_c_otro2 = new javax.swing.JTextField();
        jtf_c_limpieza = new javax.swing.JTextField();
        jtf_c_cureta = new javax.swing.JTextField();
        jtf_c_otro1 = new javax.swing.JTextField();
        jtf_t_prostodoncia = new javax.swing.JTextField();
        jtf_t_amalgama = new javax.swing.JTextField();
        jtf_t_recina = new javax.swing.JTextField();
        jtf_t_incrustacion = new javax.swing.JTextField();
        jtf_t_corona = new javax.swing.JTextField();
        jtf_t_endodoncia = new javax.swing.JTextField();
        jtf_t_exraccion = new javax.swing.JTextField();
        jtf_t_limpieza = new javax.swing.JTextField();
        jtf_t_cureta = new javax.swing.JTextField();
        jtf_t_otro1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtf_t_otro2 = new javax.swing.JTextField();
        jb_calcular = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jl_total1 = new javax.swing.JLabel();
        jb_cobrar = new javax.swing.JButton();
        jb_nuevo_paciente = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 160, 187));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COSTO TOTAL DEL TRATAMIENTO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INCRUSTACIONES C/U");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AMALGAMAS C/U");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("EXTRACCIONES C/U");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jl_total.setBackground(new java.awt.Color(204, 204, 255));
        jl_total.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jl_total.setForeground(new java.awt.Color(255, 255, 255));
        jl_total.setText("$0.00");
        jPanel1.add(jl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PRECIO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jLabel8.setBackground(new java.awt.Color(204, 204, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ENDODONCIA C/U");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jtf_p_prostotoncia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_prostotoncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 60, -1));

        jLabel9.setBackground(new java.awt.Color(204, 204, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CORONAS C/U");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel10.setBackground(new java.awt.Color(204, 204, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CONCEPTO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jLabel11.setBackground(new java.awt.Color(204, 204, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PRECIO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jtf_p_amalgama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_amalgama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 60, -1));

        jtf_p_recina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_recina, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 60, -1));

        jtf_p_incrustacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_incrustacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 60, -1));

        jtf_p_corona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 60, -1));

        jtf_p_endodoncia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_endodoncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 60, -1));

        jLabel12.setBackground(new java.awt.Color(204, 204, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("RECINAS C/U");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel13.setBackground(new java.awt.Color(204, 204, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("PROSTODONCIA C/U");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel14.setBackground(new java.awt.Color(204, 204, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LIMPIEZA C/U");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        jLabel15.setBackground(new java.awt.Color(204, 204, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CURETAS C/U");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jtf_p_extraccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtf_p_extraccion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jtf_p_extraccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 60, -1));

        jLabel16.setBackground(new java.awt.Color(204, 204, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("OTRO");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        jtf_p_otro2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_otro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 60, -1));

        jtf_p_limpieza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_limpieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 60, -1));

        jtf_p_curetas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_curetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 60, -1));

        jtf_p_otro1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_p_otro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 60, -1));

        jtf_c_prostodoncia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_prostodoncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 60, -1));

        jtf_c_amalgama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_amalgama, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 60, -1));

        jtf_c_recina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_recina, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 60, -1));

        jtf_c_incrustacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_incrustacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 60, -1));

        jtf_c_corona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 60, -1));

        jtf_c_endodoncia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_endodoncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 60, -1));

        jtf_c_exraccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_exraccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 60, -1));

        jtf_c_otro2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_otro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 60, -1));

        jtf_c_limpieza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_limpieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 60, -1));

        jtf_c_cureta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_cureta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 60, -1));

        jtf_c_otro1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_c_otro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 60, -1));

        jtf_t_prostodoncia.setEditable(false);
        jtf_t_prostodoncia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_prostodoncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 120, -1));

        jtf_t_amalgama.setEditable(false);
        jtf_t_amalgama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_amalgama, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 120, -1));

        jtf_t_recina.setEditable(false);
        jtf_t_recina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_recina, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 120, -1));

        jtf_t_incrustacion.setEditable(false);
        jtf_t_incrustacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_incrustacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 120, -1));

        jtf_t_corona.setEditable(false);
        jtf_t_corona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 120, -1));

        jtf_t_endodoncia.setEditable(false);
        jtf_t_endodoncia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_endodoncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, -1));

        jtf_t_exraccion.setEditable(false);
        jtf_t_exraccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_exraccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 120, -1));

        jtf_t_limpieza.setEditable(false);
        jtf_t_limpieza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_limpieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 120, -1));

        jtf_t_cureta.setEditable(false);
        jtf_t_cureta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_cureta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 120, -1));

        jtf_t_otro1.setEditable(false);
        jtf_t_otro1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_otro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 120, -1));

        jLabel17.setBackground(new java.awt.Color(204, 204, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("OTRO");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        jtf_t_otro2.setEditable(false);
        jtf_t_otro2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtf_t_otro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 120, -1));

        jb_calcular.setText("CALCULAR");
        jPanel1.add(jb_calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 140, -1));

        jLabel18.setBackground(new java.awt.Color(204, 204, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("CANTIDAD");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        jl_total1.setBackground(new java.awt.Color(204, 204, 255));
        jl_total1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_total1.setForeground(new java.awt.Color(255, 255, 255));
        jl_total1.setText("TOTAL:");
        jPanel1.add(jl_total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, -1, -1));

        jb_cobrar.setText("Cobrar Consulta");
        jPanel1.add(jb_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 140, -1));

        jb_nuevo_paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo_170_140.png"))); // NOI18N
        jb_nuevo_paciente.setBorder(null);
        jb_nuevo_paciente.setBorderPainted(false);
        jb_nuevo_paciente.setContentAreaFilled(false);
        jb_nuevo_paciente.setFocusPainted(false);
        jb_nuevo_paciente.setFocusable(false);
        jPanel1.add(jb_nuevo_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 170, 140));

        jb_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar_40_40.png"))); // NOI18N
        jb_salir.setBorder(null);
        jb_salir.setBorderPainted(false);
        jb_salir.setContentAreaFilled(false);
        jb_salir.setFocusPainted(false);
        jb_salir.setFocusable(false);
        jPanel1.add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 40, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nuevo Paciente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 450));

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(V_Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_Presupuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jb_calcular;
    public javax.swing.JButton jb_cobrar;
    public javax.swing.JButton jb_nuevo_paciente;
    public javax.swing.JButton jb_salir;
    public javax.swing.JLabel jl_total;
    private javax.swing.JLabel jl_total1;
    public javax.swing.JTextField jtf_c_amalgama;
    public javax.swing.JTextField jtf_c_corona;
    public javax.swing.JTextField jtf_c_cureta;
    public javax.swing.JTextField jtf_c_endodoncia;
    public javax.swing.JTextField jtf_c_exraccion;
    public javax.swing.JTextField jtf_c_incrustacion;
    public javax.swing.JTextField jtf_c_limpieza;
    public javax.swing.JTextField jtf_c_otro1;
    public javax.swing.JTextField jtf_c_otro2;
    public javax.swing.JTextField jtf_c_prostodoncia;
    public javax.swing.JTextField jtf_c_recina;
    public javax.swing.JTextField jtf_p_amalgama;
    public javax.swing.JTextField jtf_p_corona;
    public javax.swing.JTextField jtf_p_curetas;
    public javax.swing.JTextField jtf_p_endodoncia;
    public javax.swing.JTextField jtf_p_extraccion;
    public javax.swing.JTextField jtf_p_incrustacion;
    public javax.swing.JTextField jtf_p_limpieza;
    public javax.swing.JTextField jtf_p_otro1;
    public javax.swing.JTextField jtf_p_otro2;
    public javax.swing.JTextField jtf_p_prostotoncia;
    public javax.swing.JTextField jtf_p_recina;
    public javax.swing.JTextField jtf_t_amalgama;
    public javax.swing.JTextField jtf_t_corona;
    public javax.swing.JTextField jtf_t_cureta;
    public javax.swing.JTextField jtf_t_endodoncia;
    public javax.swing.JTextField jtf_t_exraccion;
    public javax.swing.JTextField jtf_t_incrustacion;
    public javax.swing.JTextField jtf_t_limpieza;
    public javax.swing.JTextField jtf_t_otro1;
    public javax.swing.JTextField jtf_t_otro2;
    public javax.swing.JTextField jtf_t_prostodoncia;
    public javax.swing.JTextField jtf_t_recina;
    // End of variables declaration//GEN-END:variables
}
