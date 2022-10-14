package com.example.dadosdosjogos2020oficial.data.francaA2022a23;

import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesFrancesA2022a23Api {

    @GET("lista-frances-a-2022-2023.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesFrancesA2022a2023();

}
