package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Profesor;

public interface ProfesoresInteractor {
    void consultarProfesores();
    void crearProfesor(Profesor profesor);
    void eliminarProfesor(int id);
    void eliminarProfesores(int[] ids);
    void actualizarProfesor(Profesor profesor);
    void consultarProfesorPorId(int id);
    boolean consultarProfesorPorUsuarioContra(String usuario, String contra);
    List<Profesor> obtenerProfesores();
}

