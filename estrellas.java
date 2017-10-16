import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class estrellas extends JFrame implements ActionListener
{
    private JButton boton;
    int[][] m = new int [5][5];
    Random alet = new Random ();
    
    public static void main (String[] args){
        estrellas demo = new estrellas ();
        demo.setSize(100, 100);
        demo.createGUI();
        demo.setVisible(true);
    }
    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        boton = new JButton ("Ejecutar");
        window.add(boton);
        boton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event){
        char estrella = '*';
        String mensaje = " ";
        
        for (int est=0; est<=5; est++){
            int f = alet.nextInt(5);
            int c = alet.nextInt(5);
            m[f][c]='*';
        }
        for(int fil=0; fil<=4; fil++){
            for(int col=0; col<=4; col++){
                int cont=0;
                if(m[fil][col]==0){
                    if (fil-1>=0 && col-1>=0 && m[fil-1][col-1]==42){
                        cont++;
                    }else if(col-1>=0 && m[fil][col-1]==42){
                        cont++;
                    }else if(fil+1<m.length && col-1>=0 && m[fil+1][col-1]==42){
                        cont++;
                    }else if (fil-1>=0 && m[fil-1][col]==42){
                        cont++;
                    }else if (fil+1<m.length && m[fil+1][col]==42){
                        cont++;
                    }else if (fil-1>=0 && col+1<m.length && m[fil-1][col+1]==42){
                        cont++;
                    }else if (col+1<m.length && m[fil][col+1]==42){
                        cont++;
                    }else if (fil+1<m.length && col+1<m.length && m[fil+1][col+1]==42){
                        cont++;
                    }
                }
                m[fil][col]=cont;
            }
        }
        
        //Leer arreglo completo
        for(int x=0; x<=4; x++){
            for(int y=0; y<=4; y++){
                mensaje += m[x][y] + "  ";
            }
            mensaje += "\n";
        }
        
            JOptionPane.showMessageDialog(null, mensaje);
        
        /*
        if (fil-1>0 && col-1>0 && m[fil-1][col-1]=='*'){
            for(fil=0; fil<=5; fil++){
            for(col=0; col<=5; col++){
                if(m[fil][col]=='*'){
                    //leer vecinos
                    int sum = estrella + estrella;
                    mensaje += m[fil][col] + " ";
                    
                }
            }
           }  
        } else if (fil>=m.length && col>=m.length && m[fil+1][col+1]){
             for(fil=0; fil<=5; fil++){
            for(col=0; col<=5; col++){
                if(m[fil][col]=='*'){
                    //leer vecinos
                    int sum = estrella + estrella;
                    mensaje += m[fil][col] + " ";
                    
                }
            }
           }
        }*/
            
        
    }
}
