package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Time implements Parcelable {

    @SerializedName("nome")
    private String name;

    @SerializedName("imagem")
    private String image;

    @SerializedName("classificacao")
    private int classification;

    @SerializedName("placar")
    private int score;

    @SerializedName("gols")
    private List<PlayedNameGols> goals;

    // Construtor padrão
    public Time() {
    }

    // Construtor completo
    public Time(String name, String image, int classification, int score, List<PlayedNameGols> goals) {
        this.name = name;
        this.image = image;
        this.classification = classification;
        this.score = score;
        this.goals = goals;
    }

    // Construtor para Parcelable
    protected Time(Parcel in) {
        name = in.readString();
        image = in.readString();
        classification = in.readInt();
        score = in.readInt();
        goals = in.createTypedArrayList(PlayedNameGols.CREATOR);
    }

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
        dest.writeTypedList(goals);
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
public List<PlayedNameGols> getGoals() {
    return goals;
}

public void setGoals(List<PlayedNameGols> goals) {
    this.goals = goals;
}

// Método toString
@Override
public String toString() {
    return "Time{" +
            "name='" + name + '\'' +
            ", image='" + image + '\'' +
            ", classification=" + classification +
            ", score=" + score +
            ", goals=" + goals +
            '}';
}
}
