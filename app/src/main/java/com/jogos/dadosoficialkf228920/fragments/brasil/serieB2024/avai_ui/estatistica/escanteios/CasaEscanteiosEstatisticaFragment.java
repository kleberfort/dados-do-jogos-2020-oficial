package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.avai_ui.estatistica.escanteios;

import android.os.Bundle;
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
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaEscanteiosBinding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CasaEscanteiosEstatisticaFragment extends Fragment implements JogosSerieB2024Listener {

    private TelaEstatisticaEscanteiosBinding binding;

    private JogosSerieB2024 jogosSerieB2024;
    private ResultadosPartidasAdapter resultadosPartidasAdapter;
    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;
    private ResultadoPartidaSegundoTempoAdapter resultadoPartidaSegundoTempoAdapter;

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




    private List<PartidaNovoModelo> partidas = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaEstatisticaEscanteiosBinding.inflate(inflater, container, false);


        jogosSerieB2024 = new JogosSerieB2024();
        jogosSerieB2024.setupHttpClient();
        jogosSerieB2024.setupDadosJogos();
        jogosSerieB2024.setListener(this);// Registra o fragmento como listener


        binding.tvEscanteios1T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] 1T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(1);
            }
        });

        binding.tvEscanteios1T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] 1T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(2);
            }
        });

        binding.tvEscanteios1T15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] 1T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(3);
            }
        });

        binding.tvEscanteios1T15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] 1T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(4);
            }
        });
        binding.tvEscanteios1T25Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] 1T 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(5);
            }
        });

        binding.tvEscanteios1T25Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] 1T 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(6);
            }
        });
        binding.tvEscanteios1T35Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] 1T 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(7);
            }
        });

        binding.tvEscanteios1T35Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] 1T 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(8);
            }
        });

        //ESCANTEIOS 2° TEMPO

        binding.tvEscanteios2T05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] 2T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(9);
            }
        });

        binding.tvEscanteios2T05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] 2T 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(10);
            }
        });

        binding.tvEscanteios2T15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] 2T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(11);
            }
        });

        binding.tvEscanteios2T15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] 2T 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(12);
            }
        });
        binding.tvEscanteios2T25Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] 2T 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(13);
            }
        });

        binding.tvEscanteios2T25Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] 2T 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(14);
            }
        });
        binding.tvEscanteios2T35Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] 2T 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(15);
            }
        });

        binding.tvEscanteios2T35Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] 2T 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(16);
            }
        });

        //ESCANTEIOS ACIMA

        binding.tvEscanteiosTotal05Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] ACIMA 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(17);

            }
        });
        binding.tvEscanteiosTotal05Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] ACIMA 0.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(18);

            }
        });
        binding.tvEscanteiosTotal15Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] ACIMA 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(19);

            }
        });
        binding.tvEscanteiosTotal15Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] ACIMA 1.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(20);

            }
        });

        binding.tvEscanteiosTotal25Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] ACIMA 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(21);

            }
        });
        binding.tvEscanteiosTotal25Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] ACIMA 2.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(22);

            }
        });

        binding.tvEscanteiosTotal35Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] ACIMA 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(23);

            }
        });
        binding.tvEscanteiosTotal35Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] ACIMA 3.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(24);

            }
        });

        binding.tvEscanteiosTotal45Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] ACIMA 4.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(25);

            }
        });
        binding.tvEscanteiosTotal45Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] ACIMA 4.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(26);

            }
        });

        binding.tvEscanteiosTotal55Mcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE [ SAIU ] ACIMA 5.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(27);

            }
        });
        binding.tvEscanteiosTotal55Ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ESCANTEIOS QUE NÃO [ SAIU ] ACIMA 5.5 ", Toast.LENGTH_LONG).show();
                handleTextViewClick(28);

            }
        });





        return binding.getRoot();


    }

    private void handleTextViewClick(int textViewId) {
        List<PartidaNovoModelo> jogos = new ArrayList<>();

        switch (textViewId) {
            case 1:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS 0.5 1°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 0)
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
                    //ESCANTEIOS MENOR 0.5 1°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 3:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS 1.5 1°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 4:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 1.5 1°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 5:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS 2.5 1°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 6:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 2.5 1°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() < 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 7:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS 3.5 1°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 8:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 3.5 1°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() < 4)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasPrimeiroTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

                //ESCANTEIOS 2° TEMPO

            case 9:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS 0.5 2°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 10:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 0.5 2°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 11:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS 1.5 2°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 12:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 1.5 2°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 13:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS 2.5 2°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 14:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 2.5 2°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() < 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 15:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS 3.5 2°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 16:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 3.5 2°TEMPO
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() < 4)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

                //ESCANTEIOS TOTAIS

            case 17:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS ACIMA 0.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 18:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 0.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() == 0)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case 19:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS ACIMA 1.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 20:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 1.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() < 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 21:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS ACIMA 2.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 22:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 2.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() < 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 23:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS ACIMA 3.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 24:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 3.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() < 4)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 25:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS ACIMA 4.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 4)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 26:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 4.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() < 5)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 27:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS ACIMA 5.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 5)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 28:
                for (int i = 0; i < partidas.size(); i++) {
                    //ESCANTEIOS MENOR 5.5
                    if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                            + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() < 6)
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;


        }
    }


    @Override
    public void onJogosSerieBReady(List<PartidaNovoModelo> amazonasCompleto, List<PartidaNovoModelo> americaMGCompleto, List<PartidaNovoModelo> avaiCompleto, List<PartidaNovoModelo> botafogoSPCompleto, List<PartidaNovoModelo> brusqueCompleto, List<PartidaNovoModelo> crbCompleto, List<PartidaNovoModelo> cearaCompleto, List<PartidaNovoModelo> chapecoenseCompleto, List<PartidaNovoModelo> coritibaCompleto, List<PartidaNovoModelo> goiasCompleto, List<PartidaNovoModelo> guaraniCompleto, List<PartidaNovoModelo> ituanoCompleto, List<PartidaNovoModelo> mirassolCompleto, List<PartidaNovoModelo> novorizontinoCompleto, List<PartidaNovoModelo> operarioCompleto, List<PartidaNovoModelo> paysanduCompleto, List<PartidaNovoModelo> pontepretaCompleto, List<PartidaNovoModelo> santosCompleto, List<PartidaNovoModelo> sportCompleto, List<PartidaNovoModelo> vilanovaCompleto) {



        PartidaNovoModelo partidaNovoModelo;

        for (PartidaNovoModelo partida : avaiCompleto) {

            if (partida.getHomeTime().getName().equals("Avaí")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        for (int i = 0; i < partidas.size(); i++) {
            //ESCANTEIOS 0.5 1°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 0)
                escanteiosPrimeiroTempoZeroCincoMarcados += 1;
            escanteiosPrimeiroTempoZeroCincoNaoMarcados = partidas.size() - escanteiosPrimeiroTempoZeroCincoMarcados;


            //ESCANTEIOS 1.5 1°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 1)
                escanteiosPrimeiroTempoUmCincoMarcados += 1;
            escanteiosPrimeiroTempoUmCincoNaoMarcados = partidas.size() - escanteiosPrimeiroTempoUmCincoMarcados;


            //ESCANTEIOS 2.5 1°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 2)
                escanteiosPrimeiroTempoDoisCincoMarcados += 1;
            escanteiosPrimeiroTempoDoisCincoNaoMarcados = partidas.size() - escanteiosPrimeiroTempoDoisCincoMarcados;

            //ESCANTEIOS 3.5 1°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() > 3)
                escanteiosPrimeiroTempoTresCincoMarcados += 1;
            escanteiosPrimeiroTempoTresCincoNaoMarcados = partidas.size() - escanteiosPrimeiroTempoTresCincoMarcados;


//                        SEGUNDO TEMPO -----------------------------------------------------------------------

            //ESCANTEIOS 0.5 2°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                escanteiosSegundoTempoZeroCincoMarcados += 1;
            escanteiosSegundoTempoZeroCincoNaoMarcados = partidas.size() - escanteiosSegundoTempoZeroCincoMarcados;


            //ESCANTEIOS 1.5 2°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                escanteiosSegundoTempoUmCincoMarcados += 1;
            escanteiosSegundoTempoUmCincoNaoMarcados = partidas.size() - escanteiosSegundoTempoUmCincoMarcados;


            //ESCANTEIOS 2.5 2°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                escanteiosSegundoTempoDoisCincoMarcados += 1;
            escanteiosSegundoTempoDoisCincoNaoMarcados = partidas.size() - escanteiosSegundoTempoDoisCincoMarcados;

            //ESCANTEIOS 3.5 2°TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                escanteiosSegundoTempoTresCincoMarcados += 1;
            escanteiosSegundoTempoTresCincoNaoMarcados = partidas.size() - escanteiosSegundoTempoTresCincoMarcados;

//                        ESCANTEIOS ACIMA -----------------------------------------------------------------------------


            //ESCANTEIOS ACIMA 0.5 TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                    + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 0)
                escanteiosTotalZeroCincoMarcados += 1;
            escanteiosTotalZeroCincoNaoMarcados = partidas.size() - escanteiosTotalZeroCincoMarcados;

            //ESCANTEIOS ACIMA 1.5 TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()
                    + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 1)
                escanteiosTotalUmCincoMarcados += 1;
            escanteiosTotalUmCincoNaoMarcados = partidas.size() - escanteiosTotalUmCincoMarcados;


            //ESCANTEIOS ACIMA 2.5 TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 2)
                escanteiosTotalDoisCincoMarcados += 1;
            escanteiosTotalDoisCincoNaoMarcados = partidas.size() - escanteiosTotalDoisCincoMarcados;


            //ESCANTEIOS ACIMA 3.5 TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 3)
                escanteiosTotalTresCincoMarcados += 1;
            escanteiosTotalTresCincoNaoMarcados = partidas.size() - escanteiosTotalTresCincoMarcados;


            //ESCANTEIOS ACIMA 4.5 TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 4)
                escanteiosTotalQuatroCincoMarcados += 1;
            escanteiosTotalQuatroCincoNaoMarcados = partidas.size() - escanteiosTotalQuatroCincoMarcados;


            //ESCANTEIOS ACIMA 5.5 TEMPO
            if(partidas.get(i).getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + partidas.get(i).getHomeEstatisticaJogo().getEscanteioSegundoTempo() > 5)
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



        binding.tvTituloCanto.setText("ESTATÍSTICA DE CANTOS " + partidas.get(0).getHomeTime().getName().toUpperCase() + " CASA");



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
