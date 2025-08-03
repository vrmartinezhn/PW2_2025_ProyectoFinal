package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Calificacion;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.CalificacionesResponse;
import pw2.gestionacademica.pw2_2025_proyectofinal.repository.DatabaseRepositoryImpl;
import pw2.gestionacademica.pw2_2025_proyectofinal.view.CalificacionesViewModel;

public class CalificacionesInteractorImpl implements CalificacionesInteractor {
    private DatabaseRepositoryImpl repositorio;
    private CalificacionesViewModel vista;

    public CalificacionesInteractorImpl(CalificacionesViewModel vista) {
        super();
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarCalificaciones() {
        try{
            CalificacionesResponse response = this.repositorio.consultarCalificaciones();
            if(response == null || response.getItems() == null || response.getItems().isEmpty() || response.getCount() == 0){
                this.vista.mostrarMensajeError("No se encontraron peliculas");
            }else{
                this.vista.mostrarCalificacionesDataTable(response.getItems());
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void crearCalificacion(Calificacion calificacion) {
        try{
            boolean creado = this.repositorio.crearCalificaciones(calificacion);
            if(creado){
                this.vista.mostrarMensajeExito("Calificación creada correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al crear la calificación");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void actualizarCalificacion(Calificacion calificacion) {
        try{
            boolean modificado = this.repositorio.actualizarCalificaciones(calificacion);
            if(modificado){
                this.vista.mostrarMensajeExito("Calificación actualizada correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al actualizar la calificación");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarCalificacion(int id) {
        try{
            boolean eliminado = this.repositorio.eliminarCalificaciones(id);
            if(eliminado){
                this.vista.mostrarMensajeExito("Calificación eliminada correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al eliminar la calificación");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarCalificaciones(int[] ids) {
        try{
            for(int id : ids){
                boolean eliminado = this.repositorio.eliminarCalificaciones(id);
                if(!eliminado){
                    this.vista.mostrarMensajeError("Error al eliminar la calificación");
                    this.vista.refrescarPantalla();
                    return;
                }
            }
            this.vista.mostrarMensajeExito("Calificación eliminada correctamente!");
            this.vista.refrescarPantalla();
        }catch(Exception error){
            error.printStackTrace();
        }
    }
}
