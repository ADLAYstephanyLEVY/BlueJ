
import java.awt.*;
public class Rectangulo extends Formas
{
   public double getArea(){
       return a*h*1.0;
    }
   public void mostrar(Graphics p){ 
       p.drawRect(x,y,h,a);
    }
}
