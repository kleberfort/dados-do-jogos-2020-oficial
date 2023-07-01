package com.jogos.dadosoficialkf228920.data.brasileiroA2023.atleticoPR;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AtleticoPrCasaA2023PartidaApi {

    @GET("casa-a-2023.json")
    Call<List<Partida>> getAtleticoPrCasa();
}
