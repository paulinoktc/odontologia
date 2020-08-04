/**
 * unicamente muestra la lista de las ventas del dia y genera las sumas correspondientes
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.MODL_Ventas;
import modelo.OBJ_Reglones;
import vista.V_Ventas;

/**
 *
 * @author PaulinoSalas
 */
public class CTRL_Ventas {

    V_Ventas v_ventasDia;

    public CTRL_Ventas() {
        v_ventasDia = new V_Ventas();
        agregarActions();
        v_ventasDia.setVisible(true);
        ArrayList<OBJ_Reglones> ventas = new MODL_Ventas().mostrarVentasDeFecha(getFecha());
        mostrarElementos(ventas);
        v_ventasDia.jdch_selectFecha.setVisible(false);
        v_ventasDia.jb_bucar.setVisible(false);
    }

    public void mostrarElementos(ArrayList<OBJ_Reglones> conceptos) {
        VaciarTabla(v_ventasDia.defModel);
        for (OBJ_Reglones servicios : conceptos) {
            String[] reglon = {
                servicios.getNombreCliente() + "",
                servicios.getConcepto(),
                servicios.getPresio() + "",
                servicios.getCantidad_1() + "",
                servicios.getTotal() + "",
                servicios.getFecha()
            };
            v_ventasDia.defModel.addRow(reglon);
        }
    }

    public void agregarActions() {
        v_ventasDia.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_ventasDia.dispose();
                new CTRL_principal();
            }
        });
        v_ventasDia.jcbx_filtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = v_ventasDia.jcbx_filtro.getSelectedIndex();
                ArrayList<OBJ_Reglones> ventas;
                switch (opcion) {

                    case 0:
                        ventas = new MODL_Ventas().mostrarVentasDeFecha(getFecha());
                        mostrarElementos(ventas);
                        v_ventasDia.jdch_selectFecha.setVisible(false);
                        v_ventasDia.jb_bucar.setVisible(false);
                        break;
                    case 1:
                        ventas = new MODL_Ventas().mostrarTodasLasVentas();
                        mostrarElementos(ventas);
                        v_ventasDia.jdch_selectFecha.setVisible(false);
                        v_ventasDia.jb_bucar.setVisible(false);
                        break;
                    case 2:
                        v_ventasDia.jdch_selectFecha.setVisible(true);
                        v_ventasDia.jb_bucar.setVisible(true);
                        break;
                }
            }
        });
        v_ventasDia.jb_bucar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarOtraFecha();
            }
        });
    }

    public void buscarOtraFecha() {
        String fecha = getFechaSeleccionada();
        if (!fecha.isEmpty()) {
            ArrayList<OBJ_Reglones> ventas = new MODL_Ventas().mostrarVentasDeFecha(fecha);
            mostrarElementos(ventas);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha");
        }
    }

    /**
     * Extrae la fecha actual para mostrar las ventas del dia ctual
     *
     * @return
     */
    public String getFecha() {
        String fecha = "";//iniciales;
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter ldt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        fecha += datetime.format(ldt);
        return fecha;
    }

    /**
     * Vacia los datos de la tabla para voverlos a llenar
     *
     * @param defModel DelModel que se pretende limpiar
     */
    public void VaciarTabla(DefaultTableModel defModel) {
        while (defModel.getRowCount() > 0) {
            defModel.removeRow(defModel.getRowCount() - 1);
        }
    }

    public String getFechaSeleccionada() {
        return ((JTextField) v_ventasDia.jdch_selectFecha.getDateEditor().getUiComponent()).getText();
    }

}
