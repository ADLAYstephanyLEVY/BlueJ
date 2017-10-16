import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
public class laberinto extends  JFrame implements ActionListener
{
    private JPanel panel;
    private JButton nuevo, resolver, dibujar, limpiar;
    Random azar = new Random();
    //iniciar nodo, Queue tipo nodo
    Queue <nodo> cola = new LinkedList <nodo>();
    int fOrig=0, cOrig=0, fFin=0, cFin=0;
    int mayor=-3;
    int m [][]={{ 0,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { 0,  0,  0,  0,  0,  0, -1,  0,  0,  0,  0,  0, -1, -1, -1,  0,  0,  0,  0,  0},
            { 0, -1, -1, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0, -1, -1, -1, -1},
            { 0, -1, -1, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0, -1, -1, -1, -1},
            { 0,  0,  0,  0,  0,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0, -1, -1, -1, -1},
            {-1, -1,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1,  0, -1, -1, -1, -1},
            { 0,  0,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0,  0,  0,  0,  0,  0,  0,  0, -1},
            { 0,  0,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1, -1, -1, -1,  0,  0},
            { 0,  0,  0, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1, -1, -1, -1,  0, -1},
            {-1, -1, -1, -1, -1,  0, -1,  0, -1,  0, -1,  0, -1, -1, -1, -1, -1, -1,  0, -1},
            {-1, -1,  0,  0,  0,  0,  0,  0, -1,  0, -1,  0, -1, -1, -1, -1, -1, -1,  0, -1},
            {-1, -1,  0, -1, -1, -1, -1, -1, -1,  0, -1,  0, -1, -1, -1, -1, -1, -1,  0, -1},
            {-1, -1,  0, -1, -1, -1, -1,  0, -1,  0, -1,  0,  0,  0,  0,  0,  0, -1,  0, -1},
            {-1, -1,  0, -1,  0,  0,  0,  0, -1,  0, -1, -1, -1, -1, -1, -1,  0, -1,  0, -1},
            {-1, -1,  0,  0,  0, -1, -1, -1, -1,  0, -1, -1,  0,  0,  0, -1,  0, -1,  0,  0},
            {-1, -1,  0, -1,  0, -1,  0,  0,  0,  0,  0,  0,  0, -1,  0, -1,  0, -1, -1,  0},
            { 0,  0,  0, -1,  0, -1,  0, -1, -1,  0, -1, -1,  0, -1,  0,  0,  0, -1, -1,  0},
            {-1, -1, -1, -1,  0, -1,  0, -1, -1,  0, -1, -1,  0, -1, -1, -1, -1, -1, -1,  0},
            {-1,  0,  0,  0,  0, -1,  0, -1, -1,  0, -1, -1,  0, -1, -1, -1, -1, -1, -1,  0},
            {-1,  0, -1, -1, -1, -1,  0,  0,  0,  0,  0,  0,  0, -1, -1, -1, -1, -1, -1,  0}};

    public static void main(String[] args) { 
        laberinto a = new laberinto();
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
                        m[f][c]=0;
                        papel.setColor(Color.white);
                        papel.fillRect(c*20,f*20,20,20);
                        papel.setColor(Color.lightGray);
                        papel.drawRect(c*20,f*20,20,20);
                    }

            
                    if(m[f][c]>=1){
                        m[f][c]=0;
                        papel.setColor(Color.white);
                        papel.fillRect(c*20,f*20,20,20);                        
                        papel.setColor(Color.lightGray);
                        papel.drawRect(c*20, f*20, 20,20);
                        //System.out.println(f +" " + c);
                    }
                    if(!cola.isEmpty()){
                        cola.remove();
                    }
                    //System.out.println(f +" " + c);
                }
            }

            for(int i=0; i<2; i++){
                do{
                    fOrig = azar.nextInt(19)+1;//agregar aleatorio la poscicion 1
                    cOrig = azar.nextInt(19)+1;
                } while(m[fOrig][cOrig]!=0);
                m[fOrig][cOrig]=-2;
                papel.setColor(Color.red);
                papel.fillRect(cOrig*20,fOrig*20,20,20);
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
            //escoger el numero menor que llegue al destino
            int cont=1;
            cola.offer(new nodo (fOrig, cOrig));
            while(!cola.isEmpty()){
                nodo temp = cola.poll();
                int x = temp.getF();
                int y = temp.getC();
                if( x-1>=0&& m[x-1][y]==0){
                    if(m[x][y]==-2){
                        m[x-1][y]=cont;
                    }else {
                        m[x-1][y]=m[x][y]+1;
                    }
                    cola.offer(new nodo(x-1,y));
                } else if(x-1>=0 && m[x-1][y]==-2 &&(x-1!=fOrig || y!=cOrig)){
                    fFin=x-1;
                    cFin=y;
                    break;
                }
                if(x+1<m.length && m[x+1][y]==0){
                    if(m[x][y]==-2){
                        m[x+1][y]=cont;
                    }else {
                        m[x+1][y]=m[x][y]+1;
                    }

                    cola.offer(new nodo(x+1,y));
                } else if(x+1<m.length && m[x+1][y]==-2 &&(x+1!=fOrig || y!=cOrig)){
                    fFin=x+1;
                    cFin=y;
                    break;
                }
                if(y-1>=0 && m[x][y-1]==0){ 
                    if(m[x][y]==-2){
                        m[x][y-1]=cont;
                    }else {
                        m[x][y-1]=m[x][y]+1;
                    }

                    cola.offer(new nodo(x,y-1));
                } else if(y-1>=0 && m[x][y-1]==-2 &&(x!=fOrig && y-1!=cOrig)){
                    fFin=x;
                    cFin=y-1;                    
                    break;
                }
                if(y+1<m.length && m[x][y+1]==0){
                    if(m[x][y]==-2){
                        m[x][y+1]=cont;
                    }else {
                        m[x][y+1]=m[x][y]+1;
                    }

                    cola.offer(new nodo(x,y+1));
                } else if(y+1<m.length && m[x][y+1]==-2 &&(x!=fOrig && y+1!=cOrig)){
                    fFin=x;
                    cFin=y+1;
                    break;
                }

            }                 
            int nuevaF=0, nuevaC=0;
            System.out.println(fFin +" "+ cFin);
            if( m[fFin-1][cFin]>mayor){  
                mayor=m[fFin-1][cFin];
                nuevaF=fFin-1;

                nuevaC=cFin;
                System.out.println(mayor +" "+ nuevaF);
            }
            if( m[fFin+1][cFin]>mayor){  
                mayor=m[fFin+1][cFin];
                nuevaF=fFin+1;
                nuevaC=cFin;
                System.out.println(mayor +" "+ nuevaF);
            }
            if( m[fFin][cFin-1]>mayor){  
                mayor=m[fFin][cFin-1];
                nuevaC=cFin-1;
                nuevaF=fFin;
                System.out.println(mayor +" "+ nuevaC);
            }
            if( m[fFin][cFin+1]>mayor){  
                mayor=m[fFin][cFin+1];
                nuevaC=cFin+1;
                nuevaF=fFin;
                System.out.println(mayor +" "+ nuevaC);
            }
            papel.setColor(Color.green);
            papel.fillRect(nuevaC*20,nuevaF*20,20,20);

            do{
                if( nuevaF-1>=0 && m[nuevaF-1][nuevaC]==mayor-1){  
                    mayor=m[nuevaF-1][nuevaC];
                    nuevaF--;

                    //System.out.println(mayor +" "+ nuevaF);
                }else
                if(nuevaF+1<m.length && m[nuevaF+1][nuevaC]==mayor-1){  
                    mayor=m[nuevaF+1][nuevaC];
                    nuevaF++;

                    //System.out.println(mayor +" "+ nuevaF);
                }else
                if(nuevaC-1>=0 && m[nuevaF][nuevaC-1]==mayor-1){  
                    mayor=m[nuevaF][nuevaC-1];
                    nuevaC--;

                    // System.out.println(mayor +" "+ nuevaC);
                }else
                if(nuevaC+1<m.length && m[nuevaF][nuevaC+1]==mayor-1){  
                    mayor=m[nuevaF][nuevaC+1];
                    nuevaC++;

                    //System.out.println(mayor +" "+ nuevaC);
                }
                papel.setColor(Color.green);
                papel.fillRect(nuevaC*20,nuevaF*20,20,20);
                //System.out.println(mayor );
            }while(mayor>1);

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

    }
}

