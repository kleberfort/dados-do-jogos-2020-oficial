package com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.ceara;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CearaForaA2022PartidaApi {

    @GET("fora-a-2022.json")
    Call<List<Partida>> getCearaFora();

}
