package com.example.dadosdosjogos2020oficial.data.espanhaA2022a23.espanyol;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EspanyolCasaA2022a23PartidaApi {

    @GET("casa-a-2022.json")
    Call<List<Partida>> getEspanyolCasa();
}
