package com.jogos.dadosoficialkf228920.data.italiaA2022a23;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesItalianoA2022a23Api {
    @GET("lista-italia-a-2022-2023-estruturado.json")
    Call<List<TimeClassificacao>> getTimesItalianoA2022a2023();
}
