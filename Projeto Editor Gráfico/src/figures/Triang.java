package figures;

import java.awt.*;
public class Triang extends Figure{
    public Triang (int x, int y, int w, int h, int r, int g, int b, int rf, int gf, int bf) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.rf = rf;
        this.gf = gf;
        this.bf = bf;
    }


    public void print () {
        System.out.format("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    
    public void paint (Graphics g, boolean focado) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.rf, this.gf, this.bf));
        g2d.fillPolygon(new int[] {x, x+(w/2), x+w}, new int[] {y+h, y, y+h}, 3);
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawPolygon(new int[] {x, x+(w/2), x+w}, new int[] {y+h, y, y+h}, 3);
    }
}

