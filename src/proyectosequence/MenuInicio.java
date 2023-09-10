/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectosequence;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela Mejía
 */
public class MenuInicio extends javax.swing.JFrame {

    /**
     * Creates new form MenuInicio
     */
    SistemaUsuarios sistemaUsuarios;
    ArrayList<Equipos> equipos;

    public MenuInicio() {
        initComponents();
        equipos = new ArrayList<>();
        sistemaUsuarios = new SistemaUsuarios();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnConfiguracion = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnReportes3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("Menu Inicio");

        btnJugar.setBackground(new java.awt.Color(0, 0, 102));
        btnJugar.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        btnJugar.setForeground(new java.awt.Color(255, 255, 255));
        btnJugar.setText("Jugar");
        btnJugar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        btnConfiguracion.setBackground(new java.awt.Color(0, 0, 102));
        btnConfiguracion.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setText("Configuracion");
        btnConfiguracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(0, 0, 102));
        btnReportes.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("Reportes");
        btnReportes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(0, 0, 102));
        btnCerrarSesion.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnReportes3.setBackground(new java.awt.Color(0, 0, 102));
        btnReportes3.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        btnReportes3.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes3.setText("Cargar usuarios (prueba)");
        btnReportes3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnReportes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportes3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrarSesion)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTitulo)
                                        .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(33, 33, 33))
                                .addComponent(btnConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnReportes)
                                    .addGap(32, 32, 32)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnReportes3)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(btnJugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfiguracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion)
                .addGap(27, 27, 27)
                .addComponent(btnReportes3)
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        // TODO add your handling code here:
        if (sistemaUsuarios.getTotalPlayers() < sistemaUsuarios.getPlayersConfig()) {
            JOptionPane.showMessageDialog(null, "Cantidad insuficiente de usuarios registrados (" + sistemaUsuarios.getTotalPlayers() + "). Necesitas " + sistemaUsuarios.getPlayersConfig() + " usuarios.");
            return;
        }
        new TeamSelection().setVisible(true);
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        Configuracion configuracion = new Configuracion();
        configuracion.setVisible(true);
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        Reportes reportes = new Reportes(sistemaUsuarios);
        reportes.setVisible(true);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres cerrar sesión?", "CERRAR SESIÓN", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            sistemaUsuarios.setUsuarioLogeado(null);
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        }            
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnReportes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportes3ActionPerformed
        ArrayList<Jugador> usuarios = sistemaUsuarios.getListaUsuarios();
        StringBuilder usuariosText = new StringBuilder("Usuarios existentes:\n\n");

        for (Usuario usuario : usuarios) {
            usuariosText.append("Usuario: ").append(usuario.getUsername()).append("\n");
            usuariosText.append("Nombre: ").append(usuario.getNombreCompleto()).append("\n");
            usuariosText.append("Fecha de Creación: ").append(usuario.getFormattedFechaCreacion()).append("\n");
            usuariosText.append("Ficha Dirección: ").append(usuario.fichaFile.getAbsolutePath()).append("\n");
            usuariosText.append("Cantidad de Jugadores: ").append(usuario.cantJugadores).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, usuariosText.toString(), "Lista de Usuarios", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnReportes3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnReportes3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
