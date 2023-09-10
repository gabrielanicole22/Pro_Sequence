/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriela Mejía
 */
public abstract class Usuario implements Serializable {

    public String usuario, contra, nombreCompleto;
    public int puntos, cantJugadores;
    File fichaFile;
    ImageIcon fichaIcon;
    Date fechaCreacion;

    public Usuario(String usuario, String contra, String nombreCompleto, long fechaCreacion, int puntos, String fichaFilename, int cantJugadores) {
        this.usuario = usuario;
        this.contra = contra;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = new Date();
        this.fechaCreacion.setTime(fechaCreacion);
        this.puntos = puntos;
        this.fichaFile = new File("src/fichas/" + fichaFilename);
        this.cantJugadores = cantJugadores;
        try {
            this.fichaIcon = new ImageIcon(ImageIO.read(fichaFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public abstract void addPuntos(int cantidad);

    public void guardarUsuario(RandomAccessFile raf) throws IOException {
        raf.seek(raf.length());
        raf.writeUTF(usuario);
        raf.writeUTF(contra);
        raf.writeUTF(nombreCompleto);
        raf.writeLong(fechaCreacion.getTime());
        raf.writeInt(puntos);
        raf.writeUTF(fichaFile.getName());
        raf.writeInt(cantJugadores);
    }

    public void setIcon(String iconName) {
        iconName += ".png";
        this.fichaFile = new File("src/fichas/" + iconName);
        try {
            this.fichaIcon = new ImageIcon(ImageIO.read(fichaFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFormattedFechaCreacion() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return dateFormat.format(fechaCreacion);
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setUsername(String username) {
        this.usuario = username;
    }

    public String getUsername() {
        return usuario;
    }

    public void setPassword(String password) {
        this.contra = password;
    }

    public String getPassword() {
        return contra;
    }

    public String toString() {
        String mensaje = "Uusario: " + usuario + "\n";
        mensaje += "Contraseña: " + contra + "\n";
        mensaje += "Nombre: " + nombreCompleto + "\n";
        mensaje += "Cant jugadores: " + cantJugadores + "\n";
        mensaje += "Ficha: " + fichaFile.getName() + "\n";
        mensaje += "Puntos: " + puntos + "\n";
        return mensaje;
    }

    public int getPuntos() {
        return puntos;
    }
}