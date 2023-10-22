package com.jogos.dadosoficialkf228920.data.europaA2023a24.ingles.tottenham;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TottenhamCasaPartidaApi {

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getTottenhamCasa();
}
