public class ElipseApp {
    public static void main (String[] args) {
        Elipse e1 = new Elipse(1,1, 10,10);
        e1.print();
    }
}
class Elipse {
    int x, y;
    int diaw, diah;
    Elipse (int x, int y, int diaw, int diah) {
        this.x = x;
        this.y = y;
        this.diaw = diaw;
        this.diah = diah;
    }
    void print () {
        System.out.format("Elipse de diametros (%d,%d) na posicao (%d,%d).\n",
            this.diaw, this.diah, this.x, this.y);
    }
}
