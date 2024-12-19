package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.primeiraLiga.util;

import android.util.Log;

import com.jogos.dadosoficialkf228920.data.brasil.serieA.Jogos_campeonatos_chamada_api;
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

public class JogosPrimeiraLiga_A_2024_25 {

    private JogosPrimeiraLiga_A_2024_25_Listener listener;

    private Jogos_campeonatos_chamada_api jogos_campeonatos_chamada_api;

    HashMap<String, Map<String, List<PartidaNovoModelo>>> partidasPorTime = new HashMap<>();

    public void setListener(JogosPrimeiraLiga_A_2024_25_Listener listener){
        this.listener = listener;
    }

    public void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/refs/heads/master/europa-a-2024-2025/primeira-liga-portugal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jogos_campeonatos_chamada_api = retrofit.create(Jogos_campeonatos_chamada_api.class);
    }

    public void setupDadosJogos() {
        jogos_campeonatos_chamada_api.getPrimeiraLigaPortugal2024_25().enqueue(new Callback<List<PartidaNovoModelo>>() {
            @Override
            public void onResponse(Call<List<PartidaNovoModelo>> call, Response<List<PartidaNovoModelo>> response) {
                if(response.isSuccessful()){
                    List<PartidaNovoModelo> partidas = response.body();

                    if (partidas != null) {
                        for (PartidaNovoModelo partida : partidas) {
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
                    listener.onJogosPrimeiraLiga_A(partidasPorTime);
                }

            }


            @Override
            public void onFailure(Call<List<PartidaNovoModelo>> call, Throwable t) {
                Log.e("API_ERROR", "Falha ao carregar partidas", t);
            }
        });


    }

}
