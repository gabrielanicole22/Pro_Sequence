package proyectosequence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

public class PruebaTablero extends JFrame implements ActionListener {

    //URL urlBackground = getClass().getResource("/proyectosequence.Imagenes/background.png");
    //URL urlFicha = getClass().getResource("/proyectosequence.Imagenes/overlay.png");
    //ImageIcon background = new ImageIcon(urlBackground);
    //ImageIcon ficha = new ImageIcon(urlFicha);
    private JButton[][] botones;
    private JLabel[][] labels;

    public PruebaTablero() {
        JPanel tableroPanel = new JPanel();

        //Para que se detenga el programa cuando se da a la x
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tableroPanel.setLayout(new GridLayout(10, 10));
        botones = new JButton[10][10];
        labels = new JLabel[10][10];

        //Poner los botones
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                JButton boton = new JButton();
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(70,70));
                label.putClientProperty("x", fila);
                label.putClientProperty("y", columna);
                
                
                boton.setPreferredSize(new Dimension(75, 75));
                boton.putClientProperty("x", fila);
                boton.putClientProperty("y", columna);
                boton.setText("(" + fila + ", " + columna + ")");
                boton.addActionListener(this);
                botones[fila][columna] = boton;
                tableroPanel.add(boton);

            }
        }
        //botones[0][0].setIcon(background);
        //labels[0][0].setIcon(ficha);
        add(tableroPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Que pasa cuando se presiona un boton
    public void actionPerformed(ActionEvent e) {
        JButton botonClickeado = (JButton) e.getSource();
        int fila = (int) botonClickeado.getClientProperty("x");
        int columna = (int) botonClickeado.getClientProperty("y");
        //Imprimir la posicion clickeada
        System.out.println("Boton clickeado: (" + fila + ", " + columna + ")");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PruebaTablero());
    }

}
