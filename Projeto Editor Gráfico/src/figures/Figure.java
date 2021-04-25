package figures;
import java.awt.event.*;
import java.awt.Graphics;

public abstract class Figure {
    public int x, y;
    public int w, h;
    int r,g,b;
    public abstract void paint (Graphics g);
    public abstract void keyPressed(KeyEvent evt);
}