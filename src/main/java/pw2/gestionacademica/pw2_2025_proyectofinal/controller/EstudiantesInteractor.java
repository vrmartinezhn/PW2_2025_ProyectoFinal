package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.*;

import java.util.List;

public interface EstudiantesInteractor {
        void consultarEstudiantes();
        void crearEstudiantes(Estudiante estudiante);
        void actualizarEstudiantes(Estudiante estudiante);
        void eliminarEstudiante(int id);
        void eliminarEstudiantes(int[] ids);
        void consultarEstudiantePorId(int id);
        boolean consultarEstudiantePorNumero_cuenta(int numero_cuenta);
        List<Estudiante> obtenerEstudiantes();
}
