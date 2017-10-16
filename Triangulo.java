import java.awt.*;
public class Triangulo extends Formas
{
    public double getArea(){
        return (a*h)/2.0;
    }
    public void mostrar(Graphics p){
        int xpts[] = {x+a/2, x+a, x};
        int ypts[] = {y, y+h, y+h};
        p.drawPolygon(xpts, ypts, 3);
    }
}
