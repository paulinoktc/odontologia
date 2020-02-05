/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author ZOMBY
 */
public class V_Agenda extends javax.swing.JFrame {

    /**
     * Creates new form V_ListaPacientes
     */
    public V_Agenda() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_cita_pacientes = new javax.swing.JTable();
        jcb_pacientes_mostrar = new javax.swing.JComboBox<>();
        jb_atender = new javax.swing.JButton();
        jb_agendar_cita = new javax.swing.JButton();
        jb_cambiar_fecha = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(94, 117, 116));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agenda");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jt_cita_pacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jt_cita_pacientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 300));

        jcb_pacientes_mostrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Atendidos", "Por Antender" }));
        jPanel1.add(jcb_pacientes_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 140, 30));

        jb_atender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Atender_80_80.png"))); // NOI18N
        jb_atender.setBorder(null);
        jb_atender.setBorderPainted(false);
        jb_atender.setContentAreaFilled(false);
        jb_atender.setFocusPainted(false);
        jb_atender.setFocusable(false);
        jPanel1.add(jb_atender, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 80, 80));

        jb_agendar_cita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agenda_80_80.png"))); // NOI18N
        jb_agendar_cita.setBorder(null);
        jb_agendar_cita.setBorderPainted(false);
        jb_agendar_cita.setContentAreaFilled(false);
        jb_agendar_cita.setFocusPainted(false);
        jb_agendar_cita.setFocusable(false);
        jPanel1.add(jb_agendar_cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 80, 80));

        jb_cambiar_fecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calendario_80_80.png"))); // NOI18N
        jb_cambiar_fecha.setBorder(null);
        jb_cambiar_fecha.setBorderPainted(false);
        jb_cambiar_fecha.setContentAreaFilled(false);
        jb_cambiar_fecha.setFocusPainted(false);
        jb_cambiar_fecha.setFocusable(false);
        jPanel1.add(jb_cambiar_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 80, 80));

        jb_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar_40_40.png"))); // NOI18N
        jb_salir.setToolTipText("");
        jb_salir.setBorder(null);
        jb_salir.setBorderPainted(false);
        jb_salir.setContentAreaFilled(false);
        jb_salir.setFocusPainted(false);
        jPanel1.add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 380));

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
            java.util.logging.Logger.getLogger(V_Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jb_agendar_cita;
    public javax.swing.JButton jb_atender;
    public javax.swing.JButton jb_cambiar_fecha;
    public javax.swing.JButton jb_salir;
    public javax.swing.JComboBox<String> jcb_pacientes_mostrar;
    public javax.swing.JTable jt_cita_pacientes;
    // End of variables declaration//GEN-END:variables
}
