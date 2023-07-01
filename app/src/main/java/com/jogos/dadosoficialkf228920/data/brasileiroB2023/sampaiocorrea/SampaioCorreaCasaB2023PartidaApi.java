package com.jogos.dadosoficialkf228920.data.brasileiroB2023.sampaiocorrea;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SampaioCorreaCasaB2023PartidaApi {

    @GET("casa-b-2023.json")
    Call<List<Partida>> getSampaioCorreaCasa();
}
