/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriela Mejía
 */
public class SistemaUsuarios {
    private static final String FILENAME = "user_data.bin";
    ArrayList<Usuario> usuariosActivos = new ArrayList<Usuario>();
    Usuario usuarioIniciado = null;

    public SistemaUsuarios() {
        loadUserDataFromFile(); // Cargar los datos al iniciar
    }

    public boolean esUsuarioUnico(String usuario) {
        for (Usuario user : usuariosActivos) {
            if (user.getUsuario().equals(usuario)) {
                return false; // El usuario ya existe
            }
        }
        return true; // El usuario es único
    }

    public Usuario getUsuario(String username) {
        for (Usuario user : usuariosActivos) {
            if (user.getUsuario().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean verificarEspaciosUsuario(String usuario) {
        return verificarEspaciosUsuario(usuario, 0);
    }

    private boolean verificarEspaciosUsuario(String usuario, int index) {
        if (index >= usuario.length()) {
            return true;
        }

        char charActual = usuario.charAt(index);

        if (charActual == ' ') {
            return false;
        }

        return verificarEspaciosUsuario(usuario, index + 1);
    }

    public void registrarUsuario(String nombre, String usuario, String contrasena) {
        Date fechaCreacion = new Date();
        Usuario nuevoUsuario = new Usuario(nombre, usuario, contrasena, fechaCreacion);
        usuariosActivos.add(nuevoUsuario);
        saveUserDataToFile(); // Guardar los datos actualizados en el archivo
    }

    public Usuario[] getUsuariosActivos() {
        return usuariosActivos.toArray(new Usuario[0]);
    }

    public Usuario iniciarSesion(String usuario, String contrasena) {
        return iniciarSesion(usuario, contrasena, 0);
    }

    private Usuario iniciarSesion(String usuario, String contrasena, int index) {
        for (Usuario usuarioActual : usuariosActivos) {
            if (usuarioActual.validarCredenciales(usuario, contrasena)) {
                this.usuarioIniciado = usuarioActual;
                return usuarioActual;
            }
        }
        return null;
    }

    //usuario que tiene sesión activa
    public Usuario getUsuarioActual() {
        return usuarioIniciado;
    }

    public void saveUserDataToFile() {
        try (RandomAccessFile file = new RandomAccessFile(FILENAME, "rw")) {
            for (Usuario usuario : usuariosActivos) {
                usuario.escribirEnArchivo(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadUserDataFromFile() {
        usuariosActivos.clear();
        try (RandomAccessFile file = new RandomAccessFile(FILENAME, "rw")) {
            while (file.getFilePointer() < file.length()) {
                usuariosActivos.add(Usuario.leerDeArchivo(file));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //solo es para visualizar los usuarios guardados
    public String obtenerListaUsuarios() {
        StringBuilder listaUsuarios = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Formato de fecha

        for (Usuario usuario : usuariosActivos) {
            listaUsuarios.append("Nombre: ").append(usuario.getNombre()).append("\n");
            listaUsuarios.append("Usuario: ").append(usuario.getUsuario()).append("\n");
            listaUsuarios.append("Puntos: ").append(usuario.getPuntos()).append("\n");
            listaUsuarios.append("Fecha de Creación: ").append(dateFormat.format(usuario.getFechaCreacion())).append("\n\n");
        }
        return listaUsuarios.toString();
    }
}