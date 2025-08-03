package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Calificacion;

public interface CalificacionesInteractor {
    void consultarCalificaciones();
    void crearCalificacion(Calificacion calificacion);
    void actualizarCalificacion(Calificacion calificacion);
    void eliminarCalificacion(int id);
    void eliminarCalificaciones(int[] ids);
}
