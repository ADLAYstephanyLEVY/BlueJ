import javax.swing.*;
import java.awt.*;
import java.util.*;
public class LZW
{
    public static void main (String [] args){
       Hashtable<String, Integer> diccionario = new Hashtable<String, Integer>();
        int num=0;
        String t = JOptionPane.showInputDialog("Ingresa letras: ");
        
        /* capturar texto
         * crear diccionario inicial
         *  ciclo para letras del 97 a 122
         *      si en el texto está la letra
         *       meter en el diccionario(letra, valor)
         *       aumeta el valos*/
        for(int i=97; i<=122; i++){         
            //String letra = t.indexOf(i);
            if(t.indexOf(i)>=0){
                diccionario.put(" "+ (char)i, num);
                num++;
            }            
        }
        /*recorrer todo el texto
         *  tomar la letra y formar prefijos
         *      si el prefijo esta en el las llaves del diccionario
         *          variable le asignas el valor del key buscado
         *              si la encuentro posicion++
         *              si nono le hago pos´´ para que e ¿¿se quede en la misma poscion y 
         *              agregamos al dicionario el valor del prefijo(prefijo, valor)
         *              valor++;
         *              al comprimidio agregar el num 
         *              num le asigno -1
         *              limpiar prefijo
         */
      /*  for(int j=0; j<texto.length; j++){
            char letra = texto.indexOf(j);
            if(letra)
        } */
        //imptimir diccionario y comprimido
        System.out.println(diccionario);
    }

}
