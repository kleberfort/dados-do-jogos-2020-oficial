package com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.bayerleverkusen;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BayerLeverkusenCasaA2022a23PartidaApi {

    @GET("casa-a-2022.json")
    Call<List<Partida>> getBayerLeverkusenCasa();
}
