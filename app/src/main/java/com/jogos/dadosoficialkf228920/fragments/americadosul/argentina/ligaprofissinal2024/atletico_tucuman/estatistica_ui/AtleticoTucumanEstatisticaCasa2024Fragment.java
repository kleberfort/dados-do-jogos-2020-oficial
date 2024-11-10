package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.atletico_tucuman.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentAtleticoTucumanEstatisticaCasa2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentAtleticoTucumanEstatisticaFora2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentRiverPlateEstatisticaCasa2024Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtleticoTucumanEstatisticaCasa2024Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AtleticoTucumanEstatisticaCasa2024Fragment extends Fragment {

    private FragmentAtleticoTucumanEstatisticaCasa2024Binding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAtleticoTucumanEstatisticaCasa2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return  view;
    }
}