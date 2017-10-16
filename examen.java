import java.util.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class examen extends JFrame implements ActionListener
{
    private JTextArea area; 
    private JButton ver;
    // private JTextField text;
    
    public static void main (String[] args){
        examen demo = new examen ();
        demo.setSize(500, 500);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        area = new JTextArea(15, 15);
        window.add(area);

        ver = new JButton ("Verificar");
        window.add(ver);
        ver.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        
        String [] cadena = (area.getText()).split("\n");
        int m [][] = new int [cadena.length][cadena[0].length()];
        String mensaje = "";
        char efe = 'F';   
        
        for(int f=0; f<cadena.length; f++){
            String x = cadena[f];
            for(int z=0; z<x.length(); z++){
                    m[f][z]=x.charAt(z);
            }
        }
        
        if (event.getSource()==ver){
            for(int fil=0; fil<=cadena.length; fil++){
                for(int col=0; col<=cadena.length; col++){
                    int cont=0;
                    if(m[fil][col]==0){
                        if (fil-1>=0 && col-1>=0 && m[fil-1][col-1]==70){
                            cont++;
                        }else if(col-1>=0 && m[fil][col-1]==70){
                            cont++;
                        }else if(fil+1<m.length && col-1>=0 && m[fil+1][col-1]==70){
                            cont++;
                        }else if (fil-1>=0 && m[fil-1][col]==70){
                            cont++;
                        }else if (fil+1<m.length && m[fil+1][col]==70){
                            cont++;
                        }else if (fil-1>=0 && col+1<m.length && m[fil-1][col+1]==70){
                            cont++;
                        }else if (col+1<m.length && m[fil][col+1]==70){
                            cont++;
                        }else if (fil+1<m.length && col+1<m.length && m[fil+1][col+1]==70){
                            cont++;
                        }
                    }
                    m[fil][col]=cont;
                    if(m[cadena.length][cadena[0].length()]==m[fil][col]){ 
                        JOptionPane.showMessageDialog(null, mensaje + "Well done!");
                    } else {
                         JOptionPane.showMessageDialog(null, mensaje + "Try again");
                        }
                }
            }
        }
    }
}
