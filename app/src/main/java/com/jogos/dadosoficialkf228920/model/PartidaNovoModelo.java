package com.jogos.dadosoficialkf228920.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PartidaNovoModelo implements Parcelable {

    @SerializedName("descricao")
    private String description;

    @SerializedName("rodada")
    private int round;

    @SerializedName("data")
    private String date;

    private LocalDate dataFormatada;

    @SerializedName("mandante")
    private Time homeTime;

    @SerializedName("visitante")
    private Time awayTime;

    @SerializedName("EstatisticaCartoesMandante")
    private EstatisticaCartoes homeCartoes;

    @SerializedName("EstatisticaCartoesVisitante")
    private EstatisticaCartoes awayCartoes;

    @SerializedName("estatistiticaJogoMandante")
    private EstatisticaJogo homeEstatisticaJogo;

    @SerializedName("estatisticaJogoVisitante")
    private EstatisticaJogo awayEstatisticaJogo;

    // Construtor padrão
    public PartidaNovoModelo() {}

    // Construtor para Parcelable
    protected PartidaNovoModelo(Parcel in) {
        description = in.readString();
        round = in.readInt();
        date = in.readString();
        dataFormatada = (LocalDate) in.readSerializable();
        homeTime = in.readParcelable(Time.class.getClassLoader());
        awayTime = in.readParcelable(Time.class.getClassLoader());
        homeCartoes = in.readParcelable(EstatisticaCartoes.class.getClassLoader());
        awayCartoes = in.readParcelable(EstatisticaCartoes.class.getClassLoader());
        homeEstatisticaJogo = in.readParcelable(EstatisticaJogo.class.getClassLoader());
        awayEstatisticaJogo = in.readParcelable(EstatisticaJogo.class.getClassLoader());
    }

    public static final Creator<PartidaNovoModelo> CREATOR = new Creator<PartidaNovoModelo>() {
        @Override
        public PartidaNovoModelo createFromParcel(Parcel in) {
            return new PartidaNovoModelo(in);
        }

        @Override
        public PartidaNovoModelo[] newArray(int size) {
            return new PartidaNovoModelo[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeInt(round);
        dest.writeString(date);
        dest.writeSerializable(dataFormatada);
        dest.writeParcelable(homeTime, flags);
        dest.writeParcelable(awayTime, flags);
        dest.writeParcelable(homeCartoes, flags);
        dest.writeParcelable(awayCartoes, flags);
        dest.writeParcelable(homeEstatisticaJogo, flags);
        dest.writeParcelable(awayEstatisticaJogo, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters e Setters
    public LocalDate getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataFormatada = LocalDate.parse(date, formatter);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EstatisticaCartoes getHomeCartoes() {
        return homeCartoes;
    }

    public void setHomeCartoes(EstatisticaCartoes homeCartoes) {
        this.homeCartoes = homeCartoes;
    }

    public EstatisticaCartoes getAwayCartoes() {
        return awayCartoes;
    }

    public void setAwayCartoes(EstatisticaCartoes awayCartoes) {
        this.awayCartoes = awayCartoes;
    }

    public EstatisticaJogo getHomeEstatisticaJogo() {
        return homeEstatisticaJogo;
    }

    public void setHomeEstatisticaJogo(EstatisticaJogo homeEstatisticaJogo) {
        this.homeEstatisticaJogo = homeEstatisticaJogo;
    }

    public EstatisticaJogo getAwayEstatisticaJogo() {
        return awayEstatisticaJogo;
    }

    public void setAwayEstatisticaJogo(EstatisticaJogo awayEstatisticaJogo) {
        this.awayEstatisticaJogo = awayEstatisticaJogo;
    }

    public String getName() {
        return description;
    }

    public void setName(String name) {
        this.description = name;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Time getHomeTime() {
        return homeTime;
    }

    public void setHomeTime(Time homeTime) {
        this.homeTime = homeTime;
    }

    public Time getAwayTime() {
        return awayTime;
    }

    public void setAwayTime(Time awayTime) {
        this.awayTime = awayTime;
    }

    @Override
    public String toString() {
        return "PARTIDAS{" +
                "description='" + description + '\'' +
                ", round=" + round +
                ", date='" + date + '\'' +
                ", dataFormatada=" + dataFormatada +
                ", homeTime=" + homeTime +
                ", awayTime=" + awayTime +
                ", homeCartoes=" + homeCartoes +
                ", awayCartoes=" + awayCartoes +
                ", homeEstatisticaJogo=" + homeEstatisticaJogo +
                ", awayEstatisticaJogo=" + awayEstatisticaJogo +
                '}';
    }
}



