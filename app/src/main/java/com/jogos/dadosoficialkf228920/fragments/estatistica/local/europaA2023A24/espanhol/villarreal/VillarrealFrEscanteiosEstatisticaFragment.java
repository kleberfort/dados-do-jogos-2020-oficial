package com.jogos.dadosoficialkf228920.fragments.estatistica.local.europaA2023A24.espanhol.villarreal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.data.brasileiroA2023.bahia.BahiaForaA2023PartidaApi;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.espanhol.villarreal.VillarrealForaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaEscanteiosBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VillarrealFrEscanteiosEstatisticaFragment extends Fragment {


    private TelaEstatisticaEscanteiosBinding binding;
    private VillarrealForaPartidaApi villarrealForaPartidaApi;


    private int escanteiosPrimeiroTempoZeroCincoMarcados;
    private int escanteiosPrimeiroTempoZeroCincoNaoMarcados;


    private int escanteiosPrimeiroTempoUmCincoMarcados;
    private int escanteiosPrimeiroTempoUmCincoNaoMarcados;

    private int escanteiosPrimeiroTempoDoisCincoMarcados;
    private int escanteiosPrimeiroTempoDoisCincoNaoMarcados;

    private int escanteiosPrimeiroTempoTresCincoMarcados;
    private int escanteiosPrimeiroTempoTresCincoNaoMarcados;


    private int escanteiosSegundoTempoZeroCincoMarcados;
    private int escanteiosSegundoTempoZeroCincoNaoMarcados;


    private int escanteiosSegundoTempoUmCincoMarcados;
    private int escanteiosSegundoTempoUmCincoNaoMarcados;

    private int escanteiosSegundoTempoDoisCincoMarcados;
    private int escanteiosSegundoTempoDoisCincoNaoMarcados;

    private int escanteiosSegundoTempoTresCincoMarcados;
    private int escanteiosSegundoTempoTresCincoNaoMarcados;


    private int escanteiosTotalZeroCincoMarcados;
    private int escanteiosTotalZeroCincoNaoMarcados;

    private int escanteiosTotalUmCincoMarcados;
    private int escanteiosTotalUmCincoNaoMarcados;

    private int escanteiosTotalDoisCincoMarcados;
    private int escanteiosTotalDoisCincoNaoMarcados;

    private int escanteiosTotalTresCincoMarcados;
    private int escanteiosTotalTresCincoNaoMarcados;

    private int escanteiosTotalQuatroCincoMarcados;
    private int escanteiosTotalQuatroCincoNaoMarcados;

    private int escanteiosTotalCincoCincoMarcados;
    private int escanteiosTotalCincoCincoNaoMarcados;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaEscanteiosBinding.inflate(inflater, container, false);




        setupHttpClient();
        setupDadosJogos();


        return binding.getRoot();


    }


    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/espanhol/villarreal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        villarrealForaPartidaApi = retrofit.create(VillarrealForaPartidaApi.class);
    }


    private void setupDadosJogos(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.array_brasileiro_rodada_ate_19, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        villarrealForaPartidaApi.getVillarrealFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()) {
                    List<Partida> partidas = response.body();

                    for (int i = 0; i < partidas.size(); i++) {
                        //ESCANTEIOS 0.5 1°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() > 0)
                            escanteiosPrimeiroTempoZeroCincoMarcados += 1;
                        escanteiosPrimeiroTempoZeroCincoNaoMarcados = partidas.size() - escanteiosPrimeiroTempoZeroCincoMarcados;


                        //ESCANTEIOS 1.5 1°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() > 1)
                            escanteiosPrimeiroTempoUmCincoMarcados += 1;
                        escanteiosPrimeiroTempoUmCincoNaoMarcados = partidas.size() - escanteiosPrimeiroTempoUmCincoMarcados;


                        //ESCANTEIOS 2.5 1°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() > 2)
                            escanteiosPrimeiroTempoDoisCincoMarcados += 1;
                        escanteiosPrimeiroTempoDoisCincoNaoMarcados = partidas.size() - escanteiosPrimeiroTempoDoisCincoMarcados;

                        //ESCANTEIOS 3.5 1°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() > 3)
                            escanteiosPrimeiroTempoTresCincoMarcados += 1;
                        escanteiosPrimeiroTempoTresCincoNaoMarcados = partidas.size() - escanteiosPrimeiroTempoTresCincoMarcados;


//                        SEGUNDO TEMPO -----------------------------------------------------------------------

                        //ESCANTEIOS 0.5 2°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                            escanteiosSegundoTempoZeroCincoMarcados += 1;
                        escanteiosSegundoTempoZeroCincoNaoMarcados = partidas.size() - escanteiosSegundoTempoZeroCincoMarcados;


                        //ESCANTEIOS 1.5 2°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                            escanteiosSegundoTempoUmCincoMarcados += 1;
                        escanteiosSegundoTempoUmCincoNaoMarcados = partidas.size() - escanteiosSegundoTempoUmCincoMarcados;


                        //ESCANTEIOS 2.5 2°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                            escanteiosSegundoTempoDoisCincoMarcados += 1;
                        escanteiosSegundoTempoDoisCincoNaoMarcados = partidas.size() - escanteiosSegundoTempoDoisCincoMarcados;

                        //ESCANTEIOS 3.5 2°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                            escanteiosSegundoTempoTresCincoMarcados += 1;
                        escanteiosSegundoTempoTresCincoNaoMarcados = partidas.size() - escanteiosSegundoTempoTresCincoMarcados;

//                        ESCANTEIOS ACIMA -----------------------------------------------------------------------------


                        //ESCANTEIOS ACIMA 0.5 TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                            escanteiosTotalZeroCincoMarcados += 1;
                        escanteiosTotalZeroCincoNaoMarcados = partidas.size() - escanteiosTotalZeroCincoMarcados;

                        //ESCANTEIOS ACIMA 1.5 TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                            escanteiosTotalUmCincoMarcados += 1;
                        escanteiosTotalUmCincoNaoMarcados = partidas.size() - escanteiosTotalUmCincoMarcados;


                        //ESCANTEIOS ACIMA 2.5 TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                            escanteiosTotalDoisCincoMarcados += 1;
                        escanteiosTotalDoisCincoNaoMarcados = partidas.size() - escanteiosTotalDoisCincoMarcados;


                        //ESCANTEIOS ACIMA 3.5 TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                            escanteiosTotalTresCincoMarcados += 1;
                        escanteiosTotalTresCincoNaoMarcados = partidas.size() - escanteiosTotalTresCincoMarcados;


                        //ESCANTEIOS ACIMA 4.5 TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 4)
                            escanteiosTotalQuatroCincoMarcados += 1;
                        escanteiosTotalQuatroCincoNaoMarcados = partidas.size() - escanteiosTotalQuatroCincoMarcados;


                        //ESCANTEIOS ACIMA 5.5 TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() > 5)
                            escanteiosTotalCincoCincoMarcados += 1;
                        escanteiosTotalCincoCincoNaoMarcados = partidas.size() - escanteiosTotalCincoCincoMarcados;



                    }//fim do for



                    //Inicio Porcentagem



                    //ESCANTEIOS 1T 0.5 PORCENTAGEM

                    binding.tvEscanteios1T05McdPct.setText(String.valueOf(Math.round(((double)escanteiosPrimeiroTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios1T05CtPct.setText(String.valueOf(Math.round((double)escanteiosPrimeiroTempoZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1T05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1T05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosPrimeiroTempoZeroCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1T05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1T05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1T05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1T05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosPrimeiroTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1T05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1T05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS 1T 1.5 PORCENTAGEM


                    binding.tvEscanteios1T15McdPct.setText(String.valueOf(Math.round(((double)escanteiosPrimeiroTempoUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios1T15CtPct.setText(String.valueOf(Math.round((double)escanteiosPrimeiroTempoUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1T15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1T15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosPrimeiroTempoUmCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1T15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1T15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1T15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1T15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosPrimeiroTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1T15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1T15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS 1T 2.5 PORCENTAGEM


                    binding.tvEscanteios1T25McdPct.setText(String.valueOf(Math.round(((double)escanteiosPrimeiroTempoDoisCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios1T25CtPct.setText(String.valueOf(Math.round((double)escanteiosPrimeiroTempoDoisCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosPrimeiroTempoDoisCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1T25McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosPrimeiroTempoDoisCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1T25McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosPrimeiroTempoDoisCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1T25McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1T25McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosPrimeiroTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1T25CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosPrimeiroTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1T25CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosPrimeiroTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1T25CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1T25CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS 1T 3.5 PORCENTAGEM


                    binding.tvEscanteios1T35McdPct.setText(String.valueOf(Math.round(((double)escanteiosPrimeiroTempoTresCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios1T35CtPct.setText(String.valueOf(Math.round((double)escanteiosPrimeiroTempoTresCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosPrimeiroTempoTresCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1T35McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosPrimeiroTempoTresCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1T35McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosPrimeiroTempoTresCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1T35McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1T35McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosPrimeiroTempoTresCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios1T35CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosPrimeiroTempoTresCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios1T35CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosPrimeiroTempoTresCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios1T35CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios1T35CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);



                    //ESCANTEIOS 2T 0.5 PORCENTAGEM

                    binding.tvEscanteios2T05McdPct.setText(String.valueOf(Math.round(((double)escanteiosSegundoTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios2T05CtPct.setText(String.valueOf(Math.round((double)escanteiosSegundoTempoZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2T05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2T05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosSegundoTempoZeroCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2T05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2T05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2T05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2T05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosSegundoTempoZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2T05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2T05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS 2T 1.5 PORCENTAGEM

                    binding.tvEscanteios2T15McdPct.setText(String.valueOf(Math.round(((double)escanteiosSegundoTempoUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios2T15CtPct.setText(String.valueOf(Math.round((double)escanteiosSegundoTempoUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2T15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2T15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosSegundoTempoUmCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2T15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2T15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2T15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2T15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosSegundoTempoUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2T15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2T15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS 2T 2.5 PORCENTAGEM


                    binding.tvEscanteios2T25McdPct.setText(String.valueOf(Math.round(((double)escanteiosSegundoTempoDoisCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios2T25CtPct.setText(String.valueOf(Math.round((double)escanteiosSegundoTempoDoisCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosSegundoTempoDoisCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2T25McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosSegundoTempoDoisCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2T25McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosSegundoTempoDoisCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2T25McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2T25McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosSegundoTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2T25CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosSegundoTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2T25CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosSegundoTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2T25CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2T25CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS 2T 3.5 PORCENTAGEM


                    binding.tvEscanteios2T35McdPct.setText(String.valueOf(Math.round(((double)escanteiosSegundoTempoTresCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteios2T35CtPct.setText(String.valueOf(Math.round((double)escanteiosSegundoTempoTresCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosSegundoTempoTresCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2T35McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosSegundoTempoTresCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2T35McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosSegundoTempoTresCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2T35McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2T35McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosSegundoTempoTresCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteios2T35CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosSegundoTempoTresCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteios2T35CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosSegundoTempoTresCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteios2T35CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteios2T35CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);




                    //ESCANTEIOS ACIMA 0.5 PORCENTAGEM

                    binding.tvEscanteiosTotal05McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotal05CtPct.setText(String.valueOf(Math.round((double)escanteiosTotalZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalZeroCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal05McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalZeroCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal05McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalZeroCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal05McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal05McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal05CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal05CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalZeroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal05CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal05CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    //ESCANTEIOS ACIMA 1.5 PORCENTAGEM

                    binding.tvEscanteiosTotal15McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotal15CtPct.setText(String.valueOf(Math.round((double)escanteiosTotalUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalUmCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal15McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalUmCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal15McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalUmCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal15McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal15McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal15CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal15CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalUmCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal15CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal15CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOSACIMA 2.5 PORCENTAGEM

                    binding.tvEscanteiosTotal25McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalDoisCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotal25CtPct.setText(String.valueOf(Math.round((double)escanteiosTotalDoisCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalDoisCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal25McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalDoisCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal25McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalDoisCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal25McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal25McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal25CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal25CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalDoisCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal25CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal25CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS ACIMA 3.5 PORCENTAGEM


                    binding.tvEscanteiosTotal35McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalTresCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotal35CtPct.setText(String.valueOf(Math.round((double)escanteiosTotalTresCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalTresCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal35McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalTresCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal35McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalTresCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal35McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal35McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal35CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal35CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal35CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal35CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS ACIMA 4.5 PORCENTAGEM


                    binding.tvEscanteiosTotal45McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalQuatroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotal45CtPct.setText(String.valueOf(Math.round((double)escanteiosTotalQuatroCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalQuatroCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal45McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalQuatroCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal45McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalQuatroCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal45McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal45McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalQuatroCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal45CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalQuatroCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal45CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalQuatroCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal45CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal45CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //ESCANTEIOS ACIMA 5.5 PORCENTAGEM


                    binding.tvEscanteiosTotal55McdPct.setText(String.valueOf(Math.round(((double)escanteiosTotalCincoCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvEscanteiosTotal55CtPct.setText(String.valueOf(Math.round((double)escanteiosTotalCincoCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) escanteiosTotalCincoCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal55McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalCincoCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal55McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalCincoCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal55McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal55McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) escanteiosTotalCincoCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvEscanteiosTotal55CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) escanteiosTotalCincoCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvEscanteiosTotal55CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) escanteiosTotalCincoCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvEscanteiosTotal55CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvEscanteiosTotal55CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);



                    //Fim Porcentagem



                    binding.tvTituloCanto.setText("ESTATÍSTICA DE CANTOS " + partidas.get(0).getAwayTime().getName().toUpperCase() + " FORA");



                    binding.tvEscanteios1T05Mcd.setText(String.valueOf(escanteiosPrimeiroTempoZeroCincoMarcados));
                    binding.tvEscanteios1T05Ct.setText(String.valueOf(escanteiosPrimeiroTempoZeroCincoNaoMarcados));

                    binding.tvEscanteios1T15Mcd.setText(String.valueOf(escanteiosPrimeiroTempoUmCincoMarcados));
                    binding.tvEscanteios1T15Ct.setText(String.valueOf(escanteiosPrimeiroTempoUmCincoNaoMarcados));


                    binding.tvEscanteios1T25Mcd.setText(String.valueOf(escanteiosPrimeiroTempoDoisCincoMarcados));
                    binding.tvEscanteios1T25Ct.setText(String.valueOf(escanteiosPrimeiroTempoDoisCincoNaoMarcados));


                    binding.tvEscanteios1T35Mcd.setText(String.valueOf(escanteiosPrimeiroTempoTresCincoMarcados));
                    binding.tvEscanteios1T35Ct.setText(String.valueOf(escanteiosPrimeiroTempoTresCincoNaoMarcados));


                    binding.tvEscanteios2T05Mcd.setText(String.valueOf(escanteiosSegundoTempoZeroCincoMarcados));
                    binding.tvEscanteios2T05Ct.setText(String.valueOf(escanteiosSegundoTempoZeroCincoNaoMarcados));

                    binding.tvEscanteios2T15Mcd.setText(String.valueOf(escanteiosSegundoTempoUmCincoMarcados));
                    binding.tvEscanteios2T15Ct.setText(String.valueOf(escanteiosSegundoTempoUmCincoNaoMarcados));


                    binding.tvEscanteios2T25Mcd.setText(String.valueOf(escanteiosSegundoTempoDoisCincoMarcados));
                    binding.tvEscanteios2T25Ct.setText(String.valueOf(escanteiosSegundoTempoDoisCincoNaoMarcados));


                    binding.tvEscanteios2T35Mcd.setText(String.valueOf(escanteiosSegundoTempoTresCincoMarcados));
                    binding.tvEscanteios2T35Ct.setText(String.valueOf(escanteiosSegundoTempoTresCincoNaoMarcados));


                    binding.tvEscanteiosTotal05Mcd.setText(String.valueOf(escanteiosTotalZeroCincoMarcados));
                    binding.tvEscanteiosTotal05Ct.setText(String.valueOf(escanteiosTotalZeroCincoNaoMarcados));

                    binding.tvEscanteiosTotal15Mcd.setText(String.valueOf(escanteiosTotalUmCincoMarcados));
                    binding.tvEscanteiosTotal15Ct.setText(String.valueOf(escanteiosTotalUmCincoNaoMarcados));

                    binding.tvEscanteiosTotal25Mcd.setText(String.valueOf(escanteiosTotalDoisCincoMarcados));
                    binding.tvEscanteiosTotal25Ct.setText(String.valueOf(escanteiosTotalDoisCincoNaoMarcados));

                    binding.tvEscanteiosTotal35Mcd.setText(String.valueOf(escanteiosTotalTresCincoMarcados));
                    binding.tvEscanteiosTotal35Ct.setText(String.valueOf(escanteiosTotalTresCincoNaoMarcados));

                    binding.tvEscanteiosTotal45Mcd.setText(String.valueOf(escanteiosTotalQuatroCincoMarcados));
                    binding.tvEscanteiosTotal45Ct.setText(String.valueOf(escanteiosTotalQuatroCincoNaoMarcados));

                    binding.tvEscanteiosTotal55Mcd.setText(String.valueOf(escanteiosTotalCincoCincoMarcados));
                    binding.tvEscanteiosTotal55Ct.setText(String.valueOf(escanteiosTotalCincoCincoNaoMarcados));



                    binding.tvTotalJogos.setText(String.valueOf(partidas.size()));


                }//fim do if





            }//fim do onResponse

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                errorBuscarDados();

            }
        });


    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao Retornar Dados local do Time. ", Snackbar.LENGTH_LONG).show();
    }





}

