package com.jogos.dadosoficialkf228920.data.alemanhaA2022a23.wolfsburg;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WolfsburgForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getWolfsburgFora();
}
