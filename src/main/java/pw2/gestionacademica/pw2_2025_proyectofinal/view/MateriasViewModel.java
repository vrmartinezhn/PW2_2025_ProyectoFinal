package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Materia;

import java.util.List;

public interface MateriasViewModel {
    void mostrarMateriasDataTable(List<Materia> materias);
    void refrescarPantalla();
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
    void cargarMateria(Materia materia);
}
