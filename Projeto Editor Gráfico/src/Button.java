import figures.Figure;
import ivisible.IVisible;
import java.awt.*;

public class Button implements IVisible{
    public int idx;
    private int x,y,w,h;
    private Figure fig;
    protected boolean foco;
    public Button (int idx, int x, int y, int w ,int h, Figure fig) {
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fig = fig;
    }
    public boolean clicked (int x, int y){
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
    public void paint (Graphics g, boolean focado){
        Graphics2D g2d = (Graphics2D)g;
        if (focado){
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(this.x, this.y, this.w, this.h);
        }
        else{
            g2d.setColor(Color.LIGHT_GRAY); 
            g2d.fillRect(this.x,this.y, this.w, this.h);
        }
        this.fig.paint(g, true);

    }
}
