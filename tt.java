import java.util.Scanner;
public class tt{
    boolean arr[][];
    boolean b=false;
    boolean[][] printtt(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<(Math.pow(2,n));j++){

                if(j<Math.pow(2,n-1)){
                    arr[j][i]=b;
                }
                else{
                    arr[j][i]=!b;
                }
            }
        }
        return(arr);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input values count");
        tt ob=new tt();
        int num=sc.nextInt();int pownum=(int)Math.pow(2,num);
        boolean array[][]=new boolean[pownum][num];
        array=ob.printtt(num);
        for(int i=0;i<num;i++){
            for(int j=0;j<(Math.pow(2,num));j++){

                System.out.println(array[j][i]);
            }
        }
        column = 0;

        while (column < numVariables)
        {
            state = false;
            toggle = (short) Math.pow(2, numVariables - column - 1);

            row = 1;
            while (row < rows)
            {
                if ((row -1)%toggle == 0)
                    state = !state;

                if (state)
                    truthTable[row][column] = 'T';
                else
                    truthTable[row][column] = 'F';

                row++;
            }

            column++;
        }
     }

}
