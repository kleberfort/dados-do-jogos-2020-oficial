package com.jogos.dadosoficialkf228920.fragments.estatistica.geral.inglesA2022a23.machestercity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.data.inglesA2022a23.manchestercity.ManchesterCityCasaA2022a23PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaOficialBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ManchestercityCasaEstatisticaFragment extends Fragment {
    private TelaEstatisticaOficialBinding binding;
    private ManchesterCityCasaA2022a23PartidaApi manchesterCityCasaA2022a23PartidaApi;

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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaOficialBinding.inflate(inflater, container, false);



        setupHttpClient();
        setupDadosJogos();


        return binding.getRoot();


    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ingles-a-2022-23/manchester-city/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        manchesterCityCasaA2022a23PartidaApi = retrofit.create(ManchesterCityCasaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos(){

        manchesterCityCasaA2022a23PartidaApi.getManchesterCityCasa().enqueue(new Callback<List<Partida>>() {
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
                        if(partidas.get(i).getHomeTime().getPlacar() > partidas.get(i).getAwayTime().getPlacar()){
                            totalVitoria += 1;
                        }

                        //TOTAL EMPATE
                        if(partidas.get(i).getHomeTime().getPlacar() == partidas.get(i).getAwayTime().getPlacar()){
                            totalEmpate += 1;
                        }

                        //TOTAL DERROTA
                        if(partidas.get(i).getHomeTime().getPlacar() < partidas.get(i).getAwayTime().getPlacar()){
                            totalDerrota += 1;
                        }



                    }//fim do for

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

