package proyectosequence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PruebaTablero extends JPanel {

    private boolean hayCasillaSeleccionada = false;
    private CasillaTablero casillaSeleccionada;
    private CasillaTablero[][] casillas;
    Juego gameWindow;
    MenuInicio mainWindow;
    private Image imagenFondo;

    //para ponerle fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }

    //URL urlBackground = getClass().getResource("/proyectosequence.Imagenes/background.png");
    //URL urlFicha = getClass().getResource("/proyectosequence.Imagenes/overlay.png");
    //ImageIcon background = new ImageIcon(urlBackground);
    //ImageIcon ficha = new ImageIcon(urlFicha);
    private JButton[][] botones;
    private JLabel[][] labels;

    public PruebaTablero(Juego gameWindow, MenuInicio mainWindow) {
        this.gameWindow = gameWindow;
        this.mainWindow = mainWindow;

        // Cargar la imagen de fondo
        ImageIcon imagenIcono = new ImageIcon("src/proyectosequence/Imagenes/fondo.jpg");
        imagenFondo = imagenIcono.getImage();

        // Crear e inicializar la matriz de casillas
        casillas = new CasillaTablero[10][10];
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                casillas[row][column] = new CasillaTablero(row, column); // Initialize with appropriate values
                add(casillas[row][column].label);
            }
        }
        setLayout(new GridLayout(10, 10));

        GestorCartas gestorCartas = new GestorCartas();
        gestorCartas.asignarCartasACasillas(casillas);

        // Manejar eventos de clic en las etiquetas
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();

                // Obtener la posición de la etiqueta en la cuadrícula
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (casillas[i][j].label == label) {
                            if (!hayCasillaSeleccionada) {
                                casillaSeleccionada = casillas[i][j];
                                casillaSeleccionada.mostrarInfo(gestorCartas);
                            }
                        }
                    }
                }
            }
        };
        // Agregar el manejador de eventos a las etiquetas
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                casillas[row][column].label.addMouseListener(mouseAdapter);
            }
        }
        setVisible(true);
        repaint();
    }
}