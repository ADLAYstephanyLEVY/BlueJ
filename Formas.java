
import java.awt.*;
public abstract class Formas
{
    protected int x, y;
    protected int h, a, dirección;
    protected void mover(){
        x = x + 10;
    }
    public void setX(int x){
        this.x = x;
    }
    
    public void moverAD(){
        x = x+3;
        y = y-3;
    }
    public void moverAI(){
        x = x-3;
        y = y-3;
    }
    public void moverBD(){
        x = x+3;
        y = y+3;
    }
    public void moverBI(){
        x = x-3;
        y = y+3;
    }
    public abstract double getArea();
    public abstract void mostrar(Graphics p); 
    
}
