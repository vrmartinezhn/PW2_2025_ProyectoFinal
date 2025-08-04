package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Profesor;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.ProfesoresResponse;
import pw2.gestionacademica.pw2_2025_proyectofinal.repository.DatabaseRepositoryImpl;
import pw2.gestionacademica.pw2_2025_proyectofinal.view.ProfesoresViewModel;

import java.util.List;

public class ProfesoresInteractorImpl implements ProfesoresInteractor {
    private DatabaseRepositoryImpl repositorio;
    private ProfesoresViewModel vista;

    public ProfesoresInteractorImpl(ProfesoresViewModel vista) {
        super();
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    public ProfesoresInteractorImpl() {
        super();
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarProfesores() {
        try{
            ProfesoresResponse response = this.repositorio.consultarProfesores();
            if(response == null || response.getItems() == null || response.getItems().isEmpty() || response.getCount() == 0){
                this.vista.mostrarMensajeError("No se encontraron profesores");
            }else{
                this.vista.mostrarProfesoresDataTable(response.getItems());
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void crearProfesor(Profesor profesor) {
        try{
            boolean creado = this.repositorio.crearProfesores(profesor);
            if(creado){
                this.vista.mostrarMensajeExito("Profesor creado correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al crear el profesor");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarProfesor(int id) {
        try{
            boolean eliminado = this.repositorio.eliminarProfesores(id);
            if(eliminado){
                this.vista.mostrarMensajeExito("Profesor eliminado correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al eliminar el profesor");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarProfesores(int[] ids) {
        try{
            for(int id : ids){
                boolean eliminado = this.repositorio.eliminarProfesores(id);
                if(!eliminado){
                    this.vista.mostrarMensajeError("Error al eliminar el profesor");
                    this.vista.refrescarPantalla();
                    return;
                }
            }
            this.vista.mostrarMensajeExito("Profesor eliminado correctamente!");
            this.vista.refrescarPantalla();
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void actualizarProfesor(Profesor profesor) {
        try{
            boolean modificado = this.repositorio.actualizarProfesores(profesor);
            if(modificado){
                this.vista.mostrarMensajeExito("Profesor actualizado correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al actualizar el profesor");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    @Override
    public void consultarProfesorPorId(int id) {
        try {
            ProfesoresResponse response = this.repositorio.consultarProfesorPorId(id);
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                this.vista.mostrarMensajeError("No se encontró el profesor con ID " + id);
            } else {
                this.vista.cargarProfesor(response.getItems().getFirst());
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error al consultar profesor por ID.");
        }
    }

    @Override
    public boolean consultarProfesorPorUsuarioContra(String usuario, String contra) {
        try {
            ProfesoresResponse response = this.repositorio.consultarProfesorPorUsuarioContra(usuario, contra);
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error al consultar profesor por ID.");
        }
        return false;
    }

    @Override
    public List<Profesor> obtenerProfesores() {
        try{
            ProfesoresResponse response = this.repositorio.consultarProfesores();
            if(response == null || response.getItems() == null || response.getItems().isEmpty() || response.getCount() == 0){
                this.vista.mostrarMensajeError("No se encontraron profesores");
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
