
/*
Clase que hereda de la clase Thread, usada
 *Para hacer un temporizador
 *Autor: LBVP
 *Fecha:06-05-2011
 *Licencia :GNU
 */
public class Post2 extends Thread{     
    public Post2 () {// Contructor porque la clase es heredada 
        super();
    }
    private static int nuMin=0;//El Contador de minutos
    private static int nuSeg=0;//El Contador de de segundos
    private static int nuHora=0;//El Contador de Horas      
    public void run() {
        try {//si ocurre un error al dormir el proceso(sleep(999))
            for (; ;){//inicio del for infinito          
                if(nuSeg!=0) {//si no es el ultimo segundo
                    nuSeg--;  //decremento el numero de segundos                                  
                }else{
                    if(nuMin!=0){//si no es el ultimo minuto
                        nuSeg=59;//segundos comienzan en 59
                        nuMin--;//decremento el numero de minutos
                    }else{
                        if (nuHora!=0){
                            nuHora--;//decremento el numero de horas
                            nuMin=59;//minutos comienzan en 59
                            nuSeg=59;//segundos comienzan en 59
                        }else{                         
                            break;//seacabo el tiempo fin hilo  
                        }
                    }
                }               
                System.out.println(nuHora+":"+nuMin+":"+nuSeg);//Muestro en pantalla el temporizador
                sleep(998);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
            }            
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }//Fin try               
    }

    public static void main(String[] args) {
        //Parametrizo el tiempo
        Post2.nuHora=0;
        Post2.nuMin=1;
        Post2.nuSeg=8;
        Post2 Temporizador= new Post2();// Crear una Instancia de la clase
        Temporizador.start();//inicializa el hilo
    }    
}