import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
public class laberintoAzar extends JFrame implements ActionListener
{
    private JPanel panel;
    private JButton dato, draw, nuevo, resolver;
    int n;
    Random random = new Random();
    LinkedList <nodo> celdas = new LinkedList <nodo>();
    LinkedList <nodo> vecinos = new LinkedList <nodo>();

    ButtonGroup grupo;
    JRadioButton botonCola, botonPila;

    public static void main(String[] args) { 
        laberintoAzar a = new laberintoAzar();
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

        dato = new JButton("Ingresar medidas del laberinto");
        window.add(dato);
        dato.addActionListener(this);

        draw = new JButton("Dibujar laberinto");
        window.add(draw);
        draw.addActionListener(this);

        resolver = new JButton("Resolver");
        window.add(resolver);
        resolver.addActionListener(this);

        botonCola = new JRadioButton("Cola", true);
        botonCola.addActionListener(this);

        botonPila = new JRadioButton("Pila", false);
        botonPila.addActionListener(this);

        grupo = new ButtonGroup();
        grupo.add(botonCola);
        grupo.add(botonPila);

        window.add(botonCola);
        window.add(botonPila);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==dato){
            String medidas = JOptionPane.showInputDialog("Ingresa un número: "); 
            n = Integer.parseInt(medidas);
            if(n%2==0){
                n++;
            }
        }
        int [][] m = new int [n][n];

        for(int f=1; f<m.length-1; f++){
            for(int c=1; c<m[f].length-1; c++){                
                if(f%2!=0 && c%2!=0){
                    m[f][c]=3;   
                }
            }   
        }
        int row =0;
        int column =0;
        do{     
            row =random.nextInt(m.length);
            column =random.nextInt(m.length);  
        }while(row%2==0 || column%2==0);   
        m[row][column]=2;
        celdas.add(new nodo(row, column));

        while(celdas.size()!=0){
            int posicion = random.nextInt(celdas.size());
            nodo num = celdas.remove(posicion);
            int fila = num.getF();
            int col = num.getC();
            m[fila][col]=1;
            if(fila-2>0 && m[fila-2][col]==3 ){                   
                m[fila-2][col]=2;
                celdas.add(new nodo (fila-2, col));             
            }else if(fila-2>0 && m[fila-2][col]==1){
                vecinos.add(new nodo (fila-1, col));
            }
            if(col+2<m.length && m[fila][col+2]==3){
                m[fila][col+2]=2;
                celdas.add(new nodo (fila, col+2));
            }else if(col+2<m.length && m[fila][col+2]==1){
                vecinos.add(new nodo (fila, col+1));
            }          
            if(fila+2<m.length && m[fila+2][col]==3){
                m[fila+2][col]=2;
                celdas.add(new nodo (fila+2, col));
            }else if(fila+2<m.length && m[fila+2][col]==1){
                vecinos.add(new nodo (fila+1, col));
            } 
            if(col-2>0 && m[fila][col-2]==3 ){                   
                m[fila][col-2]=2;
                celdas.add(new nodo (fila, col-2));             
            }else if(col-2>0 && m[fila][col-2]==1){
                vecinos.add(new nodo (fila, col-1));
            }             
            while(vecinos.size()!=0){
                int coordenada = random.nextInt(vecinos.size());
                nodo guardado = vecinos.remove(coordenada);
                int x = guardado.getF();
                int y = guardado.getC();
                m[x][y]=1;
                vecinos.clear();
            }
        }      

