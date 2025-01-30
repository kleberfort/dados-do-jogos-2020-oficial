package com.jogos.dadosoficialkf228920.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.adapter.brasil2024.CarregarFinalizacaoFaltaImpedimentoAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.DadosGeralAdapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentJogosCasaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorDatasPartidas;

import java.util.ArrayList;
import java.util.Collections;

public class JogosCasaLaLiga2025Fragment extends Fragment {

    private FragmentJogosCasaLaLiga2025Binding binding;
    private ArrayList<MatchNewModelDate> partidasCasa;
    private DadosGeralAdapter dadosGeralAdapter;
    private CarregarFinalizacaoFaltaImpedimentoAdapter carregarFinalizacaoFaltaImpedimentoAdapter;

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

        // Configura o botão para alternar entre os RecyclerViews
        binding.btnAbrirDadosResumido.setOnClickListener(v -> alternarRecyclerViews());


        return binding.getRoot();
    }

    private void configurarRecyclerView() {
        // Inicialize a lista de partidas se for nula
        if (partidasCasa == null) {
            partidasCasa = new ArrayList<>();
        }

        Collections.sort(partidasCasa, new ComparatorDatasPartidas());

        // Configure o RecyclerView da lista geral
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        dadosGeralAdapter = new DadosGeralAdapter(partidasCasa);
        binding.rvListaJogos.setAdapter(dadosGeralAdapter);

        // Configure o RecyclerView da lista resumida
        binding.rvListaJogosResumo.setLayoutManager(new LinearLayoutManager(getContext()));
        carregarFinalizacaoFaltaImpedimentoAdapter = new CarregarFinalizacaoFaltaImpedimentoAdapter(partidasCasa,"casa");
        binding.rvListaJogosResumo.setAdapter(carregarFinalizacaoFaltaImpedimentoAdapter);

    }

    private void alternarRecyclerViews() {
        if (binding.rvListaJogos.getVisibility() == View.VISIBLE) {
            binding.rvListaJogos.setVisibility(View.GONE);
            binding.rvListaJogosResumo.setVisibility(View.VISIBLE);
        } else {
            binding.rvListaJogos.setVisibility(View.VISIBLE);
            binding.rvListaJogosResumo.setVisibility(View.GONE);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evita vazamento de memória
    }
}