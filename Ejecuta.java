
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;

public class Ejecuta extends JFrame implements ActionListener
{
    private JPanel panel;
    private JButton boton;
    public static void main (String[]args){
        Ejecuta frame = new Ejecuta();
        frame.setSize(500, 500);
        frame.createGUI();
        frame.setVisible(true);
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 300));
        panel.setBackground(Color.white);
        window.add(panel);
        boton = new JButton("Press me");
        window.add(boton);
        boton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
     
     
    }
}

