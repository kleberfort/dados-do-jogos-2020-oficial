package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.sport_ui.estatistica.gols;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaGolsBinding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.util.FormatarCoresTextoGolsMcdCasa;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CasaGolsEstatisticaFragment extends Fragment implements JogosSerieB2024Listener {

    private TelaEstatisticaGolsBinding binding;
    private JogosSerieB2024 jogosSerieB2024;



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

    private List<PartidaNovoModelo> partidas = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaGolsBinding.inflate(inflater, container, false);

        jogosSerieB2024 = new JogosSerieB2024();
        jogosSerieB2024.setupHttpClient();
        jogosSerieB2024.setupDadosJogos();
        jogosSerieB2024.setListener(this);// Registra o fragmento como listener


        return binding.getRoot();


    }




    @Override
    public void onJogosSerieBReady(List<PartidaNovoModelo> amazonasCompleto, List<PartidaNovoModelo> americaMGCompleto, List<PartidaNovoModelo> avaiCompleto, List<PartidaNovoModelo> botafogoSPCompleto, List<PartidaNovoModelo> brusqueCompleto, List<PartidaNovoModelo> crbCompleto, List<PartidaNovoModelo> cearaCompleto, List<PartidaNovoModelo> chapecoenseCompleto, List<PartidaNovoModelo> coritibaCompleto, List<PartidaNovoModelo> goiasCompleto, List<PartidaNovoModelo> guaraniCompleto, List<PartidaNovoModelo> ituanoCompleto, List<PartidaNovoModelo> mirassolCompleto, List<PartidaNovoModelo> novorizontinoCompleto, List<PartidaNovoModelo> operarioCompleto, List<PartidaNovoModelo> paysanduCompleto, List<PartidaNovoModelo> pontepretaCompleto, List<PartidaNovoModelo> santosCompleto, List<PartidaNovoModelo> sportCompleto, List<PartidaNovoModelo> vilanovaCompleto) {



        PartidaNovoModelo partidaNovoModelo = new PartidaNovoModelo();

        for (PartidaNovoModelo partida : sportCompleto) {

            if (partida.getHomeTime().getName().equals("Sport")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        for (int i = 0; i < partidas.size(); i++) {
            //GOLS 0.5 1°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 0)
                golsTotalPrimeiroTempoZeroCincoMarcados += 1;
            golsTotalPrimeiroTempoZeroCincoNaoMarcados = partidas.size() - golsTotalPrimeiroTempoZeroCincoMarcados;


            //GOLS 1.5 1°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 1)
                golsTotalPrimeiroTempoUmCincoMarcados += 1;
            golsTotalPrimeiroTempoUmCincoNaoMarcados = partidas.size() - golsTotalPrimeiroTempoUmCincoMarcados;


            //GOLS 2.5 1°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 2)
                golsTotalPrimeiroTempoDoisCincoMarcados += 1;
            golsTotalPrimeiroTempoDoisCincoNaoMarcados = partidas.size() - golsTotalPrimeiroTempoDoisCincoMarcados;


//                        SEGUNDO TEMPO -----------------------------------------------------------------------

            //GOLS 0.5 2°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 0)
                golsTotalSegundoTempoZeroCincoMarcados += 1;
            golsTotalSegundoTempoZeroCincoNaoMarcados = partidas.size() - golsTotalSegundoTempoZeroCincoMarcados;


            //GOLS 1.5 2°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 1)
                golsTotalSegundoTempoUmCincoMarcados += 1;
            golsTotalSegundoTempoUmCincoNaoMarcados = partidas.size() - golsTotalSegundoTempoUmCincoMarcados;


            //GOLS 2.5 2°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 2)
                golsTotalSegundoTempoDoisCincoMarcados += 1;
            golsTotalSegundoTempoDoisCincoNaoMarcados = partidas.size() - golsTotalSegundoTempoDoisCincoMarcados;

//                        GOLS ACIMA -----------------------------------------------------------------------------


            //GOLS ACIMA 0.5 TEMPO
            if(partidas.get(i).getHomeTime().getPlacar() > 0)
                golsTotalZeroCincoMarcados += 1;
            golsTotalZeroCincoNaoMarcados = partidas.size() - golsTotalZeroCincoMarcados;

            //GOLS ACIMA 1.5 TEMPO
            if(partidas.get(i).getHomeTime().getPlacar() > 1)
                golsTotalUmCincoMarcados += 1;
            golsTotalUmCincoNaoMarcados = partidas.size() - golsTotalUmCincoMarcados;


            //GOLS ACIMA 2.5 TEMPO
            if(partidas.get(i).getHomeTime().getPlacar() > 2)
                golsTotalDoisCincoMarcados += 1;
            golsTotalDoisCincoNaoMarcados = partidas.size() - golsTotalDoisCincoMarcados;


            //GOLS ACIMA 3.5 TEMPO
            if(partidas.get(i).getHomeTime().getPlacar() > 3)
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



        binding.tvTitulo.setText("GOLS MARCADOS " + partidas.get(0).getHomeTime().getName().toUpperCase() + " CASA");



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

        String nome = partidas.get(0).getHomeTime().getNome();
        String totalJogos = String.valueOf(partidas.size());
        String totalGolsMcd = String.valueOf(golsTotalZeroCincoMarcados );
        String totalGolsMcdPct = String.valueOf(Math.round(((double)golsTotalZeroCincoMarcados * 100 ) / partidas.size()));

        // Formate o texto usando a classe TextUtils
        SpannableStringBuilder builder = FormatarCoresTextoGolsMcdCasa.formatText(nome, totalJogos, totalGolsMcd, totalGolsMcdPct);

        // Defina o texto no TextView
        binding.tvRespostaEstatistica.setText(builder);

    }
}
