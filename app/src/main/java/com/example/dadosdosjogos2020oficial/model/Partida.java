package com.example.dadosdosjogos2020oficial.model;

import com.google.gson.annotations.SerializedName;

public class Partida {
    @SerializedName("descricao")
    private String name;
    @SerializedName("rodada")
    private int round;
    @SerializedName("data")
    private String date;
    @SerializedName("mandante")
    private Time homeTime;
    @SerializedName("visitante")
    private Time awayTime;

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public int getRodada() {
        return round;
    }

    public void setRodada(int rodada) {
        this.round = rodada;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public Time getHomeTime() {
        return homeTime;
    }

    public void setHomeTime(Time homeTime) {
        this.homeTime = homeTime;
    }

    public Time getAwayTime() {
        return awayTime;
    }

    public void setAwayTime(Time awayTime) {
        this.awayTime = awayTime;
    }
}
