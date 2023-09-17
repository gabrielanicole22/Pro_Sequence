/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectosequence;

/**
 *
 * @author Gabriela
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class TabCartas extends javax.swing.JPanel {

    SequenceGamee juego;
    Image fondito;

    Jugador jugadorActualTurno = null;
    int equipoturnoActual;
    int[] equipot;
    ArrayList<Equipos> teams;

    Timer temporizador;

    boolean jugado = false;

    public Cartas cartaObtenida;
    ArrayList<Cartas> cartasMano;
    int cantCartas;
    CartasManager manejadorCartas;

    final int filas = 10;
    final int columnas = 10;
    ImageIcon[][] imagenestab = new ImageIcon[filas][columnas];
    JLabel[][] tabLabels = new JLabel[filas][columnas];
    Tokens[][] tabTokens = new Tokens[filas][columnas];

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int imageWidth = (int) (getWidth());
        int imageHeight = (int) (getHeight());
        g.drawImage(fondito, 0, 0, imageWidth, imageHeight, this);
    }
    //URL urlBackground = getClass().getResource("/proyectosequence.Imagenes/background.png");
    //URL urlFicha = getClass().getResource("/proyectosequence.Imagenes/overlay.png");
    //ImageIcon background = new ImageIcon(urlBackground);
    //ImageIcon ficha = new ImageIcon(urlFicha);

    public TabCartas(SequenceGamee juego, ArrayList<Equipos> teams, int numCartas) {
        initComponents(); // Inicializa los componentes del panel.
        fondito = new ImageIcon("src/cartas/fondo.jpg").getImage(); // Carga la imagen de fondo.
        this.teams = teams; // Asigna la lista de equipos.
        cantCartas = numCartas; // Establece la cantidad de cartas.
        this.juego = juego; // Asigna la referencia al juego.
        equipot = new int[teams.size()]; // Inicializa el arreglo de equipos.

        cartasMano = manejadorCartas.cargadoCartas(); // Carga las cartas disponibles.

        // Inicializa el arreglo de equipos.
        for (int i = 0; i < equipot.length; i++) {
            equipot[i] = 0;
        }

        guardado();

        // Itera a través de los componentes del panel.
        for (Component label : getComponents()) {
            JLabel labelsTab = (JLabel) label;
            labelsTab.setText("");
            labelsTab.setIcon(null);

            // Configura un manejador de eventos de clic del ratón para cada etiqueta en el tablero.
            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (cartaObtenida != null) {
                        Tokens newFicha = new Tokens(false, jugadorActualTurno.team, jugadorActualTurno, (ImageIcon) jugadorActualTurno.fichaIcon);
                        CasillaTablero clickedCoords = getCasillaTableros((JLabel) e.getSource());

                        // Manejo de las cartas Jack
                        if (cartaObtenida.jackDosOjos()) {
                            temporizador.stop();
                            JLabel clickedLabel = (JLabel) e.getSource();
                            JOptionPane.showMessageDialog(null, "JACK DE 2 OJOS - Coloca una ficha donde tu quieras!");

                            // Verifica si el clic se realizó en una esquina del tablero
                            boolean esquinas = (clickedLabel == tabLabels[0][0]) || (clickedLabel == tabLabels[9][0]) || (clickedLabel == tabLabels[0][9]) || (clickedLabel == tabLabels[9][9]);

                            if (esquinas) {
                                JOptionPane.showMessageDialog(juego, "Error: No se colocan fichas en las esquinas");
                                return;
                            }

                            CasillaTablero place = getCasillaTableros(clickedLabel);
                            tabTokens[place.row][place.column] = newFicha;
                            tabLabels[clickedCoords.row][clickedCoords.column].setIcon(newFicha.img);
                            agregarCartasR();
                            ultimaCartaJugada();;
                            cambioDeTurno();
                            return;
                        } else if (cartaObtenida.jackUnOjo()) {

                            temporizador.stop();
                            JOptionPane.showMessageDialog(null, "JACK DE 1 OJO - Selecciona una ficha enemiga para destrozarla.");

                            Tokens clickedFicha = tabTokens[clickedCoords.row][clickedCoords.column];

                            if (clickedFicha == null) {
                                return;
                            }

                            if (clickedFicha.equipo == jugadorActualTurno.team) {
                                JOptionPane.showMessageDialog(juego, "Usa esta herramienta para ayudar a tu equipo");
                                return;
                            }
                            tabTokens[clickedCoords.row][clickedCoords.column] = null;
                            tabLabels[clickedCoords.row][clickedCoords.column].setIcon(null);
                            agregarCartasR();
                            ultimaCartaJugada();

                            cambioDeTurno();
                            return;
                        }

                        boolean valid = cartaObtenida.equals(obtenerCarta((JLabel) e.getSource()));
                        boolean casillaOcupada = tabTokens[clickedCoords.row][clickedCoords.column] == null;

                        if (!casillaOcupada) {
                            JOptionPane.showMessageDialog(juego, "Error: CASILLA OCUPADA.");
                            return;
                        }

                        if (!valid) {
                            return;
                        }
                        if (verificarSecuencias()) {
                            System.out.println("secuencia formada");
                        }
                        CasillaTablero place = getCasillaTableros((JLabel) e.getSource());
                        temporizador.stop();

                        tabTokens[place.row][place.column] = newFicha;
                        tabLabels[place.row][place.column].setIcon(newFicha.img);

                        agregarCartasR();
                        ultimaCartaJugada();

                        cartaObtenida = null;
                        iluminarPosTablero(null);
                        jugado = true;
                        juego.cartastablero.clicked = null;
                        cambioDeTurno();
                    }
                }
            };
            labelsTab.addMouseListener(mouseAdapter);
        }

        repartirCartas(); // Reparte las cartas a los jugadores.
        juego.timerLbl.setText("Tiempo Restante: 2:00");
    }

// Obtiene la posición de la casilla en el tablero a partir de una etiqueta.
    private CasillaTablero getCasillaTableros(JLabel label) {
        int row = 0, col = 0;
        for (Component comp : getComponents()) {
            JLabel lbl = (JLabel) comp;

            if (lbl == label) {
                return new CasillaTablero(row, col); //Devuelve la posición de la casilla en el tablero.
            }
            col++;
            if (col > 9) {
                col = 0;
                row++;
            }
        }
        return null;
    }

    public void posicionarCartas() {
        juego.cartastablero.posicionarCartas(jugadorActualTurno);
    }

    private void agregarCartasR() {
        jugadorActualTurno.manoJugador.remove(cartaObtenida); // Elimina la carta del jugador actual.
        jugadorActualTurno.cartasJugadas.add(cartaObtenida); // Agrega la carta a las cartas jugadas.

        Cartas newCarta = barajear(); // Obtiene una nueva carta de la baraja.

        lbl.setText(jugadorActualTurno.usuario + " tu nueva carta");
        icon.setIcon(newCarta.imagenCartas);

        jugadorActualTurno.manoJugador.add(newCarta);
        mensajeCartas.pack();

        mensajeCartas.setLocationRelativeTo(null);
        mensajeCartas.setVisible(true);
    }

    private void repartirCartas() {
        for (Equipos t : teams) {
            for (Jugador p : t.jugadores) {
                while (p.manoJugador.size() < cantCartas) {
                    Cartas cartaSeleccionada = barajear();
                    p.manoJugador.add(cartaSeleccionada);
                }
            }
        }
    }

// Obtiene la carta correspondiente del label
    private Cartas obtenerCarta(JComponent source) {
        if (source instanceof JLabel) {
            JLabel l = (JLabel) source;

            for (int r = 0; r < filas; r++) {
                for (int c = 0; c < columnas; c++) {
                    if (tabLabels[r][c] == l) {
                        Cartas card = new Cartas((ImageIcon) imagenestab[r][c]);
                        return card;
                    }
                }
            }
            return null;
        } else if (source instanceof JButton) {
            JButton b = (JButton) source;
            Cartas card = new Cartas((ImageIcon) b.getIcon());
            return card;
        }
        return null;
    }

    private Cartas barajear() {
        Random r = new Random();
        int pos = r.nextInt(0, cartasMano.size());
        Cartas c = cartasMano.get(pos);
        cartasMano.remove(pos);
        return c;
    }

    //marca donde se puede poner una carta
    public void iluminarPosTablero(JButton labelCard) {
        Cartas clickedCard = obtenerCarta(labelCard);
        cartaObtenida = clickedCard;

        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {
                Cartas currentCard = new Cartas((ImageIcon) imagenestab[r][c]);
                Tokens fichaEnCasilla = tabTokens[r][c];

                if (currentCard.equals(clickedCard)) {

                    if (fichaEnCasilla != null) {
                        tabLabels[r][c].setBackground(Color.PINK);
                    } else {
                        tabLabels[r][c].setBackground(Color.black);
                    }
                    tabLabels[r][c].setOpaque(true);
                } else {
                    tabLabels[r][c].setOpaque(false);
                }
                tabLabels[r][c].repaint();
            }
        }
    }

    private void ultimaCartaJugada() {
        lbl.setText(jugadorActualTurno.usuario + " jugó esta carta");
        icon.setIcon(cartaObtenida.imagenCartas);
        mensajeCartas.pack();
        mensajeCartas.setLocationRelativeTo(null);
        mensajeCartas.setVisible(true);
    }

    public void temporizador() {
        int turnTime = 120 * 1000;

        juego.timerLbl.setText("Tiempo restante: 2:00");
        if (temporizador == null) {
            temporizador = new Timer(1000, new ActionListener() {
                int tiempoRestante = turnTime;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tiempoRestante > 0) {
                        tiempoRestante -= 1000;
                        int minutos = tiempoRestante / (60 * 1000);
                        int segundos = (tiempoRestante % (60 * 1000)) / 1000;
                        juego.timerLbl.setText("Tiempo restante: " + String.format("%02d:%02d", minutos, segundos));
                    } else {
                        jugado = false;
                        juego.cartastablero.clicked = null;
                        ((Timer) e.getSource()).stop();
                        temporizador.stop();
                        JOptionPane.showMessageDialog(juego, jugadorActualTurno.usuario + " se ha quedado sin tiempo para jugar.");
                        cambioDeTurno();
                    }
                }
            });

            temporizador.start();
            return;

        }

        temporizador.stop();
        temporizador = new Timer(1000, new ActionListener() {
            int tiempoRestante = turnTime;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiempoRestante > 0) {
                    tiempoRestante -= 1000;
                    int minutos = tiempoRestante / (60 * 1000);
                    int segundos = (tiempoRestante % (60 * 1000)) / 1000;
                    juego.timerLbl.setText("Tiempo restante: " + String.format("%02d:%02d", minutos, segundos));
                } else {
                    jugado = false;
                    ((Timer) e.getSource()).stop();
                    temporizador.stop();
                    JOptionPane.showMessageDialog(juego, jugadorActualTurno.usuario + " se ha quedado sin tiempo para jugar.");
                    cambioDeTurno();
                }
            }
        });

        temporizador.start();
    }

    public void cambioDeTurno() {
        juego.cartastablero.clicked = null;
        cartaObtenida = null;
        if (jugadorActualTurno == null) {
            temporizador();
            juego.ultimaCarta.setIcon(null);
            juego.ultimaCard.setVisible(false);

            jugadorActualTurno = teams.get(0).jugadores.get(0);
            equipoturnoActual = 0;

            juego.turnLabel.setText("Turno de: " + jugadorActualTurno.usuario);
            return;
        }

        int teamSize = teams.get(0).jugadores.size();

        if (equipot[equipoturnoActual] == (teamSize - 1)) {
            equipot[equipoturnoActual] = 0;
        } else {
            equipot[equipoturnoActual] += 1;
        }

        if (equipoturnoActual == (teams.size() - 1)) {
            equipoturnoActual = 0;
        } else {
            equipoturnoActual++;
        }

        Jugador nextPlayer = teams.get(equipoturnoActual).jugadores.get(equipot[equipoturnoActual]);
        JOptionPane.showMessageDialog(juego, "Fin del turno de " + jugadorActualTurno.usuario + ". Deja que juegue " + nextPlayer.usuario);
        temporizador();

        if (jugado) {
            juego.ultimaCard.setVisible(true);
            Cartas lastPlayedCard = jugadorActualTurno.cartasJugadas.get(jugadorActualTurno.cartasJugadas.size() - 1);
            juego.ultimaCarta.setIcon(lastPlayedCard.imagenCartas);
            juego.ultimaCarta.setVisible(true);
        }

        jugadorActualTurno = nextPlayer;
        juego.cartastablero.posicionarCartas(jugadorActualTurno);
        juego.turnLabel.setText("Turno de: " + jugadorActualTurno.usuario);
    }

    //esta medio medio, falta arreglar
    private boolean verificarPosicionesDisponibles() {
        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {
                if (tabTokens[r][c] != null) {
                    if (tabTokens[r][c].equipo == jugadorActualTurno.team) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void descartarCarta() {
        if (cartaObtenida != null) {
            boolean posicionesDisponibles = verificarPosicionesDisponibles();
            if (!posicionesDisponibles) {
                int indiceCartaDescartada = -1;
                for (int i = 0; i < jugadorActualTurno.manoJugador.size(); i++) {
                    if (jugadorActualTurno.manoJugador.get(i).equals(cartaObtenida)) {
                        indiceCartaDescartada = i;
                        break;
                    }
                }
                if (indiceCartaDescartada != -1 && indiceCartaDescartada < jugadorActualTurno.manoJugador.size()) {
                    jugadorActualTurno.manoJugador.remove(indiceCartaDescartada);
                }
                jugadorActualTurno.cartasJugadas.add(cartaObtenida);

                // Agregar una nueva carta después de descartar
                Cartas nuevaCarta = barajear();
                jugadorActualTurno.manoJugador.add(nuevaCarta);

                JOptionPane.showMessageDialog(juego, "Carta descartada. Se ha obtenido una nueva carta.");
                posicionarCartas();
            } else {
                JOptionPane.showMessageDialog(juego, "Esta carta aún tiene posiciones disponibles en el tablero. No se puede descartar.");
            }
        }
    }

    private void guardado() {
        int row = 0, col = 0;
        for (Component comp : getComponents()) {
            JLabel lbl = (JLabel) comp;
            imagenestab[row][col] = (ImageIcon) lbl.getIcon();
            tabLabels[row][col] = lbl;
            col++;

            if (col > 9) {
                col = 0;
                row++;
            }
        }
    }

    // Función para verificar secuencias en el tablero
    public boolean verificarSecuencias() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Tokens ficha = tabTokens[i][j];

                if (ficha != null) {
                    int equipoFicha = ficha.equipo;

                    // Verificar secuencias verticales
                    if (i + 4 < filas) {
                        boolean secuenciaVertical = true;
                        for (int k = 1; k < 5; k++) {
                            if (tabTokens[i + k][j] == null || tabTokens[i + k][j].equipo != equipoFicha) {
                                secuenciaVertical = false;
                                break;
                            }
                        }
                        if (secuenciaVertical) {
                            JOptionPane.showMessageDialog(this, "Has formado una secuencia vertical de 5 cartas.");
                            return true;
                        }
                    }

                    // Verificar secuencias horizontales
                    if (j + 4 < columnas) {
                        boolean secuenciaHorizontal = true;
                        for (int k = 1; k < 5; k++) {
                            if (tabTokens[i][j + k] == null || tabTokens[i][j + k].equipo != equipoFicha) {
                                secuenciaHorizontal = false;
                                break;
                            }
                        }
                        if (secuenciaHorizontal) {
                            JOptionPane.showMessageDialog(this, "Has formado una secuencia horizontal de 5 cartas.");
                            return true;
                        }
                    }

                    // Verificar secuencias diagonales hacia abajo y hacia la derecha
                    if (i + 4 < filas && j + 4 < columnas) {
                        boolean secuenciaDiagonalDerecha = true;
                        for (int k = 1; k < 5; k++) {
                            if (tabTokens[i + k][j + k] == null || tabTokens[i + k][j + k].equipo != equipoFicha) {
                                secuenciaDiagonalDerecha = false;
                                break;
                            }
                        }
                        if (secuenciaDiagonalDerecha) {
                            JOptionPane.showMessageDialog(this, "Has formado una secuencia diagonal de 5 cartas hacia la derecha.");
                            return true;
                        }
                    }

                    // Verificar secuencias diagonales hacia abajo y hacia la izquierda
                    if (i + 4 < filas && j - 4 >= 0) {
                        boolean secuenciaDiagonalIzquierda = true;
                        for (int k = 1; k < 5; k++) {
                            if (tabTokens[i + k][j - k] == null || tabTokens[i + k][j - k].equipo != equipoFicha) {
                                secuenciaDiagonalIzquierda = false;
                                break;
                            }
                        }
                        if (secuenciaDiagonalIzquierda) {
                            JOptionPane.showMessageDialog(this, "Has formado una secuencia diagonal de 5 cartas hacia la izquierda.");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        mensajeCartas = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();

        jLabel24.setText("jLabel24");

        jLabel26.setText("jLabel26");

        jLabel35.setText("jLabel35");

        mensajeCartas.setModal(true);
        mensajeCartas.setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl.setFont(new java.awt.Font("Pristina", 3, 24)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 204, 255));
        jPanel1.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 270, 27));
        jPanel1.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 106, 117));

        javax.swing.GroupLayout mensajeCartasLayout = new javax.swing.GroupLayout(mensajeCartas.getContentPane());
        mensajeCartas.getContentPane().setLayout(mensajeCartasLayout);
        mensajeCartasLayout.setHorizontalGroup(
            mensajeCartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );
        mensajeCartasLayout.setVerticalGroup(
            mensajeCartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setLayout(new java.awt.GridLayout(10, 10));
        add(jLabel1);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/2_pica.png"))); // NOI18N
        add(jLabel20);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/3_pica.png"))); // NOI18N
        add(jLabel33);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/4_pica.png"))); // NOI18N
        add(jLabel37);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/5_pica.png"))); // NOI18N
        add(jLabel39);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/6_pica.png"))); // NOI18N
        add(jLabel38);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/7_pica.png"))); // NOI18N
        add(jLabel34);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/8_pica.png"))); // NOI18N
        add(jLabel44);

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/9_pica.png"))); // NOI18N
        add(jLabel43);
        add(jLabel53);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/6_trebol.png"))); // NOI18N
        add(jLabel51);

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/5_trebol.png"))); // NOI18N
        add(jLabel64);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/4_trebol.png"))); // NOI18N
        add(jLabel63);

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/3_trebol.png"))); // NOI18N
        add(jLabel74);

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/2_trebol.png"))); // NOI18N
        add(jLabel73);

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/as_corazon.png"))); // NOI18N
        add(jLabel84);

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/k_corazon.png"))); // NOI18N
        add(jLabel83);

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/q_corazon.png"))); // NOI18N
        add(jLabel94);

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/10_corazon.png"))); // NOI18N
        add(jLabel93);

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/10_pica.png"))); // NOI18N
        add(jLabel100);

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/7_trebol.png"))); // NOI18N
        add(jLabel99);

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/as_pica.png"))); // NOI18N
        add(jLabel98);

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/2_diamante.png"))); // NOI18N
        add(jLabel97);

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/3_diamante.png"))); // NOI18N
        add(jLabel95);

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/4_diamante.png"))); // NOI18N
        add(jLabel96);

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/5_diamante.png"))); // NOI18N
        add(jLabel92);

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/6_diamante.png"))); // NOI18N
        add(jLabel91);

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/7_diamante.png"))); // NOI18N
        add(jLabel90);

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/9_corazon.png"))); // NOI18N
        add(jLabel89);

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/q_pica.png"))); // NOI18N
        add(jLabel88);

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/8_trebol.png"))); // NOI18N
        add(jLabel87);

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/k_pica.png"))); // NOI18N
        add(jLabel82);

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/6_trebol.png"))); // NOI18N
        add(jLabel86);

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/5_trebol.png"))); // NOI18N
        add(jLabel85);

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/4_trebol.png"))); // NOI18N
        add(jLabel78);

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/3_trebol.png"))); // NOI18N
        add(jLabel81);

        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/2_trebol.png"))); // NOI18N
        add(jLabel80);

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/8_diamante.png"))); // NOI18N
        add(jLabel79);

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/8_corazon.png"))); // NOI18N
        add(jLabel77);

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/k_pica.png"))); // NOI18N
        add(jLabel76);

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/9_trebol.png"))); // NOI18N
        add(jLabel75);

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/q_pica.png"))); // NOI18N
        add(jLabel72);

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/7_trebol.png"))); // NOI18N
        add(jLabel70);

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/6_corazon.png"))); // NOI18N
        add(jLabel71);

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/5_corazon.png"))); // NOI18N
        add(jLabel69);

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/4_corazon.png"))); // NOI18N
        add(jLabel65);

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/as_corazon.png"))); // NOI18N
        add(jLabel68);

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/9_diamante.png"))); // NOI18N
        add(jLabel67);

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/7_corazon.png"))); // NOI18N
        add(jLabel66);

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/as_pica.png"))); // NOI18N
        add(jLabel61);

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/10_trebol.png"))); // NOI18N
        add(jLabel48);

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/10_pica.png"))); // NOI18N
        add(jLabel62);

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/8_trebol.png"))); // NOI18N
        add(jLabel60);

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/7_corazon.png"))); // NOI18N
        add(jLabel59);

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/2_corazon.png"))); // NOI18N
        add(jLabel58);

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/3_corazon.png"))); // NOI18N
        add(jLabel57);

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/k_corazon.png"))); // NOI18N
        add(jLabel55);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/10_diamante.png"))); // NOI18N
        add(jLabel52);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/6_corazon.png"))); // NOI18N
        add(jLabel49);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/2_diamante.png"))); // NOI18N
        add(jLabel50);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/q_trebol.png"))); // NOI18N
        add(jLabel54);

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/9_pica.png"))); // NOI18N
        add(jLabel56);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/9_trebol.png"))); // NOI18N
        add(jLabel47);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/8_corazon.png"))); // NOI18N
        add(jLabel46);

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/9_corazon.png"))); // NOI18N
        add(jLabel45);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/10_corazon.png"))); // NOI18N
        add(jLabel41);

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/q_corazon.png"))); // NOI18N
        add(jLabel42);

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/q_diamante.png"))); // NOI18N
        add(jLabel40);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/5_corazon.png"))); // NOI18N
        add(jLabel25);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/3_diamante.png"))); // NOI18N
        add(jLabel31);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/k_trebol.png"))); // NOI18N
        add(jLabel30);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/8_pica.png"))); // NOI18N
        jLabel36.setToolTipText("");
        add(jLabel36);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/10_trebol.png"))); // NOI18N
        add(jLabel32);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/q_trebol.png"))); // NOI18N
        add(jLabel29);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/k_trebol.png"))); // NOI18N
        add(jLabel28);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/as_trebol.png"))); // NOI18N
        add(jLabel23);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/as_diamante.png"))); // NOI18N
        add(jLabel22);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/k_diamante.png"))); // NOI18N
        add(jLabel27);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/4_corazon.png"))); // NOI18N
        add(jLabel21);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/4_diamante.png"))); // NOI18N
        add(jLabel18);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/trebol/as_trebol.png"))); // NOI18N
        add(jLabel17);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/7_pica.png"))); // NOI18N
        add(jLabel16);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/6_pica.png"))); // NOI18N
        add(jLabel19);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/5_pica.png"))); // NOI18N
        add(jLabel11);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/4_pica.png"))); // NOI18N
        add(jLabel15);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/3_pica.png"))); // NOI18N
        add(jLabel2);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/pica/2_pica.png"))); // NOI18N
        add(jLabel14);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/2_corazon.png"))); // NOI18N
        add(jLabel3);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/corazon/3_corazon.png"))); // NOI18N
        add(jLabel13);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/5_diamante.png"))); // NOI18N
        add(jLabel12);
        add(jLabel4);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/as_diamante.png"))); // NOI18N
        add(jLabel5);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/k_diamante.png"))); // NOI18N
        add(jLabel6);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/q_diamante.png"))); // NOI18N
        add(jLabel7);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/10_diamante.png"))); // NOI18N
        add(jLabel8);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/9_diamante.png"))); // NOI18N
        add(jLabel9);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/8_diamante.png"))); // NOI18N
        add(jLabel10);

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/7_diamante.png"))); // NOI18N
        add(jLabel101);

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/diamante/6_diamante.png"))); // NOI18N
        add(jLabel102);
        add(jLabel103);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl;
    private javax.swing.JDialog mensajeCartas;
    // End of variables declaration//GEN-END:variables
}
