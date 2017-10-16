import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class gato extends JFrame implements MouseListener, ActionListener
{
    private JLabel label;
    private JPanel panel;
    private JButton boton;
    
    int value = 0;
    
    
    public static void main(String[] args) { 
         gato a = new gato();
         a.setSize(600, 600); 
         a.createGUI(); 
         a.setVisible(true);
    }
    private void createGUI() {
         setDefaultCloseOperation(EXIT_ON_CLOSE); 
         Container window = getContentPane(); 
         window.setLayout(new FlowLayout());
         
         label = new JLabel("");
         window.add(label);
         
         panel = new JPanel();
         panel.setPreferredSize(new Dimension(300, 300));
         panel.setBackground(Color.white);
         window.add(panel);
         
         boton = new JButton("Click");
         window.add(boton);
         boton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.black);
        paper.drawLine(0,100,300,100);
        paper.drawLine(0,200,300,200);
        paper.drawLine(200,0,200,300);
        paper.drawLine(100,0,100,300);
        
        //equis
        /*paper.setColor(Color.red);
         int [] ptsx = {0,10,50,90,100,100,60,100,100,90,50,10,0,0,40,0};
         int [] ptsy = {0,0,40,0,0,10,50,90,100,100,60,100,100,90,50,10};
         paper.fillPolygon(ptsx, ptsy, 16);*/
         
        //circulo
        /*paper.setColor(Color.blue);
        paper.fillOval(0,0,100,100);
        paper.setColor(Color.white);
        paper.fillOval(10,10,80,80);*/
    }
    public void mouseClicked(MouseEvent e) { 
        /*Caracteres se escribe con comilla ‘_’ 
         * Char [] [] arr = new int [3] [3];
         * Leer por filas  
         * 
         * Donde tu te muevas agarra la cordenada dividela entre 100 ……
         * Mouse click
         * Si me desplazo y esta libre dibuja 
         * 
         * Para ganar se tiene 8 maneras entonces se debe poner 8 if
         * If arr[0][0] == jug && arr[0][1]==jug&&…..*/
          int corX = e.getX(); 
          int corY = e.getY(); 
        //  m.setText("Cordenadas en x = " + Integer.toString(corX)); 
    }
    public void mouseExited(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }  
    public void mouseReleased(MouseEvent e) { }
    void draw(){
       // polygon();
    }
    public void mousePressed(MouseEvent e) { 
     
    }
}
