package com.jogos.dadosoficialkf228920.data.europaA2023a24.ingles.astonvilla;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AstonVillaCasaPartidaApi {

    @GET("casa-a-2023-24.json")
    Call<List<Partida>> getAstonVillaCasa();//os dois fragments pode usar o  AstonVillaCasaPartidaApi



}
