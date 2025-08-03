package pw2.gestionacademica.pw2_2025_proyectofinal.repository;

import okhttp3.ResponseBody;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Profesor;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.ProfesoresResponse;
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
}

