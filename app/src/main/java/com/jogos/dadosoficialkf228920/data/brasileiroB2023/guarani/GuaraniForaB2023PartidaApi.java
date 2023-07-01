package com.jogos.dadosoficialkf228920.data.brasileiroB2023.guarani;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GuaraniForaB2023PartidaApi {

    @GET("fora-b-2023.json")
    Call<List<Partida>> getGuaraniFora();
}
