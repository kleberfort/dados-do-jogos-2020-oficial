package com.jogos.dadosoficialkf228920.data.brasileiroA2023.vasco;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VascoForaA2023PartidaApi {

    @GET("fora-a-2023.json")
    Call<List<Partida>> getVascoFora();
}
