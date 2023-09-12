/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.File;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriela Mejia
 */
public final class Jugador extends Usuario implements Serializable {

    int team = -1;
    private ImageIcon fichaIcon;

    public Jugador(String usuario, String contra, String nombre, long fechaCreacion, int puntos, String fichaDirec, int cantPlayers) {
        super(usuario, contra, nombre, fechaCreacion, puntos, fichaDirec, cantPlayers);
        try {
            this.fichaIcon = new ImageIcon(ImageIO.read(new File("src/fichas/" + fichaDirec)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPuntos(int cantidad) {
        int puntosActuales = getPuntos();
        super.puntos = puntosActuales + (cantidad - (puntosActuales % cantidad));
    }

    public ImageIcon getFichaIcon() {
        return fichaIcon;
    }

    public void setFichaIcon(ImageIcon fichaIcon) {
        this.fichaIcon = fichaIcon;
    }
}
