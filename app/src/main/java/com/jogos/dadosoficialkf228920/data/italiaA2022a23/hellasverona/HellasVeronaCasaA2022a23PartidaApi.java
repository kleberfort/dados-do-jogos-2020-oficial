package com.jogos.dadosoficialkf228920.data.italiaA2022a23.hellasverona;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HellasVeronaCasaA2022a23PartidaApi {

    @GET("casa-a-2022-23.json")
    Call<List<Partida>> getHellasVeronaCasa();
}
