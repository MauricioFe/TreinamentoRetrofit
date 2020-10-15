package com.example.treinamentoretrofit.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.treinamentoretrofit.CadastrarUsuarioActivity;
import com.example.treinamentoretrofit.R;
import com.example.treinamentoretrofit.data.ApiUtils;
import com.example.treinamentoretrofit.data.UsuarioService;
import com.example.treinamentoretrofit.models.Usuario;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuarioAdapter extends BaseAdapter {
    Context context;
    List<Usuario> usuarioList;

    public UsuarioAdapter(Context context, List<Usuario> usuarioList) {
        this.context = context;
        this.usuarioList = usuarioList;
    }

    @Override
    public int getCount() {
        return usuarioList.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarioList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return usuarioList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_usuario, parent, false);

        TextView txvNome = convertView.findViewById(R.id.item_list_nome);
        TextView txvTelefone = convertView.findViewById(R.id.item_list_telefone);
        ImageView imgDelete = convertView.findViewById(R.id.item_list_delete);
        ImageView imgEdit = convertView.findViewById(R.id.item_list_edit);

        Usuario usuario = (Usuario) getItem(position);

        txvNome.setText(usuario.getNome());
        txvTelefone.setText(usuario.getTelefone());
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context).setTitle("Exclusão de usuários")
                        .setMessage("Você realmente deseja realizar a exclusão?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deletarUsuario(getItemId(position), position);
                            }
                        }).setNegativeButton("Não", null)
                        .show();
            }
        });
        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CadastrarUsuarioActivity.class);
                intent.putExtra("usuario", usuario);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    private void deletarUsuario(long id, int position) {
        UsuarioService usuarioService = ApiUtils.getUsuariosService();
        Call<ResponseBody> call = usuarioService.deleteUsuarios(id);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                usuarioList.remove(position);
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Error", "onFailure: " + t.getMessage());
            }
        });
    }

    public void updateUsuarios(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
        notifyDataSetChanged();
    }
}
