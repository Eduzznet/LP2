import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    Rect r1;
    Rect r2;
    Rect r3;
    Rect r4;
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;
    Ellipse e4;
    Texto t1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, 0, 0 ,0, 50, 200, 70);
        this.r2 = new Rect(150,50, 30,100, 100, 100 ,100, 200, 200, 30);
        this.r3 = new Rect(50,80, 100,30, 200, 30 ,70, 20, 50, 150);
        this.r4 = new Rect(50,110, 100,40, 30, 150 ,20, 200, 50, 20);
        this.e1 = new Ellipse(50,200, 100, 100, 0, 0, 0, 200, 10, 60);
        this.e2 = new Ellipse(200,200, 100, 100, 10, 30, 200, 200, 10, 60);
        this.e3 = new Ellipse(220,250, 35, 35, 100, 100, 100, 0, 0, 0);
        this.e4 = new Ellipse(100,250, 35, 35, 0, 115, 0, 100, 100, 0);
        this.t1 = new Texto ("By: Eduardo Franco", "Segoe Script", 1, 10, 330, 20, 100, 0, 0);
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
        this.t1.paint(g);
    }
}
