package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.ceara_ui.estatistica.resultado_intervalo;

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
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasPrimeiroTempoAdapter;
import com.jogos.dadosoficialkf228920.databinding.TelaResultadoPrimeiroSegundoTempoBinding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

public class CasaResultadoPrimeiroTempoFragment extends Fragment implements JogosSerieB2024Listener{

    private TelaResultadoPrimeiroSegundoTempoBinding binding;
    private JogosSerieB2024 jogosSerieB2024;

    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;

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

        jogosSerieB2024 = new JogosSerieB2024();
        jogosSerieB2024.setupHttpClient();
        jogosSerieB2024.setupDadosJogos();
        jogosSerieB2024.setListener(this);// Registra o fragmento como listener

        binding.tv1TempoVitoriaResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ VENCEU ] NO 1T", Toast.LENGTH_LONG).show();
                handleTextViewClick(1);
            }
        });
        binding.tv1TempoEmpateResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ EMPATOU ] NO 1T", Toast.LENGTH_LONG).show();
                handleTextViewClick(2);
            }
        });
        binding.tv1TempoDerrotaResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "PARTIDAS QUE [ SAIU DERROTADO ] NO 1T", Toast.LENGTH_LONG).show();
                handleTextViewClick(3);
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
                    if (partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo())
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                for (int i = 0; i < partidas.size(); i++) {
                    //PARTIDAS QUE EMPATOU NO 1°TEMPO
                    if (partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() == partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo())
                        jogos.add(partidas.get(i));
                }
                if (!jogos.isEmpty()) {
                    showPartidasDialog(jogos);
                } else {
                    Toast.makeText(getActivity(), "Nenhum Evento Registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case 3:
                for (int i = 0; i < partidas.size(); i++) {
                    //PARTIDAS QUE SAIU DERROTADO NO 1°TEMPO
                    if (partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() < partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo())
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

        for (PartidaNovoModelo partida : cearaCompleto) {

            if (partida.getHomeTime().getName().equals("Ceará")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        for (int i = 0; i < partidas.size(); i++) {

            //TOTAL VIÓRIA PRIMEIRO TEMPO
            if (partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() > partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) {
                vitoriaPrimeiroTempo += 1;
            }
            //TOTAL EMPATE PRIMEIRO TEMPO
            if (partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() == partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) {
                empatePrimeiroTempo += 1;
            }
            //TOTAL DERROTA PRIMEIRO TEMPO
            if (partidas.get(i).getHomeEstatisticaJogo().getGolsPrimeiroTempo() < partidas.get(i).getAwayEstatisticaJogo().getGolsPrimeiroTempo()) {
                derrotaPrimeiroTempo += 1;
            }

            //TOTAL VIÓRIA SEGUNDO TEMPO
            if (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() > partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) {
                vitoriaSegundoTempo += 1;
            }
            //TOTAL EMPATE SEGUNDO TEMPO
            if (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() == partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) {
                empateSegundoTempo += 1;
            }
            //TOTAL DERROTA SEGUNDO TEMPO
            if (partidas.get(i).getHomeEstatisticaJogo().getGolsSegundoTempo() < partidas.get(i).getAwayEstatisticaJogo().getGolsSegundoTempo()) {
                derrotaSegundoTempo += 1;
            }


        }//fim do for que faz a comparação dos resultados dos tempos


        binding.tvTituloResultado.setText("RESULTADO DO 1°TEMPO E 2°TEMPO " + partidas.get(0).getHomeTime().getName().toUpperCase() + " CASA");

        //Resultado dos Tempos
        binding.tv1TempoVitoriaResultado.setText(String.valueOf(vitoriaPrimeiroTempo));
        binding.tv1TempoEmpateResultado.setText(String.valueOf(empatePrimeiroTempo));
        binding.tv1TempoDerrotaResultado.setText(String.valueOf(derrotaPrimeiroTempo));

        binding.tv2TempoVitoriaResultado.setText(String.valueOf(vitoriaSegundoTempo));
        binding.tv2TempoEmpateResultado.setText(String.valueOf(empateSegundoTempo));
        binding.tv2TempoDerrotaResultado.setText(String.valueOf(derrotaSegundoTempo));




    }//fim da interface

    private void showPartidasDialog(List<PartidaNovoModelo> partidas) {


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


}