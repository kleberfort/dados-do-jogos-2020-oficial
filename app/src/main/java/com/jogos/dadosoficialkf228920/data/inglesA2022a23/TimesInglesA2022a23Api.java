package com.jogos.dadosoficialkf228920.data.inglesA2022a23;

import com.jogos.dadosoficialkf228920.model.TimeClassificacao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesInglesA2022a23Api {

    @GET("teste-estruturando-dados.json")
    Call<List<TimeClassificacao>> getTimesInglesA2022a2023();


}
