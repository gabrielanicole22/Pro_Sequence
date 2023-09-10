/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.Serializable;

/**
 *
 * @author Gabriela Mejia
 */
public final class Jugador extends Usuario implements Serializable {
    int team = -1;
    public Jugador(String usuario, String contra, String nombre, long fechaCreacion, int puntos, String fichaDirec, int cantPlayers) {
        super(usuario, contra, nombre, fechaCreacion, puntos, fichaDirec, cantPlayers);
    }
    @Override
    public void addPuntos(int cantidad) {
        int puntosActuales = getPuntos();
        super.puntos = puntosActuales + (cantidad - (puntosActuales % cantidad));
    }
}