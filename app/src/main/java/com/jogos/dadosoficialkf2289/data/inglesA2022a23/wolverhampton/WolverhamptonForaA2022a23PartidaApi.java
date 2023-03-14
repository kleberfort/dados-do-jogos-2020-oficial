package com.jogos.dadosoficialkf2289.data.inglesA2022a23.wolverhampton;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WolverhamptonForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getWolverhamptonFora();
}
