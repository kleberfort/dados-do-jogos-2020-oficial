package com.jogos.dadosoficialkf228920.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.adapteFragment.LaLigaPagerAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.Serie_A_B_2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentJogosCasaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorDatasPartidas;

import java.util.ArrayList;
import java.util.Collections;

public class JogosCasaLaLiga2025Fragment extends Fragment {

    private FragmentJogosCasaLaLiga2025Binding binding;
    private ArrayList<PartidaNovoModelo> partidasCasa;
    private Serie_A_B_2024Adapter serieAB2024CasaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inicialize o View Binding
        binding = FragmentJogosCasaLaLiga2025Binding.inflate(inflater, container, false);

        if (getArguments() != null) {
            partidasCasa = getArguments().getParcelableArrayList("partidas_casa");
        }


        // Inicialize o RecyclerView e o Adapter
        configurarRecyclerView();
        return binding.getRoot();
    }

    private void configurarRecyclerView() {
        // Inicialize a lista de partidas se for nula
        if (partidasCasa == null) {
            partidasCasa = new ArrayList<>();
        }

        // Configure o RecyclerView
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        serieAB2024CasaAdapter = new Serie_A_B_2024Adapter(partidasCasa);

        Collections.sort(partidasCasa, new ComparatorDatasPartidas());
        binding.rvListaJogos.setAdapter(serieAB2024CasaAdapter);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evita vazamento de memória
    }
}