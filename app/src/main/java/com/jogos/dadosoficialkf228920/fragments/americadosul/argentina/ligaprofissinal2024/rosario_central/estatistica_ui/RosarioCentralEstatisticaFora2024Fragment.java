package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.rosario_central.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentRiverPlateEstatisticaFora2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentRosarioCentralEstatisticaFora2024Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RosarioCentralEstatisticaFora2024Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RosarioCentralEstatisticaFora2024Fragment extends Fragment {

    private FragmentRosarioCentralEstatisticaFora2024Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRosarioCentralEstatisticaFora2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return  view;
    }
}