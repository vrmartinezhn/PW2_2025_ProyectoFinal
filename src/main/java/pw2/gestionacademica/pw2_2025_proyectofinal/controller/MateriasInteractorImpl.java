package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Materia;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.MateriasResponse;
import pw2.gestionacademica.pw2_2025_proyectofinal.repository.DatabaseRepositoryImpl;
import pw2.gestionacademica.pw2_2025_proyectofinal.view.MateriasViewModel;

public class MateriasInteractorImpl implements MateriasInteractor {
    private DatabaseRepositoryImpl repositorio;
    private MateriasViewModel vista;

    public MateriasInteractorImpl(MateriasViewModel vista) {
        super();
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarMaterias() {
        try{
            MateriasResponse response = this.repositorio.consultarMaterias();
            if(response == null || response.getItems() == null || response.getItems().isEmpty() || response.getCount() == 0){
                this.vista.mostrarMensajeError("No se encontraron Materias");
            }else{
                this.vista.mostrarMateriasDataTable(response.getItems());
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void crearMateria(Materia materia) {
        try{
            boolean creada = this.repositorio.crearMaterias(materia);
            if(creada){
                this.vista.mostrarMensajeExito("Materia creada correctamente");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al crear la Materia");
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @Override
    public void actualizarMateria(Materia materia) {
        try{
            boolean modificada = this.repositorio.actualizarMaterias(materia);
            if(modificada){
                this.vista.mostrarMensajeExito("Materia actualizada correctamente");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al actualizar la Materia");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarMateria(int id) {
        try{
            boolean eliminada = this.repositorio.eliminarMaterias(id);
            if(eliminada){
                this.vista.mostrarMensajeExito("Materia eliminada correctamente");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al eliminar la Materia");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarMaterias(int[] ids) {
        try{
            for(int id : ids){
                boolean eliminada = this.repositorio.eliminarMaterias(id);
                if(!eliminada){
                    this.vista.mostrarMensajeError("Error al eliminar las Materias");
                    this.vista.refrescarPantalla();
                    return;
                }
            }
            this.vista.mostrarMensajeExito("Materias eliminadas correctamente");
            this.vista.refrescarPantalla();
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    @Override
    public void consultarMateriaPorId(int id) {
        try {
            MateriasResponse response = this.repositorio.consultarMateriaPorId(id);
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                this.vista.mostrarMensajeError("No se encontró la materia con ID " + id);
            } else {
                this.vista.cargarMateria(response.getItems().getFirst());
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error al consultar materia por ID.");
        }
    }
}
