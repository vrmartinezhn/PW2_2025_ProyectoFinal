package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.EstudiantesInteractor;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.EstudiantesInteractorImpl;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Estudiante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("EstudiantesBean")
@ViewScoped
public class EstudiantesBean implements Serializable, EstudiantesViewModel {
    private List<Estudiante> estudiantes;
    private List<Estudiante> selectedEstudiantes;
    private Estudiante selectedEstudiante;
    private Estudiante estudiantePorId;
    private EstudiantesInteractor controller;
    private int idBusqueda;

    public EstudiantesBean() {
        this.estudiantes = new ArrayList<>();
        this.selectedEstudiantes = new ArrayList<>();
        this.selectedEstudiante = null;
        this.estudiantePorId = null;
        controller = new EstudiantesInteractorImpl(this);
        controller.consultarEstudiantes();
    }

// buscar estudianteporid
    public void buscarEstudiantePorId() {
        if (idBusqueda > 0) {
            controller.consultarEstudiantePorId(idBusqueda);
        } else {
            controller.consultarEstudiantes();
        }
    }
    
    public void openNew() {
        this.selectedEstudiante = new Estudiante();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedEstudiantes()) {
            int size = this.selectedEstudiantes.size();
            return size > 1 ? size + " Estudiantes seleccionados" : "1 Estudiante seleccionado";
        }

        return "Eliminar";
    }

    public boolean hasSelectedEstudiantes() {
        return this.selectedEstudiantes != null && !this.selectedEstudiantes.isEmpty();
    }

    public void guardarEstudiantes() {
        if(this.selectedEstudiante.getId() == 0){
            controller.crearEstudiantes(this.selectedEstudiante);
        }else{
            controller.actualizarEstudiantes(this.selectedEstudiante);
        }
    }

    public void eliminarEstudiante() {
        this.estudiantes.remove(this.selectedEstudiante);
        this.controller.eliminarEstudiante(this.selectedEstudiante.getId());
        this.selectedEstudiante = null;
    }

    public void eliminarEstudiantes() {
        this.estudiantes.removeAll(this.selectedEstudiantes);
        this.controller.eliminarEstudiantes(this.selectedEstudiantes.stream().mapToInt(Estudiante::getId).toArray());
        this.selectedEstudiantes = null;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Estudiante getSelectedEstudiante() {
        return selectedEstudiante;
    }

    public void setSelectedEstudiante(Estudiante selectedEstudiante) {
        this.selectedEstudiante = selectedEstudiante;
    }

    public List<Estudiante> getSelectedEstudiantes() {
        return selectedEstudiantes;
    }

    public void setSelectedEstudiantes(List<Estudiante> selectedEstudiantes) {
        this.selectedEstudiantes = selectedEstudiantes;
    }
    //tienen que añadirlo
    public int getIdBusqueda() {return idBusqueda;}

    public void setIdBusqueda(int idBusqueda) {this.idBusqueda = idBusqueda;}


    public String mostrarNombreAlumno(int id){
        controller.consultarEstudiantePorId(id);
        if (estudiantePorId != null) {
            return estudiantePorId.getNombre() + " " +estudiantePorId.getApellido();
        }
        return "Error";
    }
    
    //public void setEstudiantePorId(Estudiante estudiantePorId) {this.estudiantePorId = estudiantePorId;}

    @Override
    public void mostrarEstudiantesDataTable(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public void cargarEstudiante(Estudiante estudiante) {
        this.estudiantePorId = estudiante;
    }

    @Override
    public void refrescarPantalla() {
        controller.consultarEstudiantes();
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
