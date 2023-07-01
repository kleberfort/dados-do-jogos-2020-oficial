package com.jogos.dadosoficialkf228920.data.brasileiroB2023.novorizontino;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NovorizontinoForaB2023PartidaApi {

    @GET("fora-b-2023.json")
    Call<List<Partida>> getNovorizontinoFora();
}
