import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Hello2DFrame() {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);
        int w = getWidth();
        int h = getHeight();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, w, h);
        g2d.setColor(Color.cyan);
        g2d.drawPolygon(new int[] {w/2, 50, 50}, new int [] {h/2, 50, 100}, 3);
        g2d.drawPolygon(new int[] {w/2, 50, 100}, new int [] {h/2, 50, 50}, 3);
        g2d.drawPolygon(new int[] {w/2, h-50, w-100}, new int [] {h/2, h-50, w-50}, 3);
        g2d.drawPolygon(new int[] {w/2, h-50, w-50}, new int [] {h/2, h-50, w-100}, 3);
        g2d.drawPolygon(new int[] {w/2, 50, 100}, new int [] {h/2, h-50, h-50}, 3);
        g2d.drawPolygon(new int[] {w/2, 50, 50}, new int [] {h/2, h-50, w-100}, 3);
        g2d.drawPolygon(new int[] {w/2, w-50, w-100}, new int [] {h/2, 50, 50}, 3);
        g2d.drawPolygon(new int[] {w/2, w-50, w-50}, new int [] {h/2, 50, 100}, 3);
    }
}
