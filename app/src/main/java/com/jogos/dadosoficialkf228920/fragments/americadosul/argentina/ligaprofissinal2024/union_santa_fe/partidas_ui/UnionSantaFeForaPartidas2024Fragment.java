package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.union_santa_fe.partidas_ui;

import android.annotation.SuppressLint;
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
import com.jogos.dadosoficialkf228920.databinding.FragmentRiverPlateForaPartidas2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentUnionSantaFeForaPartidas2024Binding;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A2024;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.util.JogosLigaProfissional_A_2024_Listener;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorDatasPartidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnionSantaFeForaPartidas2024Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnionSantaFeForaPartidas2024Fragment extends Fragment implements JogosLigaProfissional_A_2024_Listener {

    private FragmentUnionSantaFeForaPartidas2024Binding binding;

    private JogosLigaProfissional_A2024 jogosLigaProfissionalA2024;
    private Serie_A_B_2024Adapter serieAB2024CasaAdapter;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUnionSantaFeForaPartidas2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        jogosLigaProfissionalA2024 = new JogosLigaProfissional_A2024();
        jogosLigaProfissionalA2024.setupHttpClient();
        jogosLigaProfissionalA2024.setupDadosJogos();
        jogosLigaProfissionalA2024.setListener(this);// Registra o fragmento como listener

        binding.rvListaJogos.setHasFixedSize(true);
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaJogos.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));



        serieAB2024CasaAdapter = new Serie_A_B_2024Adapter(partidas);
        binding.rvListaJogos.setAdapter(serieAB2024CasaAdapter);


        return view;
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onJogosSerieAReady(List<PartidaNovoModelo> argentinoJuniorsCompleto, List<PartidaNovoModelo> atleticoTucumanCompleto, List<PartidaNovoModelo> banfieldCompleto, List<PartidaNovoModelo> barracasCentralCompleto, List<PartidaNovoModelo> belgranoCompleto, List<PartidaNovoModelo> bocaJuniorsCompleto, List<PartidaNovoModelo> centralCordobaCompleto, List<PartidaNovoModelo> defensaJusticiaCompleto, List<PartidaNovoModelo> deportivoRiestraCompleto, List<PartidaNovoModelo> estudiantesLaPrataCompleto, List<PartidaNovoModelo> gimnasiaCompleto, List<PartidaNovoModelo> godoyCruzCompleto, List<PartidaNovoModelo> huracanCompleto, List<PartidaNovoModelo> independienteCompleto, List<PartidaNovoModelo> independienteRivadaviaCompleto, List<PartidaNovoModelo> institutoCompleto, List<PartidaNovoModelo> lanusCompleto, List<PartidaNovoModelo> newellOldBoysCompleto, List<PartidaNovoModelo> platenseCompleto, List<PartidaNovoModelo> racingCompleto, List<PartidaNovoModelo> riverPlateCompleto, List<PartidaNovoModelo> rosarioCentralCompleto, List<PartidaNovoModelo> sanLorenzoCompleto, List<PartidaNovoModelo> sarmientoCompleto, List<PartidaNovoModelo> talleresCompleto, List<PartidaNovoModelo> tigreCompleto, List<PartidaNovoModelo> unionSantaFeCompleto, List<PartidaNovoModelo> velezSarsfieldCompleto) {
        PartidaNovoModelo partidaNovoModelo;

        for (PartidaNovoModelo partida : unionSantaFeCompleto) {

            if (partida.getAwayTime().getName().equals("Union Santa Fe")) {
                partidaNovoModelo = partida;
                partida.setDataFormatada(partida.getDate());
                this.partidas.add(partidaNovoModelo);
            }

        }//fim do for

        Collections.sort(partidas, new ComparatorDatasPartidas());

        serieAB2024CasaAdapter.notifyDataSetChanged();
    }
}