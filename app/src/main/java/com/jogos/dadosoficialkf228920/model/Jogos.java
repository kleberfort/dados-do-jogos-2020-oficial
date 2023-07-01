package com.jogos.dadosoficialkf228920.model;

import com.google.gson.annotations.SerializedName;

public class Jogos {
  @SerializedName("rodada")
  private int rodada;
  @SerializedName("mandante")
  private JogosDentroLista jogosCasa;
  @SerializedName("visitante")
  private JogosDentroLista jogosFora;


  public int getRodada() {
    return rodada;
  }

  public void setRodada(int rodada) {
    this.rodada = rodada;
  }

  public JogosDentroLista getJogosCasa() {
    return jogosCasa;
  }

  public void setJogosCasa(JogosDentroLista jogosCasa) {
    this.jogosCasa = jogosCasa;
  }

  public JogosDentroLista getJogosFora() {
    return jogosFora;
  }

  public void setJogosFora(JogosDentroLista jogosFora) {
    this.jogosFora = jogosFora;
  }
}
