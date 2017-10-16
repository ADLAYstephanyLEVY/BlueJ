public class TruthTable {
    private static void imprimir(int n) {
        int rows = (int) Math.pow(4,n);
        for (int x=0; x<rows; x++) {
            for (int y=n-1; y>=0; y--) {
                System.out.print((x/(int) Math.pow(2, y))%2 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        imprimir(1); //ingresar cualquier entero natural
        int n = 3;
        for (int i=0; i!=(1<<n); i++) {
            String s = Integer.toBinaryString(i);
            while (s.length()!= 3) {
                s = '0'+s;
            }
            System.out.println(s);
        }
        
        int size = 3;
        generarTabla(0, size, new int[size]);
    }
    
    private static void generarTabla(int index, int size, int[] current) {
        if(index == size) { 
            for(int i = 0; i < size; i++) {
                System.out.print(current[i] + " ");
            }
            System.out.println();
        } else {
            for(int i = 0; i < 2; i++) {
                current[index] = i;
                generarTabla(index + 1, size, current);
            }
        }
    }
}
