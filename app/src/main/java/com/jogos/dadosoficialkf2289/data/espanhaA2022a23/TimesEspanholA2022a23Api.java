package com.jogos.dadosoficialkf2289.data.espanhaA2022a23;

import com.jogos.dadosoficialkf2289.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesEspanholA2022a23Api {

    @GET("lista-espanhol-a-2022-23.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesEspanholA2022a2023();

}
