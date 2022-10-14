package com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23;

import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesAlemaoA2022a23Api {

    @GET("lista-alemao-a-2022-2023.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesAlemaoA2022a2023();
}
