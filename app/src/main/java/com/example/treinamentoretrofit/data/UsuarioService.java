package com.example.treinamentoretrofit.data;

import com.example.treinamentoretrofit.models.Usuario;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioService {
    @GET("usuarios")
    Call<List<Usuario>> getUsuarios();

    @POST("usuarios")
    Call<Usuario> postUsuarios(@Body Usuario usuario);

    @DELETE("usuarios/{id}")
    Call<ResponseBody> deleteUsuarios(@Path("id") long id);

    @PUT("usuarios/{id}")
    Call<Usuario> putUsuarios(@Path("id") long id, @Body Usuario usuario);
}
