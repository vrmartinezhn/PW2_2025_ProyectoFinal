package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import java.util.List;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.*;

public interface EstudiantesViewModel {
    void mostrarEstudiantesDataTable(List<Estudiante> estudiantes);
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
    void refrescarPantalla();
    void cargarEstudiante(Estudiante estudiante);
}
