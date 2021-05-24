import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import figures.*;

public class Window extends JPanel {
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus;
    int mouseX;
    int mouseY;
    int mX;
    int mY;
    Texto tutorial = new Texto("R-Retangulo   E-Elipse   T-Texto(Escreva no console)   Y-Retangulo Arredondado", "Calibri", 0, 10, 435, 13, 0, 0, 255, 0, 0);
    Texto tutorial2 = new Texto("1-Vermlho   2-Verde   3-Azul   4-Amarelo   9-Branco   0-Preto   (Para controno use o NUMPAD)", "Calibri", 0, 10, 450, 13, 0, 0, 255, 0, 0);
    Texto tutorial3 = new Texto("Setinhas para Redimensionar(Cima/Direita aumentam e Baixo/Esquerda diminuem   DEL-Deletar", "Calibri", 0, 10, 465, 13, 0, 0, 255, 0, 0);
    
    Window(){
    
    setFocusable(true);
    setDoubleBuffered(true);
    setFocusTraversalKeysEnabled(false);
    
    
    try{
        FileInputStream f = new FileInputStream ("proj.bin");
        ObjectInputStream o = new ObjectInputStream(f);
        this.figs = (ArrayList<Figure>) o.readObject();
        o.close();
        } catch (Exception x){
            System.out.println("ERRO!");
        }
    /*this.addWindowListener (
        new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                try{
                    FileOutputStream f = new FileOutputStream("proj.bin");
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(figs);
                    o.flush();
                    o.close();
                } catch (Exception x){
                }
                System.exit(0);
            }
        }
    );*/
    this.addKeyListener (
        new KeyAdapter(){
            public void keyPressed (KeyEvent evt) {
                    int x = mX;
                    int y = mY;
                    int w = 50;
                    int h = 50;
                    int r = 255;
                    int g = 255;
                    int b = 255;
                    int rf = 0;
                    int gf = 0;
                    int bf = 0;
                if (evt.getKeyChar() == 'r') {
                    figs.add(new Rect(x,y, w,h, r,g,b, rf,gf,bf));
                    focus = figs.get(figs.size()-1);
                    repaint();
                }
                if (evt.getKeyChar() == 'e') {
                    figs.add(new Ellipse(x,y, w,h, r,g,b, rf,gf,bf));
                    focus = figs.get(figs.size()-1);
                    repaint();
                }
                if (evt.getKeyChar() == 'y'){
                    figs.add(new RoundRect(x, y, w, h, r, g, b, rf, gf, bf));
                    focus = figs.get(figs.size()-1);
                    repaint();
                }
                if (evt.getKeyChar() == 't') {
                    Scanner p = new Scanner (System.in);
                    String cadeia = p.nextLine(); 
                    figs.add(new Texto(cadeia, "Arial", 1, x, y, 20, 0, 0, r, g, b));
                    focus = figs.get(figs.size()-1);
                    repaint();
                }
                if (evt.getKeyChar() == KeyEvent.VK_TAB) {
                    for (Figure fig: figs) {
                        if (focus != fig){
                            focus=fig;
                            figs.remove(fig);
                            figs.add(fig);
                            repaint();
                            break;
                        }
                    }
                }
                if (focus!=null){
                    if (evt.getKeyCode() == KeyEvent.VK_RIGHT ||evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN ){
                        focus.keyPressed(evt);
                        repaint();
                    } 
                    if (evt.getKeyCode() == KeyEvent.VK_1 ||evt.getKeyCode() == KeyEvent.VK_2 || evt.getKeyCode() == KeyEvent.VK_3 || evt.getKeyCode() == KeyEvent.VK_4 || evt.getKeyCode() == KeyEvent.VK_9 || evt.getKeyCode() == KeyEvent.VK_0 ){
                        focus.keyPressed(evt);
                        repaint();
                        }
                    if (evt.getKeyCode() == KeyEvent.VK_NUMPAD1 ||evt.getKeyCode() == KeyEvent.VK_NUMPAD2 || evt.getKeyCode() == KeyEvent.VK_NUMPAD3 || evt.getKeyCode() == KeyEvent.VK_NUMPAD4 || evt.getKeyCode() == KeyEvent.VK_NUMPAD9 || evt.getKeyCode() == KeyEvent.VK_NUMPAD0 ){
                        focus.keyPressed(evt);
                        repaint();
                    }
                    if (evt.getKeyCode() == KeyEvent.VK_DELETE){
                        figs.remove(focus);
                        focus=null;
                        repaint();
                    }
                }

            }
        }
    );
    this.addMouseListener (
        new MouseAdapter()
        {
            public void mousePressed(MouseEvent evt)
            {
                mouseX = evt.getX();
                mouseY = evt.getY();
                focus = null;
                for (Figure fig: figs)
                {
                    if (fig.clicked(mouseX, mouseY))
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
            public void mouseDragged(MouseEvent e)
            {   
                if(focus!=null){
                    focus.x=e.getX();
                    focus.y=e.getY();
                    repaint();
                }
            }
        }
    );

}   
public void paint (Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, 2000, 1500);
    tutorial.paint(g);
    tutorial2.paint(g);
    tutorial3.paint(g);
    for (Figure fig: figs) {
        fig.paint(g);
    }
    if (focus!=null){
        g2d.setColor(Color.RED);
        focus.criaFoco(g);
    }
}
}