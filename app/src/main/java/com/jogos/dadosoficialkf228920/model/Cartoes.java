package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

public class Cartoes {
    @SerializedName("cartoesAmarelo")
    private Integer amarelo;
    @SerializedName("cartoesVermelho")
    private Integer vermelho;

    public Integer getAmarelo() {
        return amarelo;
    }

    public void setAmarelo(Integer amarelo) {
        this.amarelo = amarelo;
    }

    public Integer getVermelho() {
        return vermelho;
    }

    public void setVermelho(Integer vermelho) {
        this.vermelho = vermelho;
    }
}
