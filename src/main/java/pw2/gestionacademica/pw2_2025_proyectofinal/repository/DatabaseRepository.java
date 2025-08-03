package pw2.gestionacademica.pw2_2025_proyectofinal.repository;

import okhttp3.ResponseBody;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Materia;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.MateriasResponse;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Profesor;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.ProfesoresResponse;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Calificacion;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.CalificacionesResponse;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Estudiante;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.EstudiantesResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface DatabaseRepository {
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uthworkspace/appacademica/profesores")
    Call<ProfesoresResponse> listProfesores();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uthworkspace/appacademica/profesores")
    Call<ResponseBody> createProfesor(@Body Profesor profesor);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uthworkspace/appacademica/profesores")
    Call<ResponseBody> updateProfesor(@Body Profesor profesor);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uthworkspace/appacademica/profesores")
    Call<ResponseBody> deleteProfesor(@Query("id") int id);

    
    //==================Materias=========================
    @Headers({
            "Accept: application/vnd.github.v3.full+json", "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uthworkspace/appacademica/materias")
    Call<MateriasResponse> listMaterias();

    @Headers({
            "Accept: application/vnd.github.v3.full+json", "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uthworkspace/appacademica/materias")
    Call<ResponseBody> createMateria(@Body Materia materia);

    @Headers({
            "Accept: application/vnd.github.v3.full+json", "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uthworkspace/appacademica/materias")
    Call<ResponseBody> updateMateria(@Body Materia materia);

    @Headers({
            "Accept: application/vnd.github.v3.full+json", "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uthworkspace/appacademica/materias")
    Call<ResponseBody> deleteMateria(@Query("id") int id);

    
    //================Calificaciones================================
    @Headers({
        "Accept: application/vnd.github.v3.full+json",
        "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uthworkspace/appacademica/calificaciones")
    Call<CalificacionesResponse> listCalificaciones();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uthworkspace/appacademica/calificaciones")
    Call<ResponseBody> createCalificacion(@Body Calificacion calificacion);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uthworkspace/appacademica/calificaciones")
    Call<ResponseBody> updateCalificacion(@Body Calificacion calificacion);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uthworkspace/appacademica/calificaciones")
    Call<ResponseBody> deleteCalificacion(@Query("id") int id);

    //=====================================================================estudiante
     @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uthworkspace/appacademica/estudiantes")
    Call<EstudiantesResponse> listEstudiante();
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uthworkspace/appacademica/estudiantes")
    Call<ResponseBody> createEstudiante(@Body Estudiante estudiante);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uthworkspace/appacademica/estudiantes")
    Call<ResponseBody> updateMEstudiante(@Body Estudiante estudiante);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uthworkspace/appacademica/estudiantes")
    Call<ResponseBody> deleteEstudiante(@Query("id") int id);

    //para buscar estudinateporid
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uthworkspace/appacademica/estudianteid")
    Call<EstudiantesResponse> getEstudiantePorId(@Query("id") int id);

    
    
}

