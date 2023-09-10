/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Gabriela Mejía
 */
public class ColorItem extends DefaultListCellRenderer {

    private Color getColorFromRGB(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        String itemText = (String) value;
        switch (itemText.toLowerCase()) {
            case "amarillo":
                component.setBackground(getColorFromRGB(244, 245, 38));
                break;
            case "anaranjado":
                component.setBackground(getColorFromRGB(240, 162, 38));
                break;
            case "azul":
                component.setBackground(getColorFromRGB(94, 121, 254));
                break;
            case "cafe":
                component.setBackground(getColorFromRGB(142, 98, 32));
                break;    
            case "dark_pink":
                component.setBackground(getColorFromRGB(158, 19, 57));
                break;
            case "light_green":
                component.setBackground(getColorFromRGB(199, 253, 200));
                break;
            case "light_pink":
                component.setBackground(getColorFromRGB(251, 157, 222));
                break;
            case "light_yellow":
                component.setBackground(getColorFromRGB(235, 250, 195));
                break;    
            case "morado":
                component.setBackground(getColorFromRGB(200, 76, 252));
                break;
            case "morado_oscuro":
                component.setBackground(getColorFromRGB(83, 36, 72));
                break;
            case "morado_SpeakNowTV":
                component.setBackground(getColorFromRGB(147, 54, 129));
                break;
            case "negro_reputation":
                component.setBackground(getColorFromRGB(128, 128, 128));
                break;
            case "redTV":
                component.setBackground(getColorFromRGB(223, 32, 17));
                break;
            case "rosado":
                component.setBackground(getColorFromRGB(249, 38, 111));
                break;
            case "verde":
                component.setBackground(getColorFromRGB(37, 147, 38));
                break;
            case "verde_":
                component.setBackground(getColorFromRGB(33, 133, 108));
                break;                    
            default:
                component.setBackground(Color.WHITE);
                break;
        }
        return component;
    }
}