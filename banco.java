import java.util.Scanner;
public class banco 
{
    public static void main (String [] arg)
    {
        int cuenta, saldo, cont=0;
        Scanner leer = new Scanner (System.in);
    
        System.out.print('\u000C');    
            
       do 
       {
            System.out.println("Ingrese número de cuenta:");
            cuenta = leer.nextInt();
            System.out.println("Ingrese saldo actual");
            saldo = leer.nextInt();
            if (saldo > 0)
            {
             System.out.println("Acredor");
             cont=cont+saldo;
            }
            else if (saldo < 0)
            {
             System.out.println("Deudor");
            }
            else if (saldo == 0)
            {
             System.out.println("Nulo");
             
            }
        
        }while(cuenta>0);
              System.out.println("Cuentas acredoras: " + cont);
    }
  }


     