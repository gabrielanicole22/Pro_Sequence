/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriela
 */
public class CartasJack {
        public boolean jackUnOjo() {
        try {
            // Carga las imágenes de los Jacks de Corazón y Pica.
            ImageIcon JCorazon = new ImageIcon(ImageIO.read(new File("src/cartas/corazon/j_corazon.png")));
            ImageIcon JPica = new ImageIcon(ImageIO.read(new File("src/cartas/pica/j_pica.png")));

            // Crea cartas con las imágenes cargadas.
            Cartas jCorazon = new Cartas(JCorazon);
            Cartas jPica = new Cartas(JPica);

            // Comprueba si la carta actual es igual a Jack de Corazón o Jack de Pica.
            return this.equals(jCorazon) || this.equals(jPica);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean jackDosOjos() {
        try {
            // Carga las imágenes de los Jacks de Diamante y Trébol.
            ImageIcon JDiamante = new ImageIcon(ImageIO.read(new File("src/cartas/diamante/j_diamante.png")));
            ImageIcon JTrebol = new ImageIcon(ImageIO.read(new File("src/cartas/trebol/j_trebol.png")));

            // Crea cartas con las imágenes cargadas.
            Cartas jDiamante = new Cartas(JDiamante);
            Cartas jTrebol = new Cartas(JTrebol);

            // Comprueba si la carta actual es igual a Jack de Diamante o Jack de Trébol.
            return this.equals(jDiamante) || this.equals(jTrebol);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
