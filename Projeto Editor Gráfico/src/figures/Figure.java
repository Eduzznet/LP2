package figures;
import java.awt.event.*;
import java.io.Serializable;
import java.awt.Graphics;
import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable{
    public int x, y;
    public int w, h;
    int r,g,b;
    public abstract void paint (Graphics g);
    public abstract void keyPressed(KeyEvent evt);
    

    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
}
