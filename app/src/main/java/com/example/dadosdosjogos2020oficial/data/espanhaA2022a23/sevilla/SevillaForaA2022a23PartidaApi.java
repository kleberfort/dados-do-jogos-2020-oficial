package com.example.dadosdosjogos2020oficial.data.espanhaA2022a23.sevilla;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SevillaForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getSevillaFora();
}
