package com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.santos;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SantosCasaA2022PartidaApi {

    @GET("casa-a-2022.json")
    Call<List<Partida>> getSantosCasa();
}
