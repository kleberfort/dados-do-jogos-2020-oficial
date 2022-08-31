package com.example.dadosdosjogos2020oficial.data;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PartidaApi {
    @GET("casaA2022.json")
    Call<List<Partida>> getPartidas();
}
