package com.jogos.dadosoficialkf228920.fragments.estatistica.geral.europaA2023a24.ingles.westham;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.data.brasileiroA2023.americaMG.AmericaMgForaA2023PartidaApi;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.ingles.westham.WestHamForaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaOficialPorcentagemBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WestHamForaEstatisticaFragment extends Fragment {

    private TelaEstatisticaOficialPorcentagemBinding binding;
    private WestHamForaPartidaApi  westHamForaPartidaApi;

    private int golsTotalPrimeiroTempoZeroCincoMarcados;
    private int golsTotalPrimeiroTempoZeroCincoNaoMarcados;

    private int golsTotalPrimeiroTempoUmCincoMarcados;
    private int golsTotalPrimeiroTempoUmCincoNaoMarcados;


    private int golsTotalSegundoTempoZeroCincoMarcados;
    private int golsTotalSegundoTempoZeroCincoNaoMarcados;

    private int golsTotalSegundoTempoUmCincoMarcados;
    private int golsTotalSegundoTempoUmCincoNaoMarcados;

    private int golsTotalZeroCincoMarcados;
    private int golsTotalZeroCincoNaoMarcados;

    private int golsTotalUmCincoMarcados;
    private int golsTotalUmCincoNaoMarcados;

    private int golsTotalDoisCincoMarcados;
    private int golsTotalDoisCincoNaoMarcados;

    private int totalAmbasMarcados;
    private int totalAmbasNaoMarcados;

    private int escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados;
    private int escanteiosTotalPrimeiroTempoMaiorIgualCincoNaoMarcados;

    private int escanteiosTotalSegundoTempoMaiorIgualCincoMarcados;
    private int escanteiosTotalSegundoTempoMaiorIgualCincoNaoMarcados;

    private int escanteiosTotalMaiorIgualOitoMarcados;
    private int escanteiosTotalMaiorIgualOitoNaoMarcados;

    private int escanteiosTotalMaiorIgualNoveMarcados;
    private int escanteiosTotalMaiorIgualNoveNaoMarcados;

    private int escanteiosTotalMaiorIgualDezMarcados;
    private int escanteiosTotalMaiorIgualDezNaoMarcados;



    private int totalVitoria;
    private int totalEmpate;
    private int totalDerrota;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaOficialPorcentagemBinding.inflate(inflater, container, false);



        setupHttpClient();
        setupDadosJogos();


        return binding.getRoot();


    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/ingles/west-ham/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        westHamForaPartidaApi = retrofit.create(WestHamForaPartidaApi.class);
    }

    private void setupDadosJogos(){

        westHamForaPartidaApi.getWestHamFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()) {
                    List<Partida> partidas = response.body();

                    for (int i = 0; i < partidas.size(); i++) {

                        //GOLS 0.5 1°TEMPO
                        if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() ) +
                                (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) > 0)
                            golsTotalPrimeiroTempoZeroCincoMarcados += 1;
                        golsTotalPrimeiroTempoZeroCincoNaoMarcados = partidas.size() - golsTotalPrimeiroTempoZeroCincoMarcados;

                        //GOLS 1.5 1°TEMPO
                        if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() ) +
                                (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) > 1)
                            golsTotalPrimeiroTempoUmCincoMarcados += 1;
                        golsTotalPrimeiroTempoUmCincoNaoMarcados = partidas.size() - golsTotalPrimeiroTempoUmCincoMarcados;


                        //GOLS 0.5 2°TEMPO
                        if((partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() ) +
                                (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 0)
                            golsTotalSegundoTempoZeroCincoMarcados += 1;
                        golsTotalSegundoTempoZeroCincoNaoMarcados = partidas.size() - golsTotalSegundoTempoZeroCincoMarcados;

                        //GOLS 1.5 2°TEMPO
                        if((partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() ) +
                                (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 1)
                            golsTotalSegundoTempoUmCincoMarcados += 1;
                        golsTotalSegundoTempoUmCincoNaoMarcados = partidas.size() - golsTotalSegundoTempoUmCincoMarcados;

                        //GOLS ACIMA 0.5
                        if(partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 0 ||
                                partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 0 ||
                                partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 0 ||
                                partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 0)
                            golsTotalZeroCincoMarcados += 1;
                        golsTotalZeroCincoNaoMarcados = partidas.size() - golsTotalZeroCincoMarcados;


                        //GOLS ACIMA 1.5
                        if(
                                (partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) +
                                        (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) +
                                        (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) +
                                        (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 1



                        ) golsTotalUmCincoMarcados += 1;
                        golsTotalUmCincoNaoMarcados = partidas.size() - golsTotalUmCincoMarcados;



                        //GOLS ACIMA 2.5
                        if(
                                (partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) +
                                        (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) +
                                        (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) +
                                        (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 2



                        ) golsTotalDoisCincoMarcados += 1;
                        golsTotalDoisCincoNaoMarcados = partidas.size() - golsTotalDoisCincoMarcados;


                        //AMBAS MARCAM
                        if(((partidas.get(i).getHomeTime().getPlacar()) > 0) &&
                                ((partidas.get(i).getAwayTime().getPlacar() > 0)))
                            totalAmbasMarcados += 1;
                        totalAmbasNaoMarcados = partidas.size() - totalAmbasMarcados;


                        //ESCANTEIO 1T >= 5
                        if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()) +
                                (partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()) >= 5)
                            escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados += 1;
                        escanteiosTotalPrimeiroTempoMaiorIgualCincoNaoMarcados = partidas.size() -  escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados;

                        //ESCANTEIO 2T >= 5
                        if((partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo()) +
                                (partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo()) >= 5)
                            escanteiosTotalSegundoTempoMaiorIgualCincoMarcados += 1;
                        escanteiosTotalSegundoTempoMaiorIgualCincoNaoMarcados = partidas.size() -  escanteiosTotalSegundoTempoMaiorIgualCincoMarcados;

                        //ESCANTEIOS TOTAL >=8
                        if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                                partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                                partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                                partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 8)

                        ) escanteiosTotalMaiorIgualOitoMarcados += 1;
                        escanteiosTotalMaiorIgualOitoNaoMarcados = partidas.size() - escanteiosTotalMaiorIgualOitoMarcados;

                        //ESCANTEIOS TOTAL >=9
                        if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                                partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                                partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                                partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 9)

                        ) escanteiosTotalMaiorIgualNoveMarcados += 1;
                        escanteiosTotalMaiorIgualNoveNaoMarcados = partidas.size() - escanteiosTotalMaiorIgualNoveMarcados;

                        //ESCANTEIOS TOTAL >=10
                        if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                                partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                                partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                                partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 10)

                        ) escanteiosTotalMaiorIgualDezMarcados += 1;
                        escanteiosTotalMaiorIgualDezNaoMarcados = partidas.size() - escanteiosTotalMaiorIgualDezMarcados;

                        //TOTAL VIÓRIA
                        if(partidas.get(i).getHomeTime().getPlacar() < partidas.get(i).getAwayTime().getPlacar()){
                            totalVitoria += 1;
                        }

                        //TOTAL EMPATE
                        if(partidas.get(i).getHomeTime().getPlacar() == partidas.get(i).getAwayTime().getPlacar()){
                            totalEmpate += 1;
                        }

                        //TOTAL DERROTA
                        if(partidas.get(i).getHomeTime().getPlacar() > partidas.get(i).getAwayTime().getPlacar()){
                            totalDerrota += 1;
                        }



                    }//fim do for

                    //Inicio Porcentagem


                    binding.tvGols1T05McdPct.setText(String.valueOf(Math.round(((double)golsTotalPrimeiroTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols1T05CtPct.setText(String.valueOf(Math.round((double)golsTotalPrimeiroTempoZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols1T05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols1T05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols1T05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols1T05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    if(Math.round(((double) golsTotalPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols1T05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols1T05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols1T05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols1T05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    binding.tvGols1T15McdPct.setText(String.valueOf(Math.round(((double)golsTotalPrimeiroTempoUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols1T15CtPct.setText(String.valueOf(Math.round(((double)golsTotalPrimeiroTempoUmCincoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols1T15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols1T15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols1T15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols1T15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols1T15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols1T15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols1T15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols1T15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);



                    binding.tvGols2T05McdPct.setText(String.valueOf(Math.round(((double)golsTotalSegundoTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols2T05CtPct.setText(String.valueOf(Math.round(((double)golsTotalSegundoTempoZeroCincoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols2T05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols2T05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols2T05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols2T05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols2T05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols2T05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols2T05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols2T05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    binding.tvGols2T15McdPct.setText(String.valueOf(Math.round(((double)golsTotalSegundoTempoUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols2T15CtPct.setText(String.valueOf(Math.round(((double)golsTotalSegundoTempoUmCincoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols2T15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols2T15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols2T15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols2T15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols2T15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols2T15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols2T15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols2T15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    binding.tvGolsAcima05McdPct.setText(String.valueOf(Math.round(((double)golsTotalZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGolsAcima05CtPct.setText(String.valueOf(Math.round(((double)golsTotalZeroCincoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalZeroCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGolsAcima05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalZeroCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGolsAcima05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalZeroCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGolsAcima05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGolsAcima05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGolsAcima05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGolsAcima05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGolsAcima05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGolsAcima05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    binding.tvGolsAcima15McdPct.setText(String.valueOf(Math.round(((double)golsTotalUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGolsAcima15CtPct.setText(String.valueOf(Math.round(((double)golsTotalUmCincoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalUmCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGolsAcima15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalUmCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGolsAcima15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalUmCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGolsAcima15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGolsAcima15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGolsAcima15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGolsAcima15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGolsAcima15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGolsAcima15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    binding.tvGolsAcima25McdPct.setText(String.valueOf(Math.round(((double)golsTotalDoisCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGolsAcima25CtPct.setText(String.valueOf(Math.round(((double)golsTotalDoisCincoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalDoisCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGolsAcima25McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalDoisCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGolsAcima25McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalDoisCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGolsAcima25McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGolsAcima25McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGolsAcima25CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGolsAcima25CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGolsAcima25CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGolsAcima25CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    binding.tvAmbasMarcamMcdPct.setText(String.valueOf(Math.round(((double)totalAmbasMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvAmbasMarcamCtPct.setText(String.valueOf(Math.round(((double)totalAmbasNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) totalAmbasMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvAmbasMarcamMcdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) totalAmbasMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvAmbasMarcamMcdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) totalAmbasMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvAmbasMarcamMcdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvAmbasMarcamMcdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) totalAmbasNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvAmbasMarcamCtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) totalAmbasNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvAmbasMarcamCtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) totalAmbasNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvAmbasMarcamCtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvAmbasMarcamCtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    binding.tvEscanteios1TMaiorIgual5McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios1TMaiorIgual5CtPct.setText(String.valueOf(Math.round(((double)escanteiosTotalPrimeiroTempoMaiorIgualCincoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1TMaiorIgual5McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1TMaiorIgual5McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1TMaiorIgual5McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1TMaiorIgual5McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalPrimeiroTempoMaiorIgualCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1TMaiorIgual5CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalPrimeiroTempoMaiorIgualCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1TMaiorIgual5CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalPrimeiroTempoMaiorIgualCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1TMaiorIgual5CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1TMaiorIgual5CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    binding.tvEscanteios2TMaiorIgual5McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalSegundoTempoMaiorIgualCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios2TMaiorIgual5CtPct.setText(String.valueOf(Math.round(((double)escanteiosTotalSegundoTempoMaiorIgualCincoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalSegundoTempoMaiorIgualCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2TMaiorIgual5McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalSegundoTempoMaiorIgualCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2TMaiorIgual5McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalSegundoTempoMaiorIgualCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2TMaiorIgual5McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2TMaiorIgual5McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalSegundoTempoMaiorIgualCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2TMaiorIgual5CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalSegundoTempoMaiorIgualCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2TMaiorIgual5CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalSegundoTempoMaiorIgualCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2TMaiorIgual5CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2TMaiorIgual5CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    binding.tvEscanteiosTotalMaiorIgual8McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalMaiorIgualOitoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotalMaiorIgual8CtPct.setText(String.valueOf(Math.round(((double)escanteiosTotalMaiorIgualOitoNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalMaiorIgualOitoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotalMaiorIgual8McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualOitoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotalMaiorIgual8McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualOitoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotalMaiorIgual8McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotalMaiorIgual8McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalMaiorIgualOitoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotalMaiorIgual8CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualOitoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotalMaiorIgual8CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualOitoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotalMaiorIgual8CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotalMaiorIgual8CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    binding.tvEscanteiosTotalMaiorIgual9McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalMaiorIgualNoveMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotalMaiorIgual9CtPct.setText(String.valueOf(Math.round(((double)escanteiosTotalMaiorIgualNoveNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalMaiorIgualNoveMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotalMaiorIgual9McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualNoveMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotalMaiorIgual9McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualNoveMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotalMaiorIgual9McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotalMaiorIgual9McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalMaiorIgualNoveNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotalMaiorIgual9CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualNoveNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotalMaiorIgual9CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualNoveNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotalMaiorIgual9CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotalMaiorIgual9CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    binding.tvEscanteiosTotalMaiorIgual10McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalMaiorIgualDezMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotalMaiorIgual10CtPct.setText(String.valueOf(Math.round(((double)escanteiosTotalMaiorIgualDezNaoMarcados * 100 ) / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalMaiorIgualDezMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotalMaiorIgual10McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualDezMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotalMaiorIgual10McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualDezMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotalMaiorIgual10McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotalMaiorIgual10McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalMaiorIgualDezNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotalMaiorIgual10CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualDezNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotalMaiorIgual10CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalMaiorIgualDezNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotalMaiorIgual10CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotalMaiorIgual10CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //Fim Porcentagem

                    binding.tvGols1T05Mcd.setText(String.valueOf(golsTotalPrimeiroTempoZeroCincoMarcados));
                    binding.tvGols1T05Ct.setText(String.valueOf(golsTotalPrimeiroTempoZeroCincoNaoMarcados));

                    binding.tvGols1T15Mcd.setText(String.valueOf(golsTotalPrimeiroTempoUmCincoMarcados));
                    binding.tvGols1T15Ct.setText(String.valueOf(golsTotalPrimeiroTempoUmCincoNaoMarcados));

                    binding.tvGols2T05Mcd.setText(String.valueOf(golsTotalSegundoTempoZeroCincoMarcados));
                    binding.tvGols2T05Ct.setText(String.valueOf(golsTotalSegundoTempoZeroCincoNaoMarcados));

                    binding.tvGols2T15Mcd.setText(String.valueOf(golsTotalSegundoTempoUmCincoMarcados));
                    binding.tvGols2T15Ct.setText(String.valueOf(golsTotalSegundoTempoUmCincoNaoMarcados));

                    binding.tvGolsAcima05Mcd.setText(String.valueOf(golsTotalZeroCincoMarcados));
                    binding.tvGolsAcima05Ct.setText(String.valueOf(golsTotalZeroCincoNaoMarcados));

                    binding.tvGolsAcima15Mcd.setText(String.valueOf(golsTotalUmCincoMarcados));
                    binding.tvGolsAcima15Ct.setText(String.valueOf(golsTotalUmCincoNaoMarcados));

                    binding.tvGolsAcima25Mcd.setText(String.valueOf(golsTotalDoisCincoMarcados));
                    binding.tvGolsAcima25Ct.setText(String.valueOf(golsTotalDoisCincoNaoMarcados));

                    binding.tvAmbasMarcamMcd.setText(String.valueOf(totalAmbasMarcados));
                    binding.tvAmbasMarcamCt.setText(String.valueOf(totalAmbasNaoMarcados));

                    binding.tvEscanteios1TMaiorIgual5Mcd.setText(String.valueOf(escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados));
                    binding.tvEscanteios1TMaiorIgual5Ct.setText(String.valueOf(escanteiosTotalPrimeiroTempoMaiorIgualCincoNaoMarcados));

                    binding.tvEscanteios2TMaiorIgual5Mcd.setText(String.valueOf(escanteiosTotalSegundoTempoMaiorIgualCincoMarcados));
                    binding.tvEscanteios2TMaiorIgual5Ct.setText(String.valueOf(escanteiosTotalSegundoTempoMaiorIgualCincoNaoMarcados));

                    binding.tvEscanteiosTotalMaiorIgual8Mcd.setText(String.valueOf(escanteiosTotalMaiorIgualOitoMarcados));
                    binding.tvEscanteiosTotalMaiorIgual8Ct.setText(String.valueOf(escanteiosTotalMaiorIgualOitoNaoMarcados));


                    binding.tvEscanteiosTotalMaiorIgual9Mcd.setText(String.valueOf(escanteiosTotalMaiorIgualNoveMarcados));
                    binding.tvEscanteiosTotalMaiorIgual9Ct.setText(String.valueOf(escanteiosTotalMaiorIgualNoveNaoMarcados));


                    binding.tvEscanteiosTotalMaiorIgual10Mcd.setText(String.valueOf(escanteiosTotalMaiorIgualDezMarcados));
                    binding.tvEscanteiosTotalMaiorIgual10Ct.setText(String.valueOf(escanteiosTotalMaiorIgualDezNaoMarcados));


                    binding.tvTotalVitoria.setText(String.valueOf(totalVitoria));
                    binding.tvTotalEmpate.setText(String.valueOf(totalEmpate));
                    binding.tvTotalDerrota.setText(String.valueOf(totalDerrota));





                    binding.tvTotalJogos.setText(String.valueOf(partidas.size()));


                }



            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                errorBuscarDados();

            }
        });


    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao Retornar Dados Estatístico. ", Snackbar.LENGTH_LONG).show();
    }







}
