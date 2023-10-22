package com.jogos.dadosoficialkf228920.data.europaA2023a24.alemanha.werderbremen;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WerderBremenForaPartidaApi {

    @GET("fora-a-2023-24.json")
    Call<List<Partida>> getWerderBremenora();
}
