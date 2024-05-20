package com.jogos.dadosoficialkf228920.data.europaA2023a24.italia;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JogosItalianoCasaFora2023_24Api {

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getAtalantaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getAtalantaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getBolognaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getBolognaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getCagliariCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getCagliariFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getEmpoliCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getEmpoliFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getFiorentinaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getFiorentinaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getFrosinoneCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getFrosinoneFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getGenoaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getGenoaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getHellasVeronaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getHellasVeronaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getInterCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getInterFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getJuvetusCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getJuvetusFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLazioCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLazioFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLecceCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLecceFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getMilanCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMilanFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getMonzaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMonzaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getNapoliCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getNapoliFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getRomaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getRomaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getSalernitanaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getSalernitanaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getSassuoloCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getSassuoloFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getTorinoCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getTorinoFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getUdineseCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getUdineseFora();
    
}
