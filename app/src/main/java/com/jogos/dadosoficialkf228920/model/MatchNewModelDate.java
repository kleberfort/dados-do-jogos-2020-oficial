package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDate;
import java.util.List;

public class MatchNewModelDate implements Parcelable {

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

    @SerializedName("estatisticaGeralMandante")
    private EstatisticaGeral estatisticaGeralHome;

    @SerializedName("estatisticaGeralVisitante")
    private EstatisticaGeral estatisticaGeralAway;



    public MatchNewModelDate() {
    }

    protected MatchNewModelDate(Parcel in) {
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
        estatisticaGeralHome = in.readParcelable(EstatisticaGeral.class.getClassLoader());
        estatisticaGeralAway = in.readParcelable(EstatisticaGeral.class.getClassLoader());
    }

    public static final Creator<MatchNewModelDate> CREATOR = new Creator<MatchNewModelDate>() {
        @Override
        public MatchNewModelDate createFromParcel(Parcel in) {
            return new MatchNewModelDate(in);
        }

        @Override
        public MatchNewModelDate[] newArray(int size) {
            return new MatchNewModelDate[size];
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
        dest.writeParcelable(estatisticaGeralHome, flags);
        dest.writeParcelable(estatisticaGeralAway, flags);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters and Setters

    public LocalDate getDataFormatada() {
        return dataFormatada;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setDataFormatada(String dataFormatada) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataFormatada = LocalDate.parse(date, formatter);
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

    public EstatisticaGeral getEstatisticaGeralHome() {
        return estatisticaGeralHome;
    }

    public void setEstatisticaGeralHome(EstatisticaGeral estatisticaGeralHome) {
        this.estatisticaGeralHome = estatisticaGeralHome;
    }

    public EstatisticaGeral getEstatisticaGeralAway() {
        return estatisticaGeralAway;
    }

    public void setEstatisticaGeralAway(EstatisticaGeral estatisticaGeralAway) {
        this.estatisticaGeralAway = estatisticaGeralAway;
    }


    @Override
    public String toString() {
        return "MatchNewModelDate{" +
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
                ", estatisticaGeralHome=" + estatisticaGeralHome +
                ", estatisticaGeralAway=" + estatisticaGeralAway +
                '}';
    }
}






