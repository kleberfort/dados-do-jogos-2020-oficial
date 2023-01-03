package com.jogos.dadosoficialkf2289.data.espanhaA2022a23.almeria;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlmeriaCasaA2022a23PartidaApi {

    @GET("casa-a-2022-23.json")
    Call<List<Partida>> getAlmeriaCasa();
}
