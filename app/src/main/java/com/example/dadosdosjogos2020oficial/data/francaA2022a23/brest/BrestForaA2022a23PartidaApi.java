package com.example.dadosdosjogos2020oficial.data.francaA2022a23.brest;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrestForaA2022a23PartidaApi {

    @GET("fora-a-2022.json")
    Call<List<Partida>> getBrestFora();
}
