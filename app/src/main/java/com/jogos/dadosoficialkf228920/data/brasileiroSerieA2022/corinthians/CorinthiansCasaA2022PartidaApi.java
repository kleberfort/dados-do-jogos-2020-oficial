package com.jogos.dadosoficialkf228920.data.brasileiroSerieA2022.corinthians;

import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CorinthiansCasaA2022PartidaApi {

    @GET("casa-a-2022.json")
    Call<List<Partida>> getCorinthiansCasa();
}
