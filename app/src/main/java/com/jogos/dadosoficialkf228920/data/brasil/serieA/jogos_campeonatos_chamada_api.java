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

}
