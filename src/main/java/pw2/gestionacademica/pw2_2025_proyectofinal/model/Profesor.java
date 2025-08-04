package pw2.gestionacademica.pw2_2025_proyectofinal.model;

import java.io.Serializable;

public class Profesor implements Serializable {
    private int id;
    private String usuario;
    private String contra;
    private String nombre;
    private String apellido;
    private String genero;
    private String correo;
    private String estatus;

    public Profesor() {
        this.id = 0;
        this.usuario = "";
        this.contra = "";
        this.nombre = "";
        this.apellido = "";
        this.genero = "";
        this.correo = "";
        this.estatus = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String nombreCompletoCuenta() {
        return nombre + " " + apellido + " (" + usuario + ")";
    }
}
