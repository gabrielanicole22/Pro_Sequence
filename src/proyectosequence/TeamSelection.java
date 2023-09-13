/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectosequence;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public TeamSelection() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_players = new javax.swing.JComboBox<>();
        cb_teams = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAgregarPlayer = new javax.swing.JButton();
        mensajeLabel = new javax.swing.JLabel();

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

        jLabel1.setText("Escoge los jugadores:");

        jLabel2.setText("Escoge los equipos:");

        jTextArea1.setBackground(new java.awt.Color(153, 0, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnAgregarPlayer.setText("OKi");
        btnAgregarPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPlayerActionPerformed(evt);
            }
        });

        mensajeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mensajeLabel.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(cb_teams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(cb_players, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregarPlayer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(mensajeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(mensajeLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cb_players, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cb_teams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addComponent(btnAgregarPlayer)
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
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
        System.out.println(equipos.get(selectedTeam - 1).tamaño());
        System.out.println(equipos.get(selectedTeam - 1).estaCompleto());
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

            try {
                new Juego2Jugadores(equipos, cantCartas).setVisible(true);
            } catch (MalformedURLException ex) {
                Logger.getLogger(TeamSelection.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnAgregarPlayerActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel mensajeLabel;
    private javax.swing.JDialog mensajito;
    // End of variables declaration//GEN-END:variables
}
