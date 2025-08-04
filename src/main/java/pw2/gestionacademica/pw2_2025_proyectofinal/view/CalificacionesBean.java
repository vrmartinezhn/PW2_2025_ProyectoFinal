package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import pw2.gestionacademica.pw2_2025_proyectofinal.controller.CalificacionesInteractor;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.CalificacionesInteractorImpl;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Calificacion;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("CalificacionesBean")
@ViewScoped
public class CalificacionesBean implements Serializable, CalificacionesViewModel {
    private List<Calificacion> calificaciones;
    private List<Calificacion> selectedCalificaciones;
    private Calificacion selectedCalificacion;
    private CalificacionesInteractor controller;

    public CalificacionesBean() {
        this.calificaciones = new ArrayList<>();
        this.selectedCalificaciones = new ArrayList<>();
        this.selectedCalificacion = null;
        controller = new CalificacionesInteractorImpl(this);
        controller.consultarCalificaciones();
    }
    
    public void openNew() {
        this.selectedCalificacion = new Calificacion();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedCalificacion()) {
            int size = this.selectedCalificaciones.size();
            return size > 1 ? size + " Calificaciones seleccionadas" : "1 Calificación seleccionada";
        }

        return "Eliminar";
    }

    public boolean hasSelectedCalificacion() {
        return this.selectedCalificaciones != null && !this.selectedCalificaciones.isEmpty();
    }

    public void guardarCalificacion() {
        if(this.selectedCalificacion.getId() == 0){
            controller.crearCalificacion(this.selectedCalificacion);
        }else{
            controller.actualizarCalificacion(this.selectedCalificacion);
        }
    }

    public void eliminarCalificacion() {
        this.calificaciones.remove(this.selectedCalificacion);
        this.controller.eliminarCalificacion(this.selectedCalificacion.getId());
        this.selectedCalificacion = null;
    }

    public void eliminarCalificaciones() {
        this.calificaciones.removeAll(this.selectedCalificaciones);
        this.controller.eliminarCalificaciones(this.selectedCalificaciones.stream().mapToInt(Calificacion::getId).toArray());
        this.selectedCalificaciones = null;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Calificacion getSelectedCalificacion() {
        return selectedCalificacion;
    }

    public void setSelectedCalificacion(Calificacion selectedCalificacion) {
        this.selectedCalificacion = selectedCalificacion;
    }

    public List<Calificacion> getSelectedCalificaciones() {
        return selectedCalificaciones;
    }

    public void setSelectedCalificaciones(List<Calificacion> selectedCalificaciones) {
        this.selectedCalificaciones = selectedCalificaciones;
    }

    @Override
    public void mostrarCalificacionesDataTable(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public void refrescarPantalla() {
        controller.consultarCalificaciones();
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
