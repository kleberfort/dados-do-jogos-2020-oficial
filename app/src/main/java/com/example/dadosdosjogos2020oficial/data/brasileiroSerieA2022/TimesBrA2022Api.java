package com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022;

import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesBrA2022Api {

    @GET("lista-brasileiro-serie-a-2022.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesBrA2022();

 }
