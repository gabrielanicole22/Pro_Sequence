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

    public SequenceGamee(ArrayList<Equipos> teams, int numCartas, boolean sameColor) {
        initComponents();
        colorOriginal = btnDescartarCarta.getForeground();
        //this.setSize(1200, 750);
        tab = new TabCartas(this, teams, numCartas);
        tableroPanel.add(tab);
        cartastablero = new CartasTablero(this);
        cartasBaraja.setLayout(new BorderLayout());
        cartasBaraja.add(cartastablero);
        tab.cambioDeTurno();
        tab.temporizador();
        tab.posicionarCartas();    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        timerLbl = new javax.swing.JLabel();
        ultimaCarta = new javax.swing.JLabel();
        ultimaCard = new javax.swing.JLabel();
        tableroPanel = new javax.swing.JPanel();
        cartasBaraja = new javax.swing.JPanel();
        turnLabel = new javax.swing.JLabel();
        btnDescartarCarta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("* * * SEQUENCE GAME * * *");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        timerLbl.setFont(new java.awt.Font("Rockwell Condensed", 0, 36)); // NOI18N
        timerLbl.setForeground(new java.awt.Color(0, 0, 0));
        timerLbl.setText("temporizador");

        ultimaCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cartas/partetraseracarta.png"))); // NOI18N

        ultimaCard.setFont(new java.awt.Font("Rockwell Condensed", 0, 36)); // NOI18N
        ultimaCard.setForeground(new java.awt.Color(0, 0, 0));
        ultimaCard.setText("Última Carta Jugada");

        tableroPanel.setBackground(new java.awt.Color(0, 0, 0));
        tableroPanel.setLayout(new java.awt.GridLayout(1, 1));

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

        turnLabel.setBackground(new java.awt.Color(51, 153, 0));
        turnLabel.setFont(new java.awt.Font("Rockwell Condensed", 0, 36)); // NOI18N
        turnLabel.setForeground(new java.awt.Color(0, 0, 0));
        turnLabel.setText("Turno");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(ultimaCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ultimaCard)
                            .addComponent(timerLbl))))
                .addGap(47, 47, 47)
                .addComponent(tableroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(btnDescartarCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(turnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartasBaraja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(timerLbl)
                        .addGap(122, 122, 122)
                        .addComponent(ultimaCard)
                        .addGap(6, 6, 6)
                        .addComponent(ultimaCarta))
                    .addComponent(tableroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turnLabel)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cartasBaraja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDescartarCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel tableroPanel;
    public javax.swing.JLabel timerLbl;
    public javax.swing.JLabel turnLabel;
    public javax.swing.JLabel ultimaCard;
    public javax.swing.JLabel ultimaCarta;
    // End of variables declaration//GEN-END:variables
}
