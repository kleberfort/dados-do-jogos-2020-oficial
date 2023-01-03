package com.jogos.dadosoficialkf2289.model;

import com.google.gson.annotations.SerializedName;

public class PrimeiroMarcarEscanteios {

    @SerializedName("tres")
    private String three;
    @SerializedName("cinco")
    private String five;
    @SerializedName("sete")
    private String seven;
    @SerializedName("nove")
    private String nine;


    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSeven() {
        return seven;
    }

    public void setSeven(String seven) {
        this.seven = seven;
    }

    public String getNine() {
        return nine;
    }

    public void setNine(String nine) {
        this.nine = nine;
    }
}
