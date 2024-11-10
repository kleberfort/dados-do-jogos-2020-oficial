package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.atletico_tucuman.estatistica_ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jogos.dadosoficialkf228920.databinding.FragmentAtleticoTucumanEstatisticaFora2024Binding;


public class AtleticoTucumanEstatisticaFora2024Fragment extends Fragment {

    private FragmentAtleticoTucumanEstatisticaFora2024Binding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAtleticoTucumanEstatisticaFora2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return  view;
    }
}

