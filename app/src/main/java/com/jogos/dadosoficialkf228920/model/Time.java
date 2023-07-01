package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

public class Time {
    @SerializedName("nome")
    private String name;
    @SerializedName("imagem")
    private String image;
    @SerializedName("classificacao")
    private int classification;
    @SerializedName("placar")
    private int score;



    public Time() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getImagem() {
        return image;
    }

    public void setImagem(String imagem) {
        this.image = imagem;
    }

    public int getClassificacao() {
        return classification;
    }

    public void setClassificacao(int classificacao) {
        this.classification = classificacao;
    }

    public int getPlacar() {
        return score;
    }

    public void setPlacar(int placar) {
        this.score = placar;
    }
}
