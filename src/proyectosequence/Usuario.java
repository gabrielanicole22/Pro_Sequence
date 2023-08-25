/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Gabriela Mejía
 */
public class Usuario implements Serializable {

    private String nombre;
    private String usuario;
    private String contrasena;
    private Date fechaCreacion;
    private double puntos = 0.0;
    private static final long serialVersionUID = 1L;

    public Usuario(String nombre, String usuario, String contrasena) {
        this.nombre = nombre.trim();
        this.usuario = usuario.trim();
        this.contrasena = contrasena.trim();
        this.fechaCreacion = new Date();

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
}