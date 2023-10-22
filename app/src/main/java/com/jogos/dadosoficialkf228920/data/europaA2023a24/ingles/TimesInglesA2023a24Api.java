package com.jogos.dadosoficialkf228920.data.europaA2023a24.ingles;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesInglesA2023a24Api {

    @GET("lista-ingles-a-2023-24-estruturado.json")
    Call<List<TimeClassificacao>> getTimesInglesA2023a2024();


}
