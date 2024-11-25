package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.brighton.partidas_ui;

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
import com.jogos.dadosoficialkf228920.databinding.FragmentArsenalCasaPartidas2025Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentBrightonCasaPartidas2025Binding;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.util.JogosPremierLeague_A_2024_2025_Listener;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.util.JogosPremierLeague_A_2024_25;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorDatasPartidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrightonCasaPartidas2025Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrightonCasaPartidas2025Fragment extends Fragment implements JogosPremierLeague_A_2024_2025_Listener {

    private FragmentBrightonCasaPartidas2025Binding binding;

    private Serie_A_B_2024Adapter serieAB2024CasaAdapter;
    private JogosPremierLeague_A_2024_25 jogosPremierLeague_a_2024_25;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBrightonCasaPartidas2025Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        jogosPremierLeague_a_2024_25 = new JogosPremierLeague_A_2024_25();
        jogosPremierLeague_a_2024_25.setupHttpClient();
        jogosPremierLeague_a_2024_25.setupDadosJogos();
        jogosPremierLeague_a_2024_25.setListener(this);// Registra o fragmento como listener

        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        serieAB2024CasaAdapter = new Serie_A_B_2024Adapter(partidas);
        binding.rvListaJogos.setAdapter(serieAB2024CasaAdapter);

        return view;
    }

    @Override
    public void onJogosPremierLeague_A(List<PartidaNovoModelo> astonVillaCompleto, List<PartidaNovoModelo> arsenalCompleto, List<PartidaNovoModelo> brentfordCompleto, List<PartidaNovoModelo> brigthonCompleto, List<PartidaNovoModelo> bournemouthCompleto, List<PartidaNovoModelo> chelseaCompleto, List<PartidaNovoModelo> crystalPalaceCompleto, List<PartidaNovoModelo> evertonCompleto, List<PartidaNovoModelo> forestCompleto, List<PartidaNovoModelo> fulhamCompleto, List<PartidaNovoModelo> ipswichCompleto, List<PartidaNovoModelo> leicesterCompleto, List<PartidaNovoModelo> liverpoolCompleto, List<PartidaNovoModelo> manCityCompleto, List<PartidaNovoModelo> manUtdCompleto, List<PartidaNovoModelo> newcastleCompleto, List<PartidaNovoModelo> southamptonCompleto, List<PartidaNovoModelo> tottenhamCompleto, List<PartidaNovoModelo> westHamCompleto, List<PartidaNovoModelo> wolvesCompleto) {
        PartidaNovoModelo partidaNovoModelo;

        for (PartidaNovoModelo partida : brigthonCompleto) {

            if (partida.getHomeTime().getName().equals("Brighton")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        Collections.sort(partidas, new ComparatorDatasPartidas());


        serieAB2024CasaAdapter.notifyDataSetChanged();
    }
}