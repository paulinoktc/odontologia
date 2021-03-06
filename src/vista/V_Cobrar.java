/**
 * ventana cobrar
 */
package vista;

import com.sun.awt.AWTUtilities;
import java.awt.Font;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZOMBY
 */
public class V_Cobrar extends javax.swing.JFrame {

    public DefaultTableModel defModel;

    /**
     * Creates new form V_Cobrar
     */
    public V_Cobrar() {
        initComponents();
        customTable();
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);
        this.setLocationRelativeTo(null);
    }

    public void customTable() {
        defModel = new DefaultTableModel();
        defModel.addColumn("Concepto");
        defModel.addColumn("Precio $");
        defModel.addColumn("Cantidad");
        defModel.addColumn("Total");
        this.jtab_venta.setModel(defModel);
        
         if (jtab_venta.getColumnModel().getColumnCount() > 0) {
            jtab_venta.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtab_venta.getColumnModel().getColumn(1).setPreferredWidth(1);
            jtab_venta.getColumnModel().getColumn(2).setPreferredWidth(1);
            jtab_venta.getColumnModel().getColumn(3).setPreferredWidth(1);
        }
        jtab_venta.setFont(new Font("Arial", 20, 15));
        jtab_venta.setRowHeight(30);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_nombre2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jl_titulo = new javax.swing.JLabel();
        jl_nombre = new javax.swing.JLabel();
        jb_cobrar = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtab_venta = new javax.swing.JTable();
        jl_total_pagar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jb_add = new javax.swing.JButton();
        jb_rm = new javax.swing.JButton();
        jl_nombre1 = new javax.swing.JLabel();

        jl_nombre2.setBackground(new java.awt.Color(255, 255, 255));
        jl_nombre2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_nombre2.setForeground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 160, 187));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_titulo.setBackground(new java.awt.Color(255, 255, 255));
        jl_titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jl_titulo.setText("Registrar Venta");
        jPanel1.add(jl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        jl_nombre.setBackground(new java.awt.Color(255, 255, 255));
        jl_nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 310, 30));

        jb_cobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calcular_large.png"))); // NOI18N
        jb_cobrar.setBorder(null);
        jb_cobrar.setBorderPainted(false);
        jb_cobrar.setContentAreaFilled(false);
        jb_cobrar.setFocusPainted(false);
        jb_cobrar.setFocusable(false);
        jPanel1.add(jb_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 260, 50));

        jb_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        jb_salir.setBorder(null);
        jb_salir.setBorderPainted(false);
        jb_salir.setContentAreaFilled(false);
        jb_salir.setFocusPainted(false);
        jb_salir.setFocusable(false);
        jPanel1.add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 40, 40));

        jtab_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Concepto", "cantidad"
            }
        ));
        jScrollPane1.setViewportView(jtab_venta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 480, 230));

        jl_total_pagar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jl_total_pagar.setForeground(new java.awt.Color(255, 255, 255));
        jl_total_pagar.setText("$0.0");
        jPanel1.add(jl_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 270, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TOTAL:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jb_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/More.png"))); // NOI18N
        jb_add.setBorder(null);
        jb_add.setBorderPainted(false);
        jb_add.setContentAreaFilled(false);
        jPanel1.add(jb_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 40, 40));

        jb_rm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/quit.png"))); // NOI18N
        jb_rm.setBorder(null);
        jb_rm.setBorderPainted(false);
        jb_rm.setContentAreaFilled(false);
        jPanel1.add(jb_rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 40, 40));

        jl_nombre1.setBackground(new java.awt.Color(255, 255, 255));
        jl_nombre1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jl_nombre1.setText("Nombre:");
        jPanel1.add(jl_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 480));

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
            java.util.logging.Logger.getLogger(V_Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_Cobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_Cobrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jb_add;
    public javax.swing.JButton jb_cobrar;
    public javax.swing.JButton jb_rm;
    public javax.swing.JButton jb_salir;
    public javax.swing.JLabel jl_nombre;
    public javax.swing.JLabel jl_nombre1;
    public javax.swing.JLabel jl_nombre2;
    public javax.swing.JLabel jl_titulo;
    public javax.swing.JLabel jl_total_pagar;
    public javax.swing.JTable jtab_venta;
    // End of variables declaration//GEN-END:variables
}
