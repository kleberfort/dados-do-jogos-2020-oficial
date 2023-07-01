package com.jogos.dadosoficialkf228920.data.brasileiroSerieA2022.internacional;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InternacionalForaA2022PartidaApi {

    @GET("fora-a-2022.json")
    Call<List<Partida>> getInternacionalFora();
}
