package com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.wolfsburg;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WolfsburgForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getWolfsburgFora();
}
