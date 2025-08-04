package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Profesor;

import java.util.List;

public interface ProfesoresViewModel {
    void mostrarProfesoresDataTable(List<Profesor> profesores);
    void refrescarPantalla();
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
    void cargarProfesor(Profesor profesor);
}
