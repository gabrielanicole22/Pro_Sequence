/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosequence;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriela Mejía
 */
public class SistemaUsuarios {

    private ArrayList<Jugador> jugadores;
    private static final String USUARIOS_FOLDER = "players";
    private static final String USUARIOS_FILE = USUARIOS_FOLDER + "/usuarios.uwu";

    private Jugador usuarioLogeado;

    public SistemaUsuarios() {
        jugadores = new ArrayList<Jugador>();
        searchVerification();
        loadUsers();
    }

    public Jugador getUsuarioLogeado() {
        return usuarioLogeado;
    }

    private boolean isValidUsername(String username) {
        for (Jugador p : jugadores) {
            if (p.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    private void searchVerification() {
        File folder = new File(USUARIOS_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File(USUARIOS_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File logged = new File("players/logged.uwu");
        if (!logged.exists()) {
            try {
                logged.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadUsers() {
        RandomAccessFile raf = null;
        RandomAccessFile loggedRaf = null;
        try {
            raf = new RandomAccessFile(USUARIOS_FILE, "rw");
            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                String usuario = raf.readUTF();
                String contra = raf.readUTF();
                String nombre = raf.readUTF();
                long fechaCreacion = raf.readLong();
                int puntos = raf.readInt();
                String fichaDirec = raf.readUTF();
                int cantJugadorews = raf.readInt();
                Jugador p = new Jugador(usuario, contra, nombre, fechaCreacion, puntos, fichaDirec, cantJugadorews);
                jugadores.add(p);
            }
            raf.close();
            loggedRaf = new RandomAccessFile("players/logged.uwu", "r");
            loggedRaf.seek(0);
            if (loggedRaf.length() == 0) {
                usuarioLogeado = null;
                loggedRaf.close();
                return;
            }
            String username = loggedRaf.readUTF();
            usuarioLogeado = buscarUsuario(username);
            loggedRaf.close();
        } catch (IOException e) {
            searchVerification();
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public boolean guardarPlayer(String name, String password, String completeName) {
        if (!isValidUsername(name)) {
            return false;
        }
        long fechaCreacion = new Date().getTime();
        Jugador p = new Jugador(name, password, completeName, fechaCreacion, 0, obtenerRuta(), 4);
        jugadores.add(p);
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(USUARIOS_FILE, "rw");
            raf.seek(raf.length());
            p.guardarUsuario(raf);
            File userFolder = new File("players/" + name);
            userFolder.mkdirs();
        } catch (IOException e) {
            searchVerification();
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public Jugador buscarUsuario(String username) {
        for (Jugador p : jugadores) {
            if (p.usuario.equals(username)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<String> getFichasDisponibles() {
        try {
            ArrayList<String> fichaPaths = new ArrayList<>();
            for (File icon : new File("src/fichas").listFiles()) {
                fichaPaths.add(icon.getName());
            }
            for (Jugador p : jugadores) {
                fichaPaths.remove(p.fichaFile.getName());
            }
            if (fichaPaths.isEmpty()) {
                return null;
            }
            return fichaPaths;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getFichas() {
        try {
            ArrayList<String> fichaNombre = new ArrayList<>();

            for (File icon : new File("src/fichas").listFiles()) {
                fichaNombre.add(icon.getName());
            }
            for (Jugador p : jugadores) {
                if (p.usuario.equals(usuarioLogeado.usuario)) {
                    continue;
                }
                fichaNombre.remove(p.fichaFile.getName());
            }
            return fichaNombre;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String obtenerRuta() {
        return getFichasDisponibles().get(0);
    }

    public int getPlayersConfig() {
        return getUsuarioLogeado().cantJugadores;
    }

    public ArrayList<Jugador> getListaUsuarios() {
        return jugadores;
    }

    public void setPlayersConfig(int players) {
        try {
            usuarioLogeado.cantJugadores = players;
            guardarJugadores();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalPlayers() {
        return jugadores.size();
    }

    public void setUsuarioLogeado(Jugador usuarioLogeado) {
        try {
            File f = new File("players/logged.uwu");
            if (f.exists()) {
                f.delete();
                f.createNewFile();
            }
            if (usuarioLogeado == null) {
                return;
            }
            RandomAccessFile raf = new RandomAccessFile("players/logged.uwu", "rw");
            usuarioLogeado.guardarUsuario(raf);
            this.usuarioLogeado = usuarioLogeado;
            raf.close();
            loadUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setusuarioLogeadoFicha(String iconName) {
        usuarioLogeado.setIcon(iconName);
        guardarJugadores();
    }

    public void guardarJugadores() {
        try {
            File f = new File(USUARIOS_FILE);
            f.delete();
            RandomAccessFile raf = new RandomAccessFile(USUARIOS_FILE, "rw");
            for (Jugador p : jugadores) {
                p.guardarUsuario(raf);
            }
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}