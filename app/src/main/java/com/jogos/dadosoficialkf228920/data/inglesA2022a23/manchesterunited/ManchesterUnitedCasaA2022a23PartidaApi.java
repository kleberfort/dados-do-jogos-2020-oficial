package com.jogos.dadosoficialkf228920.data.inglesA2022a23.manchesterunited;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ManchesterUnitedCasaA2022a23PartidaApi {

    @GET("casa-a-2022-23.json")
    Call<List<Partida>> getManchesterUnitedCasa();
}
