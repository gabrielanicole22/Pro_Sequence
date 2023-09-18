/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectosequence;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela Mejia
 */
public class TeamSelection extends javax.swing.JFrame {

    SistemaUsuarios sistemaUsuarios;
    int cantPlayers;
    int cantEquipos;
    int cantCartas;
    ArrayList<Equipos> equipos;
    Color SELECT_COLOR = new Color(83, 152, 254);
    private Color colorOriginal;
    boolean mismoColorEquipo = false;

    public TeamSelection() {
        initComponents();
        colorOriginal = btnAgregarPlayer.getForeground();
        mensajeLabel.setText("Esperando a que se llenen los equipos...");
        sistemaUsuarios = new SistemaUsuarios();
        int Confi = sistemaUsuarios.getPlayersConfig();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        switch (Confi) {
            case 2:
                cantPlayers = 1;
                cantEquipos = 2;
                cantCartas = 7;
                break;
            case 3:
                cantPlayers = 1;
                cantEquipos = 3;
                cantCartas = 6;

                break;
            case 4:
                cantPlayers = 2;
                cantEquipos = 2;
                cantCartas = 7;

                break;
            case 6:
                cantPlayers = 2;
                cantEquipos = 3;
                cantCartas = 5;

                break;
            case 8:
                cantPlayers = 4;
                cantEquipos = 2;
                cantCartas = 4;
                break;
        }

        ArrayList<Jugador> jugadores = sistemaUsuarios.getListaUsuarios();

        for (Jugador p : jugadores) {
            p.team = -1;
            cb_players.addItem(p.usuario);
        }
        equipos = new ArrayList<>();
        for (int i = 1; i <= cantEquipos; i++) {
            cb_teams.addItem("" + i);
            equipos.add(new Equipos(cantPlayers));
        }
        textoInfoArea();
    }

    private boolean equipoLleno() {
        for (Equipos t : equipos) {
            if (!t.estaCompleto()) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensajito = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_players = new javax.swing.JComboBox<>();
        cb_teams = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAgregarPlayer = new javax.swing.JButton();
        mensajeLabel = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout mensajitoLayout = new javax.swing.GroupLayout(mensajito.getContentPane());
        mensajito.getContentPane().setLayout(mensajitoLayout);
        mensajitoLayout.setHorizontalGroup(
            mensajitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        mensajitoLayout.setVerticalGroup(
            mensajitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        jLabel1.setText("Escoge los jugadores:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        jLabel2.setText("Escoge los equipos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        cb_players.setBackground(new java.awt.Color(255, 204, 204));
        cb_players.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb_players.setForeground(new java.awt.Color(102, 0, 0));
        cb_players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_playersActionPerformed(evt);
            }
        });
        jPanel1.add(cb_players, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 270, 40));

        cb_teams.setBackground(new java.awt.Color(255, 204, 204));
        cb_teams.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb_teams.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(cb_teams, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 270, 40));

        jTextArea1.setBackground(new java.awt.Color(153, 0, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 550, 340));

        btnAgregarPlayer.setFont(new java.awt.Font("Quiska", 0, 36)); // NOI18N
        btnAgregarPlayer.setText("OKi");
        btnAgregarPlayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarPlayerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarPlayerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarPlayerMouseExited(evt);
            }
        });
        btnAgregarPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPlayerActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 120, 70));

        mensajeLabel.setFont(new java.awt.Font("Oswald Light", 0, 24)); // NOI18N
        mensajeLabel.setForeground(new java.awt.Color(153, 0, 0));
        mensajeLabel.setText("jLabel3");
        jPanel1.add(mensajeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, -1, -1));

        jToggleButton1.setText("Escoger los colores por equipo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

        jToggleButton2.setText("Escoger los colores individualmente");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, -1, -1));

        jRadioButton1.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        jRadioButton1.setText("Utilizar el mismo color por equipo");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg/TeamSelection.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 780));

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

    private void btnAgregarPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPlayerActionPerformed
        // TODO add your handling code here:
        Jugador playerSeleccionado = sistemaUsuarios.buscarUsuario((String) cb_players.getSelectedItem());
        int selectedTeam = Integer.parseInt((String) cb_teams.getSelectedItem());

        playerSeleccionado.team = selectedTeam;
        cb_players.removeItem(cb_players.getSelectedItem());
        
        equipos.get(selectedTeam - 1).agregar(playerSeleccionado);
        if (equipos.get(selectedTeam - 1).estaCompleto()) {
            cb_teams.removeItem("" + selectedTeam);
        }
        textoInfoArea();

        if (equipoLleno()) {
            if (!(usuarioLoggeado())) {
                JOptionPane.showMessageDialog(mensajito, "El jugador " + sistemaUsuarios.getUsuarioLogeado().usuario + " loggeado tiene que estar en un equipo.");
                mensajito.dispose();
                reiniciarSeleccion();
                return;
            }
            mensajeLabel.setText("Equipos llenos, empieza la partida");
            JOptionPane.showMessageDialog(null, "INICIA LA PARTIDA");
            mensajito.setVisible(false);

            new SequenceGamee(equipos, cantCartas, mismoColorEquipo).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnAgregarPlayerActionPerformed

    private void btnAgregarPlayerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarPlayerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPlayerMouseClicked

    private void btnAgregarPlayerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarPlayerMouseEntered
        // TODO add your handling code here:
        btnAgregarPlayer.setForeground(SELECT_COLOR);
        setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnAgregarPlayerMouseEntered

    private void btnAgregarPlayerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarPlayerMouseExited
        // TODO add your handling code here:
        btnAgregarPlayer.setForeground(colorOriginal);
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnAgregarPlayerMouseExited

    private void cb_playersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_playersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_playersActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        new ColoresPorEquipo().setVisible(true);
        this.hide();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        new ColoresIndividuales().setVisible(true);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        boolean nuevoState = !mismoColorEquipo;
        mismoColorEquipo = nuevoState;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void reiniciarSeleccion() {
        cb_players.removeAllItems();
        cb_teams.removeAllItems();
        mensajeLabel.setText("Esperando a que se llenen los equipos...");
        equipos.clear();

        ArrayList<Jugador> jugadores = sistemaUsuarios.getListaUsuarios();

        for (Jugador p : jugadores) {
            p.team = -1;
            cb_players.addItem(p.usuario);
        }
        for (int i = 1; i <= cantEquipos; i++) {
            cb_teams.addItem("" + i);
            equipos.add(new Equipos(cantPlayers));
        }
        textoInfoArea();
    }

    private boolean usuarioLoggeado() {
        Jugador currentPlayer = sistemaUsuarios.getUsuarioLogeado();
        for (Equipos equipo : equipos) {
            for (Jugador player : equipo.jugadores) {
                if (currentPlayer.equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TeamSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeamSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeamSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeamSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeamSelection().setVisible(true);
            }
        });
    }

    private String textoInfoArea() {
        String mensaje = "";

        for (int i = 0; i < equipos.size(); i++) {
            Equipos equipo = equipos.get(i);
            mensaje += "Equipo #" + (i + 1) + " - " + equipo.tamaño() + " *** PLAYERS ***\n";

            for (Jugador p : equipo.jugadores) {
                mensaje += "\t" + p.usuario + "\n";
            }
        }
        jTextArea1.setText(mensaje);
        return mensaje;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPlayer;
    private javax.swing.JComboBox<String> cb_players;
    private javax.swing.JComboBox<String> cb_teams;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel mensajeLabel;
    private javax.swing.JDialog mensajito;
    // End of variables declaration//GEN-END:variables
}
