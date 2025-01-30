package com.jogos.dadosoficialkf228920.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.service.autofill.FieldClassification;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.CarregarFinalizacaoFaltaImpedimentoAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.DadosGeralAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.Serie_A_B_2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentJogosCasaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentJogosForaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorDatasPartidas;

import java.util.ArrayList;
import java.util.Collections;


public class JogosForaLaLiga2025Fragment extends Fragment {

    private FragmentJogosForaLaLiga2025Binding binding;
    private ArrayList<MatchNewModelDate> partidasFora;
    private Serie_A_B_2024Adapter serieAB2024CasaAdapter;

    private DadosGeralAdapter dadosGeralAdapter;
    private CarregarFinalizacaoFaltaImpedimentoAdapter carregarFinalizacaoFaltaImpedimentoAdapter;

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

        // Configura o botão para alternar entre os RecyclerViews
        binding.btnAbrirDadosResumido.setOnClickListener(v -> alternarRecyclerViews());

        return binding.getRoot();
    }

    private void configurarRecyclerView() {
        // Inicialize a lista de partidas se for nula
        if (partidasFora == null) {
            partidasFora = new ArrayList<>();
        }

        Collections.sort(partidasFora, new ComparatorDatasPartidas());

        // Configure o RecyclerView
        binding.rvListaJogos.setLayoutManager(new LinearLayoutManager(getContext()));
        dadosGeralAdapter = new DadosGeralAdapter(partidasFora);
        binding.rvListaJogos.setAdapter(dadosGeralAdapter);

        // Configure o RecyclerView da lista resumida
        binding.rvListaJogosResumo.setLayoutManager(new LinearLayoutManager(getContext()));
        carregarFinalizacaoFaltaImpedimentoAdapter = new CarregarFinalizacaoFaltaImpedimentoAdapter(partidasFora, "fora");
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
