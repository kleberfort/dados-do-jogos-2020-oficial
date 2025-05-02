package com.jogos.dadosoficialkf228920.data.brasil.partidas;

import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.partidas.RoundPartida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Jogos_Partidas_chamda_api {

    @GET("partidas-premier-league.json")
    Call<List<RoundPartida>> getPartidasPremierLeague2024();

}
