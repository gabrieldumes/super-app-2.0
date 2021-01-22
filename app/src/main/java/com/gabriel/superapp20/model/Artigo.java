package com.gabriel.superapp20.model;

public class Artigo {

    String titulo, data, artigo, autor;
    int imagem;

    public Artigo() {

    }

    public Artigo(String titulo, String data, String artigo, String autor, int imagem) {

        this.titulo = titulo;
        this.data = data;
        this.artigo = artigo;
        this.autor = autor;
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getArtigo() {
        return artigo;
    }

    public void setArtigo(String artigo) {
        this.artigo = artigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
