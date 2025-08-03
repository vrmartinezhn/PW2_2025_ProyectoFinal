package pw2.gestionacademica.pw2_2025_proyectofinal.repository;

import okhttp3.ResponseBody;
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
        Response<ProfesoresResponse> response = call.execute();//EJECUTA EL LLAMADO A LA BASE DE DATOS
        if(response.isSuccessful()){//CODIGO (STATUS CODE HTTP 200)
            return response.body();
        }else{
            return null;
        }
    }

    public boolean crearProfesores(Profesor nueva) throws IOException {
        Call<ResponseBody> call = client.getInstance().createProfesor(nueva);
        Response<ResponseBody> response = call.execute();//EJECUTA EL LLAMADO A LA BASE DE DATOS
        return response.isSuccessful();
    }

    public boolean actualizarProfesores(Profesor existente) throws IOException {
        Call<ResponseBody> call = client.getInstance().updateProfesor(existente);
        Response<ResponseBody> response = call.execute();//EJECUTA EL LLAMADO A LA BASE DE DATOS
        return response.isSuccessful();
    }

    public boolean eliminarProfesores(int id) throws IOException {
        Call<ResponseBody> call = client.getInstance().deleteProfesor(id);
        Response<ResponseBody> response = call.execute();//EJECUTA EL LLAMADO A LA BASE DE DATOS
        return response.isSuccessful();
    }
}
