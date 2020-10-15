package com.example.treinamentoretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Usuario implements Serializable {
    @SerializedName("id")
    @Expose
    private int Id;
    @SerializedName("nome")
    @Expose
    private String Nome;
    @SerializedName("email")
    @Expose
    private String Email;
    @SerializedName("telefone")
    @Expose
    private String Telefone;
    @SerializedName("senha")
    @Expose
    private String Senha;
    @SerializedName("funcaoId")
    @Expose
    private int FuncaoId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public int getFuncaoId() {
        return FuncaoId;
    }

    public void setFuncaoId(int funcaoId) {
        FuncaoId = funcaoId;
    }
}
