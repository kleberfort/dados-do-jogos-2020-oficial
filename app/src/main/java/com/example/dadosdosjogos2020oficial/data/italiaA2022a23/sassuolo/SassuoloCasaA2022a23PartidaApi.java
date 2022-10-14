package com.example.dadosdosjogos2020oficial.data.italiaA2022a23.sassuolo;

import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SassuoloCasaA2022a23PartidaApi {

    @GET("casa-a-2022.json")
    Call<List<Partida>> getSassuoloCasa();
}
