package com.example.treinamentoretrofit.data;

import com.example.treinamentoretrofit.models.Usuario;

public class ApiUtils {

    public static final String URL_BASE = " http://192.168.0.108:5000/api/";
    public static final String URL_BASE_SOAP = "http://192.168.0.108:50210/ProdutoService.asmx/";
    public static UsuarioService getUsuariosService(){
        return RetrofitClient.getClient(URL_BASE).create(UsuarioService.class);
    }
    public static ProdutoSevice getProdutosService(){
        return RetrofitClient.getClient(URL_BASE_SOAP).create(ProdutoSevice.class);
    }
}
