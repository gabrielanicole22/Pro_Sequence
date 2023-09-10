/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

/**
 *
 * @author danie
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {

    public List<CartasBaraja> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        String[] palos = {"corazones", "diamantes", "picas", "trebol"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "As"};

        // Generar todas las cartas en la baraja
        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new CartasBaraja(palo, valor));
            }
        }
        //Duplicarlas para que sean 104 cartas
        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new CartasBaraja(palo, valor));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public List<CartasBaraja> repartir(int cantidad) {
        List<CartasBaraja> mano = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            if (!cartas.isEmpty()) {
                mano.add(cartas.remove(i));
            }
        }
        return mano;
    }
}
