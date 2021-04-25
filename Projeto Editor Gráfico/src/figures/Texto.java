package figures;

import java.awt.*;
import java.awt.event.*;

public class Texto extends Figure {
    String texto;
    String fonte;
    int style;
    public int t;

    public Texto (String texto, String fonte, int style, int x, int y, int t, int w, int h, int r, int g, int b) {
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

    public void keyPressed(KeyEvent evt){
        switch (evt.getKeyCode()){
            case KeyEvent.VK_UP:{
                this.t+=1;
                break;
            }
            case KeyEvent.VK_DOWN:{
                if(this.t>=1){
                    this.t-=1;
                }
                break;
            }
            case KeyEvent.VK_RIGHT:{
                this.t+=1;
                break;
            }
            case KeyEvent.VK_LEFT:{
                if (this.t>=1){
                    this.t-=1;
                }
                break;
        
            }
            case KeyEvent.VK_NUMPAD1:{ //Vermelho
                this.r = 255;
                this.g = 0;
                this.b = 0;
                break;
            }
            case KeyEvent.VK_NUMPAD2:{ //Verde
                this.r = 0;
                this.g = 255;
                this.b = 0;
                break;
            }
            case KeyEvent.VK_NUMPAD3:{ //Azul
                this.r = 0;
                this.g = 0;
                this.b = 255;
                break;
            }
            case KeyEvent.VK_NUMPAD4:{ //Amarelo
                this.r = 255;
                this.g = 255;
                this.b = 0;
                break;
            }
            case KeyEvent.VK_NUMPAD9:{ //Branco
                this.r = 255;
                this.g = 255;
                this.b = 255;
                break;
            }
            case KeyEvent.VK_NUMPAD0:{ //Preto
                this.r = 0;
                this.g = 0;
                this.b = 0;
                break;
            }
        }
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
        FontMetrics metrics = g.getFontMetrics();
        this.h= metrics.getHeight();
        this.w = metrics.stringWidth(texto);
    }
}