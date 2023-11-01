package com.jogos.dadosoficialkf228920.fragments.estatistica.local.europaA2023A24.ingles.sheffield;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.data.brasileiroA2023.americaMG.AmericaMgForaA2023PartidaApi;
import com.jogos.dadosoficialkf228920.data.europaA2023a24.ingles.sheffield.SheffieldForaPartidaApi;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaGolsBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SheffieldFrGolsEstatisticaFragment extends Fragment {


    private TelaEstatisticaGolsBinding binding;
    private SheffieldForaPartidaApi sheffieldForaPartidaApi;



    private int golsTotalPrimeiroTempoZeroCincoMarcados;
    private int golsTotalPrimeiroTempoZeroCincoNaoMarcados;

    private int golsTotalPrimeiroTempoUmCincoMarcados;
    private int golsTotalPrimeiroTempoUmCincoNaoMarcados;

    private int golsTotalPrimeiroTempoDoisCincoMarcados;
    private int golsTotalPrimeiroTempoDoisCincoNaoMarcados;


    private int golsTotalSegundoTempoZeroCincoMarcados;
    private int golsTotalSegundoTempoZeroCincoNaoMarcados;

    private int golsTotalSegundoTempoUmCincoMarcados;
    private int golsTotalSegundoTempoUmCincoNaoMarcados;


    private int golsTotalSegundoTempoDoisCincoMarcados;
    private int golsTotalSegundoTempoDoisCincoNaoMarcados;





    private int golsTotalZeroCincoMarcados;
    private int golsTotalZeroCincoNaoMarcados;

    private int golsTotalUmCincoMarcados;
    private int golsTotalUmCincoNaoMarcados;

    private int golsTotalDoisCincoMarcados;
    private int golsTotalDoisCincoNaoMarcados;


    private int golsTotalTresCincoMarcados;
    private int golsTotalTresCincoNaoMarcados;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaGolsBinding.inflate(inflater, container, false);




        setupHttpClient();
        setupDadosJogos();


        return binding.getRoot();


    }


    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/europa-a-2023-24/ingles/sheffield/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sheffieldForaPartidaApi = retrofit.create(SheffieldForaPartidaApi.class);
    }


    private void setupDadosJogos(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.array_brasileiro_rodada_ate_19, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sheffieldForaPartidaApi.getSheffieldFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()) {
                    List<Partida> partidas = response.body();

                    for (int i = 0; i < partidas.size(); i++) {
                        //GOLS 0.5 1°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 0)
                            golsTotalPrimeiroTempoZeroCincoMarcados += 1;
                        golsTotalPrimeiroTempoZeroCincoNaoMarcados = partidas.size() - golsTotalPrimeiroTempoZeroCincoMarcados;




                        //GOLS 1.5 1°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 1)
                            golsTotalPrimeiroTempoUmCincoMarcados += 1;
                        golsTotalPrimeiroTempoUmCincoNaoMarcados = partidas.size() - golsTotalPrimeiroTempoUmCincoMarcados;


                        //GOLS 2.5 1°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 2)
                            golsTotalPrimeiroTempoDoisCincoMarcados += 1;
                        golsTotalPrimeiroTempoDoisCincoNaoMarcados = partidas.size() - golsTotalPrimeiroTempoDoisCincoMarcados;


//                        SEGUNDO TEMPO -----------------------------------------------------------------------

                        //GOLS 0.5 2°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 0)
                            golsTotalSegundoTempoZeroCincoMarcados += 1;
                        golsTotalSegundoTempoZeroCincoNaoMarcados = partidas.size() - golsTotalSegundoTempoZeroCincoMarcados;


                        //GOLS 1.5 2°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 1)
                            golsTotalSegundoTempoUmCincoMarcados += 1;
                        golsTotalSegundoTempoUmCincoNaoMarcados = partidas.size() - golsTotalSegundoTempoUmCincoMarcados;


                        //GOLS 2.5 2°TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 2)
                            golsTotalSegundoTempoDoisCincoMarcados += 1;
                        golsTotalSegundoTempoDoisCincoNaoMarcados = partidas.size() - golsTotalSegundoTempoDoisCincoMarcados;

//                        GOLS ACIMA -----------------------------------------------------------------------------


                        //GOLS ACIMA 0.5 TEMPO
                        if(partidas.get(i).getAwayTime().getPlacar() > 0)
                            golsTotalZeroCincoMarcados += 1;
                        golsTotalZeroCincoNaoMarcados = partidas.size() - golsTotalZeroCincoMarcados;

                        //GOLS ACIMA 1.5 TEMPO
                        if(partidas.get(i).getAwayTime().getPlacar() > 1)
                            golsTotalUmCincoMarcados += 1;
                        golsTotalUmCincoNaoMarcados = partidas.size() - golsTotalUmCincoMarcados;


                        //GOLS ACIMA 2.5 TEMPO
                        if(partidas.get(i).getAwayTime().getPlacar() > 2)
                            golsTotalDoisCincoMarcados += 1;
                        golsTotalDoisCincoNaoMarcados = partidas.size() - golsTotalDoisCincoMarcados;


                        //GOLS ACIMA 3.5 TEMPO
                        if(partidas.get(i).getAwayTime().getPlacar() > 3)
                            golsTotalTresCincoMarcados += 1;
                        golsTotalTresCincoNaoMarcados = partidas.size() - golsTotalTresCincoMarcados;



                    }//fim do for



                    //Inicio Porcentagem



                    //GOLS 1T 0.5 PORCENTAGEM

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


                    //GOLS 1T 1.5 PORCENTAGEM


                    binding.tvGols1T15McdPct.setText(String.valueOf(Math.round(((double)golsTotalPrimeiroTempoUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols1T15CtPct.setText(String.valueOf(Math.round((double)golsTotalPrimeiroTempoUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

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


                    //GOLS 1T 2.5 PORCENTAGEM


                    binding.tvGols1T25McdPct.setText(String.valueOf(Math.round(((double)golsTotalPrimeiroTempoDoisCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols1T25CtPct.setText(String.valueOf(Math.round((double)golsTotalPrimeiroTempoDoisCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalPrimeiroTempoDoisCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols1T25McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalPrimeiroTempoDoisCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols1T25McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalPrimeiroTempoDoisCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols1T25McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols1T25McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalPrimeiroTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols1T25CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalPrimeiroTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols1T25CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalPrimeiroTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols1T25CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols1T25CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    //GOLS 2T 0.5 PORCENTAGEM

                    binding.tvGols2T05McdPct.setText(String.valueOf(Math.round(((double)golsTotalSegundoTempoZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols2T05CtPct.setText(String.valueOf(Math.round((double)golsTotalSegundoTempoZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

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


                    //GOLS 2T 1.5 PORCENTAGEM

                    binding.tvGols2T15McdPct.setText(String.valueOf(Math.round(((double)golsTotalSegundoTempoUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols2T15CtPct.setText(String.valueOf(Math.round((double)golsTotalSegundoTempoUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

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


                    //GOLS 2T 2.5 PORCENTAGEM


                    binding.tvGols2T25McdPct.setText(String.valueOf(Math.round(((double)golsTotalSegundoTempoDoisCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGols2T25CtPct.setText(String.valueOf(Math.round((double)golsTotalSegundoTempoDoisCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalSegundoTempoDoisCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols2T25McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalSegundoTempoDoisCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols2T25McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalSegundoTempoDoisCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols2T25McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols2T25McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalSegundoTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGols2T25CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalSegundoTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGols2T25CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalSegundoTempoDoisCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGols2T25CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGols2T25CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //GOLS ACIMA 0.5 PORCENTAGEM

                    binding.tvGolsAcima05McdPct.setText(String.valueOf(Math.round(((double)golsTotalZeroCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGolsAcima05CtPct.setText(String.valueOf(Math.round((double)golsTotalZeroCincoNaoMarcados * 100 / partidas.size()) + "%"));

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

                    //GOLS ACIMA 1.5 PORCENTAGEM

                    binding.tvGolsAcima15McdPct.setText(String.valueOf(Math.round(((double)golsTotalUmCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGolsAcima15CtPct.setText(String.valueOf(Math.round((double)golsTotalUmCincoNaoMarcados * 100 / partidas.size()) + "%"));

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


                    //GOLS ACIMA 2.5 PORCENTAGEM

                    binding.tvGolsAcima25McdPct.setText(String.valueOf(Math.round(((double)golsTotalDoisCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGolsAcima25CtPct.setText(String.valueOf(Math.round((double)golsTotalDoisCincoNaoMarcados * 100 / partidas.size()) + "%"));

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


                    //GOLS ACIMA 3.5 PORCENTAGEM


                    binding.tvGolsAcima35McdPct.setText(String.valueOf(Math.round(((double)golsTotalTresCincoMarcados * 100 ) / partidas.size()) + "%"));
                    binding.tvGolsAcima35CtPct.setText(String.valueOf(Math.round((double)golsTotalTresCincoNaoMarcados * 100 / partidas.size()) + "%"));

                    if(Math.round(((double) golsTotalTresCincoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGolsAcima35McdPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalTresCincoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGolsAcima35McdPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalTresCincoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGolsAcima35McdPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGolsAcima35McdPct.setBackgroundResource(R.drawable.background_fundo_vermelho);

                    if(Math.round(((double) golsTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 85)
                        binding.tvGolsAcima35CtPct.setBackgroundResource(R.drawable.background_fundo_verde);
                    else if(Math.round(((double) golsTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 70)
                        binding.tvGolsAcima35CtPct.setBackgroundResource(R.drawable.background_fundo_amarelo);
                    else if(Math.round(((double) golsTotalTresCincoNaoMarcados * 100) / partidas.size() ) >= 60)
                        binding.tvGolsAcima35CtPct.setBackgroundResource(R.drawable.background_fundo_roxo);
                    else
                        binding.tvGolsAcima35CtPct.setBackgroundResource(R.drawable.background_fundo_vermelho);


                    //Fim Porcentagem



                    binding.tvTitulo.setText("ESTATÍSTICA DE GOLS " + partidas.get(0).getAwayTime().getName().toUpperCase() + " FORA");


                    binding.tvGols1T05Mcd.setText(String.valueOf(golsTotalPrimeiroTempoZeroCincoMarcados));
                    binding.tvGols1T05Ct.setText(String.valueOf(golsTotalPrimeiroTempoZeroCincoNaoMarcados));


                    binding.tvGols1T15Mcd.setText(String.valueOf(golsTotalPrimeiroTempoUmCincoMarcados));
                    binding.tvGols1T15Ct.setText(String.valueOf(golsTotalPrimeiroTempoUmCincoNaoMarcados));


                    binding.tvGols1T25Mcd.setText(String.valueOf(golsTotalPrimeiroTempoDoisCincoMarcados));
                    binding.tvGols1T25Ct.setText(String.valueOf(golsTotalPrimeiroTempoDoisCincoNaoMarcados));


                    binding.tvGols2T05Mcd.setText(String.valueOf(golsTotalSegundoTempoZeroCincoMarcados));
                    binding.tvGols2T05Ct.setText(String.valueOf(golsTotalSegundoTempoZeroCincoNaoMarcados));

                    binding.tvGols2T15Mcd.setText(String.valueOf(golsTotalSegundoTempoUmCincoMarcados));
                    binding.tvGols2T15Ct.setText(String.valueOf(golsTotalSegundoTempoUmCincoNaoMarcados));

                    binding.tvGols2T25Mcd.setText(String.valueOf(golsTotalSegundoTempoDoisCincoMarcados));
                    binding.tvGols2T25Ct.setText(String.valueOf(golsTotalSegundoTempoDoisCincoNaoMarcados));






                    binding.tvGolsAcima05Mcd.setText(String.valueOf(golsTotalZeroCincoMarcados));
                    binding.tvGolsAcima05Ct.setText(String.valueOf(golsTotalZeroCincoNaoMarcados));

                    binding.tvGolsAcima15Mcd.setText(String.valueOf(golsTotalUmCincoMarcados));
                    binding.tvGolsAcima15Ct.setText(String.valueOf(golsTotalUmCincoNaoMarcados));

                    binding.tvGolsAcima25Mcd.setText(String.valueOf(golsTotalDoisCincoMarcados));
                    binding.tvGolsAcima25Ct.setText(String.valueOf(golsTotalDoisCincoNaoMarcados));

                    binding.tvGolsAcima35Mcd.setText(String.valueOf(golsTotalTresCincoMarcados));
                    binding.tvGolsAcima35Ct.setText(String.valueOf(golsTotalTresCincoNaoMarcados));



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

