package com.jogos.dadosoficialkf228920.data.espanhaA2022a23.rayovallecano;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RayoVallecanoCasaA2022a23PartidaApi {

    @GET("casa-a-2022-23.json")
    Call<List<Partida>> getRayoVallecanoCasa();
}
