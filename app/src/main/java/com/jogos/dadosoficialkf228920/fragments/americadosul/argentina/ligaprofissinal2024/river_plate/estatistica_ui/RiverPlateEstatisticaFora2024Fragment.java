package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.river_plate.estatistica_ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jogos.dadosoficialkf228920.databinding.FragmentRiverPlateEstatisticaFora2024Binding;


public class RiverPlateEstatisticaFora2024Fragment extends Fragment {

    private FragmentRiverPlateEstatisticaFora2024Binding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRiverPlateEstatisticaFora2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return  view;
    }
}