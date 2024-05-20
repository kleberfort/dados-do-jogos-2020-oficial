package com.jogos.dadosoficialkf228920.data.europaA2023a24.espanhol;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JogosEspanholCasaFora2023_24Api {

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getAlavesCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getAlavesFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getAlmeriaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getAlmeriaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getAthleticBilbaoCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getAthleticBilbaoFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getAtleticoMadridCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getAtleticoMadridFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getBarcelonaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getBarcelonaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getCadizCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getCadizFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getCeltaVigoCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getCeltaVigoFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getGetafeCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getGetafeFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getGironaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getGironaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getGranadaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getGranadaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getLasPalmasCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getLasPalmasFora();


    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getMallorcaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMallorcaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getOsasunaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getOsasunaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getRayoVallecanoCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getRayoVallecanoFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getRealBetisCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getRealBetisFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getRealMadridCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getRealMadridFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getRealSociedadCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getRealSociedadFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getSevillaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getSevillaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getValenciaCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getValenciaFora();

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getVillarrealCasa();

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getVillarrealFora();

}