        if(botonCola.isSelected()){
            Graphics papel = panel.getGraphics();
            Queue <nodo> cola = new LinkedList <nodo>();
            int fOrig=0, cOrig=0, fFin=0, cFin=0;
            int mayor=-3;
            if(e.getSource()==draw){
                //pintar laberinto
                papel.setColor(Color.white);
                papel.fillRect(0,0,600,600);
                for(int f=0; f<m.length; f++){
                    for(int c=0; c<m[f].length; c++){   
                        if(m[f][c]==0){
                            papel.setColor(Color.lightGray);
                            papel.fillRect(c*7,f*7,7,7);
                        }else if(m[f][c]==1){
                            papel.setColor(Color.lightGray);
                            papel.drawRect(c*7,f*7,7,7);
                        }
                    }
                }
                //crear entradas al azar
                for(int i=0; i<2; i++){
                    do{     
                        fOrig =random.nextInt(m.length);
                        cOrig =random.nextInt(m.length);  
                    }while(fOrig%2==0 || cOrig%2==0);
                    m[fOrig][cOrig]=-2;
                    papel.setColor(Color.red);
                    papel.fillRect(cOrig*7,fOrig*7,7,7);
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
                int cont=2;
                cola.offer(new nodo (fOrig, cOrig));
                while(!cola.isEmpty()){
                    nodo temp = cola.poll();
                    int x = temp.getF();
                    int y = temp.getC();
                    if( x-1>=0&& m[x-1][y]==1){                        
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
                    if(x+1<m.length && m[x+1][y]==1){
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
                    if(y-1>=0 && m[x][y-1]==1){ 
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
                    if(y+1<m.length && m[x][y+1]==1){
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
                if(fFin-1>0&& m[fFin-1][cFin]>mayor){  
                    mayor=m[fFin-1][cFin];
                    nuevaF=fFin-1;
                    nuevaC=cFin;
                }
                if(fFin+1<m.length && m[fFin+1][cFin]>mayor){  
                    mayor=m[fFin+1][cFin];
                    nuevaF=fFin+1;
                    nuevaC=cFin;
                }
                if(cFin-1>0 && m[fFin][cFin-1]>mayor){  
                    mayor=m[fFin][cFin-1];
                    nuevaC=cFin-1;
                    nuevaF=fFin;
                }
                if(cFin+1<m.length && m[fFin][cFin+1]>mayor){  
                    mayor=m[fFin][cFin+1];
                    nuevaC=cFin+1;
                    nuevaF=fFin;
                }
                papel.setColor(Color.green);
                papel.fillRect(nuevaC*7,nuevaF*7,7,7);

                do{
                    if( nuevaF-1>=0 && m[nuevaF-1][nuevaC]==mayor-1){  
                        mayor=m[nuevaF-1][nuevaC];
                        nuevaF--;
                    }else
                    if(nuevaF+1<m.length && m[nuevaF+1][nuevaC]==mayor-1){  
                        mayor=m[nuevaF+1][nuevaC];
                        nuevaF++;
                    }else
                    if(nuevaC-1>=0 && m[nuevaF][nuevaC-1]==mayor-1){  
                        mayor=m[nuevaF][nuevaC-1];
                        nuevaC--;
                    }else
                    if(nuevaC+1<m.length && m[nuevaF][nuevaC+1]==mayor-1){  
                        mayor=m[nuevaF][nuevaC+1];
                        nuevaC++;
                    }
                    papel.setColor(Color.green);
                    papel.fillRect(nuevaC*7,nuevaF*7,7,7);
                }while(mayor>2);

            }
        }

        if(botonPila.isSelected()){
            Graphics papel = panel.getGraphics();
            Stack <nodo> pila = new Stack <nodo>();
            int entradaF=0, entradaC=0, salidaF=0, salidaC=0;
            if(e.getSource()==draw){
                papel.setColor(Color.white);
                papel.fillRect(0,0,600,600);
                for(int f=0; f<m.length; f++){
                    for(int c=0; c<m[f].length; c++){   
                        if(m[f][c]==0){
                            papel.setColor(Color.lightGray);
                            papel.fillRect(c*7,f*7,7,7);
                        }else if(m[f][c]==1){
                            papel.setColor(Color.lightGray);
                            papel.drawRect(c*7,f*7,7,7);
                        }
                    }
                }

                int entSal= random.nextInt(2)+1;
                if(entSal==1){
                    entradaF=0;
                    entradaC=0;
                    salidaF=0;
                    salidaC=0;
                    do{
                        entradaF =random.nextInt(n-2)+1;                   
                    }while(m[entradaF][1]!=1);
                    m[entradaF][0]=-2;
                    do{
                        salidaF = random.nextInt(n-2)+1;                 
                    }while(m[salidaF][n-2]!=1);
                    m[salidaF][n-1]=-2;
                } else if(entSal==2){
                    do{
                        entradaC = random.nextInt(n-2)+1;                 
                    }while(m[1][entradaC]!=1);
                    m[0][entradaC]=-2;
                    do{
                        salidaC = random.nextInt(n-2)+1;                  
                    }while(m[n-2][salidaC]!=1);
                    m[n-1][salidaC]=-2;
                }
                for(int f=0; f<m.length; f++){
                    for(int c=0; c<m[f].length; c++){                    
                        if(m[f][c]==-2){
                            papel.setColor(Color.red);
                            papel.fillRect(c*7,f*7,7,7);
                        }
                    }
                }  
            }

            if(e.getSource()==resolver){            
                pila.push(new nodo (entradaF, entradaC));
                nodo temp = pila.peek();
                int x = temp.getF();
                int y = temp.getC();
                while(!pila.empty()){ 
                    if( x+1<m.length&&m[x+1][y]==-2 || x-1>=0&&m[x-1][y]==-2 || y-1>=0&&m[x][y-1]==-2 || y+1<m.length&&m[x][y+1]==-2){
                        System.out.println("I find it");
                        break;
                    }
                    if( x-1>=0&& m[x-1][y]==1){
                        m[x][y]=5;
                        pila.push(new nodo(x,y));  
                        x--;
                    }else if( x+1<m.length&& m[x+1][y]==1){
                        m[x][y]=5;
                        pila.push(new nodo(x,y)); 
                        x++;
                    }else if( y-1>=0&& m[x][y-1]==1){
                        m[x][y]=5;
                        pila.push(new nodo(x,y)) ; 
                        y--;
                    }else if( y+1<m.length&& m[x][y+1]==1){
                        m[x][y]=5; 
                        pila.push(new nodo(x,y));
                        y++;
                    } else if(!pila.empty()){                   
                        m[x][y]=7;    
                        temp = pila.pop();
                        x = temp.getF();
                        y = temp.getC();
                    }
                    System.out.println("ya salí");
                    
                    for(int f=0; f<m.length; f++){
                        for(int c=0; c<m[f].length; c++){
                            if(m[f][c]==5){
                                papel.setColor(Color.cyan);
                                papel.fillRect(c*7,f*7,7,7);
                            }
                            if(m[f][c]==7){
                                papel.setColor(Color.blue);
                                papel.fillRect(c*7,f*7,7,7);
                            }
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
        }
    }
}