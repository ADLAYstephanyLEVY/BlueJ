import javax.swing.*;
// Java program for implementation of Insertion Sort
class InsertionSort
{
    static long tiempoInicial, tiempoFinal, tiempoTotal;
    void sort(int arr[]){
        tiempoInicial=System.currentTimeMillis();
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        tiempoFinal=System.currentTimeMillis();
    }
 
    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        System.out.println("Ordenada");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println(arr[i] + " ");
 
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {        
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número"));
        System.out.println('\u000C');
        int arr[] = new int [numero];
        for(int i=0; i<arr.length; i++){
            int x = (int)(Math.random()*numero);
            arr[i]=x;
            System.out.println(arr[i]);
        }
 
        InsertionSort ob = new InsertionSort();        
        ob.sort(arr);
         
        printArray(arr);
        
        System.out.println("Tiempo total: " + (tiempoFinal-tiempoInicial) );
    }
} 
