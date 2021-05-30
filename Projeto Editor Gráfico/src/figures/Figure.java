package figures;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable{
    public int x, y;
    protected int w, h;
    protected int r,g,b;
    protected int rf,gf,bf;

    public void criaFoco (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.x-1, this.y-1, this.w+2, this.h+3);
    }

    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
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
}
