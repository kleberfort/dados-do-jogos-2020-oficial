package com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.bragantino_ui.estatistica_ui.partidas_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jogos.dadosoficialkf228920.adapter.brasil2024.Serie_A_B_2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentBragantinoCasaPartidas2024Binding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.util.JogosSerieA2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.util.JogosSerieAListener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorDatasPartidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BragantinoCasaPartidas2024Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BragantinoCasaPartidas2024Fragment extends Fragment implements JogosSerieAListener {

    private FragmentBragantinoCasaPartidas2024Binding binding;


    private Serie_A_B_2024Adapter serieAB2024CasaAdapter;
    private JogosSerieA2024 jogosSerieA2024;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBragantinoCasaPartidas2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        jogosSerieA2024 = new JogosSerieA2024();
        jogosSerieA2024.setupHttpClient();
        jogosSerieA2024.setupDadosJogos();
        jogosSerieA2024.setListener(this);// Registra o fragmento como listener

        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        serieAB2024CasaAdapter = new Serie_A_B_2024Adapter(partidas);
        binding.rvListaJogos.setAdapter(serieAB2024CasaAdapter);

        return view;
    }


    @Override
    public void onJogosSerieAReady(List<PartidaNovoModelo> atleticoPRCompleto, List<PartidaNovoModelo> atleticoGOCompleto, List<PartidaNovoModelo> atleticoMGCompleto, List<PartidaNovoModelo> bahiaCompleto, List<PartidaNovoModelo> botafogoCompleto, List<PartidaNovoModelo> bragantinoCompleto, List<PartidaNovoModelo> corinthiansCompleto, List<PartidaNovoModelo> criciumaCompleto, List<PartidaNovoModelo> cruzeiroCompleto, List<PartidaNovoModelo> cuiabaCompleto, List<PartidaNovoModelo> flamengoCompleto, List<PartidaNovoModelo> fluminenseCompleto, List<PartidaNovoModelo> fortalezaCompleto, List<PartidaNovoModelo> gremioCompleto, List<PartidaNovoModelo> internacionalCompleto, List<PartidaNovoModelo> juventudeCompleto, List<PartidaNovoModelo> palmeirasCompleto, List<PartidaNovoModelo> saoPauloCompleto, List<PartidaNovoModelo> vascoCompleto, List<PartidaNovoModelo> vitoriaCompleto) {
        PartidaNovoModelo partidaNovoModelo = new PartidaNovoModelo();

        for (PartidaNovoModelo partida : bragantinoCompleto) {

            if (partida.getHomeTime().getName().equals("Bragantino")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        Collections.sort(partidas, new ComparatorDatasPartidas());

        serieAB2024CasaAdapter.notifyDataSetChanged();

    }
}