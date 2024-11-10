package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.amazonas_ui.estatistica.geral_dois_times;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasAdapter;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaOficialPorcentagemBinding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.util.FormatarCoresTextoCasa;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CasaEstatisticaGeralFragment extends Fragment implements JogosSerieB2024Listener {

    private TelaEstatisticaOficialPorcentagemBinding binding;
    private JogosSerieB2024 jogosSerieB2024;

    private ResultadosPartidasAdapter resultadosPartidasAdapter;
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

    private List<PartidaNovoModelo> partidas = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaOficialPorcentagemBinding.inflate(inflater, container, false);

        jogosSerieB2024 = new JogosSerieB2024();
        jogosSerieB2024.setupHttpClient();
        jogosSerieB2024.setupDadosJogos();
        jogosSerieB2024.setListener(this);// Registra o fragmento como listener


        binding.tvGols1T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] GOL 1T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(1);
            }
        });

        binding.tvGols1T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ NÃO SAIU ] GOL 1T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(2);
            }
        });

        binding.tvGols1T15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] GOL 1T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(3);
            }
        });

        binding.tvGols1T15Ct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ NÃO SAIU ] GOL 1T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(4);
            }
        });

        binding.tvGols2T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] GOL 2T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(5);
            }
        });

        binding.tvGols2T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [NÃO SAIU ] GOL 2T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(6);
            }
        });
