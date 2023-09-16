/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import javax.swing.ImageIcon;

/**
 *
 * @author Gabriela Mejía
 */
public class Tokens {
    boolean isBloqueada;
    int equipo;
    Jugador owner;
    ImageIcon img;

    public Tokens(boolean isBloqueada, int equipo, Jugador owner, ImageIcon img) {
        this.isBloqueada = isBloqueada;
        this.equipo = equipo;
        this.owner = owner;
        this.img = img;
    }
}