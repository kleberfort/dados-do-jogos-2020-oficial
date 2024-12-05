package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentEstatisticaBinding;


public class EstatisticaFragment extends Fragment {

    private FragmentEstatisticaBinding binding;
    private String estatisticaTipo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Recuperar o tipo de estatística dos argumentos
        estatisticaTipo = getArguments() != null ? getArguments().getString("tipo_estatistica") : "";

        carregarEstatistica();

        return binding.getRoot();
    }

    private void carregarEstatistica() {
        // Lógica para carregar conteúdo com base no tipo de estatística
        switch (estatisticaTipo) {
            case "estatistica_geral":
                binding.textViewTitulo.setText("Estatística Geral");
                break;
            case "resultado_tempos":
                binding.textViewTitulo.setText("Resultado por Tempos");
                break;
            case "gols":
                binding.textViewTitulo.setText("Gols Marcados");
                break;
            case "gols_sofridos":
                binding.textViewTitulo.setText("Gols Sofridos");
                break;
            case "cartoes":
                binding.textViewTitulo.setText("Cartões");
                break;
            case "escanteios":
                binding.textViewTitulo.setText("Escanteios");
                break;
        }
    }
}