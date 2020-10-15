package com.example.treinamentoretrofit.data;

import com.example.treinamentoretrofit.models.Usuario;

public class ApiUtils {

    public static final String URL_BASE = " http://192.168.0.108:5000/api/";
    public static UsuarioService getUsuariosService(){
        return RetrofitClient.getClient(URL_BASE).create(UsuarioService.class);
    }
}
