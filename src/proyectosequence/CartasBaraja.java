/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

/**
 *
 * @author danie
 */
public class CartasBaraja {
    private String palo;
    private String valor;

    public CartasBaraja(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
