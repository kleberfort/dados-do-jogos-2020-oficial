package com.jogos.dadosoficialkf2289.data.brasileiroSerieA2022.fortaleza;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FortalezaCasaA2022PartidaApi {

    @GET("casa-a-2022.json")
    Call<List<Partida>> getFortalezaCasa();
}
