package pw2.gestionacademica.pw2_2025_proyectofinal.model;

import java.io.Serializable;

public class Calificacion implements Serializable {
    private int id;
    private int id_estudiante;
    private int id_profesor;
    private int id_materia;
    private int primer_parcial;
    private int segundo_parcial;
    private int tercer_parcial;
    private String observacion;
    private int anio;
    private String periodo;

    public Calificacion() {
        this.id = 0;
        this.id_estudiante = 0;
        this.id_profesor = 0;
        this.id_materia = 0;
        this.primer_parcial = 0;
        this.segundo_parcial = 0;
        this.tercer_parcial = 0;
        this.observacion = "";
        this.anio = 0;
        this.periodo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getPrimer_parcial() {
        return primer_parcial;
    }

    public void setPrimer_parcial(int primer_parcial) {
        this.primer_parcial = primer_parcial;
    }

    public int getSegundo_parcial() {
        return segundo_parcial;
    }

    public void setSegundo_parcial(int segundo_parcial) {
        this.segundo_parcial = segundo_parcial;
    }

    public int getTercer_parcial() {
        return tercer_parcial;
    }

    public void setTercer_parcial(int tercer_parcial) {
        this.tercer_parcial = tercer_parcial;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
