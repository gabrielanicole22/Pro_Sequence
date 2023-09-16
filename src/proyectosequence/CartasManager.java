/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriela Mejía
 */
public class CartasManager {

    public static ArrayList<Cartas> cargadoCartas() {
        try {
            // Lista que almacenará las cartas cargadas.
            ArrayList<Cartas> cartas = new ArrayList<>();
            
            File cardFolder = new File("src/cartas");

            // Itera a través de las subcarpetas dentro de la carpeta de cartas.
            for (File child : cardFolder.listFiles()) {
                if (!child.isDirectory()) {
                    continue;
                }
                // Itera a través de los archivos de imagen dentro de cada subcarpeta.
                for (File cardImg : child.listFiles()) {
                    ImageIcon i = new ImageIcon(ImageIO.read(cardImg));
                    Cartas c = new Cartas(i);
                    cartas.add(c); // Agrega la carta cargada a la lista de cartas.
                }
            }

            // reinicia el mazoo
            ArrayList<Cartas> cartas2 = new ArrayList<>();
            for (Cartas c : cartas) {
                cartas2.add(c);
            }
            for (Cartas c : cartas2) {
                cartas.add(c);
            }
            
            // Retorna la lista completa de cartas cargadas.
            return cartas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // para comparar las imágenes y determinar si son iguales.
    public static boolean comparador(Image img1, Image img2) {
        if (img1.getWidth(null) != img2.getWidth(null) || img1.getHeight(null) != img2.getHeight(null)) {
            return false;
        }
        BufferedImage Image1 = image(img1);
        BufferedImage Image2 = image(img2);
        // Compara ambas imágenes
        for (int x = 0; x < Image1.getWidth(); x++) {
            for (int y = 0; y < Image1.getHeight(); y++) {
                if (Image1.getRGB(x, y) != Image2.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static BufferedImage image(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        BufferedImage ig = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        ig.getGraphics().drawImage(image, 0, 0, null);
        return ig;
    }
}