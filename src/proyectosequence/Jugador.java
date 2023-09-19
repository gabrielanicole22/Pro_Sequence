/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriela Mejia
 */
public final class Jugador extends Usuario implements Serializable {

    int team = -1;

    ArrayList<Cartas> manoJugador;
    ArrayList<Cartas> cartasJugadas;

        @Override
    public void addPuntos(int cantidad) {
        int puntosActuales = getPuntos();
        super.puntos = puntosActuales + (cantidad);
    }

    public void ordenarCartas(int posiAnterior, int posiNueva) {
        if (posiAnterior >= 0 && posiAnterior < manoJugador.size() && posiNueva >= 0 && posiNueva < manoJugador.size()) {
            Cartas anterior = manoJugador.get(posiAnterior);
            Cartas nueva = manoJugador.get(posiNueva);
            manoJugador.set(posiAnterior, nueva);
            manoJugador.set(posiNueva, anterior);
        } else {
            System.out.println("error");
        }
    }

    public Jugador(String usuario, String contra, String nombreCompleto, long fechaCreacion, int puntos, String rutaToken, int jugadoresseleccionados, String logs, boolean mismoColorxTeam) {
        super(usuario, contra, nombreCompleto, fechaCreacion, puntos, rutaToken, jugadoresseleccionados, logs,mismoColorxTeam);
        manoJugador = new ArrayList<>();
        cartasJugadas = new ArrayList<>();
    }

    ImageIcon getFichaIcon() {
        throw new UnsupportedOperationException("Error");
    }
}
