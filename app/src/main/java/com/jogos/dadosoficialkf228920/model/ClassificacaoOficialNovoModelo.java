package com.jogos.dadosoficialkf228920.model;

public class ClassificacaoOficialNovoModelo {

    private String nome;
    private String imagem;
    private Integer jogos;
    private Integer golsPro;
    private Integer golsContra;
    private Integer saldoGols;
    private Integer pontos;
    private Integer vitoria;
    private Integer empate;
    private Integer derrota;


    public ClassificacaoOficialNovoModelo(String name, String image, int pontos, int golsPro, int golsContra, int saldoGols, int jogos, int vitoria, int empate, int derrota) {
        this.nome = name;
        this.imagem = image;
        this.pontos = pontos;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.saldoGols = saldoGols;
        this.jogos = jogos;
        this.vitoria = vitoria;
        this.empate = empate;
        this.derrota = derrota;
    }

    public ClassificacaoOficialNovoModelo() {
    }


    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public String getImage() {
        return imagem;
    }

    public void setImage(String image) {
        this.imagem = image;
    }


    public int getPontos() {
        return pontos;
    }

    public void setPontos(int vitoria, int empate) {
        this.pontos = (vitoria * 3 ) + empate;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(int golsPro) {
        this.golsPro += golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra += golsContra;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(int golsPro, int golsContra) {
        this.saldoGols = golsPro - golsContra;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos += jogos;
    }

    public int getVitoria() {
        return vitoria;
    }

    public void setVitoria(int vitoria) {
        this.vitoria += vitoria;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate += empate;
    }

    public int getDerrota() {
        return derrota;
    }

    public void setDerrota(int derrota) {
        this.derrota += derrota;
    }


}
