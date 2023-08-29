/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Gabriela Mejía
 */
public class Usuario {

    private String nombre;
    private String usuario;
    private String contrasena;
    private Date fechaCreacion;
    private double puntos = 0.0;

    public Usuario(String nombre, String usuario, String contrasena, Date fechaCreacion) {
        this.nombre = nombre.trim();
        this.usuario = usuario.trim();
        this.contrasena = contrasena.trim();
        this.fechaCreacion = fechaCreacion;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (!usuario.trim().isEmpty()) {
            this.usuario = usuario.trim();
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (!contrasena.trim().isEmpty()) {
            this.contrasena = contrasena.trim();
        }
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public double getPuntos() {
        return puntos;
    }

    public boolean validarCredenciales(String usuario, String contrasena) {
        return (this.usuario.equals(usuario) && this.contrasena.equals(contrasena));
    }
    public void escribirEnArchivo(RandomAccessFile file) throws IOException {
        escribirCadenaEnArchivo(file, nombre);
        escribirCadenaEnArchivo(file, usuario);
        escribirCadenaEnArchivo(file, contrasena);
        file.writeLong(fechaCreacion.getTime());
    }

    public static Usuario leerDeArchivo(RandomAccessFile file) throws IOException {
        String nombre = leerCadenaDeArchivo(file);
        String usuario = leerCadenaDeArchivo(file);
        String contrasena = leerCadenaDeArchivo(file);
        long fechaCreacionUsuario = file.readLong();
        Date fechaCreacion = new Date(fechaCreacionUsuario);

        return new Usuario(nombre, usuario, contrasena, fechaCreacion);
    }

    private static void escribirCadenaEnArchivo(RandomAccessFile file, String cadena) throws IOException {
        file.writeUTF(cadena);
    }

    private static String leerCadenaDeArchivo(RandomAccessFile file) throws IOException {
        return file.readUTF();
    }    
}