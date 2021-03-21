package figures;

import java.awt.*;

public class Texto {
    String texto;
    String fonte;
    int style;
    int x, y;
    int t;
    int r,g,b;

    public Texto (String texto, String fonte, int style, int x, int y, int t, int r, int g, int b) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.texto = texto;
        this.fonte = fonte;
        this.style = style;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void print () {
        System.out.format("Texto de tamanho (%d) na posicao (%d,%d).\n",
            this.t, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font(fonte, style, t));
        g2d.setPaint(new Color(this.r, this.g, this.b));
        g2d.drawString(this.texto, this.x, this.y);
    }
}
