package pw2.gestionacademica.pw2_2025_proyectofinal.repository;

import okhttp3.ResponseBody;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Materia;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.MateriasResponse;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.Profesor;
import pw2.gestionacademica.pw2_2025_proyectofinal.model.ProfesoresResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class DatabaseRepositoryImpl {
    private static DatabaseRepositoryImpl instance;
    private DatabaseClient client;

    private DatabaseRepositoryImpl(String url, Long timeout) {
        client = new DatabaseClient(url, timeout);
    }

    //PATRON SINGLETON
    public static DatabaseRepositoryImpl getInstance(String url, Long timeout){
        if(instance == null){
            synchronized (DatabaseRepositoryImpl.class){
                if(instance == null){
                    instance = new DatabaseRepositoryImpl(url, timeout);
                }
            }
        }
        return instance;
    }

    public ProfesoresResponse consultarProfesores() throws IOException {
        Call<ProfesoresResponse> call = client.getInstance().listProfesores();
        Response<ProfesoresResponse> response = call.execute();
        if(response.isSuccessful()){
            return response.body();
        }else{
            return null;
        }
    }

    public boolean crearProfesores(Profesor nueva) throws IOException {
        Call<ResponseBody> call = client.getInstance().createProfesor(nueva);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }

    public boolean actualizarProfesores(Profesor existente) throws IOException {
        Call<ResponseBody> call = client.getInstance().updateProfesor(existente);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }

    public boolean eliminarProfesores(int id) throws IOException {
        Call<ResponseBody> call = client.getInstance().deleteProfesor(id);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }


    //======================Materias===================================

    public MateriasResponse consultarMaterias() throws IOException {
        Call<MateriasResponse> call = client.getInstance().listMaterias();
        Response<MateriasResponse> response = call.execute();
        if(response.isSuccessful()){
            return response.body();
        }else{
            return null;
        }
    }

    public boolean crearMaterias(Materia nueva) throws IOException {
        Call<ResponseBody> call = client.getInstance().createMateria(nueva);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }

    public boolean actualizarMaterias(Materia existente) throws IOException {
        Call<ResponseBody> call = client.getInstance().updateMateria(existente);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }

    public boolean eliminarMaterias(int id) throws IOException {
        Call<ResponseBody> call = client.getInstance().deleteMateria(id);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }


    //=======================Calificaciones========================
    public CalificacionesResponse consultarCalificaciones() throws IOException {
        Call<CalificacionesResponse> call = client.getInstance().listCalificaciones();
        Response<CalificacionesResponse> response = call.execute();
        if(response.isSuccessful()){
            return response.body();
        }else{
            return null;
        }
    }

    public boolean crearCalificaciones(Calificacion calificacion) throws IOException {
        Call<ResponseBody> call = client.getInstance().createCalificacion(calificacion);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }

    public boolean actualizarCalificaciones(Calificacion existente) throws IOException {
        Call<ResponseBody> call = client.getInstance().updateCalificacion(existente);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }

    public boolean eliminarCalificaciones(int id) throws IOException {
        Call<ResponseBody> call = client.getInstance().deleteCalificacion(id);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }
}

