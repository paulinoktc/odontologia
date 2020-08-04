/**
 * Lleva el control del presupuesto solo agrega un nuevo paciente si el paciente asi lo quiere o cobra la consulta
 */
package controlador;

import modelo.ExtraccionDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MatrizCostos;
import vista.V_Presupuesto;

/**
 *
 * @author PaulinoSalas
 */
public class CTRL_Presupuesto {

    V_Presupuesto v_presupuesto;
    ExtraccionDatos xtraccionDatos;

    public CTRL_Presupuesto() {
        v_presupuesto = new V_Presupuesto();
        xtraccionDatos = new ExtraccionDatos();
        AgregarActions();
        v_presupuesto.setVisible(true);
    }

    /**
     * Configura el comportamiento de los botones
     */
    public void AgregarActions() {
        v_presupuesto.jb_calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // xtraccionDatos.ExtraerDatosPresupuesto(v_presupuesto);
                CalcularPrecioTotal();
            }
        });

        v_presupuesto.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_presupuesto.dispose();
                new CTRL_principal();
            }
        });

        v_presupuesto.jb_nuevo_paciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_DatosPersonales();
                v_presupuesto.dispose();
            }
        });
        v_presupuesto.jb_cobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] concepto = {"Consulta"};
                new CTRL_Cobrar(concepto, "Al mostrador").botonComartidoCobrar();
                v_presupuesto.dispose();
            }
        });
    }

    /**
     * Calcula el precio total a partir de la vista presupuesto
     */
    public void CalcularPrecioTotal() {
        double totalNeto = 0;

        MatrizCostos[] listaPresupuesto = xtraccionDatos.ExtraerDatosPresupuesto(v_presupuesto);

        for (int i = 0; i < listaPresupuesto.length; i++) {
            if (listaPresupuesto[i] != null) {
                totalNeto += listaPresupuesto[i].getTotal();
                v_presupuesto.jl_total.setText("$" + totalNeto);
            }
        }
    }
}
