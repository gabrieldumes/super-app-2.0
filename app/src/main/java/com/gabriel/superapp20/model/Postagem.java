package com.gabriel.superapp20.model;

public class Postagem {

    private String nome, legenda;
    private int imagem;

    public Postagem() {

    }

    public Postagem(String nome, String legenda, int imagem) {

        this.nome = nome;
        this.legenda = legenda;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
