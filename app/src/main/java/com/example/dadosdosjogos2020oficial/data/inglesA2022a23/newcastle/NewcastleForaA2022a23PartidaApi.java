package com.example.dadosdosjogos2020oficial.data.inglesA2022a23.newcastle;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewcastleForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getNewcastleCasa();
}
