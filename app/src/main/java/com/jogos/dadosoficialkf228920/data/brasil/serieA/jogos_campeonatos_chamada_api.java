package com.jogos.dadosoficialkf228920.data.brasil.serieA;

import android.service.autofill.FieldClassification;

import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
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
    Call<List<MatchNewModelDate>> getPremierLeagueA2024_2025();

    @GET("all-matchs-la-liga-a-2024-2025.json")
    Call<List<MatchNewModelDate>> getLaLiga2024_25();

    @GET("all-matchs-serie-a-italia-2024-2025.json")
    Call<List<MatchNewModelDate>> getSerieAItalia2024_25();

    @GET("all-matchs-bundesliga-a-2024-2025.json")
    Call<List<MatchNewModelDate>> getBundesliga2024_25();

    @GET("all-matchs-primeira-liga-portugal-a-2024-2025.json")
    Call<List<MatchNewModelDate>> getPrimeiraLigaPortugal2024_25();

    @GET("all-matchs-ligue1-a-franca-2024-25.json")
    Call<List<MatchNewModelDate>> getLigue1Franca2024_25();

    @GET("all-matchs-eredivise-paises-baixo-a-2024-2025.json")
    Call<List<MatchNewModelDate>> getEredivisiePaisesBaixo2024_25();

    @GET("all-matchs-ligacampeoes-2024-2025.json")
    Call<List<MatchNewModelDate>> getLigaCampeoes2024_25();

}
