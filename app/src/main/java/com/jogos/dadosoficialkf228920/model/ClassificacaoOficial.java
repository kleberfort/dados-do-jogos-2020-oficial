package com.jogos.dadosoficialkf228920.model;

public class ClassificacaoOficial implements Comparable<ClassificacaoOficial> {

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

    public ClassificacaoOficial() {
    }

    public ClassificacaoOficial(String nome, String imagem, Integer jogos, Integer golsPro, Integer golsContra, Integer saldoGols, Integer pontos, Integer vitoria, Integer empate, Integer derrota) {
        this.nome = nome;
        this.imagem = imagem;
        this.jogos = jogos;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.saldoGols = saldoGols;
        this.pontos = pontos;
        this.vitoria = vitoria;
        this.empate = empate;
        this.derrota = derrota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", imagem='" + imagem + '\'' +
                ", jogos=" + jogos +
                ", golsPro=" + golsPro +
                ", golsContra=" + golsContra +
                ", saldoGols=" + saldoGols +
                ", pontos=" + pontos +
                ", vitoria=" + vitoria +
                ", empate=" + empate +
                ", derrota=" + derrota +
                '}';
    }

    @Override
    public int compareTo(ClassificacaoOficial classificacaoOficial) {
        return this.getPontos().compareTo(classificacaoOficial.pontos);


    }
}
