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
        cartas.add(new Carta("2 de picas"));
        cartas.add(new Carta("3 de picas"));
        cartas.add(new Carta("4 de picas"));
        cartas.add(new Carta("5 de picas"));
        cartas.add(new Carta("6 de picas"));
        cartas.add(new Carta("7 de picas"));
        cartas.add(new Carta("8 de picas"));
        cartas.add(new Carta("9 de picas"));
        cartas.add(new Carta("ESQUINA"));

        cartas.add(new Carta("6 de tréboles"));
        cartas.add(new Carta("5 de tréboles"));
        cartas.add(new Carta("4 de tréboles"));
        cartas.add(new Carta("3 de tréboles"));
        cartas.add(new Carta("2 de tréboles"));
        cartas.add(new Carta("corazon negro A"));
        cartas.add(new Carta("Rey de corazones"));
        cartas.add(new Carta("Reina de corazones"));
        cartas.add(new Carta("10 de corazones"));
        cartas.add(new Carta("10 de picas"));

        cartas.add(new Carta("7 de tréboles"));
        cartas.add(new Carta("corazon negro A"));
        cartas.add(new Carta("2 de diamantes"));
        cartas.add(new Carta("3 de diamantes"));
        cartas.add(new Carta("4 de diamantes"));
        cartas.add(new Carta("5 de diamantes"));
        cartas.add(new Carta("6 de diamantes"));
        cartas.add(new Carta("7 de diamantes"));
        cartas.add(new Carta("9 de corazones"));
        cartas.add(new Carta("Reina de picas"));

        cartas.add(new Carta("8 de tréboles"));
        cartas.add(new Carta("Rey de picas"));
        cartas.add(new Carta("6 de tréboles"));
        cartas.add(new Carta("5 de tréboles"));
        cartas.add(new Carta("4 de tréboles"));
        cartas.add(new Carta("3 de tréboles"));
        cartas.add(new Carta("2 de tréboles"));
        cartas.add(new Carta("8 de diamantes"));
        cartas.add(new Carta("8 de corazones"));
        cartas.add(new Carta("Rey de picas"));

        cartas.add(new Carta("9 de tréboles"));
        cartas.add(new Carta("Reina de picas"));
        cartas.add(new Carta("7 de tréboles"));
        cartas.add(new Carta("6 de corazones"));
        cartas.add(new Carta("5 de corazones"));
        cartas.add(new Carta("4 de corazones"));
        cartas.add(new Carta("As de corazones"));
        cartas.add(new Carta("9 de diamantes"));
        cartas.add(new Carta("7 de diamantes"));
        cartas.add(new Carta("corazon negro A"));

        cartas.add(new Carta("10 de tréboles"));
        cartas.add(new Carta("10 de picas"));
        cartas.add(new Carta("8 de tréboles"));
        cartas.add(new Carta("7 de corazones"));
        cartas.add(new Carta("2 de corazones"));
        cartas.add(new Carta("3 de corazones"));
        cartas.add(new Carta("Rey de corazones"));
        cartas.add(new Carta("10 de diamantes"));
        cartas.add(new Carta("6 de corazones"));
        cartas.add(new Carta("2 de diamantes"));

        cartas.add(new Carta("Reina de tréboles"));
        cartas.add(new Carta("9 de picas"));
        cartas.add(new Carta("9 de tréboles"));
        cartas.add(new Carta("8 de corazones"));
        cartas.add(new Carta("9 de corazones"));
        cartas.add(new Carta("10 de corazones"));
        cartas.add(new Carta("Reina de corazones"));
        cartas.add(new Carta("Reina de diamantes"));
        cartas.add(new Carta("5 de corazones"));
        cartas.add(new Carta("3 de diamantes"));

        cartas.add(new Carta("Rey de tréboles"));
        cartas.add(new Carta("8 de picas"));
        cartas.add(new Carta("10 de tréboles"));
        cartas.add(new Carta("Reina de tréboles"));
        cartas.add(new Carta("Rey de tréboles"));
        cartas.add(new Carta("As de tréboles"));
        cartas.add(new Carta("As de diamantes"));
        cartas.add(new Carta("Rey de diamantes"));
        cartas.add(new Carta("4 de corazones"));
        cartas.add(new Carta("4 de diamantes"));

        cartas.add(new Carta("As de tréboles"));
        cartas.add(new Carta("7 de picas"));
        cartas.add(new Carta("6 de picas"));
        cartas.add(new Carta("5 de picas"));
        cartas.add(new Carta("4 de picas"));
        cartas.add(new Carta("3 de picas"));
        cartas.add(new Carta("2 de picas"));
        cartas.add(new Carta("2 de corazones"));
        cartas.add(new Carta("3 de corazones"));
        cartas.add(new Carta("5 de diamantes"));

        cartas.add(new Carta("ESQUINA"));
        cartas.add(new Carta("As de diamantes"));
        cartas.add(new Carta("Rey de diamantes"));
        cartas.add(new Carta("Reina de diamantes"));
        cartas.add(new Carta("10 de diamantes"));
        cartas.add(new Carta("9 de diamantes"));
        cartas.add(new Carta("8 de diamantes"));
        cartas.add(new Carta("7 de diamantes"));
        cartas.add(new Carta("6 de diamantes"));
        cartas.add(new Carta("ESQUINA"));
    }

    public String getInformacionDeCarta(Carta carta) {
        return carta.getNombre();
    }

    public void asignarCartasACasillas(CasillaTablero[][] tablero) {
        tablero[0][0].setCarta(cartas.get(0));
        tablero[0][1].setCarta(cartas.get(1));
        tablero[0][2].setCarta(cartas.get(2));
        tablero[0][3].setCarta(cartas.get(3));
        tablero[0][4].setCarta(cartas.get(4));
        tablero[0][5].setCarta(cartas.get(5));
        tablero[0][6].setCarta(cartas.get(6));
        tablero[0][7].setCarta(cartas.get(7));
        tablero[0][8].setCarta(cartas.get(8));
        tablero[0][9].setCarta(cartas.get(9));
        tablero[1][0].setCarta(cartas.get(10));
        tablero[1][1].setCarta(cartas.get(11));
        tablero[1][2].setCarta(cartas.get(12));
        tablero[1][3].setCarta(cartas.get(13));
        tablero[1][4].setCarta(cartas.get(14));
        tablero[1][5].setCarta(cartas.get(15));
        tablero[1][6].setCarta(cartas.get(16));
        tablero[1][7].setCarta(cartas.get(17));
        tablero[1][8].setCarta(cartas.get(18));
        tablero[1][9].setCarta(cartas.get(19));
        tablero[1][0].setCarta(cartas.get(20));
        tablero[2][1].setCarta(cartas.get(21));
        tablero[2][2].setCarta(cartas.get(22));
        tablero[2][3].setCarta(cartas.get(23));
        tablero[2][4].setCarta(cartas.get(24));
        tablero[2][5].setCarta(cartas.get(25));
        tablero[2][6].setCarta(cartas.get(26));
        tablero[2][7].setCarta(cartas.get(27));
        tablero[2][8].setCarta(cartas.get(28));
        tablero[2][9].setCarta(cartas.get(29));
        tablero[3][0].setCarta(cartas.get(30));
        tablero[3][1].setCarta(cartas.get(31));
        tablero[3][2].setCarta(cartas.get(32));
        tablero[3][3].setCarta(cartas.get(33));
        tablero[3][4].setCarta(cartas.get(34));
        tablero[3][5].setCarta(cartas.get(35));
        tablero[3][6].setCarta(cartas.get(36));
        tablero[3][7].setCarta(cartas.get(37));
        tablero[3][8].setCarta(cartas.get(38));
        tablero[3][9].setCarta(cartas.get(39));
        tablero[4][0].setCarta(cartas.get(40));
        tablero[4][1].setCarta(cartas.get(41));
        tablero[4][2].setCarta(cartas.get(42));
        tablero[4][3].setCarta(cartas.get(43));
        tablero[4][4].setCarta(cartas.get(44));
        tablero[4][5].setCarta(cartas.get(45));
        tablero[4][6].setCarta(cartas.get(46));
        tablero[4][7].setCarta(cartas.get(47));
        tablero[4][8].setCarta(cartas.get(48));
        tablero[4][9].setCarta(cartas.get(49));
        tablero[5][0].setCarta(cartas.get(50));
        tablero[5][1].setCarta(cartas.get(51));
        tablero[5][2].setCarta(cartas.get(52));
        tablero[5][3].setCarta(cartas.get(53));
        tablero[5][4].setCarta(cartas.get(54));
        tablero[5][5].setCarta(cartas.get(55));
        tablero[5][6].setCarta(cartas.get(56));
        tablero[5][7].setCarta(cartas.get(57));
        tablero[5][8].setCarta(cartas.get(58));
        tablero[5][9].setCarta(cartas.get(59));
        tablero[6][0].setCarta(cartas.get(60));
        tablero[6][1].setCarta(cartas.get(61));
        tablero[6][2].setCarta(cartas.get(62));
        tablero[6][3].setCarta(cartas.get(63));
        tablero[6][4].setCarta(cartas.get(64));
        tablero[6][5].setCarta(cartas.get(65));
        tablero[6][6].setCarta(cartas.get(66));
        tablero[6][7].setCarta(cartas.get(67));
        tablero[6][8].setCarta(cartas.get(68));
        tablero[6][9].setCarta(cartas.get(69));
        tablero[7][0].setCarta(cartas.get(70));
        tablero[7][1].setCarta(cartas.get(71));
        tablero[7][2].setCarta(cartas.get(72));
        tablero[7][3].setCarta(cartas.get(73));
        tablero[7][4].setCarta(cartas.get(74));
        tablero[7][5].setCarta(cartas.get(75));
        tablero[7][6].setCarta(cartas.get(76));
        tablero[7][7].setCarta(cartas.get(77));
        tablero[7][8].setCarta(cartas.get(78));
        tablero[7][9].setCarta(cartas.get(79));
        tablero[8][0].setCarta(cartas.get(80));
        tablero[8][1].setCarta(cartas.get(81));
        tablero[8][2].setCarta(cartas.get(82));
        tablero[8][3].setCarta(cartas.get(83));
        tablero[8][4].setCarta(cartas.get(84));
        tablero[8][5].setCarta(cartas.get(85));
        tablero[8][6].setCarta(cartas.get(86));
        tablero[8][7].setCarta(cartas.get(87));
        tablero[8][8].setCarta(cartas.get(88));
        tablero[8][9].setCarta(cartas.get(89));
        tablero[9][0].setCarta(cartas.get(90));
        tablero[9][1].setCarta(cartas.get(91));
        tablero[9][2].setCarta(cartas.get(92));
        tablero[9][3].setCarta(cartas.get(93));
        tablero[9][4].setCarta(cartas.get(94));
        tablero[9][5].setCarta(cartas.get(95));
        tablero[9][6].setCarta(cartas.get(96));
        tablero[9][7].setCarta(cartas.get(97));
        tablero[9][8].setCarta(cartas.get(98));
        tablero[9][9].setCarta(cartas.get(99));
    }
}
