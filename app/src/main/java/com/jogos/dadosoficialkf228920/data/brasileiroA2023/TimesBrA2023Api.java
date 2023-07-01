package com.jogos.dadosoficialkf228920.data.brasileiroA2023;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesBrA2023Api {

    @GET("lista-brasileiro-a- 2023-estruturado.json")
    Call<List<TimeClassificacao>> getTimesBrA2023();

 }
