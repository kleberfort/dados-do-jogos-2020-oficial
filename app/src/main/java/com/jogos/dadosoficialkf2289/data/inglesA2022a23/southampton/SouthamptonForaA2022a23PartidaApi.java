package com.jogos.dadosoficialkf2289.data.inglesA2022a23.southampton;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SouthamptonForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getSouthamptonCasa();
}
