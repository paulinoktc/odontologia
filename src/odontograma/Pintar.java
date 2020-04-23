package odontograma;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pintar {

    public Pintar() {

    }

    public static void pintarCirculo(Graphics2D bufferGraphics, int x, int y, String n) {
        bufferGraphics.setColor(Color.ORANGE);
        bufferGraphics.setStroke(new BasicStroke(4));
        bufferGraphics.setColor(Color.ORANGE);
        bufferGraphics.drawRect(x - 13, y - 10, 20, 20);
        bufferGraphics.setColor(Color.RED);
        Font fuente = new Font("Monospaced", Font.PLAIN, 25);
        bufferGraphics.setFont(fuente);
        bufferGraphics.drawString(n, x - 4, y - 15);

    }
}
