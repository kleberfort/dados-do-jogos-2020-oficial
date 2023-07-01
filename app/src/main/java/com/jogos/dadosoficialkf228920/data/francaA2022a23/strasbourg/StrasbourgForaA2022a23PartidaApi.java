package com.jogos.dadosoficialkf228920.data.francaA2022a23.strasbourg;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StrasbourgForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getStrasbourgFora();
}
