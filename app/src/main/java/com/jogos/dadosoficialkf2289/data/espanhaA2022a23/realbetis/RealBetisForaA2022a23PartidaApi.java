package com.jogos.dadosoficialkf2289.data.espanhaA2022a23.realbetis;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RealBetisForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getRealBetisFora();
}
