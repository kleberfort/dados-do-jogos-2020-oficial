package com.jogos.dadosoficialkf2289.data.brasileiroSerieA2022.santos;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SantosForaA2022PartidaApi {

    @GET("fora-a-2022.json")
    Call<List<Partida>> getSantosFora();
}
