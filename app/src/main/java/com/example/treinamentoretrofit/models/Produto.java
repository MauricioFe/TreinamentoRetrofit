package com.example.treinamentoretrofit.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
@Root(name="Produtos")
public class Produto implements Serializable {
    @Element(name = "Id")
    private int Id;
    @Element(name = "Nome")
    private String Nome;
    @Element(name = "Preco")
    private double Preco;
    @Element(name = "Estoque")
    private int Estoque;
    @Element(name = "Descricao")
    private String Descricao;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public int getEstoque() {
        return Estoque;
    }

    public void setEstoque(int estoque) {
        Estoque = estoque;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
