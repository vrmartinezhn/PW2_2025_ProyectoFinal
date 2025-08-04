package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.*;
import pw2.gestionacademica.pw2_2025_proyectofinal.view.*;
import pw2.gestionacademica.pw2_2025_proyectofinal.repository.DatabaseRepositoryImpl;

import java.util.List;


public class EstudiantesInteractorImpl implements EstudiantesInteractor {
    private DatabaseRepositoryImpl repositorio;
    private EstudiantesViewModel vista;

    public EstudiantesInteractorImpl(EstudiantesViewModel vista) {
        super();
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    public EstudiantesInteractorImpl() {
        super();
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarEstudiantes() {
        try{
            EstudiantesResponse response = this.repositorio.consultarEstudiantes();
            if(response == null || response.getItems() == null || response.getItems().isEmpty() || response.getCount() == 0){
                this.vista.mostrarMensajeError("No se encontraron estudiantes");
            }else{
                this.vista.mostrarEstudiantesDataTable(response.getItems());
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void crearEstudiantes(Estudiante estudiante) {
        try{
            boolean creado = this.repositorio.crearEstudiantes(estudiante);
            if(creado){
                this.vista.mostrarMensajeExito("Estudiante creado correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("error al crear Estudiante");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void actualizarEstudiantes(Estudiante estudiante) {
        try{
            boolean modificado = this.repositorio.actualizarEstudiantes(estudiante);
            if(modificado){
                this.vista.mostrarMensajeExito("Estudiante actualizado correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al actualizar la Estudiante");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    @Override
    public void eliminarEstudiante(int id) {
        try{
            boolean eliminado = this.repositorio.eliminarEstudiantes(id);
            if(eliminado){
                this.vista.mostrarMensajeExito("Estudiante eliminado correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al eliminar la Estudiante");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarEstudiantes(int[] ids) {
        try{
            for(int id : ids){
                boolean eliminado = this.repositorio.eliminarEstudiantes(id);
                if(!eliminado){
                    this.vista.mostrarMensajeError("Error al eliminar la Estudiante");
                    this.vista.refrescarPantalla();
                    return;
                }
            }
            this.vista.mostrarMensajeExito("Estudiante eliminado correctamente!");
            this.vista.refrescarPantalla();
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void consultarEstudiantePorId(int id) {
        try {
            EstudiantesResponse response = this.repositorio.consultarEstudiantePorId(id);
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                this.vista.mostrarMensajeError("No se encontró el estudiante con ID " + id);
            } else {
                this.vista.cargarEstudiante(response.getItems().getFirst());
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error al consultar estudiante por ID.");
        }
    }

    @Override
    public Estudiante consultarEstudiantePorNumero_cuenta(int numero_cuenta) {
        try {
            EstudiantesResponse response = this.repositorio.consultarEstudiantePornumero_cuenta(numero_cuenta);
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {

                return null;
            } else {
                return response.getItems().getFirst();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error al consultar estudiante por número de cuenta.");
        }
        return null;
    }


    @Override
    public List<Estudiante> obtenerEstudiantes() {
        try{
            EstudiantesResponse response = this.repositorio.consultarEstudiantes();
            if(response == null || response.getItems() == null || response.getItems().isEmpty() || response.getCount() == 0){
                return null;
            }else{
                return response.getItems();
            }
        }catch(Exception error){
            error.printStackTrace();
        }
        return null;
    }
}
