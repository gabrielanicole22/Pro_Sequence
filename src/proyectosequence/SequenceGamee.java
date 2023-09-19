/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectosequence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public class SequenceGamee extends javax.swing.JFrame {
    TabCartas tab;
    public CartasTablero cartastablero;
    Color SELECT_COLOR = new Color(83, 152, 254);
    private Color colorOriginal;
    SistemaUsuarios sistemausuarios;

    public SequenceGamee(ArrayList<Equipos> teams, int numCartas, boolean mismoColorPorEquipo, SistemaUsuarios sistemausuarios) {
        if (mismoColorPorEquipo) {
            int teamss = 0;
            for (Equipos currentTeam : teams) {
                String iconName = "";
                if (teamss == 0) {
                    iconName = "3azul";
                } else if (teamss == 1) {
                    iconName = "1redTV";
                } else {
                    iconName = "2amarillo";
                }
                for (Jugador p : currentTeam.jugadores) {
                    p.setIcon(iconName);
                }
                teamss++;
            }
        }
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        colorOriginal = btnDescartarCarta.getForeground();
        //this.setSize(1200, 750);
        this.sistemausuarios = sistemausuarios;
        tab = new TabCartas(this, teams, numCartas, sistemausuarios,fichaJugador);
        tableroPanel.add(tab);
        cartastablero = new CartasTablero(this);
        cartasBaraja.setLayout(new BorderLayout());
        cartasBaraja.add(cartastablero);
        tab.cambioDeTurno();
        tab.temporizador();
        tab.posicionarCartas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fichaJugador = new javax.swing.JLabel();
        timerLbl = new javax.swing.JLabel();
        ultimaCarta = new javax.swing.JLabel();
        tableroPanel = new javax.swing.JPanel();
        cartasBaraja = new javax.swing.JPanel();
        turnLabel = new javax.swing.JLabel();
        btnDescartarCarta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("* * * SEQUENCE GAME * * *");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(fichaJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 80, 50));

        timerLbl.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        timerLbl.setText("temporizador");
        jPanel1.add(timerLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        ultimaCarta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ultimaCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/partetraseracarta.png"))); // NOI18N
        jPanel1.add(ultimaCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, 150));

        tableroPanel.setBackground(new java.awt.Color(0, 0, 0));
        tableroPanel.setLayout(new java.awt.GridLayout(1, 1));
        jPanel1.add(tableroPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 510, 520));

        cartasBaraja.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout cartasBarajaLayout = new javax.swing.GroupLayout(cartasBaraja);
        cartasBaraja.setLayout(cartasBarajaLayout);
        cartasBarajaLayout.setHorizontalGroup(
            cartasBarajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        cartasBarajaLayout.setVerticalGroup(
            cartasBarajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        jPanel1.add(cartasBaraja, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 577, -1, -1));

        turnLabel.setBackground(new java.awt.Color(153, 255, 153));
        turnLabel.setFont(new java.awt.Font("Ravie", 0, 30)); // NOI18N
        turnLabel.setForeground(new java.awt.Color(204, 255, 204));
        turnLabel.setText("Turno: ");
        jPanel1.add(turnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 650, -1));

        btnDescartarCarta.setBackground(new java.awt.Color(102, 153, 255));
        btnDescartarCarta.setText("Descartar Carta");
        btnDescartarCarta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDescartarCartaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDescartarCartaMouseExited(evt);
            }
        });
        btnDescartarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescartarCartaActionPerformed(evt);
            }
        });
        jPanel1.add(btnDescartarCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 210, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg/tablero.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescartarCartaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescartarCartaMouseEntered
        // TODO add your handling code here:
        btnDescartarCarta.setForeground(SELECT_COLOR);
        setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnDescartarCartaMouseEntered

    private void btnDescartarCartaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescartarCartaMouseExited
        // TODO add your handling code here:
        btnDescartarCarta.setForeground(colorOriginal);
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnDescartarCartaMouseExited

    private void btnDescartarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartarCartaActionPerformed
        tab.descartarCarta();
    }//GEN-LAST:event_btnDescartarCartaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SequenceGamee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SequenceGamee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SequenceGamee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SequenceGamee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDescartarCarta;
    public javax.swing.JPanel cartasBaraja;
    public javax.swing.JLabel fichaJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel tableroPanel;
    public javax.swing.JLabel timerLbl;
    public javax.swing.JLabel turnLabel;
    public javax.swing.JLabel ultimaCarta;
    // End of variables declaration//GEN-END:variables
}
