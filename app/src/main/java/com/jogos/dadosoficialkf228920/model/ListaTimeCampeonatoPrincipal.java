package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

public class ListaTimeCampeonatoPrincipal {

    @SerializedName("nome")
    private String name;
    @SerializedName("imagem")
    private String image;


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
}
