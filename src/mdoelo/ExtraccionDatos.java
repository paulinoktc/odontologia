/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdoelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.V_Presupuesto;

/**
 *
 * @author ZOMBY
 */
public class ExtraccionDatos {

    //V_Presupuesto v_presupuesto;
    MatrizCostos[] listaPresupuesto = null;

    /**
     *Extrae los datos de la vista presupuestos
     * @param v_presupuesto ventana presupuesto a extraer elementos inicializa MatrizCostos[]
     */
    public void ExtraerDatosPresupuesto(V_Presupuesto v_presupuesto) {
        try {
            listaPresupuesto = new MatrizCostos[11];
            if (!v_presupuesto.jtf_p_amalgama.getText().isEmpty()) {
                listaPresupuesto[0] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_amalgama.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_amalgama.getText().toString()));
                v_presupuesto.jtf_t_amalgama.setText(listaPresupuesto[0].getTotal() + "");
            }
            if (!v_presupuesto.jtf_p_recina.getText().isEmpty()) {
                listaPresupuesto[1] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_recina.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_recina.getText().toString()));
                v_presupuesto.jtf_t_recina.setText(listaPresupuesto[1].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_incrustacion.getText().isEmpty()) {
                listaPresupuesto[2] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_incrustacion.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_incrustacion.getText().toString()));
                v_presupuesto.jtf_t_incrustacion.setText(listaPresupuesto[2].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_corona.getText().isEmpty()) {
                listaPresupuesto[3] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_corona.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_corona.getText().toString()));
                v_presupuesto.jtf_t_corona.setText(listaPresupuesto[3].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_endodoncia.getText().isEmpty()) {
                listaPresupuesto[4] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_endodoncia.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_endodoncia.getText().toString()));
                v_presupuesto.jtf_t_endodoncia.setText(listaPresupuesto[4].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_extraccion.getText().isEmpty()) {
                listaPresupuesto[5] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_extraccion.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_exraccion.getText().toString()));
                v_presupuesto.jtf_t_exraccion.setText(listaPresupuesto[5].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_prostotoncia.getText().isEmpty()) {
                listaPresupuesto[6] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_prostotoncia.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_prostodoncia.getText().toString()));
                v_presupuesto.jtf_t_prostodoncia.setText(listaPresupuesto[6].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_limpieza.getText().isEmpty()) {
                listaPresupuesto[7] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_limpieza.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_limpieza.getText().toString()));
                v_presupuesto.jtf_t_limpieza.setText(listaPresupuesto[7].getTotal() + "");
            }
            if (!v_presupuesto.jtf_p_curetas.getText().isEmpty()) {
                listaPresupuesto[8] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_curetas.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_cureta.getText().toString()));
                v_presupuesto.jtf_t_cureta.setText(listaPresupuesto[8].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_otro1.getText().isEmpty()) {
                listaPresupuesto[9] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_otro1.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_otro1.getText().toString()));
                v_presupuesto.jtf_t_otro2.setText(listaPresupuesto[9].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_otro2.getText().isEmpty()) {
                listaPresupuesto[10] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_otro2.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_otro2.getText().toString()));
                v_presupuesto.jtf_t_otro2.setText(listaPresupuesto[10].getTotal() + "");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dato erroneo : Prueba\n1: Verifica que presio y cantidad no estan vacios\n2: Poner Numero Entero En Cantidad\n3: No Poner Letras");
        }
    }

    public MatrizCostos[] getListaPresupuesto() {
        return listaPresupuesto;
    }

    public void setListaPresupuesto(MatrizCostos[] listaPresupuesto) {
        this.listaPresupuesto = listaPresupuesto;
    }

}
