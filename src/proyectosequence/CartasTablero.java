/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Gabriela
 */
public class CartasTablero extends JPanel {
    MouseAdapter click;
    Color color = new Color(249,241,241);
    JButton clicked = null; // Botón previamente clickeado.
    Jugador jugador;
    boolean cambio = false; // Indica si se ha cambiado una carta de posición.
    
    SequenceGamee juego;

    public void posicionarCartas(Jugador jugador) {
        this.jugador = jugador;
        removeAll();
        for (Cartas c : jugador.manoJugador) {
            JButton boton = new JButton();
            boton.setIcon(c.imagenCartas);
            //boton.setBorder(BorderFactory.createLineBorder(Color.black));
            boton.setBackground(color);
            boton.addMouseListener(click); // Agrega el manejador de eventos de clic al botón.
            add(boton); // Agrega el botón al panel.
        }
    }

    public CartasTablero(SequenceGamee juego) {
        this.juego = juego;
        setLayout(new GridLayout(1, 7));
        setPreferredSize(new Dimension(500, 80));
        MouseAdapter click = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton lblClicked = (JButton) e.getSource();
                System.out.println(lblClicked);
                juego.tab.iluminarPosTablero(lblClicked);
            }
        };

        // Manejador de eventos de clic del ratón para gestionar la interacción con las cartas.
        this.click = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton botonClicked = (JButton) e.getSource();

                if (clicked == botonClicked) {
                    return; // Si el botón clickeado es el mismo que el previamente clickeado, no hacer nada.
                }

                if (clicked != null) {
                    // Obtener las posiciones de los botones clickeados anteriormente.
                    int posicionAnterior = -1;
                    int i = 0;
                    for (Component comp : getComponents()) {
                        JButton boton = (JButton) comp;
                        if (boton == clicked) {
                            posicionAnterior = i;
                            break;
                        }
                        i++;
                    }

                    int nuevaPosicion = -1;
                    i = 0;
                    for (Component comp : getComponents()) {
                        JButton boton = (JButton) comp;
                        if (boton == botonClicked) {
                            nuevaPosicion = i;
                            break;
                        }
                        i++;
                    }

                    // Ordenar las cartas  según las nuevas posiciones.
                    juego.tab.jugadorActualTurno.ordenarCartas(posicionAnterior, nuevaPosicion);
                    clicked = null;
                    botonClicked = null;
                    juego.tab.cartaObtenida = null;
                    removeAll();

                    // Vuelve a agregar los botones de las cartas después de la reordenación.
                    for (Cartas cartas : jugador.manoJugador) {
                        JButton boton = new JButton();
                        boton.setIcon(cartas.imagenCartas);
                        //boton.setBorder(BorderFactory.createLineBorder(Color.black));
                        boton.setBackground(color);
                        boton.addMouseListener(this);
                        add(boton); // Agrega el botón al panel.
                    }
                } else {
                    // Resalta el botón clickeado y marca como clickeado.
                    for (Component comp : getComponents()) {
                        JButton boton = (JButton) comp;
                        boton.setBackground(color);
                    }
                    botonClicked.setBackground(Color.black);
                    clicked = botonClicked;
                }
                juego.tab.iluminarPosTablero(botonClicked);
            }
        };
    }
}
