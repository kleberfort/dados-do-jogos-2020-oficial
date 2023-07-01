package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

public class EstatisticaJogo {
    @SerializedName("escanteiosPrimeiroTempo")
    private int escanteiosPrimeiroTempo;
    @SerializedName("escanteiosSegundoTempo")
    private int escanteioSegundoTempo;
    @SerializedName("golsPrimeiroTempo")
    private int golsPrimeiroTempo;
    @SerializedName("golsSegundoTempo")
    private int golsSegundoTempo;

    private int escanteiosTotalPrimeiroTempo;
    private int escanteiosTotalSegundoTempo;
    private int golsTotalPrimeiroTempo;
    private int golsTotalSegundoTempo;

    public int getEscanteiosPrimeiroTempo() {
        return escanteiosPrimeiroTempo;
    }

    public void setEscanteiosPrimeiroTempo(int escanteiosPrimeiroTempo) {
        this.escanteiosPrimeiroTempo = escanteiosPrimeiroTempo;
    }

    public int getEscanteioSegundoTempo() {
        return escanteioSegundoTempo;
    }

    public void setEscanteioSegundoTempo(int escanteioSegundoTempo) {
        this.escanteioSegundoTempo = escanteioSegundoTempo;
    }

    public int getEscanteiosTotalPrimeiroTempo() {
        return escanteiosTotalPrimeiroTempo;
    }

    public void setEscanteiosTotalPrimeiroTempo(int escanteiosTotalPrimeiroTempo) {
        this.escanteiosTotalPrimeiroTempo = escanteiosTotalPrimeiroTempo;
    }

    public int getEscanteiosTotalSegundoTempo() {
        return escanteiosTotalSegundoTempo;
    }

    public void setEscanteiosTotalSegundoTempo(int escanteiosTotalSegundoTempo) {
        this.escanteiosTotalSegundoTempo = escanteiosTotalSegundoTempo;
    }

    public int getGolsPrimeiroTempo() {
        return golsPrimeiroTempo;
    }

    public void setGolsPrimeiroTempo(int golsPrimeiroTempo) {
        this.golsPrimeiroTempo = golsPrimeiroTempo;
    }

    public int getGolsSegundoTempo() {
        return golsSegundoTempo;
    }

    public void setGolsSegundoTempo(int golsSegundoTempo) {
        this.golsSegundoTempo = golsSegundoTempo;
    }

    public int getGolsTotalPrimeiroTempo() {
        return golsTotalPrimeiroTempo;
    }

    public void setGolsTotalPrimeiroTempo(int golsTotalPrimeiroTempo) {
        this.golsTotalPrimeiroTempo = golsTotalPrimeiroTempo;
    }

    public int getGolsTotalSegundoTempo() {
        return golsTotalSegundoTempo;
    }

    public void setGolsTotalSegundoTempo(int golsTotalSegundoTempo) {
        this.golsTotalSegundoTempo = golsTotalSegundoTempo;
    }
}
