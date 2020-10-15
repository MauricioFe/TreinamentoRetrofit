package com.example.treinamentoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.treinamentoretrofit.adapters.UsuarioAdapter;
import com.example.treinamentoretrofit.data.ApiUtils;
import com.example.treinamentoretrofit.data.UsuarioService;
import com.example.treinamentoretrofit.models.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestActivity extends AppCompatActivity {
    List<Usuario> usuarioList;
    ListView listaUsuarios;
    UsuarioService mService;
    UsuarioAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        listaUsuarios = findViewById(R.id.list_view_usuario);
        usuarioList = new ArrayList<>();
        mService = ApiUtils.getUsuariosService();
        mAdapter = new UsuarioAdapter(this, usuarioList);
        listaUsuarios.setAdapter(mAdapter);
        atualizaListaUsuarios();
    }

    private void atualizaListaUsuarios() {
        Call<List<Usuario>> call = mService.getUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()) {
                    mAdapter.updateUsuarios(response.body());
                }else{
                    int statusCode = response.code();
                    Log.d("Não deu sucesso", "O código de retorno é: "+ statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.d("Erro api", "Erro na chamada da api: "+ t.getMessage());
            }
        });
    }
}