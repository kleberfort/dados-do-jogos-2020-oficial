package com.jogos.dadosoficialkf2289.data.francaA2022a23;

import com.jogos.dadosoficialkf2289.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesFrancesA2022a23Api {

    @GET("lista-frances-a-2022-2023.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesFrancesA2022a2023();

}
