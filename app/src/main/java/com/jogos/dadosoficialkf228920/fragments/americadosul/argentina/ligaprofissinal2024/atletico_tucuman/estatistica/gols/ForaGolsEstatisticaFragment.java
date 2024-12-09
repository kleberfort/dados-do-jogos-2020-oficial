package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.atletico_tucuman.estatistica.gols;

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
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadoPartidaSegundoTempoAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasPrimeiroTempoAdapter;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaGolsBinding;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A2024;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A_2024_Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.util.FormatarCoresTextoGolsMcdFora;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ForaGolsEstatisticaFragment extends Fragment implements JogosLigaProfissional_A_2024_Listener {


    private TelaEstatisticaGolsBinding binding;
    private JogosLigaProfissional_A2024 jogosLigaProfissionalA2024;

    private ResultadosPartidasAdapter resultadosPartidasAdapter;
    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;
    private ResultadoPartidaSegundoTempoAdapter resultadoPartidaSegundoTempoAdapter;



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


        jogosLigaProfissionalA2024 = new JogosLigaProfissional_A2024();
        jogosLigaProfissionalA2024.setupHttpClient();
        jogosLigaProfissionalA2024.setupDadosJogos();
        jogosLigaProfissionalA2024.setListener(this);// Registra o fragmento como listener

        binding.tvGols1T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 1T QUE [ MARCOU ] GOL 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(1);
            }
        });

        binding.tvGols1T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 1T QUE [ NÃO MARCOU ] GOL 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(2);
            }
        });

        binding.tvGols1T15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 1T QUE [ MARCOU ] GOL 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(3);

            }
        });

        binding.tvGols1T15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 1T QUE [ NÃO MARCOU ] GOL 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(4);

            }
        });

        binding.tvGols1T25Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 1T QUE [ MARCOU ] GOL 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(5);

            }
        });

        binding.tvGols1T25Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 1T QUE [ NÃO MARCOU ] GOL 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(6);

            }
        });

        binding.tvGols2T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 2T QUE [ MARCOU ] GOL 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(7);

            }
        });

        binding.tvGols2T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 2T QUE [ NÃO MARCOU ] GOL 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(8);


            }
        });

        binding.tvGols2T15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 2T QUE [ MARCOU ] GOL 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(9);

            }
        });

        binding.tvGols2T15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 2T QUE [ NÃO MARCOU ] GOL 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(10);

            }
        });

        binding.tvGols2T25Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 2T QUE [ MARCOU ] GOL 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(11);

            }
        });

        binding.tvGols2T25Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO FINAL ] DO 2T QUE [ NÃO MARCOU ] GOL 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(12);

            }
        });

        binding.tvGolsAcima05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO PARTIDA ] QUE [ MARCOU ] GOL 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(13);

            }
        });

        binding.tvGolsAcima05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO PARTIDA ] QUE [ NÃO MARCOU ] GOL 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(14);

            }
        });

        binding.tvGolsAcima15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO PARTIDA ] QUE [ MARCOU ] GOL 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(15);

            }
        });

        binding.tvGolsAcima15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO PARTIDA ] QUE [ NÃO MARCOU ] GOL 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(16);

            }
        });

        binding.tvGolsAcima25Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO PARTIDA ] QUE [ MARCOU ] GOL 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(17);

            }
        });

        binding.tvGolsAcima25Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO PARTIDA ] QUE [ NÃO MARCOU ] GOL 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(18);

            }
        });
        binding.tvGolsAcima35Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO PARTIDA ] QUE [ MARCOU ] GOL 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(19);

            }
        });
        binding.tvGolsAcima35Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "[ RESULTADO PARTIDA ] QUE [ NÃO MARCOU ] GOL 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(20);

            }
        });


        return binding.getRoot();


    }

    private void handleTextViewClick(int textViewId) {
        List<PartidaNovoModelo> jogos = new ArrayList<>();

        switch (textViewId) {
            case 1:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS 0.5 1°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 0.5 1°TEMPO
                    if((partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() == 0 ))
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 3:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS  1.5 1°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 4:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 1.5 1°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 5:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS  2.5 1°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 6:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 2.5 1°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() < 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 7:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS  0.5 2°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 8:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 0.5 2°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 9:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS  1.5 2°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 10:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 1.5 2°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 11:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS  2.5 2°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 12:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS MENOR 2.5 2°TEMPO
                    if(partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() < 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 13:
                for (int i = 0; i < partidas.size(); i++) {
                    //GOLS ACIMA 0.5 TEMPO
                    if(partidas.get(i).getAwayTime().getPlacar() > 0)
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
                    //GOLS MENOR 0.5 TEMPO
                    if(partidas.get(i).getAwayTime().getPlacar() == 0)
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
                    //GOLS ACIMA 1.5 TEMPO
                    if(partidas.get(i).getAwayTime().getPlacar() > 1)
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
                    //GOLS MENOR 1.5 TEMPO
                    if(partidas.get(i).getAwayTime().getPlacar() < 2)
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
                    //GOLS ACIMA 2.5 TEMPO
                    if(partidas.get(i).getAwayTime().getPlacar() > 2)
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
                    //GOLS MENOR 2.5 TEMPO
                    if(partidas.get(i).getAwayTime().getPlacar() < 3)
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
                    //GOLS ACIMA 3.5 TEMPO
                    if(partidas.get(i).getAwayTime().getPlacar() > 3)
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
                    //GOLS MENOR 3.5 TEMPO
                    if(partidas.get(i).getAwayTime().getPlacar() < 4)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                }else{
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

        }

    }//fim do metodo que busca os dados


    @SuppressLint("SuspiciousIndentation")
    @Override
    public void onJogosSerieAReady(List<PartidaNovoModelo> argentinoJuniorsCompleto, List<PartidaNovoModelo> atleticoTucumanCompleto, List<PartidaNovoModelo> banfieldCompleto, List<PartidaNovoModelo> barracasCentralCompleto, List<PartidaNovoModelo> belgranoCompleto, List<PartidaNovoModelo> bocaJuniorsCompleto, List<PartidaNovoModelo> centralCordobaCompleto, List<PartidaNovoModelo> defensaJusticiaCompleto, List<PartidaNovoModelo> deportivoRiestraCompleto, List<PartidaNovoModelo> estudiantesLaPrataCompleto, List<PartidaNovoModelo> gimnasiaCompleto, List<PartidaNovoModelo> godoyCruzCompleto, List<PartidaNovoModelo> huracanCompleto, List<PartidaNovoModelo> independienteCompleto, List<PartidaNovoModelo> independienteRivadaviaCompleto, List<PartidaNovoModelo> institutoCompleto, List<PartidaNovoModelo> lanusCompleto, List<PartidaNovoModelo> newellOldBoysCompleto, List<PartidaNovoModelo> platenseCompleto, List<PartidaNovoModelo> racingCompleto, List<PartidaNovoModelo> riverPlateCompleto, List<PartidaNovoModelo> rosarioCentralCompleto, List<PartidaNovoModelo> sanLorenzoCompleto, List<PartidaNovoModelo> sarmientoCompleto, List<PartidaNovoModelo> talleresCompleto, List<PartidaNovoModelo> tigreCompleto, List<PartidaNovoModelo> unionSantaFeCompleto, List<PartidaNovoModelo> velezSarsfieldCompleto) {
        PartidaNovoModelo partidaNovoModelo;


        for (PartidaNovoModelo partida : atleticoTucumanCompleto) {

            if (partida.getAwayTime().getName().equals("Atl. Tucuman")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for



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



        binding.tvTitulo.setText("GOLS MARCADOS " + partidas.get(0).getAwayTime().getName().toUpperCase() + " FORA");


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

        String nome = partidas.get(0).getAwayTime().getName();
        String totalJogos = String.valueOf(partidas.size());
        String totalGolsMcd = String.valueOf(golsTotalZeroCincoMarcados );
        String totalGolsMcdPct = String.valueOf(Math.round(((double)golsTotalZeroCincoMarcados * 100 ) / partidas.size()));

        // Formate o texto usando a classe TextUtils
        SpannableStringBuilder builder = FormatarCoresTextoGolsMcdFora.formatText(nome, totalJogos, totalGolsMcd, totalGolsMcdPct);

        // Defina o texto no TextView
        binding.tvRespostaEstatistica.setText(builder);
    }

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
    private void showPartidasPrimeiroTempo(List<PartidaNovoModelo> partidas) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_partidas, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        RecyclerView recyclerViewPartidas = bottomSheetView.findViewById(R.id.recyclerViewPartidas);
        recyclerViewPartidas.setLayoutManager(new LinearLayoutManager(requireContext()));

        resultadosPartidasPrimeiroTempoAdapter = new ResultadosPartidasPrimeiroTempoAdapter(partidas);
        recyclerViewPartidas.setAdapter(resultadosPartidasPrimeiroTempoAdapter);
        //resultadosPartidasAdapter.notifyDataSetChanged();

        bottomSheetDialog.show();
    }
    private void showPartidasSegundoTempo(List<PartidaNovoModelo> partidas) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_partidas, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        RecyclerView recyclerViewPartidas = bottomSheetView.findViewById(R.id.recyclerViewPartidas);
        recyclerViewPartidas.setLayoutManager(new LinearLayoutManager(requireContext()));

        resultadoPartidaSegundoTempoAdapter = new ResultadoPartidaSegundoTempoAdapter(partidas);
        recyclerViewPartidas.setAdapter(resultadoPartidaSegundoTempoAdapter);
        //resultadosPartidasAdapter.notifyDataSetChanged();

        bottomSheetDialog.show();
    }
}

