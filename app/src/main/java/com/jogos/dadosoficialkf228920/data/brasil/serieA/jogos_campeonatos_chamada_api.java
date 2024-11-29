package com.jogos.dadosoficialkf228920.data.brasil.serieA;

import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface jogos_campeonatos_chamada_api {
    @GET("all-matchs-serie-a.json")
    Call<List<PartidaNovoModelo>> getSerieA();

    @GET("all-matchs-serie-b-2024.json")
    Call<List<PartidaNovoModelo>> getSerieB();

    @GET("all-matchs-liga-profissional-a-2024-25.json")
    Call<List<PartidaNovoModelo>> getLigaProfissionalA();

    @GET("all-matchs-premier-league-a-2024-2025.json")
    Call<List<PartidaNovoModelo>> getPremierLeagueA2024_2025();


    @GET("all-matchs-la-liga-a-2024-2025.json")
    Call<List<PartidaNovoModelo>> getLaLiga2024_25();



}
