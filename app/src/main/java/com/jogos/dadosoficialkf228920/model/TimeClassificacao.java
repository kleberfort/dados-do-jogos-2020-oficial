package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TimeClassificacao implements Comparable<TimeClassificacao>  {

    @SerializedName("nome")
    private String name;
    @SerializedName("imagem")
    private String image;
    @SerializedName("jogoscasa")
    private List<Jogos> homeTime;
    @SerializedName("jogosfora")
    private List<Jogos> awayTime;

    private Integer jogos;
    private Integer golsPro;
    private Integer golsContra;
    private Integer saldoGols;
    private Integer pontos;
    private Integer vitoria;
    private Integer empate;
    private Integer derrota;

    public TimeClassificacao() {
    }

    public TimeClassificacao(String name, String image, Integer jogos, Integer golsPro, Integer golsContra, Integer saldoGols, Integer pontos, Integer vitoria, Integer empate, Integer derrota) {
        this.name = name;
        this.image = image;
        this.jogos = jogos;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.saldoGols = saldoGols;
        this.pontos = pontos;
        this.vitoria = vitoria;
        this.empate = empate;
        this.derrota = derrota;
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

    public List<Jogos> getHomeTime() {
        return homeTime;
    }

    public void setHomeTime(List<Jogos> homeTime) {
        this.homeTime = homeTime;
    }

    public List<Jogos> getAwayTime() {
        return awayTime;
    }

    public void setAwayTime(List<Jogos> awayTime) {
        this.awayTime = awayTime;
    }

    public Integer getJogos() {
        return jogos;
    }

    public void setJogos(Integer jogos) {
        this.jogos = jogos;
    }

    public Integer getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(Integer golsPro) {
        this.golsPro = golsPro;
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(Integer golsContra) {
        this.golsContra = golsContra;
    }

    public Integer getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(Integer saldoGols) {
        this.saldoGols = saldoGols;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Integer getVitoria() {
        return vitoria;
    }

    public void setVitoria(Integer vitoria) {
        this.vitoria = vitoria;
    }

    public Integer getEmpate() {
        return empate;
    }

    public void setEmpate(Integer empate) {
        this.empate = empate;
    }

    public Integer getDerrota() {
        return derrota;
    }

    public void setDerrota(Integer derrota) {
        this.derrota = derrota;
    }


    @Override
    public int compareTo(TimeClassificacao timeClassificacao) {
        return this.getName().compareToIgnoreCase(timeClassificacao.getName());
    }
}
