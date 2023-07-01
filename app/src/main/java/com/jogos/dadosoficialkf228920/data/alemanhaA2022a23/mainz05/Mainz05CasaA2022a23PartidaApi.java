package com.jogos.dadosoficialkf228920.data.alemanhaA2022a23.mainz05;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Mainz05CasaA2022a23PartidaApi {

    @GET("casa-a-2022-23.json")
    Call<List<Partida>> getMainz05Casa();
}
