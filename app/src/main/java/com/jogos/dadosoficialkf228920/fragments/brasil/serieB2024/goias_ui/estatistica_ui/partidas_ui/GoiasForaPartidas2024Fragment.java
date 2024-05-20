package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.goias_ui.estatistica_ui.partidas_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.Serie_A_B_2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentCearaForaPartidas2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentGoiasForaPartidas2024Binding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorDatasPartidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoiasForaPartidas2024Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoiasForaPartidas2024Fragment extends Fragment implements JogosSerieB2024Listener {

    private FragmentGoiasForaPartidas2024Binding binding;

    private Serie_A_B_2024Adapter serieAB2024CasaAdapter;
    private JogosSerieB2024 jogosSerieB2024;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGoiasForaPartidas2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        jogosSerieB2024 = new JogosSerieB2024();
        jogosSerieB2024.setupHttpClient();
        jogosSerieB2024.setupDadosJogos();
        jogosSerieB2024.setListener(this);// Registra o fragmento como listener

        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        serieAB2024CasaAdapter = new Serie_A_B_2024Adapter(partidas);
        binding.rvListaJogos.setAdapter(serieAB2024CasaAdapter);

        return view;
    }


    @Override
    public void onJogosSerieBReady(List<PartidaNovoModelo> amazonasCompleto, List<PartidaNovoModelo> americaMGCompleto, List<PartidaNovoModelo> avaiCompleto, List<PartidaNovoModelo> botafogoSPCompleto, List<PartidaNovoModelo> brusqueCompleto, List<PartidaNovoModelo> crbCompleto, List<PartidaNovoModelo> cearaCompleto, List<PartidaNovoModelo> chapecoenseCompleto, List<PartidaNovoModelo> coritibaCompleto, List<PartidaNovoModelo> goiasCompleto, List<PartidaNovoModelo> guaraniCompleto, List<PartidaNovoModelo> ituanoCompleto, List<PartidaNovoModelo> mirassolCompleto, List<PartidaNovoModelo> novorizontinoCompleto, List<PartidaNovoModelo> operarioCompleto, List<PartidaNovoModelo> paysanduCompleto, List<PartidaNovoModelo> pontepretaCompleto, List<PartidaNovoModelo> santosCompleto, List<PartidaNovoModelo> sportCompleto, List<PartidaNovoModelo> vilanovaCompleto) {


        PartidaNovoModelo partidaNovoModelo = new PartidaNovoModelo();

        for (PartidaNovoModelo partida : goiasCompleto) {

            if (partida.getAwayTime().getName().equals("Goiás")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        Collections.sort(partidas, new ComparatorDatasPartidas());

        serieAB2024CasaAdapter.notifyDataSetChanged();

    }

}