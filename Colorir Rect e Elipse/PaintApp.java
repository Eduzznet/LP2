import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    Rect r1;
    Rect r2;
    Rect r3;
    Rect r4;
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;
    Ellipse e4;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, 0, 0 ,0, 50, 200, 70);
        this.r2 = new Rect(150,50, 30,100, 100, 100 ,100, 200, 200, 30);
        this.r3 = new Rect(50,80, 100,30, 200, 30 ,70, 20, 50, 150);
        this.r4 = new Rect(50,110, 100,40, 30, 150 ,20, 200, 50, 20);
        this.e1 = new Ellipse(50,200, 100, 100, 0, 0, 0, 200, 10, 60);
        this.e2 = new Ellipse(200,200, 100, 100, 10, 30, 200, 200, 10, 60);
        this.e3 = new Ellipse(220,250, 35, 35, 100, 100, 100, 0, 0, 0);
        this.e4 = new Ellipse(100,250, 35, 35, 0, 115, 0, 100, 100, 0);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
        this.r4.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.e4.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    int r, g, b;
    int rf, gf, bf;

    Rect (int x, int y, int w, int h, int r, int g, int b, int rf, int gf, int bf) {
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

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(this.rf, this.gf, this.bf));
        g2d.fillRect(this.x+1, this.y+1, this.w-1, this.h-1);
    }
    int area() {
        return this.w * this.h;
    }
    void drag(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }  
}

class Ellipse {
    int x, y;
    int w, h;
    int r, g, b;
    int rf, gf, bf;

    Ellipse (int x, int y, int w, int h, int r, int g, int b, int rf, int gf, int bf) {
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

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(new Color(this.rf, this.gf, this.bf));
        g2d.fillOval(this.x, this.y, this.w, this.h);
    }
}