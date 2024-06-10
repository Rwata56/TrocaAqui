package com.aulabd2.aulabd2.model;

import java.util.Map;

//POJO - Plain Old Java Object
public class Cliente {
    
    private int id;
    private String nome, email, senha, senhaC;

    //Sobrecarga de construtores
    public Cliente(){

    }

    public Cliente(Map<String,Object> map){
        this.id = (Integer) map.get("id");
        this.nome = (String) map.get("nome");
        this.email = (String) map.get("email");
        this.senha = (String) map.get("senha");
        this.senhaC = (String) map.get("senhaC");
    }

    public Cliente(String nome, String email, String senha, String senhaC ){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.senhaC = senhaC;
    }

    public Cliente(int id, String nome, String email, String senha, String senhaC ){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.senhaC = senhaC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaC() {
        return senhaC;
    }

    public void setSenhaC(String senhaC) {
        this.senhaC = senhaC;
    }

}
