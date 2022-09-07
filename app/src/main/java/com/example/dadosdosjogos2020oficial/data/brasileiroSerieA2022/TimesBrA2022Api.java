package com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022;

import com.example.dadosdosjogos2020oficial.model.Partida;
import com.example.dadosdosjogos2020oficial.model.TimesBrA2022;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesBrA2022Api {

    @GET("lista-brasileiro-serie-a-2022.json")
    Call<List<TimesBrA2022>> getTimesBrA2022();

 }
