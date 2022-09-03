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
    private PrimeiroMarcarEscanteios homeTimeEscanteios;
    private PrimeiroMarcarEscanteios awayTimeEscanteios;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PrimeiroMarcarEscanteios getHomeTimeEscanteios() {
        return homeTimeEscanteios;
    }

    public void setHomeTimeEscanteios(PrimeiroMarcarEscanteios homeTimeEscanteios) {
        this.homeTimeEscanteios = homeTimeEscanteios;
    }

    public PrimeiroMarcarEscanteios getAwayTimeEscanteios() {
        return awayTimeEscanteios;
    }

    public void setAwayTimeEscanteios(PrimeiroMarcarEscanteios awayTimeEscanteios) {
        this.awayTimeEscanteios = awayTimeEscanteios;
    }

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