//
        binding.tvGols2T15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] GOL 2T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(7);
            }
        });

        binding.tvGols2T15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [NÃO SAIU ] GOL 2T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(8);
            }
        });


        binding.tvGolsAcima05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] GOL 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(9);
            }
        });

        binding.tvGolsAcima05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [NÃO SAIU ] GOL 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(10);
            }
        });

        binding.tvGolsAcima15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] GOL 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(11);
            }
        });

        binding.tvGolsAcima15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [NÃO SAIU ] GOL 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(12);
            }
        });

        binding.tvGolsAcima25Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] GOL 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(13);
            }
        });
        binding.tvGolsAcima25Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [NÃO SAIU ] GOL 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(14);
            }
        });

        binding.tvAmbasMarcamMcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] AMBAS ", Toast.LENGTH_LONG).show();
                handleTextViewClick(15);
            }
        });

        binding.tvAmbasMarcamCt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [NÃO SAIU ] AMBAS ", Toast.LENGTH_LONG).show();
                handleTextViewClick(16);
            }
        });

        binding.tvEscanteios1TMaiorIgual5Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] ESCANTEIOS 1T >= 5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(17);
            }
        });
        binding.tvEscanteios1TMaiorIgual5Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [SAIU ] ESCANTEIOS 1T < 5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(18);
            }
        });

        binding.tvEscanteios2TMaiorIgual5Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] ESCANTEIOS 2T >= 5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(19);
            }
        });

        binding.tvEscanteios2TMaiorIgual5Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [SAIU ] ESCANTEIOS 2T < 5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(20);
            }
        });

        binding.tvEscanteiosTotalMaiorIgual8Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] ESCANTEIOS TOTAL >= 8 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(21);
            }
        });
        binding.tvEscanteiosTotalMaiorIgual8Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] ESCANTEIOS TOTAL < 8 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(22);
            }
        });
        binding.tvEscanteiosTotalMaiorIgual9Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] ESCANTEIOS TOTAL >= 9 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(23);
            }
        });
        binding.tvEscanteiosTotalMaiorIgual9Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] ESCANTEIOS TOTAL < 9 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(24);
            }
        });
        binding.tvEscanteiosTotalMaiorIgual10Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] ESCANTEIOS TOTAL >= 10 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(25);
            }
        });
        binding.tvEscanteiosTotalMaiorIgual10Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU ] ESCANTEIOS TOTAL < 10 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(26);
            }
        });

        binding.tvTotalVitoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE VENCEU ", Toast.LENGTH_LONG).show();
                handleTextViewClick(27);
            }
        });
        binding.tvTotalEmpate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE EMPATOU ", Toast.LENGTH_LONG).show();
                handleTextViewClick(28);
            }
        });
        binding.tvTotalDerrota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE SAIU DERROTADO ", Toast.LENGTH_LONG).show();
                handleTextViewClick(29);
            }
        });

        return binding.getRoot();


    }

    @SuppressLint("SuspiciousIndentation")
    private void handleTextViewClick(int textViewId) {
        List<PartidaNovoModelo> jogos = new ArrayList<>();

        switch (textViewId) {
            case 1:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS 0.5 1°TEMPO
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() ) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 2:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 0.5 1°TEMPO
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() ) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 3:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS 1.5 1°TEMPO
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() ) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 4:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 1.5 1°TEMPO
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() ) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 5:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS 0.5 2°TEMPO
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() ) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 6:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 0.5 2°TEMPO
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() ) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 7:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS 1.5 2°TEMPO
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() ) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 8:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 1.5 2°TEMPO
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() ) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 9:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS ACIMA 0.5 TOTAL
                    if(partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > 0 ||
                            partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 0 ||
                            partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > 0 ||
                            partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 10:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 0.5 TOTAL
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) < 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 11:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS ACIMA 1.5 TOTAL
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 12:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 1.5 TOTAL
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 13:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS ACIMA 2.5 TOTAL
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) > 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 14:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 2.5 TOTAL
                    if((partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) +
                            (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) < 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 15:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS AMBAS TOTAL
                    if(((partidas.get(i).getHomeTime().getPlacar()) > 0) &&
                            ((partidas.get(i).getAwayTime().getPlacar() > 0)))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 16:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS NÃO AMBAS TOTAL
                    if((((partidas.get(i).getHomeTime().getPlacar()) > 0) && ((partidas.get(i).getAwayTime().getPlacar() == 0))) ||
                            (((partidas.get(i).getHomeTime().getPlacar()) == 0) && ((partidas.get(i).getAwayTime().getPlacar() > 0))) ||
                            (((partidas.get(i).getHomeTime().getPlacar()) == 0) && ((partidas.get(i).getAwayTime().getPlacar() == 0))))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 17:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIO 1T >= 5
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()) >= 5)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 18:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIO 1T >= 5
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()) < 5)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 19:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIO 2T >= 5
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo()) >= 5)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 20:
                for (int i = 0; i < partidas.size(); i++) {

                    //ESCANTEIO 2T < 5
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo()) +
                            (partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo()) < 5)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 21:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS TOTAL >=8
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 8))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 22:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS TOTAL < 8
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() < 8))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 23:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS TOTAL >= 9
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 9))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 24:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS TOTAL < 9
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() < 9))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 25:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS TOTAL >= 10
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() >= 10))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 26:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS TOTAL < 10
                    if((partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() +
                            partidas.get(i).getAwayEstatisticaJogo().getEscanteioSegundoTempo() < 10))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 27:
                for (int i = 0; i < partidas.size(); i++) {
                    //TOTAL VIÓRIA CASA
                    if(partidas.get(i).getHomeTime().getPlacar() > partidas.get(i).getAwayTime().getPlacar())
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 28:
                for (int i = 0; i < partidas.size(); i++) {
                    //TOTAL EMPATE CASA
                    if(partidas.get(i).getHomeTime().getPlacar() == partidas.get(i).getAwayTime().getPlacar())
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 29:
                for (int i = 0; i < partidas.size(); i++) {
                    //TOTAL DERROTA CASA
                    if(partidas.get(i).getHomeTime().getPlacar() < partidas.get(i).getAwayTime().getPlacar())
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;




        }//fim do switch
    }







    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao Retornar Dados Estatístico. ", Snackbar.LENGTH_LONG).show();
    }


    @Override
    public void onJogosSerieBReady(List<PartidaNovoModelo> amazonasCompleto, List<PartidaNovoModelo> americaMGCompleto, List<PartidaNovoModelo> avaiCompleto, List<PartidaNovoModelo> botafogoSPCompleto, List<PartidaNovoModelo> brusqueCompleto, List<PartidaNovoModelo> crbCompleto, List<PartidaNovoModelo> cearaCompleto, List<PartidaNovoModelo> chapecoenseCompleto, List<PartidaNovoModelo> coritibaCompleto, List<PartidaNovoModelo> goiasCompleto, List<PartidaNovoModelo> guaraniCompleto, List<PartidaNovoModelo> ituanoCompleto, List<PartidaNovoModelo> mirassolCompleto, List<PartidaNovoModelo> novorizontinoCompleto, List<PartidaNovoModelo> operarioCompleto, List<PartidaNovoModelo> paysanduCompleto, List<PartidaNovoModelo> pontepretaCompleto, List<PartidaNovoModelo> santosCompleto, List<PartidaNovoModelo> sportCompleto, List<PartidaNovoModelo> vilanovaCompleto) {



        PartidaNovoModelo partidaNovoModelo = new PartidaNovoModelo();

        for (PartidaNovoModelo partida : amazonasCompleto) {

            if (partida.getHomeTime().getName().equals("Amazonas")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for


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

        String nome = partidas.get(0).getHomeTime().getNome();
        String totalJogos = String.valueOf(partidas.size());
        String totalGolsMcd = String.valueOf(golsTotalZeroCincoMarcados );
        String totalGolsMcdPct = String.valueOf(Math.round(((double)golsTotalZeroCincoMarcados * 100 ) / partidas.size()));

        // Formate o texto usando a classe TextUtils
        SpannableStringBuilder builder = FormatarCoresTextoCasa.formatText(nome, totalJogos, totalGolsMcd, totalGolsMcdPct);

        // Defina o texto no TextView
        binding.tvRespostaEstatistica.setText(builder);
    }//fim da interface

    private void showPartidasDialog(List<PartidaNovoModelo> partidas) {


        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_partidas, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        RecyclerView recyclerViewPartidas = bottomSheetView.findViewById(R.id.recyclerViewPartidas);
        recyclerViewPartidas.setLayoutManager(new LinearLayoutManager(requireContext()));



        resultadosPartidasAdapter = new ResultadosPartidasAdapter(partidas);
        recyclerViewPartidas.setAdapter(resultadosPartidasAdapter);
        //resultadosPartidasAdapter.notifyDataSetChanged();

        bottomSheetDialog.show();

    }
}
