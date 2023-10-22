package com.jogos.dadosoficialkf228920.data.europaA2023a24.franca.montpellier;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MontpellierForaPartidaApi {

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getMontpellierFora();
}
