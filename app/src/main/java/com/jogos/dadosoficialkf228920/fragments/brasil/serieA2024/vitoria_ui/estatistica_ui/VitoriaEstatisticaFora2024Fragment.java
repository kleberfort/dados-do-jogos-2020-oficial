package com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.vitoria_ui.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasAdapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentVascoEstatisticaFora2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentVitoriaEstatisticaFora2024Binding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.util.JogosSerieA2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.util.JogosSerieAListener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorDatasPartidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VitoriaEstatisticaFora2024Fragment extends Fragment implements JogosSerieAListener {

    private FragmentVitoriaEstatisticaFora2024Binding binding;

    private JogosSerieA2024 jogosSerieA2024;
    private ResultadosPartidasAdapter resultadosPartidasAdapter;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVitoriaEstatisticaFora2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        jogosSerieA2024 = new JogosSerieA2024();
        jogosSerieA2024.setupHttpClient();
        jogosSerieA2024.setupDadosJogos();
        jogosSerieA2024.setListener(this);// Registra o fragmento como listener

        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));



        resultadosPartidasAdapter = new ResultadosPartidasAdapter(partidas);
        binding.rvListaJogos.setAdapter(resultadosPartidasAdapter);


        return view;
    }

    @Override
    public void onJogosSerieAReady(List<PartidaNovoModelo> atleticoPRCompleto, List<PartidaNovoModelo> atleticoGOCompleto, List<PartidaNovoModelo> atleticoMGCompleto, List<PartidaNovoModelo> bahiaCompleto, List<PartidaNovoModelo> botafogoCompleto, List<PartidaNovoModelo> bragantinoCompleto, List<PartidaNovoModelo> corinthiansCompleto, List<PartidaNovoModelo> criciumaCompleto, List<PartidaNovoModelo> cruzeiroCompleto, List<PartidaNovoModelo> cuiabaCompleto, List<PartidaNovoModelo> flamengoCompleto, List<PartidaNovoModelo> fluminenseCompleto, List<PartidaNovoModelo> fortalezaCompleto, List<PartidaNovoModelo> gremioCompleto, List<PartidaNovoModelo> internacionalCompleto, List<PartidaNovoModelo> juventudeCompleto, List<PartidaNovoModelo> palmeirasCompleto, List<PartidaNovoModelo> saoPauloCompleto, List<PartidaNovoModelo> vascoCompleto, List<PartidaNovoModelo> vitoriaCompleto) {
        PartidaNovoModelo partidaNovoModelo;

        for (PartidaNovoModelo partida : vitoriaCompleto) {

            if (partida.getAwayTime().getName().equals("Vitória")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        Collections.sort(partidas, new ComparatorDatasPartidas());

            resultadosPartidasAdapter.notifyDataSetChanged();


    }
}