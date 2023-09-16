package proyectosequence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Gabriela
 */
public class Juego2Jugadores extends javax.swing.JFrame {

    Tablero tablero;
    TabCartas tableroo;
        public CartasTablero cartasPanel;

    List<CartasBaraja> jugador1;
    List<CartasBaraja> jugador2;
    int posx;
    int posy;
    boolean puedeDescartarCarta;
    String textoCartaQueSePuedeDescartar = "";
    JButton[] mano;
    public String cartaSeleccionadaTexto;
    public int turno;

    private JButton primerBotonClickeado;
    private JButton segundoBotonClickeado;
    private boolean intercambiando;
    String textoPrimerClickeado;
    String textoSegundoClickeado;

    //Imagen de parte trasera de la baraja
    ImageIcon imagenTrasero;
    ImageIcon A_corazones;
    ImageIcon A_diamantes;
    ImageIcon A_picas;
    ImageIcon A_trebol;
    HashMap<String, String> cartasConImagenes = new HashMap<>();
    Baraja baraja = new Baraja();
    private int turnoAnterior;

    public Juego2Jugadores(ArrayList<Equipos> teams, int numCartas) throws MalformedURLException {
        initComponents();
        intercambiando = false;
        puedeDescartarCarta = false;
        this.turnoAnterior = this.turno;
        this.turno = 1;
        mano = new JButton[7];
        mano[1] = carta1;
        mano[2] = carta2;
        mano[3] = carta3;
        mano[4] = carta4;
        mano[5] = carta5;
        mano[6] = carta6;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        gamePanel.setLayout(new GridLayout(1, 1));
        setResizable(false);
        tablero = new Tablero(this, teams, numCartas);
        gamePanel.add(tableroo);
        gamePanel.repaint();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        baraja.barajar();
        jugador1 = baraja.repartir(6);
        jugador2 = baraja.repartir(6);
        ponerTextoMano();
        ponerImagenesEnMano();
        //actualizarLabelTurno();
        tablero.temporizador();
        tablero.cambioTurno();
        tablero.actualizarLabelUltimaJugada();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JLabel getTimerLabel() {
        return timer;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        timer = new javax.swing.JLabel();
        gamePanel = new javax.swing.JPanel();
        carta1 = new javax.swing.JButton();
        carta6 = new javax.swing.JButton();
        carta2 = new javax.swing.JButton();
        carta3 = new javax.swing.JButton();
        carta4 = new javax.swing.JButton();
        carta5 = new javax.swing.JButton();
        lblturno = new javax.swing.JLabel();
        btnDescartarCarta = new javax.swing.JButton();
        barajaDeCartas = new javax.swing.JLabel();
        ultimaCartaPuesta = new javax.swing.JButton();
        jugadorQuePusoLaCarta = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        timeWarning = new javax.swing.JLabel();
        btnIntercambiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        timer.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        timer.setText("temporizador");

        gamePanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        carta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta1ActionPerformed(evt);
            }
        });

        carta6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta6ActionPerformed(evt);
            }
        });

        carta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta2ActionPerformed(evt);
            }
        });

        carta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta3ActionPerformed(evt);
            }
        });

        carta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta4ActionPerformed(evt);
            }
        });

        carta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta5ActionPerformed(evt);
            }
        });

        lblturno.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        lblturno.setText("turno");

        btnDescartarCarta.setText("Descartar Carta");
        btnDescartarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescartarCartaActionPerformed(evt);
            }
        });

        barajaDeCartas.setBackground(new java.awt.Color(255, 255, 255));
        barajaDeCartas.setText("parte trasera mazo");
        barajaDeCartas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barajaDeCartas.setOpaque(true);

        ultimaCartaPuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimaCartaPuestaActionPerformed(evt);
            }
        });

        jugadorQuePusoLaCarta.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        jugadorQuePusoLaCarta.setText("Nadie ha jugado");

        lbl1.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        lbl1.setText("Última carta jugada");

        lbl2.setFont(new java.awt.Font("Rockwell Condensed", 0, 24)); // NOI18N
        lbl2.setText("Jugada por: ");

        timeWarning.setFont(new java.awt.Font("Barlow Condensed Light", 1, 24)); // NOI18N
        timeWarning.setForeground(new java.awt.Color(255, 0, 0));
        timeWarning.setText(".");

        btnIntercambiar.setText("Intercambiar");
        btnIntercambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntercambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(timer))
                    .addComponent(timeWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(lbl1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(ultimaCartaPuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lbl2)
                        .addGap(5, 5, 5)
                        .addComponent(jugadorQuePusoLaCarta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(btnDescartarCarta)))
                .addGap(16, 16, 16)
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnIntercambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(lblturno)
                .addGap(171, 171, 171)
                .addComponent(barajaDeCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(carta6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(timer)
                        .addGap(61, 61, 61)
                        .addComponent(timeWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(lbl1)
                        .addGap(11, 11, 11)
                        .addComponent(ultimaCartaPuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl2)
                            .addComponent(jugadorQuePusoLaCarta))
                        .addGap(161, 161, 161)
                        .addComponent(btnDescartarCarta))
                    .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(553, 553, 553)
                        .addComponent(btnIntercambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblturno))
                    .addComponent(barajaDeCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void intercambiar(JButton primerBoton, JButton segundoBoton){
        textoPrimerClickeado=primerBotonClickeado.getText();
        textoSegundoClickeado=segundoBotonClickeado.getText();
        primerBoton.setText(textoSegundoClickeado);
        segundoBoton.setText(textoPrimerClickeado);
        ponerImagenesEnMano();
        intercambiando=false;
    }
    
    private void carta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta1ActionPerformed

        if (intercambiando == false) {
            primerBotonClickeado = carta1;
            textoPrimerClickeado = primerBotonClickeado.getText();
        } else {
            segundoBotonClickeado = carta1;
            intercambiar(primerBotonClickeado, segundoBotonClickeado);
        }
        // itera a través de las casillas del tablero para quitar las cartas resaltadas
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.casillas[i][j].label.setBackground(null);
                tablero.casillas[i][j].label.setOpaque(false);
            }
        }

        String textocarta = carta1.getText();
        cartaSeleccionadaTexto = textocarta;
        System.out.println(cartaSeleccionadaTexto);

        if (cartaSeleccionadaTexto.equals("J_diamantes") || cartaSeleccionadaTexto.equals("J_trebol")) {
            JOptionPane.showMessageDialog(null, "JACK DE 2 OJOS - Coloca una ficha donde tu quieras!");
        } else if (cartaSeleccionadaTexto.equals("J_picas") || cartaSeleccionadaTexto.equals("J_corazones")) {
            JOptionPane.showMessageDialog(null, "JACK DE 1 OJO - Selecciona una ficha enemiga para destrozarla.");
        }

        // itera a través de las casillas del tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.casillas[i][j].carta != null && tablero.casillas[i][j].carta.getNombre().equals(textocarta)) {
                    // si la casilla del tablero coincide con el texto del botón clickeado, se pone azul
                    tablero.casillas[i][j].label.setBackground(Color.BLUE);
                    tablero.casillas[i][j].label.setOpaque(true);
                }
            }
        }

    }//GEN-LAST:event_carta1ActionPerformed
    //Para verificar si la carta que se quiere usar ya tiene fichas puestas en ambas casillas
    public void verificarEspaciosVacios() {
        int contadorFichasOcupadas = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Revisa a ver si hay fichas 
                if (tablero.casillas[i][j].label.getIcon() != null) {
                    System.out.println("si entra a lo del icon diferente de null");
                }
                if (tablero.casillas[i][j].carta.getNombre().equals(cartaSeleccionadaTexto)) {
                    System.out.println("Si entra a lo del nombre igual a la carta seleccionada");
                }
                if (tablero.casillas[i][j].label.getIcon() != null && tablero.casillas[i][j].carta.getNombre().equals(cartaSeleccionadaTexto)) {
                    contadorFichasOcupadas++;
                    System.out.println("Fichas ocupadas= " + contadorFichasOcupadas);
                }
            }
        }
        if (contadorFichasOcupadas == 2) {
            puedeDescartarCarta = true;
            textoCartaQueSePuedeDescartar = cartaSeleccionadaTexto;
        } else {
            puedeDescartarCarta = false;
        }
    }

    public void reiniciarMazo() {
        //Crea una nueva baraja 
        baraja = new Baraja();
        baraja.barajar();

        //Elimina las cartas del mazo que ya estan en la mano
        CartasBaraja carta1 = jugador1.get(1);
        CartasBaraja carta2 = jugador1.get(2);
        CartasBaraja carta3 = jugador1.get(3);
        CartasBaraja carta4 = jugador1.get(4);
        CartasBaraja carta5 = jugador1.get(5);
        CartasBaraja carta6 = jugador1.get(6);

        baraja.cartas.remove(carta1);
        baraja.cartas.remove(carta2);
        baraja.cartas.remove(carta3);
        baraja.cartas.remove(carta4);
        baraja.cartas.remove(carta5);
        baraja.cartas.remove(carta6);

        carta1 = jugador2.get(1);
        carta2 = jugador2.get(2);
        carta3 = jugador2.get(3);
        carta4 = jugador2.get(4);
        carta5 = jugador2.get(5);
        carta6 = jugador2.get(6);

        baraja.cartas.remove(carta1);
        baraja.cartas.remove(carta2);
        baraja.cartas.remove(carta3);
        baraja.cartas.remove(carta4);
        baraja.cartas.remove(carta5);
        baraja.cartas.remove(carta6);

    }

    public void eliminarYAgregarCarta() {

        for (int i = 0; i < 6; i++) {
            if (turno == 1) {
                if (jugador1.get(i).toString().equals(cartaSeleccionadaTexto)) {
                    jugador1.remove(i);
                    CartasBaraja nuevaCarta = baraja.repartir(1).get(0); // sacar la nueva carta de la baraja
                    jugador1.add(nuevaCarta);
                    ponerTextoMano();
                    ponerImagenesEnMano();
                    break;
                }
            } else if (turno == 2) {
                if (jugador2.get(i).toString().equals(cartaSeleccionadaTexto)) {
                    jugador2.remove(i);
                    CartasBaraja nuevaCarta = baraja.repartir(1).get(0); // sacar la nueva carta de la baraja
                    jugador2.add(nuevaCarta);
                    ponerTextoMano();
                    ponerImagenesEnMano();
                    break;
                }
            }
        }
    }

    private void carta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta2ActionPerformed

        if (intercambiando == false) {
            primerBotonClickeado = carta2;
            textoPrimerClickeado = primerBotonClickeado.getText();
        } else {
            segundoBotonClickeado = carta2;
            intercambiar(primerBotonClickeado, segundoBotonClickeado);
        }

        // itera a través de las casillas del tablero para quitar las cartas resaltadas
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.casillas[i][j].label.setBackground(null);
                tablero.casillas[i][j].label.setOpaque(false);
            }
        }

        String textocarta = carta2.getText();
        cartaSeleccionadaTexto = textocarta;
        System.out.println(cartaSeleccionadaTexto);

        if (cartaSeleccionadaTexto.equals("J_diamantes") || cartaSeleccionadaTexto.equals("J_trebol")) {
            JOptionPane.showMessageDialog(null, "JACK DE 2 OJOS - Coloca una ficha donde tu quieras!");
        } else if (cartaSeleccionadaTexto.equals("J_picas") || cartaSeleccionadaTexto.equals("J_corazones")) {
            JOptionPane.showMessageDialog(null, "JACK DE 1 OJO - Selecciona una ficha enemiga para destrozarla.");
        }
        // itera a través de las casillas del tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.casillas[i][j].carta != null && tablero.casillas[i][j].carta.getNombre().equals(textocarta)) {
                    // si la casilla del tablero coincide con el texto del botón clickeado, se pone azul
                    tablero.casillas[i][j].label.setBackground(Color.BLUE);
                    tablero.casillas[i][j].label.setOpaque(true);
                }
            }
        }
    }//GEN-LAST:event_carta2ActionPerformed

    private void carta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta3ActionPerformed
        if (intercambiando == false) {
            primerBotonClickeado = carta3;
            textoPrimerClickeado = primerBotonClickeado.getText();
        } else {
            segundoBotonClickeado = carta3;
            intercambiar(primerBotonClickeado, segundoBotonClickeado);
        }

        // itera a través de las casillas del tablero para quitar las cartas resaltadas
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.casillas[i][j].label.setBackground(null);
                tablero.casillas[i][j].label.setOpaque(false);
            }
        }

        String textocarta = carta3.getText();
        cartaSeleccionadaTexto = textocarta;
        System.out.println(cartaSeleccionadaTexto);

        if (cartaSeleccionadaTexto.equals("J_diamantes") || cartaSeleccionadaTexto.equals("J_trebol")) {
            JOptionPane.showMessageDialog(null, "JACK DE 2 OJOS - Coloca una ficha donde tu quieras!");
        } else if (cartaSeleccionadaTexto.equals("J_picas") || cartaSeleccionadaTexto.equals("J_corazones")) {
            JOptionPane.showMessageDialog(null, "JACK DE 1 OJO - Selecciona una ficha enemiga para destrozarla.");
        }

        // itera a través de las casillas del tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.casillas[i][j].carta != null && tablero.casillas[i][j].carta.getNombre().equals(textocarta)) {
                    // si la casilla del tablero coincide con el texto del botón clickeado, se pone azul
                    tablero.casillas[i][j].label.setBackground(Color.BLUE);
                    tablero.casillas[i][j].label.setOpaque(true);
                }
            }
        }
    }//GEN-LAST:event_carta3ActionPerformed

    private void carta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta4ActionPerformed
        if (intercambiando == false) {
            primerBotonClickeado = carta4;
            textoPrimerClickeado = primerBotonClickeado.getText();
        } else {
            segundoBotonClickeado = carta4;
            intercambiar(primerBotonClickeado, segundoBotonClickeado);
        }
        // itera a través de las casillas del tablero para quitar las cartas resaltadas
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.casillas[i][j].label.setBackground(null);
                tablero.casillas[i][j].label.setOpaque(false);
            }
        }

        String textocarta = carta4.getText();
        cartaSeleccionadaTexto = textocarta;
        System.out.println(cartaSeleccionadaTexto);

        if (cartaSeleccionadaTexto.equals("J_diamantes") || cartaSeleccionadaTexto.equals("J_trebol")) {
            JOptionPane.showMessageDialog(null, "JACK DE 2 OJOS - Coloca una ficha donde tu quieras!");
        } else if (cartaSeleccionadaTexto.equals("J_picas") || cartaSeleccionadaTexto.equals("J_corazones")) {
            JOptionPane.showMessageDialog(null, "JACK DE 1 OJO - Selecciona una ficha enemiga para destrozarla.");
        }

        // itera a través de las casillas del tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.casillas[i][j].carta != null && tablero.casillas[i][j].carta.getNombre().equals(textocarta)) {
                    // si la casilla del tablero coincide con el texto del botón clickeado, se pone azul
                    tablero.casillas[i][j].label.setBackground(Color.BLUE);
                    tablero.casillas[i][j].label.setOpaque(true);
                }
            }
        }
    }//GEN-LAST:event_carta4ActionPerformed

    private void carta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta5ActionPerformed
        if (intercambiando == false) {
            primerBotonClickeado = carta5;
            textoPrimerClickeado = primerBotonClickeado.getText();
        } else {
            segundoBotonClickeado = carta5;
            intercambiar(primerBotonClickeado, segundoBotonClickeado);
        }
        // itera a través de las casillas del tablero para quitar las cartas resaltadas
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.casillas[i][j].label.setBackground(null);
                tablero.casillas[i][j].label.setOpaque(false);
            }
        }

        String textocarta = carta5.getText();
        cartaSeleccionadaTexto = textocarta;
        System.out.println(cartaSeleccionadaTexto);

        if (cartaSeleccionadaTexto.equals("J_diamantes") || cartaSeleccionadaTexto.equals("J_trebol")) {
            JOptionPane.showMessageDialog(null, "JACK DE 2 OJOS - Coloca una ficha donde tu quieras!");
        } else if (cartaSeleccionadaTexto.equals("J_picas") || cartaSeleccionadaTexto.equals("J_corazones")) {
            JOptionPane.showMessageDialog(null, "JACK DE 1 OJO - Selecciona una ficha enemiga para destrozarla.");
        }

        // itera a través de las casillas del tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.casillas[i][j].carta != null && tablero.casillas[i][j].carta.getNombre().equals(textocarta)) {
                    // si la casilla del tablero coincide con el texto del botón clickeado, se pone azul
                    tablero.casillas[i][j].label.setBackground(Color.BLUE);
                    tablero.casillas[i][j].label.setOpaque(true);
                }
            }
        }
    }//GEN-LAST:event_carta5ActionPerformed

    private void carta6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta6ActionPerformed
        if (intercambiando == false) {
            primerBotonClickeado = carta6;
            textoPrimerClickeado = primerBotonClickeado.getText();
        } else {
           segundoBotonClickeado = carta6;
            intercambiar(primerBotonClickeado, segundoBotonClickeado);
        }
        // itera a través de las casillas del tablero para quitar las cartas resaltadas
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.casillas[i][j].label.setBackground(null);
                tablero.casillas[i][j].label.setOpaque(false);
            }
        }

        String textocarta = carta6.getText();
        cartaSeleccionadaTexto = textocarta;
        System.out.println(cartaSeleccionadaTexto);

        if (cartaSeleccionadaTexto.equals("J_diamantes") || cartaSeleccionadaTexto.equals("J_trebol")) {
            JOptionPane.showMessageDialog(null, "JACK DE 2 OJOS - Coloca una ficha donde tu quieras!");
        } else if (cartaSeleccionadaTexto.equals("J_picas") || cartaSeleccionadaTexto.equals("J_corazones")) {
            JOptionPane.showMessageDialog(null, "JACK DE 1 OJO - Selecciona una ficha enemiga para destrozarla.");
        }

        // itera a través de las casillas del tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.casillas[i][j].carta != null && tablero.casillas[i][j].carta.getNombre().equals(textocarta)) {
                    // si la casilla del tablero coincide con el texto del botón clickeado, se pone azul
                    tablero.casillas[i][j].label.setBackground(Color.BLUE);
                    tablero.casillas[i][j].label.setOpaque(true);
                }
            }
        }
    }//GEN-LAST:event_carta6ActionPerformed

    private void btnDescartarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartarCartaActionPerformed
        verificarEspaciosVacios();
        System.out.println("cartaSeleccionadaTexto: " + cartaSeleccionadaTexto);
        System.out.println("textoCartaQueSePuedeDescartar: " + textoCartaQueSePuedeDescartar);
        if (cartaSeleccionadaTexto == null) {
            JOptionPane.showMessageDialog(null, "Seleccione primero una carta y luego dele a descartar.");
        }
        if (puedeDescartarCarta == true && textoCartaQueSePuedeDescartar.equals(cartaSeleccionadaTexto)) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea descartar " + cartaSeleccionadaTexto);

            if (respuesta == JOptionPane.YES_OPTION) {
                eliminarYAgregarCarta();
                ponerTextoMano();
                ponerImagenesEnMano();
                puedeDescartarCarta = false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "No puedes eliminar cartas que aun pueden ser usadas.");
        }
    }//GEN-LAST:event_btnDescartarCartaActionPerformed

    private void ultimaCartaPuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimaCartaPuestaActionPerformed
        tablero.casillas[posx][posy].label.setBackground(Color.YELLOW);
    }//GEN-LAST:event_ultimaCartaPuestaActionPerformed

    private void btnIntercambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntercambiarActionPerformed
        if(intercambiando==false){
        intercambiando = true;
        }
        if(intercambiando==true){
            intercambiando= false;
        }


    }//GEN-LAST:event_btnIntercambiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego2Jugadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego2Jugadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego2Jugadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego2Jugadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    //Solo pone el texto a los botones 
    private void ponerTextoMano() {
        if (turno == 1) {
            carta1.setText(jugador1.get(1 - 1).toString());
            carta2.setText(jugador1.get(2 - 1).toString());
            carta3.setText(jugador1.get(3 - 1).toString());
            carta4.setText(jugador1.get(4 - 1).toString());
            carta5.setText(jugador1.get(5 - 1).toString());
            carta6.setText(jugador1.get(6 - 1).toString());
        }
        if (turno == 2) {
            carta1.setText(jugador2.get(1 - 1).toString());
            carta2.setText(jugador2.get(2 - 1).toString());
            carta3.setText(jugador2.get(3 - 1).toString());
            carta4.setText(jugador2.get(4 - 1).toString());
            carta5.setText(jugador2.get(5 - 1).toString());
            carta6.setText(jugador2.get(6 - 1).toString());
        }

    }

    public void cambioDeTurno() {
        // itera a través de las casillas del tablero para quitar las cartas resaltadas
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero.casillas[i][j].label.setBackground(null);
                tablero.casillas[i][j].label.setOpaque(false);
            }
        }
        eliminarYAgregarCarta();
        ponerUltimaCartaJugada();
        //actualizarLabelUltimaJugada();
        turno++;
        //Reiniciar el turno
        if (turno > 2) {
            turno = 1;
        }
        System.out.println("Cartas restantes en mazo: " + baraja.cartas.size());
        if (baraja.cartas.isEmpty()) {
            reiniciarMazo();
        }
        ponerTextoMano();
        ponerImagenesEnMano();
        //actualizarLabelTurno();
    }

    //Poner imagenes a los botones de la mano
    private void ponerImagen(JButton boton) {
        String textoDeCartaAgarrada = boton.getText();
        //ruta de la imagen
        String rutaImagen = "/img/" + textoDeCartaAgarrada + ".png";

        URL urlCartaAgarrada = getClass().getResource(rutaImagen);

        if (urlCartaAgarrada != null) {
            ImageIcon imagenCarta = new ImageIcon(urlCartaAgarrada);
            int nuevoAncho = 90;
            int nuevoAlto = 100;
            Image imagenRedimensionada = imagenCarta.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

            boton.setIcon(new ImageIcon(imagenRedimensionada));
        } else {
            System.err.println("No se pudo encontrar la imagen en la ruta: " + rutaImagen);
        }
    }

    public void ponerUltimaCartaJugada() {
        ultimaCartaPuesta.setText(cartaSeleccionadaTexto);

    }

    //Poner imagen a cada boton
    private void ponerImagenesEnMano() {
        ponerImagen(carta1);
        ponerImagen(carta2);
        ponerImagen(carta3);
        ponerImagen(carta4);
        ponerImagen(carta5);
        ponerImagen(carta6);

        if (!ultimaCartaPuesta.getText().equals("")) {
            ponerImagen(ultimaCartaPuesta);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barajaDeCartas;
    private javax.swing.JButton btnDescartarCarta;
    private javax.swing.JButton btnIntercambiar;
    private javax.swing.JButton carta1;
    private javax.swing.JButton carta2;
    private javax.swing.JButton carta3;
    private javax.swing.JButton carta4;
    private javax.swing.JButton carta5;
    private javax.swing.JButton carta6;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jugadorQuePusoLaCarta;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    public javax.swing.JLabel lblturno;
    public javax.swing.JLabel timeWarning;
    public javax.swing.JLabel timer;
    public javax.swing.JButton ultimaCartaPuesta;
    // End of variables declaration//GEN-END:variables
}
