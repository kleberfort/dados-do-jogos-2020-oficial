package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PartidaNovoModelo {

    @SerializedName("descricao")
    private String description;
    @SerializedName("rodada")
    private int round;
    @SerializedName("data")
    private String date;

    private LocalDate dataFormatada;

    @SerializedName("mandante")
    private Time homeTime;
    @SerializedName("visitante")
    private Time awayTime;
    @SerializedName("EstatisticaCartoesMandante")
    private EstatisticaCartoes homeCartoes;
    @SerializedName("EstatisticaCartoesVisitante")
    private EstatisticaCartoes awayCartoes;

    @SerializedName("estatistiticaJogoMandante")
    private EstatisticaJogo homeEstatisticaJogo;
    @SerializedName("estatisticaJogoVisitante")
    private EstatisticaJogo awayEstatisticaJogo;

    public LocalDate getDataFormatada() {
        return dataFormatada;
    }


    public void setDataFormatada(String dataFormatada) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataFormatada = LocalDate.parse(date, formatter);
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EstatisticaCartoes getHomeCartoes() {
        return homeCartoes;
    }

    public void setHomeCartoes(EstatisticaCartoes homeCartoes) {
        this.homeCartoes = homeCartoes;
    }

    public EstatisticaCartoes getAwayCartoes() {
        return awayCartoes;
    }

    public void setAwayCartoes(EstatisticaCartoes awayCartoes) {
        this.awayCartoes = awayCartoes;
    }

    public EstatisticaJogo getHomeEstatisticaJogo() {
        return homeEstatisticaJogo;
    }

    public void setHomeEstatisticaJogo(EstatisticaJogo homeEstatisticaJogo) {
        this.homeEstatisticaJogo = homeEstatisticaJogo;
    }

    public EstatisticaJogo getAwayEstatisticaJogo() {
        return awayEstatisticaJogo;
    }

    public void setAwayEstatisticaJogo(EstatisticaJogo awayEstatisticaJogo) {
        this.awayEstatisticaJogo = awayEstatisticaJogo;
    }

    public String getName() {
        return description;
    }

    public void setName(String name) {
        this.description = name;
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



