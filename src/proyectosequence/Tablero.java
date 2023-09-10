package proyectosequence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Tablero extends JPanel {

    private boolean hayCasillaSeleccionada = false;
    private CasillaTablero casillaSeleccionada;
    public CasillaTablero[][] casillas;
    Juego2Jugadores gameWindow;
    MenuInicio mainWindow;
    private Image imagenFondo;
    ArrayList<Equipos> teams;
    int[] TurnosT;
    int EquipoActualTurn;
    public Carta selectedCard;
    Jugador JugadorActualTurn = null;
    int cantCartas;
    private int turnoAnterior;

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

    //temporizador
    private Timer turnTimer;
    public int turnTimeInSeconds = 120;
    private JLabel timerLabel;

    private ImageIcon[] imagenes; // Lista de fichas
    //private int[] valoresImagenes;
    private int indiceImagenActual = 0;
    private int currentPlayerIndex = 0;

    //para escalar los tokens
    private int imagenWidth = 50;
    private int imagenHeight = 50;
    private boolean primeraVez = true;

    public Tablero(Juego2Jugadores gameWindow, ArrayList<Equipos> teams, int numCartas) {
        this.gameWindow = gameWindow;
        this.teams = teams;
        cantCartas = numCartas;

        TurnosT = new int[teams.size()];

        for (int i = 0; i < TurnosT.length; i++) {
            TurnosT[i] = 0;
        }

        // Carga la imagen de fondo
        ImageIcon imagenIcono = new ImageIcon("src/proyectosequence/Imagenes/fondo.jpg");
        imagenFondo = imagenIcono.getImage();

        //fichas
        imagenes = new ImageIcon[4];
        imagenes[0] = new ImageIcon("src/fichas/redTV.png");
        imagenes[1] = new ImageIcon("src/fichas/verde.png");
        imagenes[2] = new ImageIcon("src/fichas/azul.png");
        imagenes[3] = new ImageIcon("src/fichas/amarillo.png");

        //timer
        timerLabel = gameWindow.getTimerLabel();
        updateTimerLabel(turnTimeInSeconds);

        turnTimer = new Timer(1000, new ActionListener() {
            int timeRemaining = turnTimeInSeconds;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                    updateTimerLabel(timeRemaining);
                } else {
                    turnTimer.stop();
                    JOptionPane.showMessageDialog(null, "Perdiste tu turno.");
                    changeToNextPlayer(); // Cambia al siguiente jugador
                    startTurnTimer(); // Inicia el temporizador para el siguiente jugador
                }
            }
        });

        // Crea e inicializa la matriz de casillas
        casillas = new CasillaTablero[10][10];
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                casillas[row][column] = new CasillaTablero(row, column);
                add(casillas[row][column].label);

            }
        }
        setLayout(new GridLayout(10, 10));

        GestorCartas gestorCartas = new GestorCartas();
        gestorCartas.asignarCartasACasillas(casillas);

        // Maneja eventos de clic en las etiquetas
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();

                // Obtiene la posición de la etiqueta en la cuadrícula
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (casillas[i][j].label == label) {
                            System.out.println("Casilla clickeada: [" + i + "][" + j + "]");

                            if (!hayCasillaSeleccionada) {
                                if (turnTimer.isRunning()) {
                                    turnTimer.stop();
                                }
                                resetTurnTimer();
                                startTurnTimer();
                                casillaSeleccionada = casillas[i][j];
                                casillaSeleccionada.mostrarInfo(gestorCartas);

                                // Valida que no haya una ficha en la casilla
                                if (casillaSeleccionada.label.getIcon() == null) {
                                    if (casillaSeleccionada.getNombreCarta(gestorCartas).equals(gameWindow.cartaSeleccionadaTexto)) {
                                        // Pone imagen roja para el jugador 1
                                        if (gameWindow.turno == 1) {
                                            Image imagenOriginal = imagenes[0].getImage();
                                            Image imagenEscalada = imagenOriginal.getScaledInstance(imagenWidth, imagenHeight, Image.SCALE_SMOOTH);
                                            ImageIcon imagenEscaladaIcon = new ImageIcon(imagenEscalada);
                                            // Pone la ficha en la casilla
                                            casillaSeleccionada.label.setIcon(imagenEscaladaIcon);

                                            // Pone imagen verde para el jugador 2
                                        } else if (gameWindow.turno == 2) {
                                            Image imagenOriginal = imagenes[1].getImage();
                                            Image imagenEscalada = imagenOriginal.getScaledInstance(imagenWidth, imagenHeight, Image.SCALE_SMOOTH);
                                            ImageIcon imagenEscaladaIcon = new ImageIcon(imagenEscalada);

                                            // Pone la ficha en la casilla
                                            casillaSeleccionada.label.setIcon(imagenEscaladaIcon);
                                        }

                                        // Aquí verifica si hay una secuencia
                                        if (casillaSeleccionada.label.getIcon() != null) {
                                            // Verificar si hay una secuencia
                                            if (verificarSecuencia(casillaSeleccionada, gameWindow.turno)) {
                                                JOptionPane.showMessageDialog(null, "¡Felicidades Jugador " + gameWindow.turno + ", has formado una secuencia!");
                                            }
                                        }
                                        gameWindow.posx = i;
                                        gameWindow.posy = j;
                                        // Cambia de turno y de mano
                                        gameWindow.cambioDeTurno();
                                        cambioTurno();
                                        actualizarLabelUltimaJugada();
                                    } else {
                                        if (gameWindow.cartaSeleccionadaTexto != (null)) {
                                            JOptionPane.showMessageDialog(null, "Pon la ficha en la carta que has seleccionado.");
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya hay una ficha en la casilla.");
                                }
                            }
                        }
                    }
                }
            }
        };

        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                casillas[row][column].label.addMouseListener(mouseAdapter);
            }
        }
        setVisible(true);
        repaint();
    }

    public void actualizarLabelUltimaJugada() {
        String nombreTurnoAnterior = "Nadie ha jugado";
        int turnoAnteriorIndex = (EquipoActualTurn == 0) ? teams.size() - 1 : EquipoActualTurn - 1;
        if (turnoAnteriorIndex >= 0) {
            nombreTurnoAnterior = teams.get(turnoAnteriorIndex).jugadores.get(TurnosT[turnoAnteriorIndex]).usuario;
        }

        if (primeraVez) {
            gameWindow.jugadorQuePusoLaCarta.setText("Nadie ha jugado");
            primeraVez = false;
        } else {
            gameWindow.jugadorQuePusoLaCarta.setText(nombreTurnoAnterior);
        }
    }

    public void cambioTurno() {
        if (JugadorActualTurn == null) {
            JugadorActualTurn = teams.get(0).jugadores.get(0);
            EquipoActualTurn = 0;
            gameWindow.lblturno.setText("Turno de: " + JugadorActualTurn.usuario);
            return;
        }

        int ts = teams.get(0).jugadores.size();

        if (TurnosT[EquipoActualTurn] == (ts - 1)) {
            TurnosT[EquipoActualTurn] = 0;
        } else {
            TurnosT[EquipoActualTurn] += 1;
        }

        if (EquipoActualTurn == (teams.size() - 1)) {
            EquipoActualTurn = 0;
        } else {
            turnoAnterior = EquipoActualTurn;
            EquipoActualTurn++;
        }
        JugadorActualTurn = teams.get(EquipoActualTurn).jugadores.get(TurnosT[EquipoActualTurn]);
        gameWindow.lblturno.setText("Turno de: " + JugadorActualTurn.usuario);
    }

    //hay código que se puede simplicar pero nomas es de prueba
    private boolean verificarSecuencia(CasillaTablero casilla, int jugador) {
        int fila = casilla.getRow();
        int columna = casilla.getColumn();
        int contador = 1; // Inicia con 1 porque ya tenemos una ficha en la casilla actual

        // Verificar secuencia horizontal hacia la derecha
        for (int i = columna + 1; i < 10; i++) {
            if (casillas[fila][i].label.getIcon() != null && casillas[fila][i].label.getIcon().equals(imagenes[jugador - 1])) {
                contador++;
            } else {
                break; // si no hay una ficha del mismo jugador
            }
        }
        // Verificar secuencia horizontal hacia la izquierda
        for (int i = columna - 1; i >= 0; i--) {
            if (casillas[fila][i].label.getIcon() != null && casillas[fila][i].label.getIcon().equals(imagenes[jugador - 1])) {
                contador++;
            } else {
                break;
            }
        }
        // Verificar secuencia vertical hacia abajo
        for (int i = fila + 1; i < 10; i++) {
            if (casillas[i][columna].label.getIcon() != null && casillas[i][columna].label.getIcon().equals(imagenes[jugador - 1])) {
                contador++;
            } else {
                break;
            }
        }
        // Verificar secuencia vertical hacia arriba
        for (int i = fila - 1; i >= 0; i--) {
            if (casillas[i][columna].label.getIcon() != null && casillas[i][columna].label.getIcon().equals(imagenes[jugador - 1])) {
                contador++;
            } else {
                break;
            }
        }
        // Verificar secuencia diagonal hacia la derecha y abajo
        for (int i = 1; i < 5; i++) {
            if (fila + i < 10 && columna + i < 10
                    && casillas[fila + i][columna + i].label.getIcon() != null
                    && casillas[fila + i][columna + i].label.getIcon().equals(imagenes[jugador - 1])) {
                contador++;
            } else {
                break;
            }
        }
        // Verificar secuencia diagonal hacia la izquierda y arriba
        for (int i = 1; i < 5; i++) {
            if (fila - i >= 0 && columna - i >= 0
                    && casillas[fila - i][columna - i].label.getIcon() != null
                    && casillas[fila - i][columna - i].label.getIcon().equals(imagenes[jugador - 1])) {
                contador++;
            } else {
                break;
            }
        }
        // Verificar secuencia diagonal hacia la derecha y arriba
        for (int i = 1; i < 5; i++) {
            if (fila - i >= 0 && columna + i < 10
                    && casillas[fila - i][columna + i].label.getIcon() != null
                    && casillas[fila - i][columna + i].label.getIcon().equals(imagenes[jugador - 1])) {
                contador++;
            } else {
                break;
            }
        }
        // Verificar secuencia diagonal hacia la izquierda y abajo
        for (int i = 1; i < 5; i++) {
            if (fila + i < 10 && columna - i >= 0
                    && casillas[fila + i][columna - i].label.getIcon() != null
                    && casillas[fila + i][columna - i].label.getIcon().equals(imagenes[jugador - 1])) {
                contador++;
            } else {
                break;
            }
        }
        // Si hay una secuencia de 5 fichas del mismo jugador, retorna true
        return contador == 5;
    }

    public int getTurnTimeInSeconds() {
        return turnTimeInSeconds;
    }

    public void startTurnTimer() {
        turnTimer.setInitialDelay(1000);
        turnTimer.start();
    }

    //pendiente -falta mejorar
    public void resetTurnTimer() {
        turnTimer = new Timer(1000, new ActionListener() {
            int timeRemaining = turnTimeInSeconds;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                    updateTimerLabel(timeRemaining);
                } else {
                    turnTimer.stop();
                    JOptionPane.showMessageDialog(null, "Perdiste tu turno.");
                    changeToNextPlayer(); // Cambia al siguiente jugador
                    startTurnTimer(); // Inicia el temporizador para el siguiente jugador
                }
            }
        });
    }

    private void changeToNextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= teams.size()) {
            currentPlayerIndex = 0; // Vuelve al primer jugador si se llega al último
        }
        JugadorActualTurn = teams.get(currentPlayerIndex).jugadores.get(TurnosT[currentPlayerIndex]);
        gameWindow.lblturno.setText("Turno de: " + JugadorActualTurn.usuario);

        // Reinicia el temporizador y comienza el turno del siguiente jugador
        resetTurnTimer();
        startTurnTimer();
    }

    private void updateTimerLabel(int timeRemaining) {
        int minutes = timeRemaining / 60;
        int seconds = timeRemaining % 60;
        timerLabel.setText(String.format("Tiempo restante: %02d:%02d", minutes, seconds));
    }
}
