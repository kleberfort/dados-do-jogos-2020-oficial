package com.jogos.dadosoficialkf2289.data.francaA2022a23.troyes;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TroyesCasaA2022a23PartidaApi {

    @GET("casa-a-2022-23.json")
    Call<List<Partida>> getTroyesCasa();
}
