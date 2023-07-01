package com.jogos.dadosoficialkf228920.data.brasileiroB2023;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesBrB2023Api {

    @GET("lista-brasileiro-serie-b-2023-estruturado.json")
    Call<List<TimeClassificacao>> getTimesBrB2023();

 }
