package com.jogos.dadosoficialkf228920.data.brasil.serieA;

import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Jogos_campeonatos_chamada_api {
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

    @GET("all-matchs-serie-a-italia-2024-2025.json")
    Call<List<PartidaNovoModelo>> getSerieAItalia2024_25();

    @GET("all-matchs-bundesliga-a-2024-2025.json")
    Call<List<PartidaNovoModelo>> getBundesliga2024_25();

    @GET("all-matchs-primeira-liga-portugal-a-2024-2025.json")
    Call<List<PartidaNovoModelo>> getPrimeiraLigaPortugal2024_25();

    @GET("all-matchs-ligue1-a-franca-2024-25.json")
    Call<List<PartidaNovoModelo>> getLigue1Franca2024_25();

    @GET("all-matchs-eredivise-paises-baixo-a-2024-2025.json")
    Call<List<PartidaNovoModelo>> getEredivisiePaisesBaixo2024_25();



}
