
import java.awt.*;
public class Circulo extends Formas
{
    public Circulo(){
        x = (int)(Math.random()*480);
        y = (int)(Math.random()*480);
        a = 20;
        h = 20; 
        dirección=(int)(Math.random() * 4+1);
    }
    public double getArea(){
        return Math.PI*Math.pow(a,2);
    }
    public void mostrar (Graphics p){
        p.drawOval(x,y,a,h);
    }
}