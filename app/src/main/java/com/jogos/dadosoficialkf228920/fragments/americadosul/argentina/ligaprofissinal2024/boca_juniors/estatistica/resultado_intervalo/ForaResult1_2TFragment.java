package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.boca_juniors.estatistica.resultado_intervalo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadoPartidaSegundoTempoAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasPrimeiroTempoAdapter;
import com.jogos.dadosoficialkf228920.databinding.TelaResultadoPrimeiroSegundoTempoBinding;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A2024;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A_2024_Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

public class ForaResult1_2TFragment extends Fragment implements JogosLigaProfissional_A_2024_Listener {

    private TelaResultadoPrimeiroSegundoTempoBinding binding;
    private JogosLigaProfissional_A2024 jogosLigaProfissionalA2024;

    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;

    private ResultadoPartidaSegundoTempoAdapter resultadoPartidaSegundoTempoAdapter;

    private int vitoriaPrimeiroTempo;
    private int empatePrimeiroTempo;
    private int derrotaPrimeiroTempo;

    private int vitoriaSegundoTempo;
    private int empateSegundoTempo;
    private int derrotaSegundoTempo;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = TelaResultadoPrimeiroSegundoTempoBinding.inflate(inflater, container, false);

        jogosLigaProfissionalA2024 = new JogosLigaProfissional_A2024();
        jogosLigaProfissionalA2024.setupHttpClient();
        jogosLigaProfissionalA2024.setupDadosJogos();
        jogosLigaProfissionalA2024.setListener(this);// Registra o fragmento como listener

        binding.tv1TempoVitoriaResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "RESULTADO NO 1T QUE [ VENCEU ]", Toast.LENGTH_LONG).show();
                handleTextViewClick(1);
            }
        });
        binding.tv1TempoEmpateResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "RESULTADO NO 1T QUE [ EMPATOU ]", Toast.LENGTH_LONG).show();
                handleTextViewClick(2);
            }
        });
        binding.tv1TempoDerrotaResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "RESULTADO NO 1T QUE [ SAIU DERROTADO ]", Toast.LENGTH_LONG).show();
                handleTextViewClick(3);
            }
        });

        binding.tv2TempoVitoriaResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "RESULTADO NO 2T QUE [ VENCEU ]", Toast.LENGTH_LONG).show();
                handleTextViewClick(4);
            }
        });
        binding.tv2TempoEmpateResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "RESULTADO NO 2T QUE [ EMPATOU ]", Toast.LENGTH_LONG).show();
                handleTextViewClick(5);
            }
        });
        binding.tv2TempoDerrotaResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "RESULTADO NO 2T QUE [ SAIU DERROTADO ]", Toast.LENGTH_LONG).show();
                handleTextViewClick(6);
            }
        });


        return binding.getRoot();
    }

    private void handleTextViewClick(int textViewId) {

        List<PartidaNovoModelo> jogos = new ArrayList<>();

        switch (textViewId) {
            case 1:
                for (int i = 0; i < partidas.size(); i++) {
                    //PARTIDAS QUE VENCEU NO 1°TEMPO
                    if (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo())
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
                    //PARTIDAS QUE EMPATOU NO 1°TEMPO
                    if (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() == partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo())
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
                    //PARTIDAS QUE SAIU DERROTADO NO 1°TEMPO
                    if (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() < partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo())
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
                    //PARTIDAS QUE VENCEU NO 1°TEMPO
                    if (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo())
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 5:
                for (int i = 0; i < partidas.size(); i++) {
                    //PARTIDAS QUE EMPATOU NO 1°TEMPO
                    if (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() == partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo())
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 6:
                for (int i = 0; i < partidas.size(); i++) {
                    //PARTIDAS QUE SAIU DERROTADO NO 1°TEMPO
                    if (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() < partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo())
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasSegundoTempo(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;

        }

    }


    @Override
    public void onJogosSerieAReady(List<PartidaNovoModelo> argentinoJuniorsCompleto, List<PartidaNovoModelo> atleticoTucumanCompleto, List<PartidaNovoModelo> banfieldCompleto, List<PartidaNovoModelo> barracasCentralCompleto, List<PartidaNovoModelo> belgranoCompleto, List<PartidaNovoModelo> bocaJuniorsCompleto, List<PartidaNovoModelo> centralCordobaCompleto, List<PartidaNovoModelo> defensaJusticiaCompleto, List<PartidaNovoModelo> deportivoRiestraCompleto, List<PartidaNovoModelo> estudiantesLaPrataCompleto, List<PartidaNovoModelo> gimnasiaCompleto, List<PartidaNovoModelo> godoyCruzCompleto, List<PartidaNovoModelo> huracanCompleto, List<PartidaNovoModelo> independienteCompleto, List<PartidaNovoModelo> independienteRivadaviaCompleto, List<PartidaNovoModelo> institutoCompleto, List<PartidaNovoModelo> lanusCompleto, List<PartidaNovoModelo> newellOldBoysCompleto, List<PartidaNovoModelo> platenseCompleto, List<PartidaNovoModelo> racingCompleto, List<PartidaNovoModelo> riverPlateCompleto, List<PartidaNovoModelo> rosarioCentralCompleto, List<PartidaNovoModelo> sanLorenzoCompleto, List<PartidaNovoModelo> sarmientoCompleto, List<PartidaNovoModelo> talleresCompleto, List<PartidaNovoModelo> tigreCompleto, List<PartidaNovoModelo> unionSantaFeCompleto, List<PartidaNovoModelo> velezSarsfieldCompleto) {


        PartidaNovoModelo partidaNovoModelo;

        for (PartidaNovoModelo partida : bocaJuniorsCompleto) {

            if (partida.getAwayTime().getName().equals("Boca Juniors")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        for (int i = 0; i < partidas.size(); i++) {

            //TOTAL VIÓRIA PRIMEIRO TEMPO
            if (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() > partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) {
                vitoriaPrimeiroTempo += 1;
            }
            //TOTAL EMPATE PRIMEIRO TEMPO
            if (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() == partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) {
                empatePrimeiroTempo += 1;
            }
            //TOTAL DERROTA PRIMEIRO TEMPO
            if (partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo() < partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo()) {
                derrotaPrimeiroTempo += 1;
            }

            //TOTAL VIÓRIA SEGUNDO TEMPO
            if (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() > partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) {
                vitoriaSegundoTempo += 1;
            }
            //TOTAL EMPATE SEGUNDO TEMPO
            if (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() == partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) {
                empateSegundoTempo += 1;
            }
            //TOTAL DERROTA SEGUNDO TEMPO
            if (partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo() < partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo()) {
                derrotaSegundoTempo += 1;
            }


        }//fim do for que faz a comparação dos resultados dos tempos


        binding.tvTituloResultado.setText("RESULTADO DO 1°TEMPO E 2°TEMPO " + partidas.get(0).getAwayTime().getName().toUpperCase() + " FORA");

        //Resultado dos Tempos
        binding.tv1TempoVitoriaResultado.setText(String.valueOf(vitoriaPrimeiroTempo));
        binding.tv1TempoEmpateResultado.setText(String.valueOf(empatePrimeiroTempo));
        binding.tv1TempoDerrotaResultado.setText(String.valueOf(derrotaPrimeiroTempo));

        binding.tv2TempoVitoriaResultado.setText(String.valueOf(vitoriaSegundoTempo));
        binding.tv2TempoEmpateResultado.setText(String.valueOf(empateSegundoTempo));
        binding.tv2TempoDerrotaResultado.setText(String.valueOf(derrotaSegundoTempo));




    }//fim da interface

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
