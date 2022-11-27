import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import figures.*;

public class Window extends JPanel {
    private static final long serialVersionUID = 1L; // RESPOSTA: (nome=serialVersionUID, propriedade=valor, tempo=pré-processamento)
    private ArrayList<Figure> figs = new ArrayList<Figure>();
    private ArrayList<Button> botoes = new ArrayList<Button>();
    private Figure focus;
    private Button focusB;
    private int mouseX;
    private int mouseY;
    private int mX; // RESPOSTA: (nome=mX, propriedade=valor, tempo=implementação)
    private int mY;
    private Texto tutorial = new Texto("ctrl+R: Retangulo   ctrl+E: Elipse   ctrl+Y: Retangulo Arredondado   ctrl+U: Triangulo Equilatero   ctrl+T: Texto(Teclado)", "Calibri", 0, 10, 435, 13, 0, 0, 255, 0, 0);
    private Texto tutorial2 = new Texto("1-Vermelho   2-Verde   3-Azul   4-Amarelo   9-Branco   0-Preto   (Para controno ou Texto use o NUMPAD)", "Calibri", 0, 10, 450, 13, 0, 0, 255, 0, 0);
    private Texto tutorial3 = new Texto("Setinhas para Redimensionar(Cima/Direita aumentam e Baixo/Esquerda diminuem)   DEL-Deletar   TAB-Foco   F4-Salvar", "Calibri", 0, 10, 465, 13, 0, 0, 255, 0, 0);
    
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

    botoes.add(new Button(1, 5, 5, 30, 30, new Rect(10, 9, 18, 20, 255, 0, 0, 255, 0, 0)));
    botoes.add(new Button(2, 5, 40, 30, 30, new Ellipse(9, 45, 20, 20, 255, 0, 0, 255, 0, 0)));
    botoes.add(new Button(3, 5, 75, 30, 30, new RoundRect(8, 78, 22, 22, 255, 0, 0, 255, 0, 0)));
    botoes.add(new Button(4, 5, 110, 30, 30, new Triang(8, 113, 22, 22, 255, 0, 0, 255, 0, 0)));
    botoes.add(new Button(5, 5, 145, 30, 30, new Texto("T", "Times New Roman", 1, 12, 168, 25, 0, 0, 255, 0, 0)));
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
                if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_R) {
                    figs.add(new Rect(x,y, w,h, r,g,b, rf,gf,bf));
                    focus = figs.get(figs.size()-1);
                    repaint();
                }
                if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_E) {
                    figs.add(new Ellipse(x,y, w,h, r,g,b, rf,gf,bf));
                    focus = figs.get(figs.size()-1);
                    repaint();
                }
                if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_Y){
                    figs.add(new RoundRect(x, y, w, h, r, g, b, rf, gf, bf));
                    focus = figs.get(figs.size()-1);
                    repaint();
                }
                if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_T) {
                    figs.add(new Texto("", "Arial", 1, x, y, 20, 0, 0, r, g, b));
                    focus = figs.get(figs.size()-1);
                    repaint();
                }
                if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_U) {
                    figs.add(new Triang(x, y, w, h, r, g, b, rf, gf, bf));
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
                if (evt.getKeyCode() == KeyEvent.VK_F4){
                    try{
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    } catch (Exception xException){
                    }
                }
                if (focus!=null){
                    if (evt.getKeyCode() >= 32 && evt.getKeyCode() < 127 || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                        focus.keyPressed(evt);
                        repaint();
                    }
                    else{
                        if (evt.getKeyCode() == KeyEvent.VK_DELETE){
                            figs.remove(focus);
                            focus=null;
                            repaint();
                        }
                        else if (! (evt.isActionKey() || evt.isControlDown() || evt.isShiftDown())){ 
                            focus.keyPressed(evt);
                            repaint();
                        }
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
                
                if(focusB!=null && (mouseX>35 || mouseY>170)){
                    if (focusB.idx==1){
                        figs.add(new Rect(mouseX,mouseY, 50,50, 255,255,255, 0,0,0));
                        focus = figs.get(figs.size()-1);
                        repaint();
                    }
                    else if (focusB.idx==2){
                        figs.add(new Ellipse(mouseX,mouseY, 50,50, 255,255,255, 0,0,0));
                        focus = figs.get(figs.size()-1);
                        repaint();
                    }
                    else if (focusB.idx==3){
                        figs.add(new RoundRect(mouseX,mouseY, 50,50, 255,255,255, 0,0,0));
                        focus = figs.get(figs.size()-1);
                        repaint();
                    }
                    else if (focusB.idx==4){
                        figs.add(new Triang(mouseX,mouseY, 50,50, 255,255,255, 0,0,0));
                        focus = figs.get(figs.size()-1);
                        repaint();
                    }
                    else if (focusB.idx==5){
                        figs.add(new Texto("", "Arial", 1, mouseX, mouseY, 20, 0, 0, 255, 255, 255));
                        focus = figs.get(figs.size()-1);
                        repaint();
                    }
                    focusB = null;
                    repaint();
                }
                for (Button botao:botoes)
                {
                    if (botao.clicked(mouseX, mouseY))
                    {
                        focusB = botao;
                        focusB.foco = true;
                        repaint();
                        break;
                    }
                    else{
                        focusB = null;
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
    tutorial.paint(g, true);
    tutorial2.paint(g, true);
    tutorial3.paint(g, true);
    for (Figure fig: figs) {
        fig.paint(g,true);
    }
    if (focus!=null){
        g2d.setColor(Color.RED);
        focus.criaFoco(g);
    }
    for (Button botao: botoes){
        botao.paint(g, botao==focusB);
    }       
}
}
