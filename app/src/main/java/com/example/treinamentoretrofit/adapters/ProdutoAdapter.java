package com.example.treinamentoretrofit.adapters;

import android.content.Context;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.treinamentoretrofit.R;
import com.example.treinamentoretrofit.models.Produto;

import java.util.List;

public class ProdutoAdapter extends BaseAdapter {
    Context context;
    List<Produto> produtoList;
    public ProdutoAdapter(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public int getCount() {
        return produtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return produtoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtoList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_produto, parent, false);
        TextView txvNome = convertView.findViewById(R.id.item_list_nome_produto);
        TextView txvPreco = convertView.findViewById(R.id.item_list_preco_produto);
        ImageView imgDelete = convertView.findViewById(R.id.item_list_delete_produto);
        ImageView imgEdit = convertView.findViewById(R.id.item_list_edit_produto);
        
        Produto produto = (Produto) getItem(position);
        
        txvNome.setText(produto.getNome());
        txvPreco.setText(String.valueOf(produto.getPreco()));
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Deletando", Toast.LENGTH_SHORT).show();
            }
        });
        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Editando", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
