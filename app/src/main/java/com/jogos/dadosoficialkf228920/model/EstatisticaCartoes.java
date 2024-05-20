package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

public class EstatisticaCartoes {
    @SerializedName("cartoesAmareloPrimeiroTempo")

    private int cartaoAmareloPrimeiroTempo;
    @SerializedName("cartoesAmareloSegundoTempo")
    private int cartaoAmareloSegundoTempo;

    @SerializedName("cartoesVermelhoPrimeiroTempo")
    private int cartaoVermelhoPrimeiroTempo;
    @SerializedName("cartoesVermelhoSegundoTempo")
    private int cartaoVermelhoSegundoTempo;


    public int getCartaoAmareloPrimeiroTempo() {
        return cartaoAmareloPrimeiroTempo;
    }

    public void setCartaoAmareloPrimeiroTempo(int cartaoAmareloPrimeiroTempo) {
        this.cartaoAmareloPrimeiroTempo = cartaoAmareloPrimeiroTempo;
    }

    public int getCartaoAmareloSegundoTempo() {
        return cartaoAmareloSegundoTempo;
    }

    public void setCartaoAmareloSegundoTempo(int cartaoAmareloSegundoTempo) {
        this.cartaoAmareloSegundoTempo = cartaoAmareloSegundoTempo;
    }

    public int getCartaoVermelhoPrimeiroTempo() {
        return cartaoVermelhoPrimeiroTempo;
    }

    public void setCartaoVermelhoPrimeiroTempo(int cartaoVermelhoPrimeiroTempo) {
        this.cartaoVermelhoPrimeiroTempo = cartaoVermelhoPrimeiroTempo;
    }

    public int getCartaoVermelhoSegundoTempo() {
        return cartaoVermelhoSegundoTempo;
    }

    public void setCartaoVermelhoSegundoTempo(int cartaoVermelhoSegundoTempo) {
        this.cartaoVermelhoSegundoTempo = cartaoVermelhoSegundoTempo;
    }
}
