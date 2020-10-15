package com.example.treinamentoretrofit.data;

import com.example.treinamentoretrofit.models.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProdutoSevice {

    @POST("GetProdutos")
    Call<List<Produto>> getProdutos();
    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("Post")
    Call<Produto> postProdutos(@Body Produto produto);
    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("Put")
    Call<Produto> putProdutos(@Body Produto produto);
    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("Delete")
    Call<Produto> deleteProdutos(@Body int id);
}
