package com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.atleticoGO;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AtleticoGoCasaA2022PartidaApi {

    @GET("casa-a-2022.json")
    Call<List<Partida>> getAtleticoGoCasa();
}
