package com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.freiburg;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FreiburgCasaA2022a23PartidaApi {

    @GET("casa-a-2022-23.json")
    Call<List<Partida>> getFreiburgCasa();
}
