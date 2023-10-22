package com.jogos.dadosoficialkf228920.data.europaA2023a24.alemanha;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesAlemaoA2023a24Api {

    @GET("lista-alemao-serie-a-2023-2024-estruturado.json")
    Call<List<TimeClassificacao>> getTimesAlemaoA2023a2024();
}
