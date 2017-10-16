import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
public class maze extends  JFrame implements ActionListener
{
    private JPanel panel;
    private JButton nuevo, resolver, dibujar, limpiar;
    Random azar = new Random();
    Stack <nodo> pila = new Stack <nodo>();
    int entradaF=0, entradaC=0, salidaF=0, salidaC=0;
    //-int mayor=-3;
    int m [][]={{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1},
            { -1,  0, -1, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0, -1, -1,  0, -1},
            { -1,  0, -1, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0,  0,  0,  0, -1},
            { -1,  0,  0,  0,  0,  0, -1,  0, -1,  0, -1,  0,  0,  0,  0,  0, -1, -1,  0, -1},
            { -1, -1,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0, -1, -1,  0, -1},
            { -1,  0,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0,  0,  0,  0,  0,  0,  0,  0, -1},
            { -1, -1,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0, -1, -1,  0, -1},
            { -1, -1,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0,  0,  0,  0,  0, -1, -1,  0, -1},
            { -1, -1,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0,  0, -1,  0, -1},
            { -1,  0,  0,  0,  0,  0,  0,  0, -1,  0, -1,  0, -1, -1, -1, -1,  0, -1,  0, -1},
            { -1, -1,  0, -1, -1, -1, -1,  0, -1,  0, -1,  0, -1, -1, -1, -1,  0,  0,  0, -1},
            { -1, -1,  0, -1, -1, -1, -1,  0, -1,  0, -1,  0,  0,  0,  0,  0,  0, -1,  0, -1},
            { -1, -1,  0, -1,  0,  0,  0,  0, -1,  0, -1, -1, -1, -1, -1, -1,  0, -1,  0, -1},
            { -1, -1,  0,  0,  0, -1,  0, -1, -1,  0, -1, -1,  0,  0,  0, -1,  0, -1,  0, -1},
            { -1, -1,  0, -1,  0, -1,  0,  0,  0,  0,  0,  0,  0, -1,  0, -1,  0, -1,  0, -1},
            { -1,  0,  0, -1,  0, -1,  0, -1, -1,  0, -1, -1,  0, -1,  0,  0,  0, -1,  0, -1},
            { -1,  0, -1, -1,  0, -1,  0, -1, -1,  0, -1, -1,  0, -1, -1, -1, -1, -1,  0, -1},
            { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};

    public static void main(String[] args) { 
        maze a = new maze();
        a.setSize(800, 800); 
        a.createGUI();  
        a.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        Container window = getContentPane(); 
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setBackground(Color.white); 
        window.add(panel);

        resolver = new JButton("Resolver");
        window.add(resolver);
        resolver.addActionListener(this);

        nuevo = new JButton("Nuevo");
        window.add(nuevo);
        nuevo.addActionListener(this);

        dibujar = new JButton("Dibujar");
        window.add(dibujar);
        dibujar.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        Graphics papel = panel.getGraphics();
        if(e.getSource()==dibujar){
            for(int f=0; f<m.length; f++){
                for(int c=0; c<m[f].length; c++){                    
                    if(m[f][c]==-1){
                        papel.setColor(Color.lightGray);
                        papel.fillRect(c*20,f*20,20,20);
                    }else if(m[f][c]==0){
                        papel.setColor(Color.lightGray);
                        papel.drawRect(c*20,f*20,20,20);
                    }
                }
            }
        }
        if(e.getSource()==nuevo){
            
            for(int f=0; f<m.length; f++){
                for(int c=0; c<m[f].length; c++){
                    if(m[f][c]==-2){
                        m[f][c]=-1;
                        papel.setColor(Color.lightGray);
                        papel.fillRect(c*20,f*20,20,20);
                    }
                    if(m[f][c]==-3 || m[f][c]==5){
                        m[f][c]=0;
                        papel.setColor(Color.white);
                        papel.fillRect(c*20,f*20,20,20);
                        papel.setColor(Color.lightGray);
                        papel.drawRect(c*20,f*20,20,20);
                    }
                }
            } 
            pila=new Stack <nodo> ();
            entradaF=0;
            entradaC=0;
            salidaF=0;
            salidaC=0;
            int entSal= azar.nextInt(2)+1;
            if(entSal==1){
                //System.out.println("Entrando");
                do{
                    entradaF =azar.nextInt(18)+1;                   
                }while(m[entradaF][1]!=0);
                 m[entradaF][0]=-2;
                System.out.println("Saliendo");
                System.out.println("Entrando2");
                do{
                    salidaF = azar.nextInt(18)+1; 
                 
                }while(m[salidaF][18]!=0);
                   m[salidaF][19]=-2;
                   System.out.println("saliendo2");
            } else if(entSal==2){
                do{
                    entradaC = azar.nextInt(18)+1;
                 
                }while(m[1][entradaC]!=0);
                    m[0][entradaC]=-2;
                do{
                    salidaC = azar.nextInt(18)+1;
                  
                }while(m[18][salidaC]!=0);
                  m[19][salidaC]=-2;
            }
            System.out.println("xI: "+entradaF+", yI: "+entradaC);
            for(int row=0; row<m.length; row++){
                for(int col=0; col<m[row].length; col++){                    
                    if(m[row][col]==-2){
                        papel.setColor(Color.red);
                        papel.fillRect(col*20,row*20,20,20);
                    }
                }
            }  
            for(int f=0; f<m.length; f++){
                for(int c=0; c<m[f].length; c++){
                    if(m[f][c]<0){
                        System.out.print("  " + m[f][c]);
                    }else if(m[f][c]<10){
                        System.out.print("   " + m[f][c]);
                    }else if(m[f][c]<100){
                        System.out.print("  " + m[f][c]);
                    }else {
                        System.out.print(" " + m[f][c]);
                    }
                }
                System.out.println();
            }
        }

        if(e.getSource()==resolver){            
            pila.push(new nodo (entradaF, entradaC));System.out.println("xI: "+entradaF+", yI: "+entradaC);
            nodo temp = pila.peek();
            int x = temp.getF();
            int y = temp.getC();
            while(!pila.empty()){  
                System.out.println("Ya entré");
                if( x+1<m.length&&m[x+1][y]==-2 || x-1>=0&&m[x-1][y]==-2 || y-1>=0&&m[x][y-1]==-2 || y+1<m.length&&m[x][y+1]==-2){
                        System.out.println("Arriba");
                        break;
                    }
                if( x-1>=0&& m[x-1][y]==0){
                    m[x][y]=5;
                    pila.push(new nodo(x,y));                    
                    if(m[x][y]==5){
                        papel.setColor(Color.yellow);
                        papel.fillRect(y*20, x*20, 20, 20);
                    }
                    x--;
                }else if( x+1<m.length&& m[x+1][y]==0){
                    m[x][y]=5;
                    pila.push(new nodo(x,y));
                    if(m[x][y]==5){
                        papel.setColor(Color.yellow);
                        papel.fillRect(y*20, x*20, 20, 20);
                    }  
                    x++;
                }else if( y-1>=0&& m[x][y-1]==0){
                    m[x][y]=5;
                    pila.push(new nodo(x,y)) ; 
                    if(m[x][y]==5){
                        papel.setColor(Color.yellow);
                        papel.fillRect(y*20, x*20, 20, 20);
                    }
                    y--;
                }else if( y+1<m.length&& m[x][y+1]==0){
                    m[x][y]=5; 
                    pila.push(new nodo(x,y));
                    if(m[x][y]==5){
                        papel.setColor(Color.yellow);
                        papel.fillRect(y*20, x*20, 20, 20);
                    }
                    y++;
                } else if(!pila.empty()){                   
                    m[x][y]=-3;                  
                    papel.setColor(Color.magenta);
                    papel.fillRect(y*20, x*20, 20, 20);  
                    temp = pila.pop();
                    x = temp.getF();
                    y = temp.getC();
                }
                System.out.println("ya salí");
            }
            m[x][y]=5;
            papel.setColor(Color.yellow);
            papel.fillRect(y*20, x*20, 20, 20);
            m[entradaF][entradaC]=-2;
            papel.setColor(Color.red);
            papel.fillRect(entradaC*20, entradaF*20, 20, 20);
            for(int f=0; f<m.length; f++){
                for(int c=0; c<m[f].length; c++){
                    if(m[f][c]<0){
                        System.out.print("  " + m[f][c]);
                    }else if(m[f][c]<10){
                        System.out.print("   " + m[f][c]);
                    }else if(m[f][c]<100){
                        System.out.print("  " + m[f][c]);
                    }else {
                        System.out.print(" " + m[f][c]);
                    }
                }
                System.out.println();
            }
            System.out.println(pila);
        }
    }
}

