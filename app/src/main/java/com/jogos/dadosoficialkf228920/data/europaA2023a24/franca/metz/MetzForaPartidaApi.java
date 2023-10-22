package com.jogos.dadosoficialkf228920.data.europaA2023a24.franca.metz;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MetzForaPartidaApi {

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMetzFora();
}
