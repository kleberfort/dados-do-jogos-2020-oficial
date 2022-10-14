package com.example.dadosdosjogos2020oficial.data.italiaA2022a23;

import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesA2022a23Api {
    @GET("lista-italiano-a-2022-2023.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesItalianoA2022a2023();
}
