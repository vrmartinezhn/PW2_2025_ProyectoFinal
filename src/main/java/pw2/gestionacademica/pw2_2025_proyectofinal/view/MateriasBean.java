package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.MateriasInteractor;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.MateriasInteractorImpl;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Materia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named("MateriasBean")
@ViewScoped
public class MateriasBean implements Serializable, MateriasViewModel {
    private List<Materia> materias;
    private List<Materia> selectedMaterias;
    private Materia selectedMateria;
    private MateriasInteractor controller;

    public MateriasBean() {
        this.materias = new ArrayList<>();
        this.selectedMaterias = new ArrayList<>();
        this.selectedMateria = null;
        controller = new MateriasInteractorImpl(this);
        controller.consultarMaterias();
    }

    public void openNew() {
        this.selectedMateria = new Materia();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedMateria()) {
            int size = this.selectedMaterias.size();
            return size > 1 ? size  + " Materias seleccionadas" : "1 materia seleccionada";
        }

        return "Eliminar";
    }

    public boolean hasSelectedMateria() {
        return this.selectedMaterias != null && !this.selectedMaterias.isEmpty();
    }

    public void guardarMateria() {
        if(this.selectedMateria.getId() == 0){
            controller.crearMateria(this.selectedMateria);
        }else{
            controller.actualizarMateria(this.selectedMateria);
        }
    }

    public void eliminarMateria() {
        this.materias.remove(this.selectedMateria);
        this.controller.eliminarMateria(this.selectedMateria.getId());
        this.selectedMateria = null;
    }

    public void eliminarMaterias() {
        this.materias.removeAll(this.selectedMaterias);
        this.controller.eliminarMaterias(this.selectedMaterias.stream().mapToInt(Materia::getId).toArray());
        this.selectedMaterias = null;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public List<Materia> getSelectedMaterias() {
        return selectedMaterias;
    }

    public void setSelectedMaterias(List<Materia> selectedMaterias) {
        this.selectedMaterias = selectedMaterias;
    }

    public Materia getSelectedMateria() {
        return selectedMateria;
    }

    public void setSelectedMateria(Materia selectedMateria) {
        this.selectedMateria = selectedMateria;
    }

    @Override
    public void mostrarMateriasDataTable(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public void refrescarPantalla() {
        controller.consultarMaterias();
    }

    @Override
    public void mostrarMensajeExito(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_INFO);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_INFO);
    }
}
