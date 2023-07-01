package com.jogos.dadosoficialkf228920.data.francaA2022a23;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesFrancesA2022a23Api {

    @GET("lista-franca-a-2022-2023-estruturado.json")
    Call<List<TimeClassificacao>> getTimesFrancesA2022a2023();

}
