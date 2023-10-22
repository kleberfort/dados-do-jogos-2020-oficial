package com.jogos.dadosoficialkf228920.data.europaA2023a24.italia;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesItalianoA2023a24Api {

    @GET("lista-italia-a-2023-24-estruturado.json")
    Call<List<TimeClassificacao>> getTimesItalianoA2023a2024();
}
