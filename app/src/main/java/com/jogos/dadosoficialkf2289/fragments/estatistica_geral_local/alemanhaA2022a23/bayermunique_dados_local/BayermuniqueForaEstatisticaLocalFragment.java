package com.jogos.dadosoficialkf2289.fragments.estatistica_geral_local.alemanhaA2022a23.bayermunique_dados_local;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf2289.data.espanhaA2022a23.almeria.AlmeriaForaA2022a23PartidaApi;
import com.jogos.dadosoficialkf2289.databinding.TelaEstatisticaOficialCasaForaBinding;
import com.jogos.dadosoficialkf2289.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlmeriaForaEstatisticaLocalFragment extends Fragment {

    private TelaEstatisticaOficialCasaForaBinding binding;
    private AlmeriaForaA2022a23PartidaApi almeriaForaA2022a23PartidaApi;

    private int golsPrimeiroTempoZeroCincoMarcados;
    private int golsPrimeiroTempoZeroCincoNaoMarcados;

    private int golsPrimeiroTempoUmCincoMarcados;
    private int golsPrimeiroTempoUmCincoNaoMarcados;


    private int golsSegundoTempoZeroCincoMarcados;
    private int golsSegundoTempoZeroCincoNaoMarcados;

    private int golsSegundoTempoUmCincoMarcados;
    private int golsSegundoTempoUmCincoNaoMarcados;

    private int golsTotalZeroCincoMarcados;
    private int golsTotalZeroCincoNaoMarcados;

    private int golsTotalUmCincoMarcados;
    private int golsTotalUmCincoNaoMarcados;

    private int golsTotalDoisCincoMarcados;
    private int golsTotalDoisCincoNaoMarcados;

    private int totalAmbasMarcadosPrimeiroTempo;
    private int totalAmbasNaoMarcadosPrimeiroTempo;

    private int totalAmbasMarcadosSegundoTempo;
    private int totalAmbasNaoMarcadosSegundoTempo;

    private int escanteiosPrimeiroTempoMaiorIgualDoisMarcados;
    private int escanteiosPrimeiroTempoMaiorIgualDoisNaoMarcados;

    private int escanteiosPrimeiroTempoMaiorIgualTresMarcados;
    private int escanteiosPrimeiroTempoMaiorIgualTresNaoMarcados;

    private int escanteiosPrimeiroTempoMaiorIgualQuatroMarcados;
    private int escanteiosPrimeiroTempoMaiorIgualQuatroNaoMarcados;


    private int escanteiosSegundoTempoMaiorIgualDoisMarcados;
    private int escanteiosSegundoTempoMaiorIgualDoisNaoMarcados;

    private int escanteiosSegundoTempoMaiorIgualTresMarcados;
    private int escanteiosSegundoTempoMaiorIgualTresNaoMarcados;

    private int escanteiosSegundoTempoMaiorIgualQuatroMarcados;
    private int escanteiosSegundoTempoMaiorIgualQuatroNaoMarcados;


    private int escanteiosTotalMaiorIgualCincoMarcados;
    private int escanteiosTotalMaiorIgualCincoNaoMarcados;

    private int escanteiosTotalMaiorIgualSeisMarcados;
    private int escanteiosTotalMaiorIgualSeisNaoMarcados;

    private int escanteiosTotalMaiorIgualSeteMarcados;
    private int escanteiosTotalMaiorIgualSeteNaoMarcados;



    private int totalVitoriaIntervalo;
    private int totalEmpateIntervalo;
    private int totalDerrotaIntervalo;


    private int totalVitoriaSegundoTempo;
    private int totalEmpateSegundoTempo;
    private int totalDerrotaSegundoTempo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaOficialCasaForaBinding.inflate(inflater, container, false);



        setupHttpClient();
        setupDadosJogos();


        return binding.getRoot();


    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/espanhol-a-2022-23/almeria/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        almeriaForaA2022a23PartidaApi = retrofit.create(AlmeriaForaA2022a23PartidaApi.class);
    }

    private void setupDadosJogos(){

        almeriaForaA2022a23PartidaApi.getAlmeriaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()) {
                    List<Partida> partidas = response.body();

                    for (int i = 0; i < partidas.size(); i++) {

                        //GOLS 0.5 1°TEMPO
                        if((partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() )  > 0)
                            golsPrimeiroTempoZeroCincoMarcados += 1;

                        //GOLS 1.5 1° TEMPO
                        if((partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() )  > 1)
                            golsPrimeiroTempoUmCincoMarcados += 1;

                        //GOLS 0.5 2°TEMPO
                        if((partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() )  > 0)
                            golsSegundoTempoZeroCincoMarcados += 1;

                        //GOLS 1.5 2°TEMPO
                        if((partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() )  > 1)
                            golsSegundoTempoUmCincoMarcados += 1;

                        //GOLS ACIMA 0.5
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 0  || partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 0 )
                            golsTotalZeroCincoMarcados += 1;

                        //GOLS ACIMA 1.5
                        if((partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) + (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 1)
                            golsTotalUmCincoMarcados += 1;

                        //GOLS ACIMA 2.5
                        if((partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) + (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 2)
                            golsTotalDoisCincoMarcados += 1;

                        //AMBAS MARCAM 1° TEMPO
                        if(((partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) > 0) && ((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 0)))
                            totalAmbasMarcadosPrimeiroTempo += 1;

                        //AMBAS MARCAM 2° TEMPO
                        if(((partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 0) && ((partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 0)))
                            totalAmbasMarcadosSegundoTempo += 1;

                        //ESCANTEIO 1T >= 2
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()) >= 2)
                            escanteiosPrimeiroTempoMaiorIgualDoisMarcados += 1;

                        //ESCANTEIO 1T >= 3
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()) >= 3)
                            escanteiosPrimeiroTempoMaiorIgualTresMarcados += 1;

                        //ESCANTEIO 1T >= 4
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()) >= 4)
                            escanteiosPrimeiroTempoMaiorIgualQuatroMarcados += 1;

                        //ESCANTEIO 2T >= 2
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo()) >= 2)
                            escanteiosSegundoTempoMaiorIgualDoisMarcados += 1;

                        //ESCANTEIO 2T >= 3
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo()) >= 3)
                            escanteiosSegundoTempoMaiorIgualTresMarcados += 1;

                        //ESCANTEIO 2T >= 4
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo()) >= 4)
                            escanteiosSegundoTempoMaiorIgualQuatroMarcados += 1;

                        //ESCANTEIOS TOTAL >=5
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 5))
                            escanteiosTotalMaiorIgualCincoMarcados += 1;

                        //ESCANTEIOS TOTAL >=6
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 6))
                            escanteiosTotalMaiorIgualSeisMarcados += 1;

                        //ESCANTEIOS TOTAL >=7
                        if((partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 7))
                            escanteiosTotalMaiorIgualSeteMarcados += 1;

                        //TOTAL VIÓRIA 1° TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo())
                            totalVitoriaIntervalo += 1;

                        //TOTAL EMPATE 1° TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() == partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo())
                            totalEmpateIntervalo += 1;

                        //TOTAL DERROTA  1° TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() < partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo())
                            totalDerrotaIntervalo += 1;

                        //TOTAL VIÓRIA 2° TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo())
                            totalVitoriaSegundoTempo += 1;

                        //TOTAL EMPATE 2° TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() == partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo())
                            totalEmpateSegundoTempo += 1;

                        //TOTAL DERROTA  2° TEMPO
                        if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() < partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo())
                            totalDerrotaSegundoTempo += 1;


                    }// fim do for


                    golsPrimeiroTempoZeroCincoNaoMarcados = partidas.size() - golsPrimeiroTempoZeroCincoMarcados;
                    golsPrimeiroTempoUmCincoNaoMarcados = partidas.size() - golsPrimeiroTempoUmCincoMarcados;
                    golsSegundoTempoZeroCincoNaoMarcados = partidas.size() - golsSegundoTempoZeroCincoMarcados;
                    golsSegundoTempoUmCincoNaoMarcados = partidas.size() - golsSegundoTempoUmCincoMarcados;

                    golsTotalZeroCincoNaoMarcados = partidas.size() - golsTotalZeroCincoMarcados;
                    golsTotalUmCincoNaoMarcados = partidas.size() - golsTotalUmCincoMarcados;
                    golsTotalDoisCincoNaoMarcados = partidas.size() - golsTotalDoisCincoMarcados;

                    totalAmbasNaoMarcadosPrimeiroTempo = partidas.size() - totalAmbasMarcadosPrimeiroTempo;
                    totalAmbasNaoMarcadosSegundoTempo = partidas.size() - totalAmbasMarcadosSegundoTempo;

                    escanteiosPrimeiroTempoMaiorIgualDoisNaoMarcados = partidas.size() -  escanteiosPrimeiroTempoMaiorIgualDoisMarcados;
                    escanteiosPrimeiroTempoMaiorIgualTresNaoMarcados = partidas.size() -  escanteiosPrimeiroTempoMaiorIgualTresMarcados;
                    escanteiosPrimeiroTempoMaiorIgualQuatroNaoMarcados = partidas.size() -  escanteiosPrimeiroTempoMaiorIgualQuatroMarcados;

                    escanteiosSegundoTempoMaiorIgualDoisNaoMarcados = partidas.size() -  escanteiosSegundoTempoMaiorIgualDoisMarcados;
                    escanteiosSegundoTempoMaiorIgualTresNaoMarcados = partidas.size() -  escanteiosSegundoTempoMaiorIgualTresMarcados;
                    escanteiosSegundoTempoMaiorIgualQuatroNaoMarcados = partidas.size() -  escanteiosSegundoTempoMaiorIgualQuatroMarcados;

                    escanteiosTotalMaiorIgualCincoNaoMarcados = partidas.size() - escanteiosTotalMaiorIgualCincoMarcados;
                    escanteiosTotalMaiorIgualSeisNaoMarcados = partidas.size() - escanteiosTotalMaiorIgualSeisMarcados;
                    escanteiosTotalMaiorIgualSeteNaoMarcados = partidas.size() - escanteiosTotalMaiorIgualSeteMarcados;



                    binding.tvEstatisticaJogos.setText("ESTATÍSTICA DO " + ( partidas.get(0).getAwayTime().getNome().toUpperCase()) + " FORA");

                    binding.tvGols1T05Mcd.setText(String.valueOf(golsPrimeiroTempoZeroCincoMarcados));
                    binding.tvGols1T05Ct.setText(String.valueOf(golsPrimeiroTempoZeroCincoNaoMarcados));


                    binding.tvGols1T15Mcd.setText(String.valueOf(golsPrimeiroTempoUmCincoMarcados));
                    binding.tvGols1T15Ct.setText(String.valueOf(golsPrimeiroTempoUmCincoNaoMarcados));

                    binding.tvGols2T05Mcd.setText(String.valueOf(golsSegundoTempoZeroCincoMarcados));
                    binding.tvGols2T05Ct.setText(String.valueOf(golsSegundoTempoZeroCincoNaoMarcados));

                    binding.tvGols2T15Mcd.setText(String.valueOf(golsSegundoTempoUmCincoMarcados));
                    binding.tvGols2T15Ct.setText(String.valueOf(golsSegundoTempoUmCincoNaoMarcados));

                    binding.tvGolsAcima05Mcd.setText(String.valueOf(golsTotalZeroCincoMarcados));
                    binding.tvGolsAcima05Ct.setText(String.valueOf(golsTotalZeroCincoNaoMarcados));

                    binding.tvGolsAcima15Mcd.setText(String.valueOf(golsTotalUmCincoMarcados));
                    binding.tvGolsAcima15Ct.setText(String.valueOf(golsTotalUmCincoNaoMarcados));

                    binding.tvGolsAcima25Mcd.setText(String.valueOf(golsTotalDoisCincoMarcados));
                    binding.tvGolsAcima25Ct.setText(String.valueOf(golsTotalDoisCincoNaoMarcados));

                    binding.tvAmbasMarcam1tMcd.setText(String.valueOf(totalAmbasMarcadosPrimeiroTempo));
                    binding.tvAmbasMarcam1tCt.setText(String.valueOf(totalAmbasNaoMarcadosPrimeiroTempo));


                    binding.tvAmbasMarcam2tMcd.setText(String.valueOf(totalAmbasMarcadosSegundoTempo));
                    binding.tvAmbasMarcam2tCt.setText(String.valueOf(totalAmbasNaoMarcadosSegundoTempo));


                    binding.tvEscanteios1TMaiorIgual2Mcd.setText(String.valueOf(escanteiosPrimeiroTempoMaiorIgualDoisMarcados));
                    binding.tvEscanteios1TMaiorIgual2Ct.setText(String.valueOf(escanteiosPrimeiroTempoMaiorIgualDoisNaoMarcados));

                    binding.tvEscanteios1TMaiorIgual3Mcd.setText(String.valueOf(escanteiosPrimeiroTempoMaiorIgualTresMarcados));
                    binding.tvEscanteios1TMaiorIgual3Ct.setText(String.valueOf(escanteiosPrimeiroTempoMaiorIgualTresNaoMarcados));

                    binding.tvEscanteios1TMaiorIgual4Mcd.setText(String.valueOf(escanteiosPrimeiroTempoMaiorIgualQuatroMarcados));
                    binding.tvEscanteios1TMaiorIgual4Ct.setText(String.valueOf(escanteiosPrimeiroTempoMaiorIgualQuatroNaoMarcados));


                    binding.tvEscanteios2tMaiorIgual2Mcd.setText(String.valueOf(escanteiosSegundoTempoMaiorIgualDoisMarcados));
                    binding.tvEscanteios2tMaiorIgual2Ct.setText(String.valueOf(escanteiosSegundoTempoMaiorIgualDoisNaoMarcados));

                    binding.tvEscanteios2tMaiorIgual3Mcd.setText(String.valueOf(escanteiosSegundoTempoMaiorIgualTresMarcados));
                    binding.tvEscanteios2tMaiorIgual3Ct.setText(String.valueOf(escanteiosSegundoTempoMaiorIgualTresNaoMarcados));

                    binding.tvEscanteios2tMaiorIgual4Mcd.setText(String.valueOf(escanteiosSegundoTempoMaiorIgualQuatroMarcados));
                    binding.tvEscanteios2tMaiorIgual4Ct.setText(String.valueOf(escanteiosSegundoTempoMaiorIgualQuatroNaoMarcados));


                    binding.tvEscanteiosTotalMaiorIgual5Mcd.setText(String.valueOf(escanteiosTotalMaiorIgualCincoMarcados));
                    binding.tvEscanteiosTotalMaiorIgual5Ct.setText(String.valueOf(escanteiosTotalMaiorIgualCincoNaoMarcados));


                    binding.tvEscanteiosTotalMaiorIgual6Mcd.setText(String.valueOf(escanteiosTotalMaiorIgualSeisMarcados));
                    binding.tvEscanteiosTotalMaiorIgual6Ct.setText(String.valueOf(escanteiosTotalMaiorIgualSeisNaoMarcados));


                    binding.tvEscanteiosTotalMaiorIgual7Mcd.setText(String.valueOf(escanteiosTotalMaiorIgualSeteMarcados));
                    binding.tvEscanteiosTotalMaiorIgual7Ct.setText(String.valueOf(escanteiosTotalMaiorIgualSeteNaoMarcados));

                    binding.tvIntervaloVitoriaResultado.setText(String.valueOf(totalVitoriaIntervalo));
                    binding.tvIntervaloEmpateResultado.setText(String.valueOf(totalEmpateIntervalo));
                    binding.tvIntervaloDerrotaResultado.setText(String.valueOf(totalDerrotaIntervalo));





                    binding.tv2TempoVitoriaResultado.setText(String.valueOf(totalVitoriaSegundoTempo));
                    binding.tv2TempoEmpateResultado.setText(String.valueOf(totalEmpateSegundoTempo));
                    binding.tv2TempoDerrotaResultado.setText(String.valueOf(totalDerrotaSegundoTempo));




                    binding.tvTotalJogos.setText(String.valueOf(partidas.size()));


                }//fim do se



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
