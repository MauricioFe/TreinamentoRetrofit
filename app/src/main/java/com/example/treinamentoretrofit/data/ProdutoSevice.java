package com.example.treinamentoretrofit.data;

import com.example.treinamentoretrofit.models.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ProdutoSevice {
    @POST("GetProdutos")
    Call<List<Produto>> getProdutos();

    @POST("Post")
    Call<Produto> postProdutos(@Body Produto produto);

    @POST("Put")
    Call<Produto> putProdutos(@Body Produto produto);

    @POST("Delete")
    Call<Produto> deleteProdutos(@Body int id);
}
