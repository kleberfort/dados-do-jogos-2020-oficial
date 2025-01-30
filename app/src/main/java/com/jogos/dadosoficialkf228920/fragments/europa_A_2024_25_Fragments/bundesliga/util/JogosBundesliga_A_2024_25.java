package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.bundesliga.util;

import android.util.Log;

import com.jogos.dadosoficialkf228920.data.brasil.serieA.Jogos_campeonatos_chamada_api;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util.JogosLaLiga_A_2024_2025_Listener;
import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JogosBundesliga_A_2024_25 {

    private JogosBundesliga_A_2024_25_Listener listener;

    private Jogos_campeonatos_chamada_api jogos_campeonatos_chamada_api;

    HashMap<String, Map<String, List<MatchNewModelDate>>> partidasPorTime = new HashMap<>();

    public void setListener(JogosBundesliga_A_2024_25_Listener listener){
        this.listener = listener;
    }

    public void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/refs/heads/master/europa-a-2024-2025/bundesliga/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogos_campeonatos_chamada_api = retrofit.create(Jogos_campeonatos_chamada_api.class);
    }

    public void setupDadosJogos() {
        jogos_campeonatos_chamada_api.getBundesliga2024_25().enqueue(new Callback<List<MatchNewModelDate>>() {
            @Override
            public void onResponse(Call<List<MatchNewModelDate>> call, Response<List<MatchNewModelDate>> response) {
                if(response.isSuccessful()){
                    List<MatchNewModelDate> partidas = response.body();

                    if (partidas != null) {
                        for (MatchNewModelDate partida : partidas) {
                            // Time da casa
                            String homeTeam = partida.getHomeTime().getName();
                            partida.setDataFormatada(partida.getDate());
                            partidasPorTime
                                    .computeIfAbsent(homeTeam, k -> new HashMap<>())
                                    .computeIfAbsent("casa", k -> new ArrayList<>())
                                    .add(partida);

                            // Time visitante
                            String awayTeam = partida.getAwayTime().getName();
                            partidasPorTime
                                    .computeIfAbsent(awayTeam, k -> new HashMap<>())
                                    .computeIfAbsent("fora", k -> new ArrayList<>())
                                    .add(partida);
                        }
                    }else {
                        Log.e("API_ERROR", "Erro ao carregar partidas: " + response.message());
                    }


                }
                if(listener != null){
                    listener.onJogosBundesliga_A(partidasPorTime);
                }

            }


            @Override
            public void onFailure(Call<List<MatchNewModelDate>> call, Throwable t) {
                Log.e("API_ERROR", "Falha ao carregar partidas", t);
            }
        });


    }

}
