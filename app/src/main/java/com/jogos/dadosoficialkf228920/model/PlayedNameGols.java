package com.jogos.dadosoficialkf228920.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PlayedNameGols implements Parcelable {

    @SerializedName("jogador")
    private String jogador;

    @SerializedName("tempo")
    private String tempo;

    // Construtor
    public PlayedNameGols() {}

    // Getters e Setters
    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    // Métodos Parcelable
    protected PlayedNameGols(Parcel in) {
        jogador = in.readString();
        tempo = in.readString();
    }

    public static final Creator<PlayedNameGols> CREATOR = new Creator<PlayedNameGols>() {
        @Override
        public PlayedNameGols createFromParcel(Parcel in) {
            return new PlayedNameGols(in);
        }

        @Override
        public PlayedNameGols[] newArray(int size) {
            return new PlayedNameGols[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(jogador);
        dest.writeString(tempo);
    }

    @Override
    public String toString() {
        return "PlayedNameGols{" +
                "jogador='" + jogador + '\'' +
                ", tempo='" + tempo + '\'' +
                '}';
    }
}


