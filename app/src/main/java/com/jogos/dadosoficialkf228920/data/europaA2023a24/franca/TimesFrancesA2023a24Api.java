package com.jogos.dadosoficialkf228920.data.europaA2023a24.franca;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesFrancesA2023a24Api {

    @GET("lista-franca-a-2023-24-estruturado.json")
    Call<List<TimeClassificacao>> getTimesFrancesA2023a2024();

}
