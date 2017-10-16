
import java.util.Scanner;
public class valores
{
    public static void main (String [] arg)
    {
      int x, contPos = 0, par = 0, mult=0, sumaPares=0, negativos=0;
   
      Scanner leer = new Scanner (System.in);
      System.out.print("\u000C");
      System.out.println("Ingrese quince valores: ");
     
      for(int i = 0; i < 15; i++)
      {
        x=leer.nextInt();
      
        if(x > 0)
        {
            contPos++;
            
        }
        
        if (x!=0 && x%2==0)
        {
            par++;
            sumaPares=sumaPares+x;
            
        }
        
        if (x!=0 && x%15==0)
        {
            mult++;
        }
        if (x<0)
        {
            negativos++;
        }
    }
    System.out.println("valores positivos: "+ contPos);
    System.out.println("valores negativos: "+ negativos);
    System.out.println("valores pares: "+ par);
    System.out.println("valores multiplos de 15: " + mult);
    System.out.println("La suma de los numeros pares: " + sumaPares);
  }
}
