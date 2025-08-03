package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import org.primefaces.PrimeFaces;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.ProfesoresInteractor;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.ProfesoresInteractorImpl;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Profesor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("ProfesoresBean")
@ViewScoped
public class ProfesoresBean implements Serializable, ProfesoresViewModel {
    private List<Profesor> profesores;
    private List<Profesor> profesoresSeleccionados;
    private Profesor profesorSeleccionado;
    private ProfesoresInteractor controller;

    public ProfesoresBean() {
        this.profesores = new ArrayList<>();
        this.profesoresSeleccionados = new ArrayList<>();
        this.profesorSeleccionado = null;
        controller = new ProfesoresInteractorImpl(this);
        controller.consultarProfesores();
    }

    public void openNew() {
        this.profesorSeleccionado = new Profesor();
    }

    public String getDeleteButtonMessage() {
        if (hasProfesorSeleccionado()) {
            int size = this.profesoresSeleccionados.size();
            return size > 1 ? size + " profesores seleccionados" : "1 profesor seleccionado";
        }

        return "Eliminar";
    }

    public void guardarProfesor() {
        if(this.profesorSeleccionado.getId() == 0){
            controller.crearProfesor(this.profesorSeleccionado);
        }else{
            controller.actualizarProfesor(this.profesorSeleccionado);
        }
    }

    public void eliminarProfesor() {
        this.profesores.remove(this.profesorSeleccionado);
        this.controller.eliminarProfesor(this.profesorSeleccionado.getId());
        this.profesorSeleccionado = null;
    }

    public void eliminarProfesores() {
        this.profesores.removeAll(this.profesoresSeleccionados);
        this.controller.eliminarProfesores(this.profesoresSeleccionados.stream().mapToInt(Profesor::getId).toArray());
        this.profesoresSeleccionados = null;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Profesor getProfesorSeleccionado() {
        return profesorSeleccionado;
    }

    public void setProfesorSeleccionado(Profesor profesorSeleccionado) {
        this.profesorSeleccionado = profesorSeleccionado;
    }

    public boolean hasProfesorSeleccionado() {
        return this.profesoresSeleccionados != null && !this.profesoresSeleccionados.isEmpty();
    }

    public List<Profesor> getProfesoresSeleccionados() {
        return profesoresSeleccionados;
    }

    public void setProfesoresSeleccionados(List<Profesor> profesoresSeleccionados) {
        this.profesoresSeleccionados = profesoresSeleccionados;
    }

    @Override
    public void mostrarProfesoresDataTable(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    @Override
    public void refrescarPantalla() {
        controller.consultarProfesores();
    }

    @Override
    public void mostrarMensajeExito(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_INFO);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
    }
}
