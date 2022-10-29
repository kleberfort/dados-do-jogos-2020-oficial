package com.example.dadosdosjogos2020oficial.data.italiaA2022a23.bologna;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BolognaForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getBolognaFora();
}
