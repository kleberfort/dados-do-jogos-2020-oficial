package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class EstatisticaCartoes implements Parcelable {

    @SerializedName("cartoesAmareloPrimeiroTempo")
    private int cartaoAmareloPrimeiroTempo;

    @SerializedName("cartoesAmareloSegundoTempo")
    private int cartaoAmareloSegundoTempo;

    @SerializedName("cartoesVermelhoPrimeiroTempo")
    private int cartaoVermelhoPrimeiroTempo;

    @SerializedName("cartoesVermelhoSegundoTempo")
    private int cartaoVermelhoSegundoTempo;

    // Construtor padrão
    public EstatisticaCartoes() {
    }

    // Construtor para Parcelable
    protected EstatisticaCartoes(Parcel in) {
        cartaoAmareloPrimeiroTempo = in.readInt();
        cartaoAmareloSegundoTempo = in.readInt();
        cartaoVermelhoPrimeiroTempo = in.readInt();
        cartaoVermelhoSegundoTempo = in.readInt();
    }

    // Creator para Parcelable
    public static final Creator<EstatisticaCartoes> CREATOR = new Creator<EstatisticaCartoes>() {
        @Override
        public EstatisticaCartoes createFromParcel(Parcel in) {
            return new EstatisticaCartoes(in);
        }

        @Override
        public EstatisticaCartoes[] newArray(int size) {
            return new EstatisticaCartoes[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cartaoAmareloPrimeiroTempo);
        dest.writeInt(cartaoAmareloSegundoTempo);
        dest.writeInt(cartaoVermelhoPrimeiroTempo);
        dest.writeInt(cartaoVermelhoSegundoTempo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters e Setters
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
