package com.jogos.dadosoficialkf228920.data.europaA2023a24.espanhol;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesEspanholA2023a24Api {

    @GET("lista-espanhol-a-2023-24-estruturado.json")
    Call<List<TimeClassificacao>> getTimesEspanholA2023a2024();

}
