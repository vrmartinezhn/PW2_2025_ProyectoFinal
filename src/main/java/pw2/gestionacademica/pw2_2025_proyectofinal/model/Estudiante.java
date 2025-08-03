package pw2.gestionacademica.pw2_2025_proyectofinal.model;

import java.io.Serializable;

public class Estudiante implements Serializable {


    private int id;
    private int numero_cuenta;
    private String nombre;
    private String apellido;
    private String correo;
    private String genero;
    private String estatus;



    public Estudiante() {
        this.id = 0;
        this.numero_cuenta = 0;
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.genero = "";
        this.estatus = "";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {this.correo = correo;}



}
