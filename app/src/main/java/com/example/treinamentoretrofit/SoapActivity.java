package com.example.treinamentoretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.treinamentoretrofit.adapters.ProdutoAdapter;
import com.example.treinamentoretrofit.data.ApiUtils;
import com.example.treinamentoretrofit.data.ProdutoSevice;
import com.example.treinamentoretrofit.models.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class SoapActivity extends AppCompatActivity {

    List<Produto> produtoList;
    ListView listaProdutos;
    ProdutoAdapter adapter;
    ProdutoSevice mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soap);
        listaProdutos = findViewById(R.id.list_view_produto);
        produtoList = new ArrayList<>();
        mService = ApiUtils.getProdutosService();
       Call<List<Produto>> call = mService.getProdutos();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.item_adicionar) {
            int idProduto = 0;
            for (Produto produto : produtoList) {
                idProduto = produto.getId();
            }
            idProduto++;
            Intent intent = new Intent(this, CadastrarProdutoActivity.class);
            intent.putExtra("idProduto", idProduto);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}