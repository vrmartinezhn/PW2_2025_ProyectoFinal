package pw2.gestionacademica.pw2_2025_proyectofinal.controller;

import pw2.gestionacademica.pw2_2025_proyectofinal.model.*;
public interface EstudiantesInteractor {
        void consultarEstudiantes();
        void crearEstudiantes(Estudiante estudiante);
        void actualizarEstudiantes(Estudiante estudiante);
        void eliminarEstudiante(int id);
        void eliminarEstudiantes(int[] ids);

        // tienen que añadirlo
        void consultarEstudiantePorId(int id);
        void consultarEstudiantePornumero_cuenta(int numero_cuenta);

}
