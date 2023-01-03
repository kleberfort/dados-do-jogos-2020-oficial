package com.jogos.dadosoficialkf2289.data.inglesA2022a23.manchesterunited;

import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ManchesterUnitedForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getManchesterUnitedCasa();
}
