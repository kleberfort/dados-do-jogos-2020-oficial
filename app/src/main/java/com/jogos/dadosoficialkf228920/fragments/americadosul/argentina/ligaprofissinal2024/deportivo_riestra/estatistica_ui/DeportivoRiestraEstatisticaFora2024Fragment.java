package com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ligaprofissinal2024.deportivo_riestra.estatistica_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentDeportivoRiestraEstatisticaFora2024Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentRiverPlateEstatisticaFora2024Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeportivoRiestraEstatisticaFora2024Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeportivoRiestraEstatisticaFora2024Fragment extends Fragment {

    private FragmentDeportivoRiestraEstatisticaFora2024Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDeportivoRiestraEstatisticaFora2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return  view;
    }
}