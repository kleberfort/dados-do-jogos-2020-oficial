package com.jogos.dadosoficialkf2289.data.alemanhaA2022a23.hoffenheim;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HoffenheimForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getHoffenheimFora();
}
