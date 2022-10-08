package com.example.dadosdosjogos2020oficial.data;

import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesInglesA2022a23Api {

    @GET("lista-ingles-a-2022-2023.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesInglesA2022a2023();


}
