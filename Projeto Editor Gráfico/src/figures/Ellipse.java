package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.event.*;

public class Ellipse extends Figure {

    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int rf, int gf, int bf) {
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

    public void keyPressed(KeyEvent evt){
        switch (evt.getKeyCode()){
            case KeyEvent.VK_UP:{
                this.h+=5;
                break;
            }
            case KeyEvent.VK_DOWN:{
                if(this.h>=1){
                    this.h-=3;
                }
                break;
            }
            case KeyEvent.VK_RIGHT:{
                this.w+=5;
                break;
            }
            case KeyEvent.VK_LEFT:{
                if (this.w>=1){
                    this.w-=3;
                }
                break;
            }
            case KeyEvent.VK_1:{ //Vermelho
                this.rf = 255;
                this.gf = 0;
                this.bf = 0;
                break;
            }
            case KeyEvent.VK_2:{ //Verde
                this.rf = 0;
                this.gf = 255;
                this.bf = 0;
                break;
            }
            case KeyEvent.VK_3:{ //Azul
                this.rf = 0;
                this.gf = 0;
                this.bf = 255;
                break;
            }
            case KeyEvent.VK_4:{ //Amarelo
                this.rf = 255;
                this.gf = 255;
                this.bf = 0;
                break;
            }
            case KeyEvent.VK_9:{ //Branco
                this.rf = 255;
                this.gf = 255;
                this.bf = 255;
                break;
            }
            case KeyEvent.VK_0:{ //Preto
                this.rf = 0;
                this.gf = 0;
                this.bf = 0;
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
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.rf, this.gf, this.bf));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}