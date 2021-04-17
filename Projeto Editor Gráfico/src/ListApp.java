import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus;
    int mouseX;
    int mouseY;
    int mX;
    int mY;

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                        int x = mX;
                        int y = mY;
                        int w = rand.nextInt(150);
                        int h = rand.nextInt(150);
                        int r = rand.nextInt(255);
                        int g = rand.nextInt(255);
                        int b = rand.nextInt(255);
                        int rf = rand.nextInt(255);
                        int gf = rand.nextInt(255);
                        int bf = rand.nextInt(255);
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h, r,g,b, rf,gf,bf));
                        repaint();
                    }
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h, r,g,b, rf,gf,bf));
                        repaint();
                    }
                }
            }
        );
    this.addMouseListener (
        new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                mouseX = evt.getX();
                mouseY = evt.getY();
                focus = null;
                for (Figure fig: figs)
                {
                    if ((mouseX >= fig.x && mouseX <= (fig.w+fig.x)) && (mouseY >= fig.y && mouseY <= (fig.y+fig.h)))
                    {
                        focus = fig;
                        figs.remove(fig);
                        figs.add(fig);
                        repaint();
                        break;
                    }
                    else
                    {
                        focus = null;
                        repaint();
                    }
                }
            }
        }
    );


    this.addMouseMotionListener(
        new MouseMotionAdapter()
        {    
            public void mouseMoved(MouseEvent e)
            {
                mX = e.getX();
                mY = e.getY();
            }
        }
    );

        this.setTitle("Lista de Rects e Ellipses");
        this.setSize(720, 480);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);  
        }
    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
        if (focus!=null){
            g2d.setColor(Color.RED);
            g2d.drawRect(focus.x-1, focus.y-1, focus.w+2, focus.h+2);
            this.addKeyListener (
                new KeyAdapter() {
                    public void keyPressed (KeyEvent evt) {
                        if (evt.getKeyChar() == KeyEvent.VK_DELETE) {
                            figs.remove(focus);
                            focus=null;
                            repaint();
                        }
                    }
                }
            );
        }
        focus.paint(g);
    }
}
