package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Calificacion;

import java.util.List;

public interface CalificacionesViewModel {
    void mostrarCalificacionesDataTable(List<Calificacion> calificaciones);
    void refrescarPantalla();
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
}
