package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.Materia;

public interface MateriasInteractor {
    void consultarMaterias();
    void crearMateria(Materia materia);
    void actualizarMateria(Materia materia);
    void eliminarMateria(int id);
    void eliminarMaterias(int[] ids);
    void consultarMateriaPorId(int id);
}

