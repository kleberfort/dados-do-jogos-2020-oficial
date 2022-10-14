package com.example.dadosdosjogos2020oficial.data.espanhaA2022a23;

import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesEspanholA2022a23Api {

    @GET("lista-espanhol-a-2022-23.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesEspanholA2022a2023();

}
