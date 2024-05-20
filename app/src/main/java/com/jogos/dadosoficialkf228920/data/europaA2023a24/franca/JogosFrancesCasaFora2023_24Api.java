package com.jogos.dadosoficialkf228920.data.europaA2023a24.franca;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JogosFrancesCasaFora2023_24Api {

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getBrestCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getBrestFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getClermontCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getClermontFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLeHavreCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLeHavreFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLensCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLensFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLilleCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLilleFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLorientCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLorientFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLyonCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLyonFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getMarseilleCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMarseilleFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getMetzCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMetzFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getMonacoCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMonacoFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getMontpellierCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMontpellierFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getNantesCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getNantesFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getNiceCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getNiceFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getPsgCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getPsgFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getReimsCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getReimsFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getRennesCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getRennesFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getStrasbourgCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getStrasbourgFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getToulouseCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getToulouseFora();

}
