package com.example.dadosdosjogos2020oficial.data.italiaA2022a23.napoli;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NapoliForaA2022a23PartidaApi {

    @GET("fora-a-2022.json")
    Call<List<Partida>> getNapoliFora();
}
