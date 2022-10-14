package com.example.dadosdosjogos2020oficial.data.alemanhaA2022a23.werderbremen;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WerderBremenForaA2022a23PartidaApi {

    @GET("fora-a-2022.json")
    Call<List<Partida>> getWerderBremenora();
}
