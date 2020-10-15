package com.example.treinamentoretrofit.data;

import com.example.treinamentoretrofit.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsuarioService {
    @GET("usuarios")
    Call<List<Usuario>> getUsuarios();

    @POST("usuarios")
    Call<Usuario> postUsuarios(@Body Usuario usuario);
}
