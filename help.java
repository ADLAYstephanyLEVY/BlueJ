import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class help extends JFrame implements ActionListener
{
    private JButton boton;
    private JTextField text;
     ArrayList<String> palin = new ArrayList<String> ();
   
    public static void main (String [] args) {
        help frame = new help();
        frame.setSize(500, 500);
        frame.createGUI();
        frame.setVisible(true);
    }
    private void createGUI() {
        Container window = getContainerPanel();
        window.setLayout(new FlowLayout());
         text = new JTextField (15);
         window.add(text);
         
         boton = new JButton ("Leer");
         window.add(boton);
         boton.addActionListener(this);
        
    }
    public void actionPerformed (ActionEvent event){
        palin.add("oso");
        palin.add("apa");
        palin.add("rotor");
        if (entrada.getText().equals(lista)){
            JOptionPane.showMessageDialog(null, "Palindromo dentro de la lista el programa");
        }
    }
}

