package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class EstatisticaJogo implements Parcelable {

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

    // Construtor padrão
    public EstatisticaJogo() {
    }

    // Construtor para Parcelable
    protected EstatisticaJogo(Parcel in) {
        escanteiosPrimeiroTempo = in.readInt();
        escanteioSegundoTempo = in.readInt();
        golsPrimeiroTempo = in.readInt();
        golsSegundoTempo = in.readInt();
        escanteiosTotalPrimeiroTempo = in.readInt();
        escanteiosTotalSegundoTempo = in.readInt();
        golsTotalPrimeiroTempo = in.readInt();
        golsTotalSegundoTempo = in.readInt();
    }

    // Creator para Parcelable
    public static final Creator<EstatisticaJogo> CREATOR = new Creator<EstatisticaJogo>() {
        @Override
        public EstatisticaJogo createFromParcel(Parcel in) {
            return new EstatisticaJogo(in);
        }

        @Override
        public EstatisticaJogo[] newArray(int size) {
            return new EstatisticaJogo[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(escanteiosPrimeiroTempo);
        dest.writeInt(escanteioSegundoTempo);
        dest.writeInt(golsPrimeiroTempo);
        dest.writeInt(golsSegundoTempo);
        dest.writeInt(escanteiosTotalPrimeiroTempo);
        dest.writeInt(escanteiosTotalSegundoTempo);
        dest.writeInt(golsTotalPrimeiroTempo);
        dest.writeInt(golsTotalSegundoTempo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters e Setters
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

    @Override
    public String toString() {
        return "EstatisticaJogo{" +
                "escanteiosPrimeiroTempo=" + escanteiosPrimeiroTempo +
                ", escanteioSegundoTempo=" + escanteioSegundoTempo +
                ", golsPrimeiroTempo=" + golsPrimeiroTempo +
                ", golsSegundoTempo=" + golsSegundoTempo +
                ", escanteiosTotalPrimeiroTempo=" + escanteiosTotalPrimeiroTempo +
                ", escanteiosTotalSegundoTempo=" + escanteiosTotalSegundoTempo +
                ", golsTotalPrimeiroTempo=" + golsTotalPrimeiroTempo +
                ", golsTotalSegundoTempo=" + golsTotalSegundoTempo +
                '}';
    }
}
