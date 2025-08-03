package pw2.gestionacademica.pw2_2025_proyectofinal.model;

import java.io.Serializable;

public class Materia implements Serializable {
    private int id;
    private String icono;
    private String materia;
    private int id_profesor;
    private String estatus;

    public Materia() {
        this.id = 0;
        this.icono = "";
        this.materia = "";
        this.id_profesor = 0;
        this.estatus = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcono() { return icono; }

    public void setIcono(String icono) { this.icono = icono; }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getId_profesor() { return id_profesor; }

    public void setId_profesor(int id_profesor) { this.id_profesor = id_profesor; }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
