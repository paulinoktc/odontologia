/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontograma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import vista.V_DatosPersonales;

/**
 *
 * @author zomby
 */
public class ManipulaOdontograma {

    private ArrayList<Nodo> nodo_;

    BufferedImage buffer, buffer2 = null;
    Graphics2D bufferGraphics, buffer2Graphics, jPanelGraphics = null;
    V_DatosPersonales vista;

    public ManipulaOdontograma(V_DatosPersonales vista) {
        nodo_ = new ArrayList<>();
        this.vista = vista;
        inicializaBuffer();
        carga();
        agregarActions();
    }

    public void inicializaBuffer() {
        buffer = (BufferedImage) vista.jp_odontograma.createImage(vista.jp_odontograma.getWidth(), vista.jp_odontograma.getHeight());
        vista.setBuffer(buffer);
        bufferGraphics = buffer.createGraphics();
        bufferGraphics.setColor(new Color(94, 117, 116));
        bufferGraphics.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
        buffer2 = (BufferedImage) vista.jp_odontograma.createImage(vista.jp_odontograma.getWidth(), vista.jp_odontograma.getHeight());
        buffer2Graphics = buffer2.createGraphics();
        buffer2Graphics.setColor(new Color(94, 117, 116));
        buffer2Graphics.fillRect(0, 0, buffer2.getWidth(), buffer2.getHeight());

        jPanelGraphics = (Graphics2D) vista.jp_odontograma.getGraphics();
        vista.setPanel(jPanelGraphics);

    }

    private void carga() {
        File fichero = new File("/home/zomby/Escritorio/odontograma.png");
        String nombre = fichero.getName();
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(fichero);
            bufferGraphics.drawImage(imagen, 0, 0, null);
            buffer2Graphics.drawImage(imagen, 0, 0, null);

        } catch (IOException e) {
        }
    }

    public void guarda(String nombre) {
        //String nombres = "nuevoEdit.png";

        File fichero = new File("/home/zomby/Escritorio/" + nombre + ".png");// jFileChooser1.getSelectedFile();

        String extension = "png";
        try {
            ImageIO.write(buffer, extension, fichero);
        } catch (IOException e) {
        }
    }

    public void agregarActions() {
        vista.jp_odontograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent evt) {

                dibujaCuadro(evt);
            }
        });
    }

    private void dibujaCuadro(MouseEvent evt) {
        try {
            int x = evt.getX();
            int y = evt.getY();
            if (evt.isMetaDown()) {

            } else {
                if (!clickIzquierdo(x, y)) {
                    int nombre = Integer.parseInt(JOptionPane.showInputDialog("Ingresa cantidad"));
                    nodo_.add(new Nodo(x, y, nombre));
                    inicializaBuffer();
                    carga();
                    pintarCuadros();

                }
            }
        } catch (Exception e) {

        }
        bufferGraphics.drawImage(buffer2, 0, 0, null);

    }

    public void pintarCuadros() {
        for (Nodo nodo : nodo_) {
            Pintar.pintarCirculo(buffer2Graphics, nodo.getNx1(), nodo.getNy1(), String.valueOf(nodo.getNombre()));
        }
        vista.repaint();

    }

    public boolean clickIzquierdo(int x1, int y1) {
        boolean existeUno = false;
        int indice = -1;
        int elimina = -1;
        for (Nodo nods : nodo_) {
            indice++;
            if ((x1 + 15) > nods.getNx1() && x1 < (nods.getNx1() + 30) && (y1 + 15) > nods.getNy1() && y1 < (nods.getNy1() + 30)) {
                elimina = indice;
                existeUno = true;
            }
        }
        if (nodo_.size() > 0 & elimina >= 0) {
            nodo_.remove(elimina);
            inicializaBuffer();
            carga();
            pintarCuadros();
            bufferGraphics.drawImage(buffer2, 0, 0, null);

        }

        return existeUno;
    }
}
