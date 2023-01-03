package com.jogos.dadosoficialkf2289.data.brasileiroSerieA2022;

import com.jogos.dadosoficialkf2289.model.ListaTimeCampeonatoPrincipal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimesBrA2022Api {

    @GET("lista-brasileiro-serie-a-2022.json")
    Call<List<ListaTimeCampeonatoPrincipal>> getTimesBrA2022();

 }
