package com.example.treinamentoretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.treinamentoretrofit.data.ApiUtils;
import com.example.treinamentoretrofit.data.UsuarioService;
import com.example.treinamentoretrofit.models.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarUsuarioActivity extends AppCompatActivity {
    EditText edtNome;
    EditText edtEmail;
    EditText edtTelefone;
    EditText edtSenha;
    Spinner spnFuncao;
    Button btnSalvar;
    Usuario usuario;
    int funcaoId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        inicializaComponentes();
        preencheSpinner();

        Intent intent = getIntent();
        if (intent.hasExtra("usuario")) {
            Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");
            edtNome.setText(usuario.getNome());
            edtEmail.setText(usuario.getEmail());
            edtTelefone.setText(usuario.getTelefone());
            edtSenha.setText(usuario.getSenha());
            handleClickUpdate(usuario);
        } else {
            handleClickInsert();
        }
    }

    private void handleClickUpdate(Usuario usuario) {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNome.getText().length() > 0 && edtEmail.getText().length() > 0 &&
                        edtTelefone.getText().length() > 0 && edtSenha.getText().length() > 0) {
                    usuario.setNome(edtNome.getText().toString());
                    usuario.setEmail(edtEmail.getText().toString());
                    usuario.setTelefone(edtTelefone.getText().toString());
                    usuario.setSenha(edtSenha.getText().toString());
                    usuario.setFuncaoId(funcaoId);

                    editarUsuario(usuario, usuario.getId());
                } else {
                    new AlertDialog.Builder(CadastrarUsuarioActivity.this).setNeutralButton("Ok", null)
                            .setMessage("Preecha todos os campos").setTitle("Erro a cadastrar um usuário").show();
                }
            }
        });
    }

    private void editarUsuario(Usuario usuario, int id) {
        UsuarioService mService = ApiUtils.getUsuariosService();
        Call call = mService.putUsuarios(id, usuario);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), RestActivity.class));
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }

    private void handleClickInsert() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNome.getText().length() > 0 && edtEmail.getText().length() > 0 &&
                        edtTelefone.getText().length() > 0 && edtSenha.getText().length() > 0) {
                    usuario = new Usuario();
                    usuario.setNome(edtNome.getText().toString());
                    usuario.setEmail(edtEmail.getText().toString());
                    usuario.setTelefone(edtTelefone.getText().toString());
                    usuario.setSenha(edtSenha.getText().toString());
                    usuario.setFuncaoId(funcaoId);

                    cadastrarUsuario(usuario);
                } else {
                    new AlertDialog.Builder(CadastrarUsuarioActivity.this).setNeutralButton("Ok", null)
                            .setMessage("Preecha todos os campos").setTitle("Erro a cadastrar um usuário").show();
                }
            }
        });
    }

    private void preencheSpinner() {
        List<String> funcaoList = new ArrayList<>();
        funcaoList.add("Administrador");
        funcaoList.add("Usuario");
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, funcaoList);
        spnFuncao.setAdapter(adapter);
        spnFuncao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                funcaoId = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void inicializaComponentes() {
        edtNome = findViewById(R.id.cadastrar_usuario_txt_nome);
        edtEmail = findViewById(R.id.cadastrar_usuario_txt_email);
        edtTelefone = findViewById(R.id.cadastrar_usuario_txt_telefone);
        edtSenha = findViewById(R.id.cadastrar_usuario_txt_senha);
        spnFuncao = findViewById(R.id.cadastrar_usuario_spn_funcao);
        btnSalvar = findViewById(R.id.cadastrar_usuario_btn_salvar);
    }

    private void cadastrarUsuario(Usuario usuario) {
        UsuarioService mService = ApiUtils.getUsuariosService();
        Call call = mService.postUsuarios(usuario);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), RestActivity.class));
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });

    }
}