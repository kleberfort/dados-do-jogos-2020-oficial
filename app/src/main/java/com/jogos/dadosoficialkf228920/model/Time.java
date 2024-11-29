package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Time implements Parcelable {

    @SerializedName("nome")
    private String name;

    @SerializedName("imagem")
    private String image;

    @SerializedName("classificacao")
    private int classification;

    @SerializedName("placar")
    private int score;

    // Construtor padrão
    public Time() {
    }

    // Construtor para Parcelable
    protected Time(Parcel in) {
        name = in.readString();
        image = in.readString();
        classification = in.readInt();
        score = in.readInt();
    }

    // Creator para Parcelable
    public static final Creator<Time> CREATOR = new Creator<Time>() {
        @Override
        public Time createFromParcel(Parcel in) {
            return new Time(in);
        }

        @Override
        public Time[] newArray(int size) {
            return new Time[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image);
        dest.writeInt(classification);
        dest.writeInt(score);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters e Setters
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

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getImagem() {
        return image;
    }

    public void setImagem(String imagem) {
        this.image = imagem;
    }

    public int getClassificacao() {
        return classification;
    }

    public void setClassificacao(int classificacao) {
        this.classification = classificacao;
    }

    public int getPlacar() {
        return score;
    }

    public void setPlacar(int placar) {
        this.score = placar;
    }

    @Override
    public String toString() {
        return "Time{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", classification=" + classification +
                ", score=" + score +
                '}';
    }
}
