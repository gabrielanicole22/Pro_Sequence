/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela
 */
public class Equipos {

    ArrayList<Jugador> jugadores;
    int cant;

    public Equipos(int tamaño) {
        this.cant = tamaño;
        this.jugadores = new ArrayList<>();
    }

    public boolean estaCompleto() {
        return jugadores.size() == cant;
    }

    public int tamaño() {
        return jugadores.size();
    }

    public void agregar(Jugador p) {
        if (estaCompleto()) {
            return;
        }
        jugadores.add(p);
    }

}
