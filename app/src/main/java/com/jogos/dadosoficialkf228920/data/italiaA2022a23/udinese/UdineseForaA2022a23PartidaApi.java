package com.jogos.dadosoficialkf228920.data.italiaA2022a23.udinese;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UdineseForaA2022a23PartidaApi {

    @GET("fora-a-2022-23.json")
    Call<List<Partida>> getUdineseFora();
}
