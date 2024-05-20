package com.jogos.dadosoficialkf228920.data.europaA2023a24.alemanha;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JogosAlemaoCasaFora2023_24Api {

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getAugsburgCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getAugsburgFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getBayerLeverkusenCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getBayerLeverkusenFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getBayernMuniqueCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getBayernMuniqueFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getBochumCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getBochumFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getBorussiaDortmundCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getBorussiaDortmundFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getBorussiaMoncheCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getBorussiaMoncheFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getDarmstadtCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getDarmstadtFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getEintrachtFrankfurtCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getEintrachtFrankfurtFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getFreiburgCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getFreiburgFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getHoffenheimCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getHoffenheimFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getHeidenheimCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getHeidenheimFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getKolnCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getKolnFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLeipzigCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLeipzigFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getMainzCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMainzFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getStuttgartCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getStuttgartFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getUnionBerlinCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getUnionBerlinFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getWerderBremenCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getWerderBremenFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getWolfsburgCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getWolfsburgFora();

}
