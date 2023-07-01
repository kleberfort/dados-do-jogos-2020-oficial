package com.jogos.dadosoficialkf228920.data.italiaA2022a23.napoli;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NapoliForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getNapoliFora();
}
