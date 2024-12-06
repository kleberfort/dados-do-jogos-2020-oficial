package com.jogos.dadosoficialkf228920.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.Serie_A_B_2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentJogosCasaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentJogosForaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;


public class JogosForaLaLiga2025Fragment extends Fragment {

    private FragmentJogosForaLaLiga2025Binding binding;
    private ArrayList<PartidaNovoModelo> partidasFora;
    private Serie_A_B_2024Adapter serieAB2024CasaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inicialize o View Binding
        binding = FragmentJogosForaLaLiga2025Binding.inflate(inflater, container, false);

        // Verifica se o argumento foi passado corretamente
        if (getArguments() != null) {
            partidasFora = getArguments().getParcelableArrayList("partidas_fora");
        }

        // Se partidasFora for null, inicializa uma lista vazia
        if (partidasFora == null) {
            partidasFora = new ArrayList<>();
        }

        // Inicialize o RecyclerView e o Adapter
        configurarRecyclerView();

        return binding.getRoot();
    }

    private void configurarRecyclerView() {
        // Inicialize a lista de partidas se for nula
        if (partidasFora == null) {
            partidasFora = new ArrayList<>();
        }

        // Configure o RecyclerView
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        serieAB2024CasaAdapter = new Serie_A_B_2024Adapter(partidasFora);
        binding.rvListaJogos.setAdapter(serieAB2024CasaAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evita vazamento de memória
    }
}
