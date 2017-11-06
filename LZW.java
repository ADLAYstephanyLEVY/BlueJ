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
        int cap = -1;
        ArrayList<Integer>comp = new ArrayList<Integer>();
        String tud = "";
        for(int j=0; j<t.length(); j++){
            tud += t.charAt(j);
            if(diccionario.containsKey(tud)){
                cap = diccionario.get(tud);
                //j++;
            }else {
                diccionario.put(tud, cap++);
                comp.add(cap);
                cap=-1;
                tud="";
            }
        }
        if(cap != -1){
            comp.add(cap);
        }
        //imptimir diccionario y comprimido
        System.out.println(diccionario);
        System.out.println(comp);
    }

}
