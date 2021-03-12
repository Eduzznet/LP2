public class ElipseApp {
    public static void main (String[] args) {
        Elipse e1 = new Elipse(1,1, 10,10);
        e1.print();
    }
}
class Elipse {
    int x, y;
    int raiow, raioh;
    Elipse (int x, int y, int raiow, int raioh) {
        this.x = x;
        this.y = y;
        this.raiow = raiow;
        this.raioh = raioh;
    }
    void print () {
        System.out.format("Elipse de raios (%d,%d) na posicao (%d,%d).\n",
            this.raiow, this.raioh, this.x, this.y);
    }
}