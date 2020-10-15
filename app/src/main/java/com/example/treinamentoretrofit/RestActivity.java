package com.example.treinamentoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.treinamentoretrofit.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RestActivity extends AppCompatActivity {
    List<Usuario> usuarioList;
    ListView listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        listaUsuarios = findViewById(R.id.list_view_usuario);
        usuarioList = new ArrayList<>();

        atualizaListaUsuarios();
    }

    private void atualizaListaUsuarios() {

    }
}