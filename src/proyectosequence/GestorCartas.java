/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public class GestorCartas {

    private ArrayList<Carta> cartas;

    public GestorCartas() {
        cartas = new ArrayList<>();
        cartas.add(new Carta("ESQUINA"));
        cartas.add(new Carta("2_picas"));
        cartas.add(new Carta("3_picas"));
        cartas.add(new Carta("4_picas"));
        cartas.add(new Carta("5_picas"));
        cartas.add(new Carta("6_picas"));
        cartas.add(new Carta("7_picas"));
        cartas.add(new Carta("8_picas"));
        cartas.add(new Carta("9_picas"));
        cartas.add(new Carta("ESQUINA"));

        cartas.add(new Carta("6_trebol"));
        cartas.add(new Carta("5_trebol"));
        cartas.add(new Carta("4_trebol"));
        cartas.add(new Carta("3_trebol"));
        cartas.add(new Carta("2_trebol"));
        cartas.add(new Carta("As_corazones"));
        cartas.add(new Carta("K_corazones"));
        cartas.add(new Carta("Q_corazones"));
        cartas.add(new Carta("10_corazones"));
        cartas.add(new Carta("10_picas"));

        cartas.add(new Carta("7_trebol"));
        cartas.add(new Carta("As_picas"));
        cartas.add(new Carta("2_diamantes"));
        cartas.add(new Carta("3_diamantes"));
        cartas.add(new Carta("4_diamantes"));
        cartas.add(new Carta("5_diamantes"));
        cartas.add(new Carta("6_diamantes"));
        cartas.add(new Carta("7_diamantes"));
        cartas.add(new Carta("9_corazones"));
        cartas.add(new Carta("Q_picas"));

        cartas.add(new Carta("8_trebol"));
        cartas.add(new Carta("K_picas"));
        cartas.add(new Carta("6_trebol"));
        cartas.add(new Carta("5_trebol"));
        cartas.add(new Carta("4_trebol"));
        cartas.add(new Carta("3_trebol"));
        cartas.add(new Carta("2_trebol"));
        cartas.add(new Carta("8_diamantes"));
        cartas.add(new Carta("8_corazones"));
        cartas.add(new Carta("K_picas"));

        cartas.add(new Carta("9_trebol"));
        cartas.add(new Carta("Q_picas"));
        cartas.add(new Carta("7_trebol"));
        cartas.add(new Carta("6_corazones"));
        cartas.add(new Carta("5_corazones"));
        cartas.add(new Carta("4_corazones"));
        cartas.add(new Carta("As_corazones"));
        cartas.add(new Carta("9_diamantes"));
        cartas.add(new Carta("7_diamantes"));
        cartas.add(new Carta("As_picas"));

        cartas.add(new Carta("10_trebol"));
        cartas.add(new Carta("10_picas"));
        cartas.add(new Carta("8_trebol"));
        cartas.add(new Carta("7_corazones"));
        cartas.add(new Carta("2_corazones"));
        cartas.add(new Carta("3_corazones"));
        cartas.add(new Carta("K_corazones"));
        cartas.add(new Carta("10_diamantes"));
        cartas.add(new Carta("6_corazones"));
        cartas.add(new Carta("2_diamantes"));

        cartas.add(new Carta("Q_trebol"));
        cartas.add(new Carta("9_picas"));
        cartas.add(new Carta("9_trebol"));
        cartas.add(new Carta("8_corazones"));
        cartas.add(new Carta("9_corazones"));
        cartas.add(new Carta("10_corazones"));
        cartas.add(new Carta("Q_corazones"));
        cartas.add(new Carta("Q_diamantes"));
        cartas.add(new Carta("5_corazones"));
        cartas.add(new Carta("3_diamantes"));

        cartas.add(new Carta("K_trebol"));
        cartas.add(new Carta("8_picas"));
        cartas.add(new Carta("10_trebol"));
        cartas.add(new Carta("Q_trebol"));
        cartas.add(new Carta("K_trebol"));
        cartas.add(new Carta("As_trebol"));
        cartas.add(new Carta("As_diamantes"));
        cartas.add(new Carta("K_diamantes"));
        cartas.add(new Carta("4_corazones"));
        cartas.add(new Carta("4_diamantes"));

        cartas.add(new Carta("As_trebol"));
        cartas.add(new Carta("7_picas"));
        cartas.add(new Carta("6_picas"));
        cartas.add(new Carta("5_picas"));
        cartas.add(new Carta("4_picas"));
        cartas.add(new Carta("3_picas"));
        cartas.add(new Carta("2_picas"));
        cartas.add(new Carta("2_corazones"));
        cartas.add(new Carta("3_corazones"));
        cartas.add(new Carta("5_diamantes"));

        cartas.add(new Carta("ESQUINA"));
        cartas.add(new Carta("As_diamantes"));
        cartas.add(new Carta("K_diamantes"));
        cartas.add(new Carta("Q_diamantes"));
        cartas.add(new Carta("10_diamantes"));
        cartas.add(new Carta("9_diamantes"));
        cartas.add(new Carta("8_diamantes"));
        cartas.add(new Carta("7_diamantes"));
        cartas.add(new Carta("6_diamantes"));
        cartas.add(new Carta("ESQUINA"));
    }

    public String getInformacionDeCarta(Carta carta) {
        return carta.getNombre();
    }

    public void asignarCartasACasillas(CasillaTablero[][] tablero) {
        int cartaIndex = 0;
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                tablero[fila][columna].setCarta(cartas.get(cartaIndex++));
            }
        }
    }
}